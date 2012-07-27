package mirnaminer;
import java.io.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2008</p>
 * <p>Company: </p>
 * @author Quan Zou
 * @version 1.0
 */

public class FilterSVM {
  double threshold =0.8;
  public FilterSVM() {
  }
  public int code(char a,char b,char c){
  int i=-1;
  switch(a){
    case 'a':
    case 'A':switch(b){
               case'a':
               case'A':switch(c){
                         case'a':
                         case'A':i=0;break;
                         case'c':
                         case'C':i=1;break;
                         case'g':
                         case'G':i=2;break;
                         case't':
                         case'T':
                         case'u':
                         case'U':i=3;break;
                         default:break;
                       }break;
                case'c':
                case'C':switch(c){
                         case'a':
                         case'A':i=4;break;
                         case'c':
                         case'C':i=5;break;
                         case'g':
                         case'G':i=6;break;
                         case't':
                         case'T':
                         case'u':
                         case'U':i=7;break;
                         default:break;
                       }break;
                case'g':
                case'G':switch(c){
                         case'a':
                         case'A':i=8;break;
                         case'c':
                         case'C':i=9;break;
                         case'g':
                         case'G':i=10;break;
                         case't':
                         case'T':
                         case'u':
                         case'U':i=11;break;
                         default:break;
                       }break;
                case't':
                case'T':
                case'u':
                case'U':switch(c){
                         case'a':
                         case'A':i=12;break;
                         case'c':
                         case'C':i=13;break;
                         case'g':
                         case'G':i=14;break;
                         case't':
                         case'T':
                         case'u':
                         case'U':i=15;break;
                         default:break;
                       }break;
                default:break;
             }break;
    case 'c':
    case 'C':switch(b){
               case'a':
               case'A':switch(c){
                         case'a':
                         case'A':i=16;break;
                         case'c':
                         case'C':i=17;break;
                         case'g':
                         case'G':i=18;break;
                         case't':
                         case'T':
                         case'u':
                         case'U':i=19;break;
                         default:break;
                       }break;
                case'c':
                case'C':switch(c){
                         case'a':
                         case'A':i=20;break;
                         case'c':
                         case'C':i=21;break;
                         case'g':
                         case'G':i=22;break;
                         case't':
                         case'T':
                         case'u':
                         case'U':i=23;break;
                         default:break;
                       }break;
                case'g':
                case'G':switch(c){
                         case'a':
                         case'A':i=24;break;
                         case'c':
                         case'C':i=25;break;
                         case'g':
                         case'G':i=26;break;
                         case't':
                         case'T':
                         case'u':
                         case'U':i=27;break;
                         default:break;
                       }break;
                case't':
                case'T':
                case'u':
                case'U':switch(c){
                         case'a':
                         case'A':i=28;break;
                         case'c':
                         case'C':i=29;break;
                         case'g':
                         case'G':i=30;break;
                         case't':
                         case'T':
                         case'u':
                         case'U':i=31;break;
                         default:break;
                       }break;
                default:break;
             }break;
    case 'g':
    case 'G':switch(b){
               case'a':
               case'A':switch(c){
                         case'a':
                         case'A':i=32;break;
                         case'c':
                         case'C':i=33;break;
                         case'g':
                         case'G':i=34;break;
                         case't':
                         case'T':
                         case'u':
                         case'U':i=35;break;
                         default:break;
                       }break;
                case'c':
                case'C':switch(c){
                         case'a':
                         case'A':i=36;break;
                         case'c':
                         case'C':i=37;break;
                         case'g':
                         case'G':i=38;break;
                         case't':
                         case'T':
                         case'u':
                         case'U':i=39;break;
                         default:break;
                       }break;
                case'g':
                case'G':switch(c){
                         case'a':
                         case'A':i=40;break;
                         case'c':
                         case'C':i=41;break;
                         case'g':
                         case'G':i=42;break;
                         case't':
                         case'T':
                         case'u':
                         case'U':i=43;break;
                         default:break;
                       }break;
                case't':
                case'T':
                case'u':
                case'U':switch(c){
                         case'a':
                         case'A':i=44;break;
                         case'c':
                         case'C':i=45;break;
                         case'g':
                         case'G':i=46;break;
                         case't':
                         case'T':
                         case'u':
                         case'U':i=47;break;
                         default:break;
                       }break;
                default:break;
             }break;
    case 't':
    case 'T':
    case 'u':
    case 'U':switch(b){
               case'a':
               case'A':switch(c){
                         case'a':
                         case'A':i=48;break;
                         case'c':
                         case'C':i=49;break;
                         case'g':
                         case'G':i=50;break;
                         case't':
                         case'T':
                         case'u':
                         case'U':i=51;break;
                         default:break;
                       }break;
                case'c':
                case'C':switch(c){
                         case'a':
                         case'A':i=52;break;
                         case'c':
                         case'C':i=53;break;
                         case'g':
                         case'G':i=54;break;
                         case't':
                         case'T':
                         case'u':
                         case'U':i=55;break;
                         default:break;
                       }break;
                case'g':
                case'G':switch(c){
                         case'a':
                         case'A':i=56;break;
                         case'c':
                         case'C':i=57;break;
                         case'g':
                         case'G':i=58;break;
                         case't':
                         case'T':
                         case'u':
                         case'U':i=59;break;
                         default:break;
                       }break;
                case't':
                case'T':
                case'u':
                case'U':switch(c){
                         case'a':
                         case'A':i=60;break;
                         case'c':
                         case'C':i=61;break;
                         case'g':
                         case'G':i=62;break;
                         case't':
                         case'T':
                         case'u':
                         case'U':i=63;break;
                         default:break;
                       }break;
                default:break;
             }break;
     default:break;
  }
  return(i);
}


