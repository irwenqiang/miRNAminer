package test;

import com.ppfold.main.PPfold;

public class PPfolder {
	public static void doFold(String inputPath, String outputDir){
		String[] arg = new String[3];
		arg[0] = inputPath;
		arg[1] = "-o";
		arg[2] = outputDir;
		PPfold pf = new PPfold();
		pf.main(arg);
	}

	public static void main(String[] args) throws Exception {
		PPfolder pf = new PPfolder();
		pf.doFold("precursors.txt", "precursors");
//		pf.doFold("simple.txt", "simple");
	}
}