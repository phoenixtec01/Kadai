/**
 * 
 */
package kadai;

import java.util.*;
import java.io.File;

/**
 * 
 */
public class Kadai {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
	    //コマンドライン（パラメータ）が2確認
		
		ReadCommandline RCline = new ReadCommandline(args);
		
		String csvname;
		String textname;
		
		csvname = RCline.Pathget(RCline.parname(0));
		textname = RCline.Pathget(RCline.parname(1));
		
		System.out.println(csvname);
		System.out.println(textname);
		
		ReadCSV RCS = new ReadCSV(csvname);

		
		//パラメータの内容を配列に格納
		/*String input[] = new String[2];
		for (int i = 0 ; i < args.length ; i++) {
			input [i] = args[i];
		}
		
		//コマンドラインを解析(Path作成)
		String url[] = new String[2];
		url = ReadCommandline.read(input);
		
		ArrayList<String> csvdata = new ArrayList<>();

		System.out.println(url[0]);
		System.out.println(url[1]);*/
		System.out.println("finished.");
	}
	
}
