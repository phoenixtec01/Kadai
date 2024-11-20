package kadai;

import java.io.File;
import java.io.FileWriter;

import java.io.IOException;

class WriteTEXT {
	private String Datatext[];
	private int Nextline;//１ページに記載できる残りの行数
	final private int MAXLINE = 30; //テキストファイルの１ページに記載できる最大行数
	private File textfile;
	
	public WriteTEXT(String TextURL){
		Datatext = new String [5];
		textfile = new File(TextURL);
	}
	
	//テキストファイル出力
	public void writeing(String CSVData[][],int line) throws IOException {	
        FileWriter filewriter = new FileWriter(textfile);
        Nextline = MAXLINE -1;//１ページ目の先頭行は個人情報が確定で入るので-1する
        
		for (int i = 0 ;i < line -3;i++) {
			if (i == 0 ) { //１ページ目の先頭行は個人情報
				for (int j = 0;j <3;j++) {
					filewriter.write(CSVData[i][j]);
					if (j <2) { //住所記載前までは情報の間に"、"を追加する
						filewriter.write("、");  
					}
				}
				filewriter.write(System.lineSeparator());
			}else { //１ページ目の先頭行以外は経歴情報
				Datatext[0]="ーーーーーーーーーーーーーーーーーーーー";//枠線
				Datatext[1]=CSVData[i][0];//経歴番号
				Datatext[2]=CSVData[i][1] + "ー" + CSVData[i][2]; //期間
				Datatext[3]=CSVData[i][3] + ":" + CSVData[i][4]; //案件・案件詳細
				Datatext[4]=CSVData[i][5] + "," + CSVData[i][6]; //使用OS・言語
				for (int j = 0;j <5;j++) {
					filewriter.write(Datatext[j]);
					filewriter.write(System.lineSeparator()); //１行分記載後改行
				}
				Nextline = Nextline -5;//経歴情報は5行使用する
				if (Nextline < 5) {	//記入可能行数が5行以下になったら、ページ最下段までは空白行を挿入			
					for (int k = 0;k<Nextline;k++) {
						filewriter.write(System.lineSeparator());
					}
					Nextline = MAXLINE;//新しいページなので記入可能行数をリセット
				}
			}
		}
        filewriter.close();	
	}
}
