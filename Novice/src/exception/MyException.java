package exception;

import java.io.IOException;

public class MyException extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String myError;

	public MyException(String error, int... errorCode) {
		myError = error;
		System.out.println("Hello");
	}

	public static void main(String[] args) {

		MyException e = new MyException("dd", 3);
		System.out.println(e.myError);
	}
}