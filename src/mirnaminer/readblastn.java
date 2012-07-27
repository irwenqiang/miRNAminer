package mirnaminer;
import java.io.*;

import test.BlastGenerator;
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
public class readblastn {
  public readblastn() {
  }
  public void run(){
    try{
    	BufferedReader br = new BufferedReader(new FileReader("result.txt"));
//      BufferedReader br = new BufferedReader(new FileReader("input.txt"));
      BufferedWriter bw = new BufferedWriter(new FileWriter("blastn_info.txt"));
      String line = "";
      String matureseq="",genomeseq="";
      while(br.ready()){
        if(line.indexOf("Query=")!=-1){
          String maturename = line.trim().substring(6).trim();
          while(br.ready()){
            line = br.readLine();
            if(line.length()==0)
              continue;
            else if(line.indexOf("No hits found")!=-1)
              break;
            else if(line.charAt(0)=='>'){
              String genomename =line.trim().substring(1);
              while(br.ready()){
                line = br.readLine();
                if(line.indexOf("Query:")!=-1)
                  matureseq = line.trim();
                if(line.indexOf("Sbjct:")!=-1){
                  genomeseq = line.trim();
                  break;
                }
              }
              bw.write(maturename);
              bw.newLine();
              bw.write(genomename);
              bw.newLine();
              bw.write(matureseq);
              bw.newLine();
              bw.write(genomeseq);
              bw.newLine();
              bw.newLine();
              bw.flush();
            }
            else if(line.indexOf("Query=")!=-1)
              break;
          }
        }
        else
          line = br.readLine();
      }
      br.close();
      bw.close();
      System.out.println("ok!");
    }
    catch(Exception ex){
      System.out.println(ex.getMessage());
    }
  }
}
