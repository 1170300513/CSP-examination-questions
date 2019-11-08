package CSP2019_9;

import java.util.Scanner;

public class CSP2019_9_2 {
public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int N = sc.nextInt();
  boolean[] flag = new boolean[N];
  int total = 0;
  for(int i = 0 ; i < N ; i++)
  {
    int m = sc.nextInt();
    int part = sc.nextInt();
    for(int j = 1 ; j < m ; j++)
    {
      int a = sc.nextInt();
      if(a > 0)
      {
        if(a < part)
        {
          part = a;
          flag[i] = true;
        }
      }
      else
      {
        part += a;
      }
    }
    total += part;
  }
  int d = 0;
  int e = 0;
  if(N >= 3)
  {
    for(int i = 0 ; i < N ; i++)
    {
      if(flag[i])
      {
        d++;
      }
      if(i != 0 && i != N-1)
      {
        if(flag[i] && flag[i-1] && flag[i+1])
        {
          e++;
        }
      }
      else if(i == 0)
      {
        if(flag[0] && flag[1] && flag[N-1])
        {
          e++;
        }
      }
      else
      {
        if(flag[0] && flag[N-2] && flag[N-1])
        {
          e++;
        }
      }
    }
  }
  else
  {
    for(int i = 0 ; i < N ; i++)
    {
      if(flag[i])
      {
        d++;
      }
    }
  }
  System.out.println(total + " " + d + " " + e);
}
}
