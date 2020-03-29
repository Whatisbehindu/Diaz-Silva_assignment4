import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.FileWriter;
import java.io.IOException;

public class DuplicateRemover {
	
	private Set<String> uniqueWords = new HashSet<String>();
	
	public void remove(String dataFile) {
		try {
		File input = new File(dataFile);
		Scanner read = new Scanner(input);
			while (read.hasNextLine()) {
				uniqueWords.add(read.next().toLowerCase());
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
			for (String string : uniqueWords) {
			writer.write(string + "");
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