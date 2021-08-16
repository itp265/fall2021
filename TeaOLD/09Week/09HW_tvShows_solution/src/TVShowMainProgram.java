import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class TVShowMainProgram {

	private BFF bff;
	private List<TVWatcher> people; // a simple list of all the data
	private List<TVShow> shows; // a list of shows, with duplicates combined

	private Map<String, TVWatcher> userMap;
	private Map<TVShow, Integer> showCount ;
	private Map<Streaming, List<TVShow>> serviceMap ;

	public TVShowMainProgram() {
		bff = new BFF();
		people = new ArrayList<>();
		shows = new ArrayList<>();
		readInitialDataFromFile();
		shows = collapseDuplicates(shows);
		setupMaps(); // after the data is read in and the lists are made, set up the maps

	}
	public void setupMaps() {
		userMap =  makeUserMap();
		showCount =  makePopularityMap();
		serviceMap =  makeServiceMap();
	}

	////////////////////////////////////////////////////////////
	// STEP 1: Handling errors 
	////////////////////////////////////////////////////////////
	private void readInitialDataFromFile() {
		String file = "bin/tvShowFormData.tsv";
		ArrayList<String> data = FileReader.readFile(file);
		String header = data.get(0);
		//System.out.println("Data is formatted like the following: \n" + header);

		for(int i = 1; i < data.size(); i++) {
			String line = data.get(i);

			try {
				TVWatcher person = parseDataLineToStudentWatcher(line);
				people.add(person);
				for(TVShow show: person.getFavorites()) {
					this.shows.add(show);
				}
			} catch (InvalidTVWatcherException e) {
				System.out.println("ERROR on LINE " + i + " of file: " + e);
				e.printStackTrace();
			}
		}

	}


	private TVWatcher parseDataLineToStudentWatcher(String lineOfFile) throws InvalidTVWatcherException {
		//Timestamp	Email Address	Your first name	Your last name	Which section are you in?	
		//Your number 1 favorite tv show	Which streaming service is it on?	Your number 2 favorite tv show	Which streaming service is it on?	Your number 3 favorite tv show	Which streaming service is it on?
		Scanner sc = new Scanner(lineOfFile);
		sc.useDelimiter("\t");

		try {
			String timestamp = sc.next();
			String email = sc.next();
			String fname = sc.next();
			String lname = sc.next();
			String section = sc.next().toUpperCase();
			ArrayList<TVShow> shows = new ArrayList<>();
			//additional loop allows to getting 1+ shows from the line
			while(sc.hasNext()) {
				String show = sc.next().toLowerCase();
				if(! show.isBlank()) {
					char let = show.charAt(0);
					String cap = (let+"").toUpperCase();
					show = cap + show.substring(1);
					String platform = sc.next(); // platforms could have multiple items
					String[] str_array = platform.split(",");
					Streaming[] services = new Streaming[str_array.length];
					for(int i = 0; i < str_array.length; i++) {
						services[i] = Streaming.matchService(str_array[i]);
					}
					shows.add(new TVShow(show, services));
				}
				// else : Missing data for rest of show, not adding
			}
			TVWatcher watcher = new StudentTVWatcher(email, fname, lname, shows, Section.valueOf(section));
			return watcher;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new InvalidTVWatcherException("Error parsing the tv watcher from line: " + lineOfFile);

		}
	}
	////////////////////////////////////////////////////////////
	//STEP 2: Commenting Helper Methods
	////////////////////////////////////////////////////////////

	//TODO: Comment (For Step 2)
	private List<TVShow> collapseDuplicates(List<TVShow> allData) {
		Set<String> showNames = new HashSet<>();
		List<TVShow> noDups = new ArrayList<>();
		for(TVShow show : allData) {
			String name = show.getName();
			if(showNames.contains(name)) {
				// showName is in set, does the show match one in the list?
				if(!noDups.contains(show)) {
					//show name matches, but the TVShow object is different, so match up services
					TVShow other = findMatch(name, noDups);
					for(Streaming serv: show.getServices()) {
						other.addSevice(serv);
					}

				}
			}
			else {
				showNames.add(name);
				noDups.add(show);

			}
		}
		return noDups;
	}

	//TODO: Comment (For Step 2)
	private TVShow findMatch(String name, List<TVShow> allShows) {
		TVShow match = null;
		int i = 0;
		while (i < allShows.size() && match == null) {
			TVShow show = allShows.get(i);
			if(show.getName().equalsIgnoreCase(name)) {
				match = show;
			}
			i++;
		}
		return match;
	}
	////////////////////////////////////////////////////////////
	//STEP 3: Making maps
	////////////////////////////////////////////////////////////

	private Map<String, TVWatcher> makeUserMap() {
		Map<String, TVWatcher> userMap = new HashMap<>();
		for(TVWatcher p: this.people) {
			userMap.put(p.getEmail(), p);
		}
		return userMap;
	}

	private Map<Streaming, List<TVShow>> makeServiceMap() {
		Map<Streaming, List<TVShow>>  map = new HashMap<>();
		for(Streaming s: Streaming.values()) {
			map.put(s, new ArrayList<>() );
		}
		for(TVShow show: this.shows) {
			for(Streaming s: show.getServices()) {
				if(!map.get(s).contains(show)) {
					map.get(s).add(show);
				}
			}

		}
		return map;
	}

	private Map<TVShow, Integer> makePopularityMap() {
		Map<TVShow, Integer> map = new HashMap<>();

		for(TVWatcher person: this.people) {
			for(TVShow show: person.getFavorites()) {
				TVShow standard = findMatch(show.getName(), shows);
				if(map.containsKey(standard)) {
					int value = map.get(standard);
					map.put(standard, value + 1);
				}
				else {
					map.put(standard, 1);
				}
			}
		}

		return map;
	}



	public void run(){
		bff.print("Welcome to the program for exploring tv shows");


		boolean keepGoing = true;
		while(keepGoing){
			TVProgramMenu.printMenu();
			int num = bff.inputInt(">", 1,  TVProgramMenu.getNumOptions());
			TVProgramMenu option = TVProgramMenu.getOption(num);
			switch(option){

			case PRINT_MAP_USERS: 
				printUserMap(userMap);
				break;
			case  PRINT_SERVICE_MAP: 
				printServiceMap(serviceMap);
				break;
			case PRINT_MAP_POPULARITY_SHOWS: 
				printPopularityMap(showCount);
				break;
			case FIND_NUMBER_LIKES: 
				String name = bff.inputLine("Enter the show you want to find count for");
				findLikes(name, showCount);
				break;
			case GET_MOST_POPULAR: //optional
				List<Integer> counts = new ArrayList<>(showCount.values());
				Collections.sort(counts);
				int most = counts.get(counts.size()-1);
				System.out.println("These popular shows are liked by " + most + " people:");
				for(TVShow show: showCount.keySet()) {
					if(showCount.get(show) == most) {
						System.out.println("\t" + show);
					}
				}
				break;
			case MAKE_USER_FILE: // ("Make user file of people who like a show"),
				String sn = bff.inputLine("Enter the show you want to find in common");
				TVShow showName = findMatch(sn, shows);
				if(showName != null) {
					writeUsersTofile(showName);
				}
				else {
					System.out.println("No data to match that show");
				}
				break;
			case READ_USER_FILE: // ("Read user file based on name of file"),
				String file = bff.inputLine("Enter the name of the user file you want to read").toLowerCase();
				readUserFile(file);
				break;
			case WRITE_LIST_TO_FILE: 
				String serviceName = bff.inputLine("Enter the service you want to make file for");
				Streaming service = Streaming.matchService(serviceName);
				writeShowsToFile(service, serviceMap);
				break;
			case QUIT   :  keepGoing = false; break;
			}
		}
		bff.print("Goodbye");
	}


	////////////////////////////////////////////////////////////
	//STEP 4: Methods for the TVProgram Menu
	////////////////////////////////////////////////////////////
	private void printUserMap(Map<String, TVWatcher> map) {
		System.out.println("USER MAP");
		for(Map.Entry<String, TVWatcher> pair: map.entrySet()) {
			System.out.println("\t" + pair.getKey() + "->" + pair.getValue());
		}

	}
	private void printServiceMap(Map<Streaming, List<TVShow>> map) {
		System.out.println("List of shows in alphabetical order by service");
		for(Map.Entry<Streaming, List<TVShow>> pair: map.entrySet()) {
			System.out.println(pair.getKey() + "->");
			List<TVShow> allShows = pair.getValue();
			Collections.sort(allShows);
			for(TVShow t : allShows) {
				System.out.println("\t" + t); 
			}
		}

	}

	private void printPopularityMap(Map<TVShow, Integer> map) {
		System.out.println("Popularity Show MAP");
		for(Map.Entry<TVShow, Integer> pair: map.entrySet()) {
			System.out.println("\t" + pair.getKey() + ": " + pair.getValue() );
		}

	}

	private void readUserFile(String showName) {
		List<TVShow> otherShows = new ArrayList<>();
		String file = showName;
		if(!file.endsWith(".txt")) {
			file += ".txt";
		}

		try (FileInputStream fis = new FileInputStream(file);
				Scanner sc = new Scanner(fis)){
			while(sc.hasNextLine()) {
				String person = sc.nextLine();
				System.out.println("Data in file; " + person);
				Scanner pSc = new Scanner(person);
				pSc.useDelimiter("/");
				String email = pSc.next();
				TVWatcher watcher = this.userMap.get(email);
				if(watcher != null) {
					for(TVShow show : watcher.getFavorites()) {
						otherShows.add(show);
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("No file with that name found: " + file);

		} catch (IOException e) {
			System.out.println("An error occured reading the user file");

		}
		otherShows = this.collapseDuplicates(otherShows);
		otherShows.remove(this.findMatch(showName, otherShows));
		if(otherShows.size() > 1) {
			System.out.println("Based on people who like " + showName + " you might also like:");
			for(TVShow s: otherShows) {
				System.out.println(s);
			}
		}

	}

	private void writeUsersTofile(TVShow showName) {
		String fileName = showName.getName().toLowerCase();
		try (FileOutputStream fos = new FileOutputStream(fileName + ".txt");
				PrintWriter out = new PrintWriter(fos)){

			for(TVWatcher person: this.people) {
				if(person.likesShow(showName)) {
					out.println(person.getEmail() + "/" + person.getName());
				}
			}
			System.out.println("Wrote matching users to : " +  fileName + ".txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void writeShowsToFile(Streaming serviceName, Map<Streaming, List<TVShow>> serviceMap) {
		List<TVShow> shows = serviceMap.get(serviceName);

		try (FileOutputStream fout = new FileOutputStream("src/" + serviceName + ".txt");
				PrintWriter out = new PrintWriter(fout)){

			for(TVShow s : shows) {
				out.println(s.toString());
			}

			System.out.println("Wrote the data to file: " + "src/" + serviceName + ".txt");
		} // everything does auto-close
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void findLikes(String name, Map<TVShow, Integer> showCount) {

		TVShow show = null;

		for(TVShow s: showCount.keySet()) {
			if(s.getName().equalsIgnoreCase(name)) {
				show = s;
				break; // not great practice
			}
		}
		if(show != null) {
			System.out.println("There are : " + showCount.get(show) + " people who like that show");
		}
		else {
			System.out.println("Did not find that show in the data");

		}


	}



	public static void main(String[] args) {
		TVShowMainProgram program = new TVShowMainProgram();
		program.run();

	}

}
