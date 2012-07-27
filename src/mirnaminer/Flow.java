package mirnaminer;

import test.BlastGenerator;

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
public class Flow {
  public Flow() {
  }
  public void run(){
    System.out.println("Reading the result from BLASTN...");
    readblastn rb = new readblastn();
    rb.run();
    System.out.println("Extending the information...");
    Extend e = new Extend();
    e.run();
    System.out.println("Extracting precursors...");
    Precursor precursor = new Precursor();
    precursor.run();
    System.out.println("Predicting Secondary Structure...");
    
    try{
      Process process = Runtime.getRuntime().exec("fold.bat");
      process.waitFor();
    }
    catch(Exception ex){
      System.out.println(ex.getMessage());
      System.exit(0);
    }
    System.out.println("Extracting hairpins...");
    ExtractHairpinSeq ehs = new ExtractHairpinSeq();
    ehs.run();
    System.out.println("Do SVM...");
    FilterSVM f = new FilterSVM();
    f.run();
    System.out.println("Computing the free energies...");
    try{
      Process process = Runtime.getRuntime().exec("a.bat");
      process.waitFor();
    }
    catch(Exception ex){
      System.out.println(ex.getMessage());
      System.exit(0);
    }
    System.out.println("Filter by energies...");
    ComputeEnergy ce = new ComputeEnergy();
    ce.run();
    System.out.println("Delete the repeated sequences...");
    DeleteRe dr = new DeleteRe();
    dr.run();
    System.out.println("Output the whole information...");
    getinformation g = new getinformation();
    g.run();
    System.out.println("Extract sequences...");
    SimpleInformation si = new SimpleInformation();
    si.run();
    try{
      Process process = Runtime.getRuntime().exec("fold2.bat");
      process.waitFor();
    }
    catch(Exception ex){
      System.out.println(ex.getMessage());
      System.exit(0);
    }
    System.out.println("Draw hairpins...");
    DrawHairpin dh = new DrawHairpin();
    dh.run();
    System.out.println("Deleting temp files");
  //  DeleteFiles df = new DeleteFiles();
 //   df.run();
  }
}
