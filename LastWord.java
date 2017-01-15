import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * 
 * @author Dustin Olychuck
 * @version 15/01/2017
 * Last word Round 1A from Google Code Jam 2016.
 *
 */
public class LastWord {

	/**
	 * 
	 * @param str A string representing a word.
	 * @return A string that is the last of an alphabetically sorted list of 
	 * all of the possible last words that could have been produced. 
	 */
	public static String lastWord(String str) {
		ArrayDeque<Character> result = new ArrayDeque<>();
		result.addFirst(str.charAt(0));

		for (int i = 1; i < str.length(); i++) {
			char temp = str.charAt(i);
			if (result.peekFirst() > temp)
				result.addLast(temp);
			else
				result.addFirst(temp);
		}
		StringBuilder st = new StringBuilder();
		while (!result.isEmpty()) {
			st.append(result.removeFirst());
		}
		return st.toString();
	}

	/**
	 * Takes in input from a file and writes output to another.
	 * @param fileIn The input file being read from.
	 * @param FileOut The out file being written to.
	 */
	public static void input(File fileIn, File fileOut) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileOut));
			Scanner sc = new Scanner(fileIn);
			int count = 1;
			sc.nextInt();
			while (sc.hasNext()) {
				out.write("Case #" + count++ + ": " + lastWord(sc.next()));
				out.newLine();
			}
			sc.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		File in = new File("C:\\Users\\Dustin\\Desktop\\A-large-practice.in");
		File out = new File("C:\\Users\\Dustin\\Desktop\\out.txt");
		LastWord.input(in,out);
	}
}
