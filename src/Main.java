
class Node{
    private double[] weights;
    private double bias;

    public Node() {
        weights = new double[]{20.0,20.0};
        bias = -30;
    }

    public double FeedForwardCompute(double input1,double input2){
        double weightSum= input1*weights[0]+input2*weights[1]+bias;
        if(weightSum>0){
            return 1;
        }
        else {
            return 0;
        }
    }

}
class NetWork{
    private Node[][] layer;
    public NetWork(){
        layer = new Node[][]{
                {new Node(),new Node()},
                {new Node(),new Node()},
                {new Node(),new Node()},
                {new Node()}
        };
    }
    public int compute(double input1, double input2){
        double [] inputs = {input1,input2};
        for (int i = 0; i < layer.length; i++) {
            Node[] layer1 = layer[i];
            double[] outputs = new double[layer1.length];
            //loop every layers
            for (int j = 0; j < layer1.length; j++) {
                double in1,in2;
                if(inputs.length > j){
                    in1 = inputs[0];
                    in2 = inputs[1];
                }
                else {
                    in1 = inputs[j];
                    in2 = inputs[j];
                }

                outputs[j] = layer1[j].FeedForwardCompute(in1,in2);
            }
            inputs=outputs;
        }
        return (int) inputs[0];
    }
}


public class Main {
    public static void main(String[] args) {
            NetWork nn = new NetWork();
            System.out.println("Testing AND gate neural network model: ");
            System.out.println("0 AND 0 = " + nn.compute(0, 0));
            System.out.println("0 AND 1 = " + nn.compute(0, 1));
            System.out.println("1 AND 0 = " + nn.compute(1, 0));
            System.out.println("1 AND 1 = " + nn.compute(1, 1));

    }
}
