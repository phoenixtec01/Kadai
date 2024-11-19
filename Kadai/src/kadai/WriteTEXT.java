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
	public void writeing(String CSVData[][],int line) throws IOException {	
        FileWriter filewriter = new FileWriter(textfile);
        Nextline = MAXLINE -1;
        
		for (int i = 0 ;i < line -3;i++) {
			if (i == 0 ) {
				for (int j = 0;j <3;j++) {
					filewriter.write(CSVData[i][j]);
					if (j <2) {
						filewriter.write("、");
					}
				}
				filewriter.write(System.lineSeparator());
			}else {
				Datatext[0]="ーーーーーーーーーーーーーーーーーーーー";
				Datatext[1]=CSVData[i][0];
				Datatext[2]=CSVData[i][1] + "ー" + CSVData[i][2];
				Datatext[3]=CSVData[i][3] + ":" + CSVData[i][4];
				Datatext[4]=CSVData[i][5] + "," + CSVData[i][6];
				for (int j = 0;j <5;j++) {
					filewriter.write(Datatext[j]);
					filewriter.write(System.lineSeparator());
				}
				Nextline = Nextline -5;
				if (Nextline < 5) {				
					for (int k = 0;k<Nextline;k++) {
						filewriter.write(System.lineSeparator());
					}
					Nextline = MAXLINE;
				}
			}
		}
        filewriter.close();	
	}
}
