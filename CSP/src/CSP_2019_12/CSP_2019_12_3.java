package CSP_2019_12;

import java.util.*;

public class CSP_2019_12_3 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    for(int i = 0 ; i < n ; i++)
    {
      String[] couple = sc.nextLine().split("=");
      Map<String,Integer> left = getsums(couple[0]);
      Map<String,Integer> right = getsums(couple[1]);
      if(left.size() == right.size())
      {
        int flag = 1;
        for(String element : left.keySet())
        {
          if(left.get(element) != right.get(element))
          {
            flag = 0;
          }
        }
        if(flag == 1)
        {
          System.out.println("Y");
          continue;
        }
      }
      System.out.println("N");
    }
  }
  
  public static Map<String,Integer> getsums(String s)
  {
    Map<String,Integer> table = new HashMap<String, Integer>();
    List<String> parts = getpartplus(s);
    for(int i = 0 ; i < parts.size() ; i++)
    {
      String temp = parts.get(i);
      int mul = 1;
      for(int j = 0 ; j < temp.length() ; j++)
      {
        if(temp.charAt(j) < '0' || temp.charAt(j) > '9')
        {
          String num = temp.substring(0,j);
          if(num.length() > 0)
          {
            mul = Integer.valueOf(num);
          }
          temp = temp.substring(j);
          break;
        }
      }
      
      List<String> list = getpart(temp);
      for(int k = 0 ; k < list.size() ; k++)
      {
        changetable(table, list.get(k), mul);
      }
      
    }
    return table;
  }
  
  public static void addtothetable(Map<String,Integer> table , String s , int num)
  {
    if(table.get(s) == null)
    {
      table.put(s, num);
    }
    else
    {
      table.replace(s,table.get(s)+num);
    }
  }
  
  
  public static void changetable(Map<String,Integer> table , String k , int mul)
  {
    
    if(k.charAt(0) == '(')
    {
      int m;
      for(m = k.length() - 1 ; m >=0 ; m--)
      {
        if(k.charAt(m) == ')')
        {
          break;
        }
      }
      String temp = k.substring(1, m);
      int mul2;
      if(m == k.length() -1)
      {
        mul2 = 1;
      }
      else
      {
        mul2 = Integer.valueOf(k.substring(m+1));
      }
      List<String> list = getpart(temp);
      for(int n = 0 ; n < list.size() ; n++)
      {
        changetable(table, list.get(n), mul*mul2);
      }
    }
    else
    {
      int m;
      for(m = 0 ; m < k.length() ; m++)
      {
        if(k.charAt(m) >= '1' && k.charAt(m) <= '9')
        {
          break;
        }
      }
      if(m == k.length())
      {
        addtothetable(table, k, mul);
      }
      else
      {
        int num = Integer.valueOf(k.substring(m));
        addtothetable(table, k.substring(0,m), mul*num);
      }
    }
  }
  
  public static List<String> getpart(String s)
  {
    List<String> list = new ArrayList<>();
    int count = 0;
    while(count < s.length())
    {
      if(count == 0 && s.charAt(count) =='(')
      {
        while(s.charAt(count) != ')')
          count++;
      }
      if(count != 0 && 
          ((s.charAt(count) >= 'A' && s.charAt(count) <= 'Z') || s.charAt(count) =='(' ))
      {
        list.add(s.substring(0,count));
        s = s.substring(count);
        count = 0;
        continue;
      }
      count++;
    }
    list.add(s);
    return list;
  }
  public static List<String> getpartplus(String s)
  {
    List<String> list = new ArrayList<>();
    int count = 0;
    while(count < s.length())
    {
      if(count != 0 && 
           s.charAt(count) =='+' )
      {
        list.add(s.substring(0,count));
        s = s.substring(count+1);
        count = 0;
        continue;
      }
      count++;
    }
    list.add(s);
    return list;
  }
  
}
