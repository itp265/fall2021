import java.io.*;
import java.util.*;

public class Sample {

	public static void main(String[] args) {
		//12_fileSample/numbers.txt
		try (FileInputStream fis = new FileInputStream("bin/numbers.txt");
				Scanner scan = new Scanner(fis)){
			while(scan.hasNextInt()) {
				int num = scan.nextInt();
				System.out.println("Read in number from file: " + num);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found, no numbers in the program.");
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Code is still running even though file was not found");
	}

}
