import java.util.Random;
import java.util.Scanner;

public class View {

	private Perceptron perceptron;
	private Scanner sc = new Scanner(System.in);
	Random r = new Random();
	private int inputValues = 2; //inputvalues without w_0
	int[] inputs = new int[3];

	public View() {
		perceptron = new Perceptron(inputValues);
		inputs[0] = 1;

		System.out.println("Welcome! We're training a perceptron for an OR-gate today!");
		System.out.println("Enter anything to start. Enter \"exit\" any time to exit.\n> ");
		String input = sc.next();
		while (!input.equals("exit")) {
			inputs[1]= r.nextInt(2);
			inputs[2] = r.nextInt(2);
			int y = calcResult(inputs[1], inputs[2]);
			int yhat = perceptron.makeGuess(inputs);
			printResult(y, yhat);
			perceptron.updateWeights(calcDelta(y, yhat), inputs);
			
			System.out.println("Next? \n> ");
			input = sc.next();
		}
	}
	
	public int calcResult(int x1, int x2) {
		return (x1 == 1 || x2 == 1) ? 1 : 0; 
	}
	
	public int calcDelta(int y, int yhat) {
		if (y == 1 && yhat == 0) {
			return 1;
		} else if (y == 0 && yhat == 1) {
			return -1;
		}
		return 0;
	}
	
	//quick method of keeping track of results
	public void printResult(int y, int yhat) {
		System.out.println("X_0\tX_1\tX_2\tw_0\tw_1\tw_2\tYhat\tY\tdelta");
		System.out.print(inputs[0] + "\t" + inputs[1] + "\t"  + inputs[2] + "\t");
		perceptron.printInfo();
		System.out.print(yhat + "\t" + y + "\t" + calcDelta(y, yhat) + "\n");
	}

}