  public String kuplecompute(String presurcor){
    String output = "";
    float num[] = new float[64];
    int i;
    for (i = 0; i < 64; i++)
      num[i] = 0;
    for (i = 0; i < presurcor.length() - 2; i++) {
      int j = code(presurcor.charAt(i), presurcor.charAt(i + 1),
                   presurcor.charAt(i + 2));
      if (j != -1)
        num[j]++;
    }
    for (i = 0; i < 64; i++) {
      num[i] = num[i] / (float) (presurcor.length() - 2);
      output = output.concat(" " + String.valueOf(i) + ":" +
                             String.valueOf(num[i]));
    }
    return (output);
  }



public void svmpredict(){
   try{
     Process p =Runtime.getRuntime().exec("2.bat");
     p.waitFor();
   }
   catch(Exception ex){
   }
 }


  public void run(){
    try{
      BufferedReader br = new BufferedReader(new FileReader("ESTprecucorcan.txt"));
      //BufferedWriter bw = new BufferedWriter(new FileWriter("est_precursor.txt"));
      BufferedWriter bw1 = new BufferedWriter(new FileWriter("feature1.txt"));
      int k=1;
      while(br.ready()){
        System.out.println(k);
        k++;
        String title = br.readLine();
        String seq = br.readLine();
        String ss = br.readLine();
        bw1.write("1 ");
        bw1.write(kuplecompute(seq));
        bw1.newLine();
        bw1.flush();

      }
      //bw.close();
      bw1.close();
      br.close();
    }
    catch(Exception ex){
      System.out.println(ex.getMessage());
    }
    svmpredict();

    try{
      BufferedReader br = new BufferedReader(new FileReader("ESTprecucorcan.txt"));
      BufferedReader brsvm =  new BufferedReader(new FileReader("svmout.txt"));
      BufferedWriter bw = new BufferedWriter(new FileWriter("out_svm.txt"));
      while(br.ready()&&brsvm.ready()){
        String line = brsvm.readLine();
        if(line.length()==0)
          continue;
        if(line.charAt(0)=='-'){
          br.readLine();
          br.readLine();
          br.readLine();
        }
        else{
          bw.write(br.readLine());
          bw.newLine();
          bw.write(br.readLine());
          bw.newLine();
          bw.write(br.readLine());
          bw.newLine();
          bw.flush();
        }
      }
      bw.close();
      brsvm.close();
      br.close();
      System.out.println("OK!");
    }
    catch(Exception ex){

    }



  }

}
