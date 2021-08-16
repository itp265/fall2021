import java.util.*;

public class StudentData {
	
	private List<TVWatcher> people;
	
	public StudentData() {
		people = new ArrayList<>();
		ArrayList<String> data = FileReader.readFile("bin/tvShowFormData.tsv");
		parseData(data);
	}

	private void parseData(ArrayList<String> data) {
		String header = data.get(0);
		System.out.println("Data is formatted like the following: \n" + header);
		for(int i = 1; i < data.size(); i++) {
			String line = data.get(i);
			System.out.println(i + " : " + line);
			//turn that line into a StudentTVWatcher and add to list of people
		}
		
	}

	public static void main(String[] args) {
		StudentData program = new StudentData();

	}

}
