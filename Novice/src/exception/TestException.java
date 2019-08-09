package exception;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TestException {

	public static void main(String[] args) throws IOException {

		File file = new File("C:/Users/karun/Git/Algorithms/Novice/a.txt");

		BufferedReader buf = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buf.readLine()) != null) {
			System.out.println(line);
		}
		StringTokenizer s = new StringTokenizer("");

		buf.close();
	}

	public static void doIt(int number) throws Exception {
		assert number != 6;

		try {
			doItAgain();
		} // catch (Exception e) {
			// return;
			// throw new Exception("Error");
			// }
		finally {
			System.out.println("ola");
		}

		System.out.println("Oh my god");
	}

	public static void doItAgain() throws Exception {
		System.out.println("Hello");
		// throw new Exception("Should not have come here");

	}

}

class A {

	public void doOne() throws IOException, FileNotFoundException, InterruptedException {

	}

}

class B extends A {

	@Override
	public void doOne() throws FileNotFoundException {
		// super.doOne();
		// throw new FileNotFoundException("");
	}
}
