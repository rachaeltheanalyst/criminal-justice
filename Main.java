/**
 * Class that Loads each line of compas-scores.csv into a DefendantGroup
 * object that accepts one string that is the file name
 * Detects the race, risk level, and if they re-offended and prints stats
 * For example, given the race, which is assigned to the 
 * variable, tests if it is "White" or "African American"
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Main class that includes test classes, file reader
 */
public class Main {

  /**
   * Main method for calling test methods, creating a DefendantGroup object and
   * calling the proPublica method
   */
  public static void main(String[] args) {
    testConstructor();
    testSetters();
    testStringConstructor();
    testFileReader();
    testBooleans();
    DefendantGroup defendantGroup = new DefendantGroup("compas-scores.csv");
    defendantGroup.proPublica();
  }

  /**
   * Method to test the Defendant constructor.
   *
   * Construct a defendant object to test getter methods. For example, a defendant
   * object is constructed and a test is run for each field to test if the fields
   * correspond to the fields in the object
   */
  public static void testConstructor() {
    /* construct an object */
    Defendant d = new Defendant("Male", "Chinese", 'B', "Robbery", 5, "High", 1, "Murder of wife using gun", "Murder");
    TestCode.beginTest("testConstructor");
    TestCode.subTest("getSex", d.getSex().equals("Male"));
    TestCode.subTest("getRace", d.getRace().equals("Chinese"));
    TestCode.subTest("getChargeDegree", d.getChargeDegree() == 'B');
    TestCode.subTest("getChargeDesc", d.getChargeDesc().equals("Robbery"));
    TestCode.subTest("getDecileScore", d.getDecileScore() == 5);
    TestCode.subTest("getScoreText", d.getScoreText().equals("High"));
    TestCode.subTest("getTwoYearRecid", d.getTwoYearRecid() == 1);
    TestCode.subTest("getRChargeDesc", d.getRChargeDesc().equals("Murder of wife using gun"));
    TestCode.subTest("getRChargeDegree", d.getRChargeDegree().equals("Murder"));
    TestCode.concludeTest();
  }

  /**
   * Method to test the Defendant String constructor
   *
   * Construct a defendant object tests if one string correctly separates the
   * strings into fields For example, given a string, the method tests if the
   * String Constructor separates the strings, so that each string before the
   * comma becomes the value of the field
   */
  public static void testStringConstructor() {
    Defendant d = new Defendant(
        "Male,Caucasian,F,Possession Burglary Tools,6,Medium,1,Poss of Firearm by Convic Felo,(F2)");
    TestCode.beginTest("testStringConstructor");
    TestCode.subTest("Sex", d.getSex().equals("Male"));
    TestCode.subTest("getRace", d.getRace().equals("Caucasian"));
    TestCode.subTest("getChargeDegree", d.getChargeDegree() == 'F');
    TestCode.subTest("getChargeDesc", d.getChargeDesc().equals("Possession Burglary Tools"));
    TestCode.subTest("getDecileScore", d.getDecileScore() == 6);
    TestCode.subTest("getScoreText", d.getScoreText().equals("Medium"));
    TestCode.subTest("getTwoYearRecid", d.getTwoYearRecid() == 1);
    TestCode.subTest("getRChargeDesc", d.getRChargeDesc().equals("Poss of Firearm by Convic Felo"));
    TestCode.subTest("getRChargeDegree", d.getRChargeDegree().equals("(F2)"));
    TestCode.concludeTest();
  }

  /**
   * Method to test the setters
   * 
   * Construct a defendant object test if the setters from 
   * Defendant class are working correctly. For example, 
   * it tests if "female" value I want to put in
   * the field actually gets assigned to the Sex field
   */
  public static void testSetters() {
    Defendant d = new Defendant("", "", 'X', "", 0, "", 0, "", "");
    d.setSex("Female");
    d.setRace("Hispanic");
    d.setChargeDegree('D');
    d.setChargeDesc("Tax Evasion");
    d.setDecileScore(1);
    d.setScoreText("Low");
    d.setTwoYearRecid(1);
    d.setRChargeDegree("Selling drugs");
    d.setRChargeDesc("Selling cocaine");
    TestCode.beginTest("testSetters");
    TestCode.subTest("setSex", d.getSex().equals("Female"));
    TestCode.subTest("setRace", d.getRace().equals("Hispanic"));
    TestCode.subTest("setChargeDegree", d.getChargeDegree() == 'D');
    TestCode.subTest("setChargeDesc", d.getChargeDesc().equals("Tax Evasion"));
    TestCode.subTest("setDecileScore", d.getDecileScore() == 1);
    TestCode.subTest("setScoreText", d.getScoreText().equals("Low"));
    TestCode.subTest("setTwoYearRecid", d.getTwoYearRecid() == 1);
    TestCode.subTest("setRChargeDegree", d.getRChargeDegree().equals("Selling drugs"));
    TestCode.subTest("setRChargeDesc", d.getRChargeDesc().equals("Selling cocaine"));
    TestCode.concludeTest();
  }

  /**
   * Method to test reading in csv
   *
   * reads in the compas-scores.csv file line by line and assigns 
   * each line to a defendant object
   */
  public static void testFileReader() {
    Scanner file = null;
    try {
      file = new Scanner(new File("compas-scores.csv"));
    } catch (FileNotFoundException e) {
      System.err.println("Cannot locate file.");
      System.exit(-1);
    }
    file.nextLine();
    while (file.hasNextLine()) {
      String line = file.nextLine();
      Defendant defendant = new Defendant(line);
      // System.out.println(defendant.toString());
    }
    file.close();
  }

  /**
   * Method to test Booleans
   *
   * Construct a defendant object to test booleans. Test the 
   * isWhite(), isBlack(), hasReoffended(), isLowRisk(), and 
   * isHighRisk() methods For example, a defendant object is 
   * constructed and a test is run for each method to test if
   * the criminal is white (true if White, false if not White)
   * 
   */
  public static void testBooleans() {
    Defendant testBools = new Defendant("Male", "African-American", 'F', "Possession of Cocaine", 4, "Low", 1,
        "Driving Under The Influence", "(M1)");
    TestCode.beginTest("testBooleans");
    TestCode.subTest("isWhite", testBools.isWhite() == false);
    TestCode.subTest("isBlack", testBools.isBlack() == true);
    TestCode.subTest("hasReoffended", testBools.hasReoffended() == true);
    TestCode.subTest("isLowRisk", testBools.isLowRisk() == true);
    TestCode.concludeTest();
  }
}