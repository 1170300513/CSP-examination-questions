package CSP_2019_12;
import java.sql.*;

public class test {
  public static void main(String[] args) {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("Success loading Mysql Driver!");
    } catch (Exception e) {
      System.out.print("Error loading Mysql Driver!");
      e.printStackTrace();
    }
  }
}
