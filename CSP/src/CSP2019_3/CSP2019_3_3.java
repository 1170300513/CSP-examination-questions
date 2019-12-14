package CSP2019_3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//超时70分，主要超时的点目测是在16进制异或处，但不知如何改进（自己写一个进制转换的不知道能不能比java自带的快）。
public class CSP2019_3_3 {
  public static void main(String[] args) 
  {
    Scanner sc = new Scanner(System.in);
    Map<Integer, String> disks = new HashMap<Integer, String>();
    int n = sc.nextInt();
    int s = sc.nextInt();
    int l = sc.nextInt();
    int length = 0;
    sc.nextLine();
    String[] couple = sc.nextLine().split(" ");
    disks.put(Integer.valueOf(couple[0]), couple[1]);
    length = couple[1].length();
    for(int i = 1 ; i < l ; i++)
    {
      String[] couples = sc.nextLine().split(" ");
      disks.put(Integer.valueOf(couples[0]), couples[1]);
    }
    int m = sc.nextInt();
    for(int i = 0 ; i < m ; i++)
    {
      int search = sc.nextInt();
      int snum = search / s;
      int layer = snum / (n-1);
      int P = n-1 - (layer % n);
      int dnum = (P + 1 + (snum%(n-1))) % n;
      String disk;
      int spos = search % s;
      int start = 8*s*layer+spos*8;
      if(start >= length)
      {
        System.out.println("-");
        continue;
      }
      if((disk = disks.get(dnum)) != null)
      {  
        System.out.println(disk.substring(start, start+8));
      }
      else if(n - l <= 1)
      {
        String lost = "00000000";
        for(int k : disks.keySet())
        {
          disk = disks.get(k).substring(start, start+8);
          lost = notor(lost,disk);
//          lost = lost ^ string2hex(disk);
        }
//        String ans = Long.toHexString(lost).toUpperCase();
//        int loss;
//        if((loss = ans.length()) < 8)
//        {
//          for(int j = 0 ; j < 8 - loss ; j++)
//          {
//            ans = "0" + ans;
//          }
//        }
        System.out.println(lost);
      }
      else
      {
        System.out.println("-");
      }
    }
    
  }
  public static String notor(String str1, String str2)
  {
    StringBuilder notor = new StringBuilder();
    for(int i = 0 ; i < 8 ; i++)
    {
      int num = c2ntranstable(str1.charAt(i)) ^ c2ntranstable(str2.charAt(i));
      notor.append(n2ctranstable(num));
    }
    return notor.toString();
  }
  
  public static char n2ctranstable(int num)
  {
    String str = "0123456789ABCDEF";
    return str.charAt(num);
  }
  
  
  public static int c2ntranstable(char c)
  {
    int num ;
    switch (c) {
      case '0':
        num = 0;
        break;   
      case '1':
        num = 1;
        break;   
      case '2':
        num = 2;
        break;        
      case '3':
        num = 3;
        break;
      case '4':
        num = 4;
        break;      
      case '5':
        num = 5;
        break;
      case '6':
        num = 6;
        break;    
      case '7':
        num = 7;
        break;   
      case '8':
        num = 8;
        break;    
      case '9':
        num = 9;
        break;  
      case 'A':
        num = 10;
        break;  
      case 'B':
        num = 11;
        break; 
      case 'C':
        num = 12;
        break;   
      case 'D':
        num = 13;
        break;
      case 'E':
        num = 14;
        break;
      case 'F':
        num = 15;
        break;
      default:
        num = 0;
        break;
    }
    
    return num;
  }
}
