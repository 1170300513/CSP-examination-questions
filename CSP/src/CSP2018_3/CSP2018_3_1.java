package CSP2018_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSP2018_3_1 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<Integer> list = new ArrayList<>();
    int num;
    int centercount = 2;
    int point = 0;
    do {
      num = sc.nextInt();
      if(num == 0)
      {
        System.out.println(point);
      }
      else if(num == 1)
      {
        centercount = 2;
        point += 1;
      }
      else if(num == 2)
      {
        point += centercount;
        centercount += 2;
      }
    } while (num != 0);
  }
}
