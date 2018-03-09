package calculator;

public class UndoCommand implements Command {

	double undoResult;


	UndoCommand(MathCommand toUndo) {
		undoResult = toUndo.previous;
	}


	@Override
	public double execute() {
		return 0.00;
	}
}