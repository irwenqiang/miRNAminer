package mirnaminer;
import java.io.*;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: </p>
 *
 * @author Quan Zou
 * @version 1.0
 */
public class getinformation {
  public getinformation() {
  }
  public String nibu(String dna){
   dna = dna.toUpperCase().replace('U','T');
   StringBuffer sb = new StringBuffer();
   for(int i=dna.length()-1;i>=0;i--){
     if (dna.charAt(i) == 'A')
       sb.append('T');
     else if(dna.charAt(i) == 'C')
       sb.append('G');
     else if(dna.charAt(i) == 'G')
       sb.append('C');
     else if(dna.charAt(i) == 'T')
       sb.append('A');
     else
       sb.append('N');
   }
   return sb.toString();
 }
 public String reverse(String dna){
   dna = dna.toUpperCase().replace('U','T');
   StringBuffer sb = new StringBuffer();
   for(int i=0;i<dna.length();i++){
     if (dna.charAt(i) == 'A')
       sb.append('T');
     else if(dna.charAt(i) == 'C')
       sb.append('G');
     else if(dna.charAt(i) == 'G')
       sb.append('C');
     else if(dna.charAt(i) == 'T')
       sb.append('A');
     else
       sb.append('N');
   }
   return sb.toString();

 }


  public void run() {
    try {
      BufferedReader br1 = new BufferedReader(new FileReader("out_svm_mefi_deletere.txt"));
      BufferedReader br2 = new BufferedReader(new FileReader("sang1zong.txt"));
      BufferedWriter bw = new BufferedWriter(new FileWriter("outlast.txt"));
      int k = 0;
      String res = br1.readLine();
      int num = Integer.parseInt(res.substring(1, res.indexOf(' ')));
      while (br1.ready() && br2.ready()) {
        String[] s = new String[14];
        s[0] = br2.readLine();
        s[1] = br2.readLine();
        s[2] = br2.readLine();

        if (s[2].indexOf("anti") != -1) {
          for (int i = 3; i < 14; i++) {
            s[i] = br2.readLine();
          }
        }
        else {
          for (int i = 3; i < 7; i++) {
            s[i] = br2.readLine();
          }
        }
        br2.readLine();
        k++;

        if (k == num) {
          String precursor="";
          int begin = Integer.parseInt(res.substring(res.indexOf(' ') + 1,
              res.indexOf('-')));
          int end = Integer.parseInt(res.substring(res.indexOf('-') + 1));
          precursor=br1.readLine().replace('U','T');
          br1.readLine();
          res = br1.readLine();
          if (br1.ready()) {
            num = Integer.parseInt(res.substring(1, res.indexOf(' ')));
          }
          if (s[2].indexOf("anti") != -1) {
            for(int i=0;i<14;i++)
              System.out.println(s[i]);
            if(precursor.indexOf(s[12])==-1)
              continue;
            for (int i = 0; i < 4; i++) {
              bw.write(s[i]);
              bw.newLine();
            }

            int b = Integer.parseInt(s[4].substring(s[4].indexOf(':')+1,s[4].indexOf("--")));

            int e = Integer.parseInt(s[4].substring(s[4].indexOf('>')+1));
            b-=begin;
            e=b-end;

            bw.write("pre-miRNA position:"+String.valueOf(b)+"-->"+String.valueOf(e));
            bw.newLine();
            bw.write(s[5]);
            bw.newLine();
            bw.write(s[6]);
            bw.newLine();
            bw.write(reverse(precursor));
            bw.newLine();
            bw.write(s[8]);
           bw.newLine();
           bw.write(s[9]);
           bw.newLine();
           bw.write(nibu(precursor));
            bw.newLine();
            bw.write(s[11]);
           bw.newLine();
           bw.write(s[12]);
           bw.newLine();
           bw.write(precursor);
            bw.newLine();
            bw.newLine();
           bw.flush();





          }
          else {
            for(int i=0;i<7;i++)
              System.out.println(s[i]);
            System.out.println("===");
            if(precursor.indexOf(s[5])==-1)
              continue;
            for (int i = 0; i < 4; i++) {
              bw.write(s[i]);
              bw.newLine();
            }
            int b = Integer.parseInt(s[4].substring(s[4].indexOf(':')+1,s[4].indexOf("--")));
            int e = Integer.parseInt(s[4].substring(s[4].indexOf('>')+1));
            b+=begin;
            e=e+b+end;

            bw.write("pre-miRNA position:"+String.valueOf(b)+"-->"+String.valueOf(e));
            bw.newLine();
            bw.write(s[5]);
            bw.newLine();
            bw.write(precursor);
            bw.newLine();
            bw.newLine();
            bw.flush();

          }

        }
      }
      br2.close();
      br1.close();
      System.out.println("ok");
    }
    catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }
}
