/**  
 *  Class that reads in a line and puts it in a defendant object, which can be used for
 *  data analysis (printing stats)
 *  For example, one row in the csv is put into an object for the defendant 
 *  class and its fields are analyzed for stats
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DefendantGroup {

  /**
   *  declare an arraylist of type defendant
   */
  ArrayList<Defendant> defendantArrayList = new ArrayList<Defendant>();

  /**
   *  constructor that reads csv
   *  takes in a file name and reads it line by line and assigns each line 
   *  into a defendant object
   *  @param file name 
   */
  public DefendantGroup(String filename) {
    Scanner file = null;
    try {
      file = new Scanner(new File(filename));
    } catch (FileNotFoundException e) {
      System.err.println("Cannot locate file.");
      System.exit(-1);
    }
    file.nextLine();
    while (file.hasNextLine()) {
      String line = file.nextLine();
      //System.out.println(line);
      Defendant defendant = new Defendant(line);
      defendantArrayList.add(defendant); 
      //System.out.println(defendant.toString());
    }
    file.close();
  }

  /**
   *  Method that adds defendant    
   *
   *  requires Defendant object as input and adds it on the arraylist
   *  @param defendant object 
   */
  public void addDefendant(Defendant d) {
    defendantArrayList.add(d);
  }

  /** 
   *  Method that gets defendant   
   *
   *  user inputs index and the element corresponding to that index in the arraylist is returned
   *  @param index
   *  @return defendant object in arraylist
   */
  public Defendant getDefendant(int i) {
    return defendantArrayList.get(i);
  }

  /**
   *  Method that removes defendant 
   *  user inputs index and the element corresponding to that index in the arraylist is removed
   *  @param index 
   */
  public void removeDefendant(int i) {
    defendantArrayList.remove(i);
  }

  /**
   *  finds length of arraylist
   *  @param length of arraylist 
   */
  public int size() {
    return defendantArrayList.size();
  }

  /**
   *  Method that prints stats. 
   *
   *  prints percentages, including 
   *  white, high risk, did not reoffend
   *  black, high risk, didn't reoffend
   *  white, low risk, did reoffend
   *  black, low risk, did reoffend
   */
  public void proPublica() {
    // variables to count particular categories
    // note that medium and high risk are counted here as high
    int wly = 0; // White, low risk, has reoffended
    int wln = 0; // White, low risk, has not reoffended
    int bly = 0; // Black, low risk, has reoffended
    int bln = 0; // Black, low risk, has not reoffended
    int why = 0; // White, high risk, has reoffended
    int whn = 0; // White, high risk, has not reoffended
    int bhy = 0; // Black, high risk, has reoffended
    int bhn = 0; // Black, high risk, has not reoffended

    // loop to count sums
    for (int i = 0; i < size(); i++) {
      Defendant d = getDefendant(i);
      if (d.isWhite()&&d.isLowRisk()&&d.hasReoffended()) {
        wly++;
      } else if (d.isWhite()&&d.isLowRisk()&&!d.hasReoffended()) {
        wln++;
      } else if (d.isBlack()&&d.isLowRisk()&&d.hasReoffended()) {
        bly++;
      } else if (d.isBlack()&&d.isLowRisk()&&!d.hasReoffended()) {
        bln++;
      } else if (d.isWhite()&&!d.isLowRisk()&&d.hasReoffended()) {
        why++;
      } else if (d.isWhite()&&!d.isLowRisk()&&!d.hasReoffended()) {
        whn++;
      } else if (d.isBlack()&&!d.isLowRisk()&&d.hasReoffended()) {
        bhy++;
      } else if (d.isBlack()&&!d.isLowRisk()&&!d.hasReoffended()) {
        bhn++;
  }
}

    // print the results
    System.out.println("White, high risk, didn't reoffend: "+whn*100.0/(whn+wln)+" %");
    System.out.println("Black, high risk, didn't reoffend: "+bhn*100.0/(bhn+bln)+" %");
    System.out.println("White, low risk, did reoffend: "+wly*100.0/(wly+why)+" %");
    System.out.println("Black, low risk, did reoffend: "+bly*100.0/(bly+bhy)+" %");
  }
}