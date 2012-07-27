package mirnaminer;
import java.io.*;
import java.util.Vector;
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
public class DeleteRe {
  public DeleteRe() {
  }

  public void run(){
    try{
      BufferedReader br = new BufferedReader(new FileReader("out_svm_mefi.txt"));
      BufferedWriter bw = new BufferedWriter(new FileWriter("out_svm_mefi_deletere.txt"));
      Vector v = new Vector();
      while(br.ready()){
        String line = br.readLine();
        if(line.length()==0)
          continue;
        if(line.charAt(0)=='>'){
          String title = line;
          String seq = br.readLine();
          String ss=br.readLine();
          boolean flag = true;
          for(int i=0;i<v.size();i++){
            if(seq.equals(v.elementAt(i))){
              flag = false;
              break;
            }
          }
          if(flag){
            v.add(seq);
            bw.write(title);
            bw.newLine();
            bw.write(seq);
            bw.newLine();
            bw.write(ss);
            bw.newLine();
            bw.flush();
          }
        }
      }
      bw.close();
      br.close();
      System.out.println("OK!");
    }
    catch(Exception ex){
      System.out.println(ex.getMessage());
    }
  }
}
