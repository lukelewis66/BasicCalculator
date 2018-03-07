package calculator;

public class MathCommand implements Command {

	double previous;
	double operand;
	double result;


	public MathCommand(double operand1, double operand2) {
		previous = operand1;
		operand = operand2;
	}


	@Override
	public double execute() {
		return result;
	}

}
