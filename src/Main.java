import java.io.IOException;

import com.samborskiy.elements.Grammar;

public class Main {

	private static final String FILE_NAME = "grammar";

	public static void main(String[] args) throws IOException {
		Grammar grammar = new Grammar(FILE_NAME);
	}
}
