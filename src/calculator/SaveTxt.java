package calculator;

import static sbcc.Core.*;

import java.io.*;
import java.util.*;
import org.apache.commons.*;
import org.apache.commons.io.*;

public class SaveTxt implements SaveStrategy {

	Stack<Command> log = new Stack<>();
	Stack<Command> reverseLog = new Stack<>();


	public SaveTxt(Stack<Command> logg) {
		log = logg;
		while (log.peek() != null) {
			reverseLog.push(log.pop());
		}
	}


	@Override
	public void save() throws IOException {
		StringBuilder saveSb = new StringBuilder();
		while (reverseLog.peek() != null) {
			Command command = reverseLog.pop();
			if (command instanceof MathCommand) {
				String op;
				if (command instanceof MathPlus) {
					op = " + ";
				} else if (command instanceof MathMinus) {
					op = " - ";
				} else if (command instanceof MathMultiply) {
					op = " * ";
				} else {
					op = " / ";
				}
				saveSb.append(((MathCommand) command).previous + op + ((MathCommand) command).operand + " = "
						+ ((MathCommand) command).result);
				saveSb.append('\n');
			} else {
				saveSb.append("Undo. Result = " + ((UndoCommand) command).undoResult);
				saveSb.append('\n');
			}
		}
		FileUtils.writeStringToFile(new File("CalculatorLog.txt"), saveSb.toString(), "UTF-8");
	}

}
