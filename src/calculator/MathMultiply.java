package calculator;

public class MathMultiply extends MathCommand {

	public MathMultiply(double op1, double op2) {
		super(op1, op2);
	}


	@Override
	public double execute() {
		result = previous * operand;
		return result;
	}

}
