package calculator;

import java.io.*;
import java.util.*;

import org.apache.commons.io.*;

public class SaveXml implements SaveStrategy {

	Stack<Command> reverseLog = new Stack<>();
	String tab = "    ";


	public SaveXml(Stack<Command> logg) {
		Stack<Command> log = (Stack<Command>) logg.clone(); // we have to clone the constructor stack so that we don't
															// pop off of the original stack
		while (!log.isEmpty()) {
			reverseLog.push(log.pop());
		}
	}


	@Override
	public void save() throws IOException {
		StringBuilder saveSb = new StringBuilder();
		saveSb.append("<log>\n");
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
				saveSb.append(tab + "<math operation=\"" + op.trim() + "\">\n");
				saveSb.append(tab + tab + "<operand1>" + ((MathCommand) command).previous + "</operand1>\n");
				saveSb.append(tab + tab + "<operand2>" + ((MathCommand) command).operand + "</operand2>\n");
				saveSb.append(tab + tab + "<result>" + ((MathCommand) command).result + "</result>\n");
				saveSb.append(tab + "</math>\n");
			} else {
				saveSb.append(tab + "<undo>\n");
				saveSb.append(tab + tab + "<result>" + ((UndoCommand) command).undoResult + "</result>\n");
				saveSb.append(tab + "</undo>\n");
			}
		}
		saveSb.append("</log>");
		FileUtils.writeStringToFile(new File("CalculatorLog.xml"), saveSb.toString(), "UTF-8");

	}

}
