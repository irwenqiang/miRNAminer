package test;

import com.bsi.tools.patternHunter.PHunterConsole;

public class PatternHunter_test {
	public static void main(String[] args) {
		String inputfile1="leyi/input.fna";
		//String inputfile2="leyi/input.fna";
		String subjectfile="leyi/input.fna";
        String outputfile="result.txt";
        String[] arg=new String[6]; 
        arg[0]="-i";
        arg[1]=inputfile1;
//        arg[2]=inputfile2;
        arg[2]="-j";
        arg[3]=subjectfile;
        arg[4]="-o";
        arg[5]=outputfile;
        PHunterConsole.main(arg);
	}
}

