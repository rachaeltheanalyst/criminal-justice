/**
 *  Class to represent the characteristics of
 *  one defendant from a dataset
 */
public class Defendant implements ProPublica{
  /** 
   *  Sex of defendant.   
   */
  private String sex;
  /** 
   *  Race of defendant.   
   */
  private String race;
  /** 
   *  charge degree of criminal   
   */
  private char c_charge_degree;
  /** 
   *  description of charge  
   */
  private String c_charge_desc;
  /** 
   *  Score for level of risk  
   */
  private int decile_score;
  /** 
   *  level of risk  
   */
  private String score_text;
  /** 
   *  if another crime was committed (0 for no, 1 for yes)  
   */
  private int two_year_recid;
  /** 
   *  recidivism charge description 
   */
  private String r_charge_desc;
  /** 
   *  recidivism charge degree  
   */
  private String r_charge_degree;

  /**
   *  constructor that initializes fields
   *  @param private fields initialized above  
   */
  public Defendant(String sex, String race, char c_charge_degree, String c_charge_desc, int decile_score, String score_text, int two_year_recid, String r_charge_desc, String r_charge_degree) {
    this.sex = sex;
    this.race = race;
    this.c_charge_degree = c_charge_degree;
    this.c_charge_desc = c_charge_desc;
    this.decile_score = decile_score;
    this.score_text = score_text;
    this.two_year_recid = two_year_recid;
    this.r_charge_desc = r_charge_desc;
    this.r_charge_degree = r_charge_degree;
  }
  
  /**
   *  another String constructor
   *  splits one string with comma separation, assigns corresponding values to the fields (converts values 
   *  that do not match the field's type), and gets rid of 
   *  rows with problems (multiple commas together, missing fields, values that do not follow the same type 
   *  as the field)                              
   *  For example, one value, like two_year_recid, gets assigned to two_year_recid field by converting it 
   *  to an integer and making sure it follows the standard convention for csv lines
   *  @param one string with all fields.                                                                    
   */
  public Defendant(String row) {
    String[] data_values = new String[9];
    data_values = row.split(",");
    this.sex = data_values[0];
    this.race = data_values[1];
    this.c_charge_degree = data_values[2].charAt(0);
    this.c_charge_desc = data_values[3];
    if (data_values[4] != "" && data_values[4] != null && data_values[4].matches("-?\\d+")) {
      this.decile_score = Integer.parseInt(data_values[4]);
    }
    this.score_text = data_values[5];
    if (data_values[6] != "" && data_values[6] != null && data_values[6].matches("-?\\d+")) {
      this.two_year_recid = Integer.parseInt(data_values[6]);
    }
    if (data_values.length >= 8 && data_values[7] != "" && data_values[7] != null) {
      this.r_charge_desc = data_values[7];
    }
    if (data_values.length >= 9 && data_values[8] != "" && data_values[8] != null) {
    this.r_charge_degree = data_values[8];
    }
  }

  /**
   *  getters, setters...    
   */

  /**
   *  get Sex  
   *  @return Sex field
   */
  public String getSex() {
    return this.sex;
  }

  /**
   *  set Sex      
   *  @param sex field
   */
  public void setSex(String sex) {
    this.sex = sex;
  }

  /**
   *  get Race  
   *  @return race field
   */
  public String getRace() {
    return this.race;
  }

  /**
   *  set Race      
   *  @param race field
   */
  public void setRace(String race) {
    this.race = race;
  }

  /**
   *  get charge degree  
   *  @return charge degree field
   */
  public char getChargeDegree() {
    return this.c_charge_degree;
  }

  /**
   *  set charge degree      
   *  @param charge degree field
   */
  public void setChargeDegree(char c_charge_degree) {
    this.c_charge_degree = c_charge_degree;
  }

  /**
   *  get charge description  
   *  @return charge description field
   */
  public String getChargeDesc() {
    return this.c_charge_desc;
  }

  /**
   *  set charge description      
   *  @param charge description field
   */
  public void setChargeDesc(String c_charge_desc) {
    this.c_charge_desc = c_charge_desc;
  }

  /**
   *  get decile score 
   *  @return decile score field
   */
  public int getDecileScore() {
    return this.decile_score;
  }

  /**
   *  set decile score     
   *  @param decile score field
   */
  public void setDecileScore(int decile_score) {
    this.decile_score = decile_score;
  }

  /**
   *  get Score text  
   *  @return Score text field
   */
  public String getScoreText() {
    return this.score_text;
  }

  /**
   *  set score text      
   *  @param score text field
   */
  public void setScoreText(String score_text) {
    this.score_text = score_text;
  }

  /**
   *  get two year recid  
   *  @return two year recid field
   */
  public int getTwoYearRecid() {
    return this.two_year_recid;
  }

  /**
   *  set two year recid      
   *  @param two year recid field
   */
  public void setTwoYearRecid(int two_year_recid) {
    this.two_year_recid = two_year_recid;
  }

  /**
   *  get R charge description  
   *  @return R charge description field
   */
  public String getRChargeDesc() {
    return this.r_charge_desc;
  }

  /**
   *  set R charge description     
   *  @param R charge description field
   */
  public void setRChargeDesc(String r_charge_desc) {
    this.r_charge_desc = r_charge_desc;
  }

  /**
   *  get R charge degree  
   *  @return R charge degree field
   */
  public String getRChargeDegree() {
    return this.r_charge_degree;
  }

  /**
   *  set R charge degree      
   *  @param R charge degree field
   */
  public void setRChargeDegree(String r_charge_degree) {
    this.r_charge_degree = r_charge_degree;
  }

  /** Method to return each criminal's data
   * 
   *  returns a string of variable names and values
   *  @return return string of variable names and values
   */
  public String toString() {
    return "Sex: " + this.sex + ", " + "Race: " + this.race + ", " + "Criminal charge degree: " + this.c_charge_degree + ", " + "Criminal charge description: " + this.c_charge_desc + ", " + "Decile score: " + this.decile_score + ", " + "Score text: " + this.score_text + ", " + "Two year recidivism: " + this.two_year_recid + ", " + "Recidivism charge description: " + this.r_charge_desc + "Recidivism charge degree: " + this.r_charge_degree;
  }

  /**
   *  isWhite() detects if race is Caucasian     
   *  @return boolean if race is Caucasian
   */
  public boolean isWhite(){
    if (this.race.equals("Caucasian")) {
      return true;
    }
    else {
      return false;
    }
  }

  /**
   *  isBlack() detects if race is African-American     
   *  @return boolean if race is African-American
   */
  public boolean isBlack(){
    if (this.race.equals("African-American")) {
      return true;
    }
    else {
      return false;
    }
  }

  /**
   *  hasReoffended() detects if criminal has reoffended    
   *  @return boolean if criminal has reoffended
   */
  public boolean hasReoffended(){
    if (this.two_year_recid == 0) {
      return false;
    }
    else {
      return true;
    }
  }

  /**
   *  isLowRisk() detects if criminal is low risk    
   *  @return boolean if criminal is low risk
   */
  public boolean isLowRisk(){
    if (this.score_text.equals("Low")) {
      return true;
    }
    else {
      return false;
    }
  }
}