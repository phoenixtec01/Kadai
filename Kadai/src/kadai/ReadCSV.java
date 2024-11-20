package kadai;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class ReadCSV {
	private int linecount;
	private File csvfiledata;
	private String CPath;
	private String[] CSVLine;
	private String[][] CSVData;
	
	public ReadCSV(String CSVPath) {
		
	//ファイルの存在確認
	try {
		CPath = CSVPath;
		csvfiledata = new File(CPath);
		FileReader filereader = new FileReader(csvfiledata);
		Scanner sc = new Scanner(csvfiledata);
	    
		while (sc.hasNextLine()) {
	        sc.nextLine();
	        linecount++;
	    }
	    sc.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}
	
	//CSVファイルの行数
	public int CSVLines () {
		return linecount;
	}
	
	//ファイル内容を配列に書き込み
	public String[][] CSVwrite (){
		CSVLine = new String[7];
		CSVData = new String[linecount-3][7];
		try (BufferedReader br = new BufferedReader(new FileReader(CPath))) {
			String line;
			int i =0;
			int j =0;
	    	while ((line = br.readLine()) != null) {
	    		String[] data = line.split(",");
    			if (i!=0) { //CSVの先頭行はヘッダーなのでスキップ
    				if (i <4) { //CSV2行目から4行目は技術者情報なので、配列１行目に入れる
    					for (String csvtext : data) {
    						CSVLine[j] = csvtext;
    						CSVData[0][j] =CSVLine[j];
    						j++;
    					}
    				}else { //CSVの5行目以降は経歴情報なので、配列2行目以下に入れる。コンマで細かく分ける。
    					int k = 0;
    					for (String csvtext : data) {
    						CSVLine[k] = csvtext;
    						CSVData[i-3][k] =CSVLine[k];
    						k++;
    					}
    				}
    			}
    			i++;
	    	}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return CSVData;
	}
	
	//CSVデータのチェック
	public void DataCheak() {
		for (int i = 0 ;i < linecount -3;i++) {
			for (int j = 0;j <7;j++) {
				if (i==0) {
					if (j < 3 ) {
						Objects.requireNonNull(CSVData[i][j]);						
					}
				}else {
					Objects.requireNonNull(CSVData[i][j]);	
				}
			}
		}
	}
}



