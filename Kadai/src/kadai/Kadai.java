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

		
		try {
			ReadCommandline RCline = new ReadCommandline(args);
		    //コマンドライン（パラメータ）確認
			if (RCline.parcount() !=2) {
				System.out.println("Parameter Count Error!");
				System.exit(1);
			}
			
			String csvname;
			String textname;
			
			csvname = RCline.Pathget(RCline.parname(0));
			textname = RCline.Pathget(RCline.parname(1));
			
			System.out.println(csvname);
			System.out.println(textname);
			
			ReadCSV RCS = new ReadCSV(csvname);
			
			String CSVData[][] = new String[RCS.CSVLines()-3][7];
			
			CSVData =RCS.CSVwrite();
			
			RCS.DataCheak();
			
			RCline.Textfilecheak(textname);
			
			WriteTEXT WT = new WriteTEXT(textname);
			
			WT.writeing(CSVData, RCS.CSVLines());
			
		}catch (Exception e){
			System.out.println("Error");
			
		}
		System.out.println("finished.");
	}
	
}
