package calculator;

import java.io.*;
import java.util.*;

public class SmartSaver {
	Stack<Command> log;


	SmartSaver(Stack<Command> logg) {
		log = logg;
	}


	public void save(char c) throws IOException {
		if (c == 'X') {
			SaveXml saver = new SaveXml(log);
			saver.save();
			System.out.println("Saving as xml...");
		}

		if (c == 'T') {
			SaveTxt saver = new SaveTxt(log);
			saver.save();
			System.out.println("Saving as txt...");
		}
	}
}
