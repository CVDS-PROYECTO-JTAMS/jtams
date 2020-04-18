package edu.eci.cvds.jtams.exceptions;

public class JtamsExceptions extends Exception {

	public JtamsExceptions() {
		super();
	}

	public JtamsExceptions(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public JtamsExceptions(String message, Throwable cause) {
		super(message, cause);
	}

	public JtamsExceptions(String message) {
		super(message);
	}

	public JtamsExceptions(Throwable cause) {
		super(cause);
	}

}
