import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Set;
import java.util.Scanner;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;

public class DuplicateCounter {
	
	private Map<String, Integer> wordCounter = new HashMap<>();
	
	public void count(String dataFile) {
		try {
		File input = new File(dataFile);
		Scanner read = new Scanner(input);
			while (read.hasNextLine()) {
				String string = read.next().toLowerCase();
				if (wordCounter.containsKey(string)) {
					int num = wordCounter.get(string);
					wordCounter.put(string, num +1);
				}
				else
					wordCounter.put(string, 1);
		}
			read.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found, terminating program");
			e.printStackTrace();
		}
	}
	
	public void write(String outputFile) {
		try {
			FileWriter output = new FileWriter(outputFile);
			BufferedWriter writer = new BufferedWriter(output);
			Set<String> list = wordCounter.keySet();
			for (String string : list) {
			writer.write(string + "");
			writer.write(" ");
			writer.write(wordCounter.get(string) + "");
			writer.newLine();
			
			}
			writer.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found, terminating program");
			e.printStackTrace();
		}
		catch (IOException v) {
			System.out.println("Could not create file...Terminating program");
			v.printStackTrace();
		}
	}
}