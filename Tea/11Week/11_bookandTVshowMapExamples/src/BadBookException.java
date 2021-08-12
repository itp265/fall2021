import java.io.*;
public class BadBookException extends IOException {
	public BadBookException() {
		super();
	}
	public BadBookException(String msg) {
		super(msg);
	}
}
