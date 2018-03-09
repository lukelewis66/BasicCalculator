package calculator;

import java.io.*;
import java.util.*;
import static sbcc.Core.*;

public class CommandCalculator {
	Stack<MathCommand> mathLog = new Stack<>();
	Stack<Command> commandLog = new Stack<>();


	double mathOperation(double op1, double op2, char operator) {
		double result = 0.00;
		switch (operator) { // basic switch based on what operation the user clicked to determine what kind
							// of Math Command we need to initialize
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


	void save(char c) throws IOException {
		SmartSaver saver = new SmartSaver(commandLog);
		saver.save(c);
	}


	double undoOperation() {
		if (!mathLog.isEmpty()) {
			MathCommand mathUndone = mathLog.pop();
			UndoCommand undone = new UndoCommand(mathUndone);
			commandLog.push(undone);
			double result = mathUndone.previous;
			return result;
		} else { // if our stack is empty we just return 0 and not create a new Undo class
			return 0.00;
		}
	}
}
