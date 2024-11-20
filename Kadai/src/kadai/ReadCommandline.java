package kadai;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import java.util.*;

class ReadCommandline{

	private ArrayList<String> par = new ArrayList<>();
	private ArrayList<String> opt= new ArrayList<>();
	private String url = System.getProperty("user.dir");
	
	public ReadCommandline(String[] args) {
		for (int i =0 ; i <args.length;i++) {
			if (args[i].matches("-.*")) {
				opt.add(args[i]);
			}else {
				par.add(args[i]);
			}
		}
	}
	
	//パラメータの数を返す
	public int parcount () {
		return par.size();
	}
	
	//パラメータを返す
	public String parname (int p) {
		return par.get(p);
	}
	
	//ファイルPath作成
	public String Pathget (String filename) {
		Path now = Paths.get(url);
		Path npath = Paths.get(filename);
		Path filepath = now.resolve(npath);
		String pathname = filepath.toString();
		return pathname;
	}
	
	//テキストファイルの確認
	public void Textfilecheak (String testname) {
		Path textfile = Paths.get(testname);
		if (Files.exists(textfile)) {
			throw new IllegalArgumentException();	        
		}
	}	
}
