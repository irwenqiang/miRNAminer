package test;

import com.ppfold.main.PPfold;

public class PPfold_test {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
		String inputfile = "dataset/gca-alignment.fasta";
		String outputfile = "dataset/result";
		String[] arg = new String[3];
		arg[0] = inputfile;
		arg[1] = "-o";
		arg[2] = outputfile;
		PPfold pf = new PPfold();
		pf.main(arg);
	}
}