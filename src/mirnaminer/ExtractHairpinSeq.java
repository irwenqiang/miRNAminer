package mirnaminer;
import java.io.*;
import java.util.Vector;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2008</p>
 * <p>Company: </p>
 * @author Quan Zou
 * @version 1.0
 */

public class ExtractHairpinSeq {
  int minhairpin;

  public ExtractHairpinSeq(int a) {
    minhairpin = a;
  }

  public ExtractHairpinSeq() {
    minhairpin = 60;
  }


  public String Loop(String s){
    String loop = "";
    int left=0, right = 0;
    //System.out.println(s);
    for(int i=0;i<s.length();i++){
      if(s.charAt(i)=='(')
        left++;
      if(s.charAt(i)==')')
        break;
    }
    for(int i=s.length()-1;i>=0;i--){
      if(s.charAt(i)==')')
        right++;
      if(s.charAt(i)=='(')
        break;
    }

    if(left>right)
      loop = s.substring(posofchar(s,'(',left-right+1),s.lastIndexOf(')')+1);
    else
      loop = s.substring(s.indexOf('('),posofchar(s,')',left)+1);
    //System.out.println(loop);
    return loop;
  }

  public int posofchar(String s, char c, int num){
    int pos=0;

    while(pos<s.length()){
      if(s.charAt(pos)==c){
        num--;
        if(num==0)
          break;
      }
      pos++;
    }
    return pos;
  }

  /**
   * return the longest hairpin in the secondary structure
   * @param ss String
   * @return int
   */
  public String hairpin(String ss){
    String loop = "";
    boolean flag = true;
    int begin = 0;
    Vector v = new Vector();
    for(int i=0;i<ss.length();i++){
      if(ss.charAt(i)=='('&&!flag){
        flag = true;
        v.add(ss.substring(begin,i));
        begin = i;
      }
      if(ss.charAt(i)==')')
        flag=false;
    }
    v.add(ss.substring(begin));

    for(int i=0;i<v.size();i++){
      String s = (String)v.get(i);
      String looptmp = Loop(s);

      if(loop.length() < looptmp.length())
        loop = looptmp;
    }


    return loop;
  }


  public void run(){
    try{
      BufferedReader br = new BufferedReader(new FileReader("precursors_ss.txt"));
      //BufferedWriter bw = new BufferedWriter(new FileWriter("hairpinEST.txt"));
      BufferedWriter bw1 = new BufferedWriter(new FileWriter("ESTprecucorcan.txt"));
      int k=0;
      while(br.ready()){


        String line = br.readLine();
        if(line.length()==0)
          continue;
        if(line.charAt(0)=='>'){
          System.out.println(k);
          k++;
          String title = line;
          String seq = br.readLine().trim();
          String ss = br.readLine().substring(0,seq.length());
          if(ss.indexOf('(')==-1)  //二级结构中没有配对！
            continue;

          String precursorss = hairpin(ss);
          int posbegin = ss.indexOf(precursorss);
          int posend = posbegin+precursorss.length();

          if(precursorss.length()>minhairpin){
        /*
            bw.write(title);
            bw.newLine();
            bw.write(seq);
            bw.newLine();
            bw.write(ss);
            bw.newLine();
            bw.flush();
*/
            bw1.write(title);
            bw1.write(" "+String.valueOf(posbegin)+"-"+String.valueOf(posend));
            bw1.newLine();
            bw1.write(seq.substring(posbegin,posend));
            bw1.newLine();
            bw1.write(ss.substring(posbegin,posend));
            bw1.newLine();
            bw1.flush();

          }

        }

      }
      bw1.close();
 //     bw.close();
      br.close();
      System.out.println("Sucessful!");
    }
    catch(Exception ex){
      System.out.println(ex.getMessage());
    }
  }

}
