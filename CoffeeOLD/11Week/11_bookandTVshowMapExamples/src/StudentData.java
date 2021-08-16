import java.util.*;

public class StudentData {
	
	private List<TVWatcher> people;
	
	public StudentData() {
		people = new ArrayList<>();
		ArrayList<String> data = FileReader.readFile("bin/tvShowFormData.tsv");
		parseData(data);
	}
	
	private void parseData(ArrayList<String> fileData) {
		String header = fileData.get(0);
		System.out.println("Date is formatted like this: \n" + header);
		for(int i = 1; i< fileData.size(); i++) {
			String line = fileData.get(i);
			System.out.println(i + ": " + line);
			//turn that line into a StudentTVWatcher and add to list of people....
		}
	}

	public static void main(String[] args) {
		StudentData d = new StudentData();
	}

}
