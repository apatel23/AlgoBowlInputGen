import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class NumGen {
	
	FileWriter fw;
	ArrayList<Integer> tasks;
	ArrayList<Integer> machines;
	Random rand = new Random();
	static NumGen ng;
	String input = "input.txt";
	int t, n, m;
	
	
	NumGen(int n, int m) throws IOException {
		fw = new FileWriter(new File(input));
		fw.write(n + "\n" + m + "\n");
		
		setTasks(genTasks(n));
		setMachines(genMachines(m));
		
		ArrayList<Integer> times = getTasks();
		ArrayList<Integer> speeds = getMachines();
		
		System.out.println("Tasks: ");
		System.out.println("num: " + n);
		displayList(times);
		System.out.println("\nMachines: ");
		System.out.println("num: " + m);
		displayList(speeds);
		System.out.println("");
		fw.close();
	}
	

	public int numTasks() {
		t = rand.nextInt(1000) + 1;
		return t;
	}
	
	public int numMachines() {
		m = rand.nextInt(50) + 1;
		return m;
	}
	
	public ArrayList<Integer> genTasks(int num) {
		tasks = new ArrayList<Integer>();
		
		for(int i = 0; i < num; i++) {
			// task processing times in [1,10000]
			int currentTask = rand.nextInt(10000) + 1;
			if(tasks.contains(currentTask)) currentTask+=1;
			tasks.add(currentTask);
		}
		return tasks; 
	}
	
	public ArrayList<Integer> genMachines(int num) {
		machines = new ArrayList<Integer>();
		
		for(int i = 0; i < num; i++) {
			// machine speeds in [1,20]
			int currentMachine = rand.nextInt(20) + 1;
			machines.add(currentMachine);
		}
		return machines;
	}
	
	public void displayList(ArrayList<Integer> a) throws IOException {
		for(int i = 0; i < a.size(); i++) {
			fw.write(a.get(i) + " ");
			System.out.print(a.get(i) + " ");
		}
		System.out.print("");
		fw.write("\n");
	}
	
	public ArrayList<Integer> getTasks() {return tasks;}

	public void setTasks(ArrayList<Integer> tasks) {this.tasks = tasks;}

	public ArrayList<Integer> getMachines() {return machines;}

	public void setMachines(ArrayList<Integer> machines) {this.machines = machines;}
	
	public int getT() {return t;}

	public void setT(int t) {this.t = t;}

	public int getM() {return m;}

	public void setM(int m) {this.m = m;}
	
	
	
	public static void main(String[] args) throws IOException {
		if(args.length < 2)
			System.out.println("Invalid arguments");
		else {
			int n = Integer.parseInt(args[0]); // tasks
			int m = Integer.parseInt(args[1]); // machines
			ng = new NumGen(n, m);
		}
	}
}
