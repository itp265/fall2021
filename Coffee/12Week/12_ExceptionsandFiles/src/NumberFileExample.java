import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class NumberFileExample {

	public static void main(String[] args) {
		try(FileInputStream fis = new FileInputStream("bin/numbers.txt");
				Scanner scan = new Scanner(fis)){
			while(scan.hasNextInt()) {
				int num = scan.nextInt();
				System.out.println("Read in: " + num);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
