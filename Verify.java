import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Verify {
	
	Scanner sc1;
	Scanner sc2;
	String file;
	int t;
	int m;
	int answer;
	ArrayList<String> lines;
	ArrayList<String> sol;
	ArrayList<Task> tasks;
	ArrayList<Integer> check;
	
	// Verify(input, solution)
	Verify(String f, String g) throws FileNotFoundException {
		t = 0;
		m = 0;
		answer = 0;
		lines = new ArrayList<String>();
		tasks = new ArrayList<Task>();
		sol = new ArrayList<String>();
		check = new ArrayList<Integer>();
		sc1 = new Scanner(new File(f));
		sc2 = new Scanner(new File(g));

		parseInput();
		Boolean b = parseSolution();
		
		if(b == true) System.out.println("PASS");
		else System.out.println("FAIL");
	}
	
	public void parseInput() {
		String line = "";

		// Input file
		if(sc1.hasNextLine()) {
			while(sc1.hasNextLine()) {
				line = sc1.nextLine();
				lines.add(line);
				//System.out.println(": " + line);
			}
			String tes[] = lines.get(0).split(" ");
			t = Integer.parseInt(tes[0]);
			String ms[] = lines.get(1).split(" ");
			m = Integer.parseInt(ms[0]);
			//System.out.println("t: " + t + " m: " + m);
			String s = lines.get(2);
			String spl[] = s.split(" ");
			for(int i = 0; i < spl.length; i++) {
				Task ts = new Task(Integer.parseInt(spl[i]),i);
				tasks.add(ts);
				//System.out.println("spl: " + spl[i]);
			}
			t = tasks.size();
			for(Task ts : tasks) {
				//System.out.println(ts.id + ": " + ts.value);
			}

		}
	}
	
	public Boolean parseSolution() {
		String line = "";
		int count = 0;
		if(sc2.hasNextLine()) {
			while(sc2.hasNextLine()) {
				line = sc2.nextLine();
				sol.add(line);
				//System.out.println(": " + line);
			}
			for(int i = 0; i < m; i++) {
				//System.out.println("m: " + sol.get(i));
				String tes[] = sol.get(i).split(" ");
				count += tes.length;
				for(int j = 0; j < tes.length; j++) {
					//System.out.println("tes: " + tes[j]);
					int current = Integer.parseInt(tes[j]);
					if(!check.contains(current))
						check.add(current);
					else {
						System.out.println("already processed");
						return false;
					}
				}

			}
			if(count != t) {
				System.out.println("more/less tasks");
				return false; 
			}
		}
		return true;
	}

	
	public String getFile() {
		return file;
	}
	
	public void setFile(String f) {
		file = f;
	}

	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		if(args.length < 1) {
			System.out.println("Invalid Argument");
			return;
		}
		
		Verify v = new Verify(args[0],args[1]);
		
		

	}

}
