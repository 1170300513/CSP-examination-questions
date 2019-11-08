package CSP2019_3;

import java.util.Scanner;

public class CSP2019_3_1 {
public static void main(String[] args) {
  
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  int[] nums = new int[n];
  int max , min ,mid = 0;
  double midf = 0;
  int flag = 0;
  int num = sc.nextInt();
  nums[0] = num;
  max = num;
  min = num;
  for(int i = 1 ; i < n ; i++)
  {
    num = sc.nextInt();
    nums[i] = num;
    if(max < num)
    {
      max = num;
    }
    if(min > num)
    {
      min = num;
    }
  }
  if(n % 2 == 1)
  {
    mid = nums[n/2];
  }
  else
  {
    
    if((nums[n/2] + nums[n/2 - 1]) % 2 != 0)
    {
      flag = 1;
      midf = (nums[n/2] + nums[n/2 - 1]) / 2.0;
    }
    else
      mid = (nums[n/2] + nums[n/2 - 1]) / 2;
  }
  if(flag == 0)
  {
    System.out.println(max + " " + mid + " " +  min);
  }
  else
    System.out.println(max + " " +String.format("%.1f", midf) + " " +  min);
}
}
