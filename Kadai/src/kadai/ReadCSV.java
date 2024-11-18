package kadai;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;

class ReadCSV {
	private int linecount;
	private File file;
	
	public ReadCSV(String CSVPath) {
		
	//ファイルが存在確認と行数カウント（行数カウントは別メゾット予定）
	try {
		file = new File(CSVPath);
		FileReader filereader = new FileReader(file);
		Scanner sc = new Scanner(file);

	      while (sc.hasNextLine()) {
	        sc.nextLine();
	        linecount++;
	      }
	      System.out.println(linecount);
	      sc.close();
	} catch (FileNotFoundException e) {
	    System.out.println(e);
	}
	
	//ファイル内容書き込み（仕掛中）
	try (BufferedReader br = new BufferedReader(new FileReader(CSVPath))) {
	    String line;
	    	while ((line = br.readLine()) != null) {
	    		//System.out.println(line);
	    		}
	} catch (IOException e) {
		e.printStackTrace();
		}
	}
}


