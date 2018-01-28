import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * The solution to Google Code Jam "Oversized Pancake Flipper"
 * https://code.google.com/codejam/contest/3264486/dashboard.
 * @author Dustin Olychuck
 * @version 1/27/2018
 *
 */
public class PancakeFlipper {

	/**
	 * 
	 * @param arr An array representing Pancakes that require a flip.
	 * @param i The index that needs a flip.
	 */
	static void swap(char[] arr, int i) {
		if (arr[i] == '-')
			arr[i] = '+';
		else
			arr[i] = '-';
	}

	/**
	 * 
	 * @param str The input string for one set of Pancakes.
	 * @param k The number of Pancakes that must flip at one time.
	 * @param numCase The number of test cases.
	 * @return The number of times that a flip must occur to turn all Pancakes to a + or "IMPOSSIBLE if it cannot be done.
	 */
	static String flip(String str, int k, int numCase) {
		char arr[] = str.toCharArray();
		int result = 0;
		int i;
		for (i = 0; i <= (arr.length - k); i++) {
			if (arr[i] == '-') {
				result++;
				int start = i;
				for (int j = start; j < (start + k); j++) {
					swap(arr, j);
				}
			}
		}
		for (int m = i; m < arr.length; m++) {
			if (arr[m] == '-') {
				return "Case #" + numCase + ": IMPOSSIBLE";
			}
		}
		return "Case #" + numCase + ": " + result;
	}

	/**
	 * A method to take in a file with input data to produce a correct output file.
	 * @param inPath The input file path.
	 * @param outPath The output file path.
	 */
	static void fileIO(String inPath, String outPath) {
		File inFile = new File(inPath);
		FileWriter writer;
		try {
			writer = new FileWriter(outPath);
			BufferedWriter outFile = new BufferedWriter(writer);

			Scanner sc = new Scanner(inFile);
			int n = sc.nextInt();

			for (int i = 1; i <= n; i++) {
				outFile.write(flip(sc.next(), sc.nextInt(), i));
				outFile.newLine();
			}
			sc.close();
			outFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		String inPath = "A-large-practice.in";
		String outPath = "output";

		fileIO(inPath, outPath);
	}
}
