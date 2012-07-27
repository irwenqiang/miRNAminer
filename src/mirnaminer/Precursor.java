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
public class Precursor {
  public Precursor() {
  }

  public void run() {
    try {
      BufferedReader br = new BufferedReader(new FileReader("sang1zong.txt"));
      BufferedWriter bw = new BufferedWriter(new FileWriter("precursors.txt"));
      int k = 1;
      while (br.ready()) {

        String tmp=br.readLine();
        if(tmp.length()==0)
          continue;
        br.readLine();
        if (br.readLine().indexOf("anti") != -1) {
          for (int i = 0; i < 10; i++) {
            br.readLine();
          }
        }
        else {
          for (int i = 0; i < 3; i++) {
            br.readLine();
          }
        }
        bw.write(">" + String.valueOf(k));
        bw.newLine();
        k++;
        bw.write(br.readLine());
        bw.newLine();
        bw.flush();



      }
      System.out.print("ok!");
      br.close();
    }
    catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }
}
