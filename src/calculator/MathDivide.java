package calculator;

public class MathDivide extends MathCommand {

	public MathDivide(double op1, double op2) {
		super(op1, op2);
	}


	@Override
	public double execute() {
		result = previous / operand;
		return result;
	}

}
