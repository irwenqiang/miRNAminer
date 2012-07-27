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
public class SimpleInformation {
  public SimpleInformation() {
  }

  public void run(){
    try{
      BufferedReader br = new BufferedReader(new FileReader("outlast.txt"));
      BufferedWriter bw = new BufferedWriter(new FileWriter("simple.txt"));
      while(br.ready()){
        String line = br.readLine();
        if(line.length()==0)
          continue;
        if(line.charAt(0)=='>'){
          String line1 = line.trim();
          String line2 = br.readLine();
          String line3 = br.readLine();
          if(line3.indexOf("anti")==-1){
            br.readLine();
            String pos = br.readLine();
            String mature = br.readLine();
            String precursor = br.readLine();

            String name =">"+line2.substring(0,line2.indexOf(' '))+"("+line1.substring(1)+":"+pos.substring(pos.indexOf(':'))+")";

            name = name + " mature position:"+String.valueOf(precursor.indexOf(mature)+1)+"-"+String.valueOf(precursor.indexOf(mature)+mature.length());
            bw.write(name);
            bw.newLine();
            bw.write(precursor);
            bw.newLine();
            bw.flush();
          }
          else{
            br.readLine();
           String pos = br.readLine();
           for(int i=0;i<7;i++)
             br.readLine();
           String mature = br.readLine();
           String precursor = br.readLine();

           String name =">"+line2.substring(0,line2.indexOf(' '))+"("+line1.substring(1)+":"+pos.substring(pos.indexOf(':'))+",antisense)";

           name = name + " mature position:"+String.valueOf(precursor.indexOf(mature)+1)+"-"+String.valueOf(precursor.indexOf(mature)+mature.length());
           bw.write(name);
           bw.newLine();
           bw.write(precursor);
           bw.newLine();
           bw.flush();

          }
        }
      }
      bw.close();
      br.close();
      System.out.println("ok!");
    }
    catch(Exception ex){
      System.out.println(ex.getMessage());
    }
  }
}
