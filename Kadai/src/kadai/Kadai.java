/**
 * 
 */
package kadai;



/**
 * 
 */
public class Kadai {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
	    //コマンドライン（パラメータ）が2つあるか確認
		if (args.length != 2) {
            System.out.println("コマンドライン引数が足りません。");
            System.exit(0);
        }
		
		//パラメータの内容を配列に格納
		String input[] = new String[2];
		for (int i = 0 ; i < args.length ; i++) {
			input [i] = args[i];
		}
		
		//コマンドラインを解析(Path作成)
		String url[] = new String[2];
		url = ReadCommandline.read(input);
		
		System.out.println(url[0]);
		System.out.println(url[1]);
		System.out.println("finished.");
	}
	
	
}
