package calculator;

import java.util.*;

public class CommandCalculator {
	Stack<MathCommand> mathLog = new Stack<>();
	Stack<Command> commandLog = new Stack<>();


	double mathOperation(double op1, double op2, char operator) {
		double result = 0.00;
		switch (operator) {
		case '+':
			MathPlus plusCmd = new MathPlus(op1, op2);
			result = plusCmd.execute();
			mathLog.push(plusCmd);
			commandLog.push(plusCmd);
			break;
		case '-':
			MathMinus minusCmd = new MathMinus(op1, op2);
			result = minusCmd.execute();
			mathLog.push(minusCmd);
			commandLog.push(minusCmd);
			break;
		case '/':
			MathDivide divideCmd = new MathDivide(op1, op2);
			result = divideCmd.execute();
			mathLog.push(divideCmd);
			commandLog.push(divideCmd);
			break;
		case '*':
			MathMultiply multiplyCmd = new MathMultiply(op1, op2);
			result = multiplyCmd.execute();
			mathLog.push(multiplyCmd);
			commandLog.push(multiplyCmd);
			break;
		default:
			break;
		}

		return result;
	}


	double undoOperation() {
		MathCommand mathUndone = mathLog.pop();
		UndoCommand undone = new UndoCommand();
		commandLog.push(undone);
		double result = mathUndone.previous;
		return result;
	}
}
