package CSP_2019_12;

import java.util.Scanner;


public class CSP_2019_12_1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] counter = new int[4];
    int n = sc.nextInt();
    int count = 0;
    int j = 1;
    while(j <= n)
    {
      int flag = 0;
      String s = j + "";
      for(int i = 0 ; i < s.length() ; i++)
      {
        if(s.charAt(i) == '7')
        {
          flag = 1;
        }
      }
      if(j % 7 == 0 || flag == 1)
      {
        n++;
        counter[count] ++;
        count = (count + 1) % 4;
      }
      else
      {
        count = (count + 1) % 4;
        
      }
      j++;
    }
    
    for(int i = 0 ; i < counter.length ; i++)
    {
      System.out.println(counter[i]);
    }
  }
}
