package calculator;

import java.io.*;
import java.util.*;

public interface SaveStrategy {
	public void save() throws IOException;
}
