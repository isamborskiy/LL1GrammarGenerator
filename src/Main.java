import java.io.IOException;

import com.samborskiy.elements.Grammar;

public class Main {

	public static void main(String[] args) throws IOException {
		Grammar grammar = new Grammar(args);
		System.out.print(grammar.toString());
	}
}
