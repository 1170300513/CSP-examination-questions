package CSP2019_9;

import java.util.Scanner;

public class CSP2019_9_1 {
public static void main(String[] args) {
  
  Scanner sc = new Scanner(System.in);
  int N = sc.nextInt();
  int M = sc.nextInt();
  int sum = 0;
  int max = 0;
  int maxnum = 0;
  for(int i = 0 ; i < N ; i++)
  {
    int first = sc.nextInt();
    int jsum = 0;
    for(int j = 0; j < M ; j++)
    {
      int a = sc.nextInt();
      first += a;
      jsum += Math.abs(a);
    }
    sum += first;
    if(i == 0)
    {
      max = 1;
      maxnum = jsum;
    }
    if(jsum > maxnum)
    {
      max = i + 1;
      maxnum = jsum;
    } 
  }
  System.out.println(sum + " " + max + " " + maxnum);
}
}
