import java.io.IOException;

public class BadBookException extends IOException {
	public BadBookException() {
		super();
	}
	public BadBookException(String msg) {
		super(msg);
	}
}
