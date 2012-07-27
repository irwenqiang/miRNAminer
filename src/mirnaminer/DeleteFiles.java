package mirnaminer;
import java.io.*;
/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2009</p>
 *
 * <p>Company: </p>
 *
 * @author Quan Zou
 * @version 1.0
 */
public class DeleteFiles {
  public DeleteFiles() {
  }
  public void run(){
    try{
      File f1 = new File("blastn_info.txt");
      f1.delete();
      File f2 = new File("sang1zong.txt");
      f2.delete();
      File f3 = new File("ESTprecucorcan.txt");
      f3.delete();
      File f4 = new File("feature1.txt");
      f4.delete();
      File f5 = new File("out_svm.txt");
      f5.delete();
      File f6 = new File("out_svm_en.txt");
      f6.delete();
      File f7 = new File("out_svm_mefi.txt");
      f7.delete();
      File f8 = new File("out_svm_mefi_deletere.txt");
      f8.delete();
      File f9 = new File("precursors.txt");
      f9.delete();
      File f10 = new File("precursors_ss.txt");
      f10.delete();
      File f11 = new File("simple.txt");
      f11.delete();
      File f12 = new File("simple_ss.txt");
      f12.delete();
      File f13 = new File("svmout.txt");
      f13.delete();
      System.out.println("OK!");
    }
    catch(Exception ex){
      System.out.println(ex.getMessage());
      System.exit(0);
    }
  }
}
