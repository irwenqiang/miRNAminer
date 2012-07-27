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
public class DrawHairpin {
  public DrawHairpin() {
  }

  public void run(){
    try{
      BufferedReader br = new BufferedReader(new FileReader("simple_ss.txt"));
      BufferedWriter bw = new BufferedWriter(new FileWriter("output.str"));
      while(br.ready()){
        String line = br.readLine();
        if(line.length()==0)
          continue;
        if(line.charAt(0)=='>'){
          String title = line;
          String seq = br.readLine();
          String ss = br.readLine().substring(0,seq.length());
          int mature_begin = Integer.parseInt(title.substring(title.lastIndexOf(':')+1,title.lastIndexOf('-')));
          int mature_end = Integer.parseInt(title.substring(title.lastIndexOf('-')+1));
          seq = seq.toLowerCase();
          seq =seq.substring(0,mature_begin-1)+seq.substring(mature_begin-1,mature_end).toUpperCase()+seq.substring(mature_end);

          StringBuffer[] sb = new StringBuffer[5];
          for(int i=0;i<5;i++)
            sb[i] = new StringBuffer();

          sb[0].append(' ');
          sb[0].append(' ');
          sb[1].append('5');
          sb[1].append('\'');
          sb[2].append(' ');
          sb[2].append(' ');
          sb[3].append('3');
          sb[3].append('\'');
          sb[4].append(' ');
          sb[4].append(' ');
          System.out.println(ss);
          int pos5 = 0,pos3=ss.length()-1;

          while(pos3>pos5){

            if(ss.charAt(pos5)=='.'&&ss.charAt(pos3)=='.'){
              sb[0].append(seq.charAt(pos5));
              sb[1].append(' ');
              sb[2].append(' ');
              sb[3].append(' ');
              sb[4].append(seq.charAt(pos3));
              pos5++;
              pos3--;

            }
            else if(ss.charAt(pos5)=='('&&ss.charAt(pos3)==')'){
              sb[0].append(' ');
              sb[1].append(seq.charAt(pos5));
              sb[2].append('|');
              sb[3].append(seq.charAt(pos3));
              sb[4].append(' ');
              pos5++;
              pos3--;

            }
            else if(ss.charAt(pos5)=='('&&ss.charAt(pos3)=='.'){
              sb[0].append('-');
              sb[1].append(' ');
              sb[2].append(' ');
              sb[3].append(' ');
              sb[4].append(seq.charAt(pos3));
              pos3--;

            }
            else if(ss.charAt(pos5)=='.'&&ss.charAt(pos3)==')'){
              sb[0].append(seq.charAt(pos5));
              sb[1].append(' ');
              sb[2].append(' ');
              sb[3].append(' ');
              sb[4].append('-');
              pos5++;

            }
            else{
              System.out.println("errors");
              System.out.println(pos3);
              System.out.println(pos5);
              System.out.println(ss.charAt(pos5));
              System.out.println(ss.charAt(pos3));
              System.exit(0);
            }
          }
          if(sb[1].charAt(sb[1].length()-1)==' '&&sb[3].charAt(sb[3].length()-1)==' '){
            sb[1].deleteCharAt(sb[1].length() - 1);
            sb[1].append(sb[0].charAt(sb[0].length()-1));
            sb[0].deleteCharAt(sb[0].length() - 1);
            sb[0].append(' ');
            sb[3].deleteCharAt(sb[3].length() - 1);
            sb[3].append(sb[4].charAt(sb[4].length()-1));
            sb[4].deleteCharAt(sb[4].length() - 1);
            sb[4].append(' ');

          }
          if(pos5==pos3){
            sb[2].deleteCharAt(sb[2].length()-1);
            sb[2].append(seq.charAt(pos5));
          }

          bw.write(title);
          bw.newLine();
          bw.newLine();
          for(int i=0;i<5;i++){
            bw.write(sb[i].toString());
            bw.newLine();
          }
          bw.newLine();
          bw.flush();
        }
      }
      br.close();
      bw.close();
      System.out.print("ok!");
    }
    catch(Exception ex){
      System.out.println(ex.getMessage());
    }
  }
}
