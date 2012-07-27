package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import com.ppfold.main.PPfold;

public class FoldFormater {
	public void doFold(){
		String inputfile = "dataset/gca-alignment.fasta";
		String outputfile = "dataset/result";
		String[] arg = new String[3];
		arg[0] = inputfile;
		arg[1] = "-o";
		arg[2] = outputfile;
		PPfold pf = new PPfold();
		pf.main(arg);
	}
	public static void convert(String inputPath, String outputPath){
		File outputFile = new File(outputPath);

		if (!outputFile.exists())
			try {
				outputFile.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(outputFile);
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}

		File file = new File(inputPath);

		BufferedReader br = null;
		try {
			InputStreamReader read = new InputStreamReader(new FileInputStream(
					file), "utf-8");
			br = new BufferedReader(read);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String temp = null;


		StringBuffer sb = new StringBuffer();
		try {
			temp = br.readLine();
			temp = br.readLine();
			
			temp = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}


		
		while (temp != null) {
			if(temp.length() != 0 && !temp.contains("pairingmask")){
				int index = temp.indexOf(" ");
				String name = temp.substring(0, index + 1);
				temp = temp.substring(index + 1);
				String seq = temp;
				
				sb.append(">")
				  .append(name)
				  .append("\n")
				  .append(seq)
				  .append("\n");
			}else if(temp.contains("pairingmask")){
				temp = temp.substring(temp.indexOf(" ")+1);
				sb.append(temp)
				  .append("\n");
			}
			
			try {
				temp = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println(sb.toString());
		try {
			out.write(sb.toString().getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch bloc			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FoldFormater cv = new FoldFormater();
//		cv.doFold();
		
		cv.convert("precursors/precursors.lseq", "precursors_ss.txt");
		cv.convert("simple/simple.lseq", "simple_ss.txt");
		
	}

}
