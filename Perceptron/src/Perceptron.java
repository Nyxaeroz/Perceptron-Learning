
public class Perceptron {
	
	private double[] weights;
	private int learningRate = 1;
	
	
	public Perceptron(int inputValues) {
		weights = new double[inputValues + 1];
		for (int i = 0; i < weights.length; i++) {
			weights[i] = 0;
		}
	}
	
	public int makeGuess(int[] input) {
		double z = weights[0];
		for (int i = 1; i < input.length; i++) {
			z+=(weights[i]*input[i]);
		}
		return z >= 1 ? 1 : 0;
	}
	
	void updateWeights(int delta, int[] input) {
		for (int i = 0; i < weights.length; i++) {
			weights[i] = weights[i] + learningRate * delta * input[i];
		}
	}
	
	public void printInfo() {
		for (int i = 0; i < weights.length; i++) {
			System.out.print(weights[i] + "\t");
		}
	}

}
