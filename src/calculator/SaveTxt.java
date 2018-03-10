package calculator;

import static sbcc.Core.*;

import java.io.*;
import java.util.*;
import org.apache.commons.*;
import org.apache.commons.io.*;

public class SaveTxt implements SaveStrategy {

	Stack<Command> reverseLog = new Stack<>();


	public SaveTxt(Stack<Command> logg) {
		Stack<Command> log = (Stack<Command>) logg.clone(); // we have to clone the constructor stack so that we don't
															// pop off of the original stack
		while (!log.isEmpty()) {
			reverseLog.push(log.pop());
		}
	}


	@Override
	public void save() throws IOException {
		StringBuilder saveSb = new StringBuilder();
		while (!reverseLog.isEmpty()) {
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
				saveSb.append("UNDO ---> " + ((UndoCommand) command).undoResult);
				saveSb.append('\n');
			}
		}
		FileUtils.writeStringToFile(new File("CalculatorLog.txt"), saveSb.toString(), "UTF-8");
	}

}
