package mirnaminer;
import java.io.*;
public class ComputeEnergy {
    double minMFEI = 0.8;
    public ComputeEnergy() {
    }

    /**
     * this method will compute the content rate of G+C in the input String
     * @param s String
     * @return double
     */
    public double GC(String s){
        double gc=0;
        s = s.toLowerCase();
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)=='g'||s.charAt(i)=='c')
                gc++;
        gc = gc/(double)s.length();
        return gc;
    }

    public void run(){
        try{
            BufferedReader br1 = new BufferedReader(new FileReader("out_svm_en.txt"));

            BufferedWriter bw1 = new BufferedWriter(new FileWriter("out_svm_mefi.txt"));


            while(br1.ready()){
                String title = br1.readLine();
                String pre = br1.readLine().trim();
                double gc = GC(pre);
                String ss = br1.readLine().trim();
                double en = Double.parseDouble(ss.substring(pre.length()+2,ss.length()-1));
                double mfei = Math.abs(en)/(double)pre.length()/gc;

                if(mfei>minMFEI&&gc>0.3&&gc<0.7){
                    bw1.write(title);
                    bw1.newLine();
                    bw1.write(pre);
                    bw1.newLine();
                    bw1.write(ss);
                    bw1.newLine();
                    bw1.flush();


                }
            }

            br1.close();

            bw1.close();

            System.out.println("Successful");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
