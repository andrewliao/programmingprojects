package project4;

import java.io.*;

/**
 * 
 * @author Andrew Liao
 *
 */

public class WordPath {
	public static int numLines(Reader reader) throws IOException {
		BufferedReader br = new BufferedReader(reader);
		int lines = 0;
		while(br.readLine() != null) {
			lines++;
		}
		br.close();
		return lines;
	}
	
	public WordData[] makeWordArray(String fileName) throws IOException {
		FileReader x = new FileReader(fileName);
		int numOfLines = WordPath.numLines(x);
		WordData[] y = new WordData[numOfLines];
		x.close();
		
		BufferedReader z = new BufferedReader(new FileReader(fileName));
		String line;
		int i = 0;
		WordData thing = new WordData();
		while((line = z.readLine()) != null) {
			y[i++] = thing.parseWordData(line);
		}
		return y;
		
		
	}
}
