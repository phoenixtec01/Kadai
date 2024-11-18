package kadai;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;

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
		if (par.size() !=2) {
			System.out.println("Parameter Count Error!");
			System.exit(1);
		}
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
	
	/*
	public String[] read(String[] input) {
		// TODO 自動生成されたメソッド・スタブ
		
		//Pathを格納する配列を確保
		String paths[] = new String[2];
		
		//現在位置のURLを取得
		String url = System.getProperty("user.dir");
		
		// 現在位置・CSV・TextファイルをPath型に変換
		Path now = Paths.get(url);
		Path csv = Paths.get(input[0]);
		Path text = Paths.get(input[1]);
		
		//CSV・TextファイルのPathを現在位置のPathと結合
		Path csvpath = now.resolve(csv);
		Path textpath = now.resolve(text);
		
		//PathをString型に変換
		String pathcsv = csvpath.toString();
		String pathtext = textpath.toString();
		
		//CSVファイルが存在するかチェック
		File csvfile = new File(pathcsv);
		if (csvfile.exists()){
		}else {
			System.out.println("CSVファイルが存在しません。");
			System.exit(0);
		}
		
		//テキストファイルが存在するかチェック
		File textfile = new File(pathtext);
		if (textfile.exists()){
			System.out.println("テキストファイルが存在します。");
			System.exit(0);
		}else {
		}
		
		//Pathを配列に格納してreturn
		paths[0] = pathcsv;
		paths[1] = pathtext;
		
			return paths;
	}
	*/
}
