package CSP2018_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//2h,运行超时80分
public class CSP2018_12_3 {
  public static void main(String[] args) 
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    List<int[]> list = new ArrayList<>();
    sc.nextLine();
    for (int i = 0; i < n; i++) 
    {
      String str = sc.nextLine();
      if (str.indexOf("/") == -1) 
      {
        int[] netexpress = new int[5];
        String[] strarray = str.split("\\.");
        int l = strarray.length;
        netexpress[4] = 8 * l;
        for (int j = 0; j < l; j++) 
        {
          netexpress[j] = Integer.valueOf(strarray[j]);
        }
        list.add(netexpress);
      }
      else 
      {
        int[] netexpress = new int[5];
        String[] firstdis = str.split("/");
        netexpress[4] = Integer.valueOf(firstdis[1]);
        String[] strarray = firstdis[0].split("\\.");
        int l = strarray.length;
        for(int j = 0 ; j < l ; j++ )
        {
          netexpress[j] = Integer.valueOf(strarray[j]);
        }
        list.add(netexpress);
      }
    }
    
    int size = list.size();
//    for(int i = 0 ; i < size; i++)
//    {
//      for(int j = i + 1 ; j < size ; j++)
//      {
//          int k = 0;
//          int[] a = list.get(i);
//          int[] b = list.get(j);
//          for( ; k < 4 ; k++)
//          {
//            if(a[k] > b[k])
//            {
//              int[] temp;
//              temp = a;
//              list.set(i, b);
//              list.set(j, temp);
//              break;
//            }
//            else if(a[k] < b[k])
//            {
//              break;
//            }
//          }
//        
//      }
//    }
    mergesort(list,0,size-1);
    int i = 0;
    while(i+1 < list.size())
    {
      int[] merge = merge(list.get(i),list.get(i+1));
      int[] a = list.get(i);
      int[] b = list.get(i+1);
      if(merge == null)
      {
        i++;
        continue;
      }
//      else if(a[4] == b[4] && i != 0)
//      {
//        list.set(i, merge);
//        list.remove(i+1);
//        i--;
//      }
      else
      {
        list.set(i, merge);
        list.remove(i+1);
      }
    }
    
    for(i = 0 ; i < list.size() ; i++)
    {
      StringBuilder str = new StringBuilder();
      int[] array = list.get(i);
      System.out.println(array[0] + "." + array[1] + "." + array[2] + "." + array[3] + "/" + array[4]);
    }
    
  }
  
  public static boolean compare(int[] a ,int[] b)
  {
    int k = 0;

    for( ; k < 4 ; k++)
    {
      if(a[k] > b[k])
      {
        return false;
      }
      else if(a[k] < b[k])
      {
        break;
      }
    }
    return true;
  }
  
  public static void mergesort(List<int[]> list,int left , int right)
  {
    if(left < right)
    {
      int mid = (left + right) / 2;
      mergesort(list, left, mid);
      mergesort(list , mid+1 , right);
      Mer(list, left , mid , mid+1 , right);
    }
  }
  
  public static void Mer(List<int[]> list,int l1 , int r1 , int l2 , int r2)
  {
    int i = l1 , j = l2 , index = 0;
    int L = r1 - l1 + r2 - l2;
    int[][] temp = new int[L+2][5];
    while(i <= r1 && j <= r2)
    {
      if(compare(list.get(i), list.get(j)))
      {
        temp[index] = list.get(i);
        index++;
        i++;
      }
      else
      {
        temp[index] = list.get(j);
        index++;
        j++;
      }
    }
    while(i <= r1)
    {
      temp[index] = list.get(i);
      index++;
      i++;
    }
    while(j <= r2)
    {
      temp[index] = list.get(j);
      index++;
      j++;
    }
    for(int k = 0 ; k < index ; k++)
    {
      list.set(l1+k, temp[k]);
    }
    return;
  }
  
  public static int[] merge(int[] f , int[] l) 
  {
    if(f[4] == l[4])
    {
      int samenum = f[4] / 8;
      int flag = 1;
      int[] merge = new int[5];
      if(f[4] % 8 != 0)
      {
        for(int i = 0 ; i < samenum ; i++)
        {
  
          if(f[i] != l[i])
          {
            flag = 0;
            break;
          }
        }
      }
      else
      {
        for(int i = 0 ; i < samenum - 1 ; i++)
        {
          if(f[i] != l[i])
          {
            flag = 0;
            break;
          }
        }
      }
      if(flag == 1)
      {
//        if(f[4] % 8 == 0)
//        {
//          int temp = (f[4] % 8);
//          if((f[samenum - 1] >> temp) + (l[samenum - 1] >> temp) != 1)
//          {
//            return null;
//          }
//        }
        for(int i = 0 ; i < 4 ; i++)
        {
          merge[i] = Integer.min(f[i], l[i]);
        }
        merge[4] = f[4] - 1;
        return merge;

      }
//      else if(flag == 2)
//        return f;
    }
    else
    {
      int min;
      int minnum;
      if(f[4] < l[4])
      {
        min = f[4];
        minnum = 1;
      }
      else
      {
        min = l[4];
        minnum = 2;
      }
      int samenum = min / 8;
      int flag = 1;
      for(int i = 0 ; i < samenum ; i++)
      {      
        if(samenum == 4 && i == 3)
        {
          if(minnum == 1)
          {
            if(f[3] < l[3])
            {
              flag = 2;
              break;
            }
          }
          else
          {
            if(f[3] > l[3])
            {
              flag = 2;
              break;
            }
          }
          flag = 0;
          break;       
        }
        
        if(f[i] != l[i])
        {
          flag = 0;
          break;
        }
      }
      
      if(flag == 1)
      {
        if(minnum == 1)
        {
          if(f[samenum] < l[samenum])
          {
            flag = 2;
          }
        }
        else
        {
          if(f[samenum] > l[samenum])
          {
            flag = 2;
          }
        }
      }
      
      if(flag == 2)
      {
        if(f[4] < l[4])
          return f;
        else
          return l;
      }        
    }
    
    return null;
  }

}
