package CSP2019_9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//Treemap排序+Hashmap辅助查
//注意：Map的key无法用equals来操作，所以要Hashmap辅助查(大胆转换，不要犹豫半天)

public class CSP2019_9_4 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();
    Map<commoditys, commoditys> mylist = new TreeMap<>(new MComparator());
    Map<Integer, List<commoditys>> cmplist = new HashMap<Integer,  List<commoditys>>();
    for(int i = 0 ; i < n ; i++)
    {
      int id = sc.nextInt();
      int score = sc.nextInt();
      for(int j = 0 ; j < m ; j++)
      {
        commoditys commodity = new commoditys(j, id, score);
        mylist.put(commodity, commodity);
        if(cmplist.get(id) == null)
        {
          List<commoditys> templist = new ArrayList<>();
          templist.add(commodity);
          cmplist.put(id, templist);
        }
        else
        {
          cmplist.get(id).add(commodity);
        }
      }
    }
    int opnum = sc.nextInt();
    sc.nextLine();
    for(int i = 0 ; i < opnum ; i++)
    {

      int optionclass = sc.nextInt();
      if(optionclass == 1)
      {
        int type = sc.nextInt();
        int num = sc.nextInt();
        int point = sc.nextInt();
        commoditys newone = new commoditys(type, num, point);
        mylist.put(newone, newone);
        if(cmplist.get(num) == null)
        {
          List<commoditys> templist = new ArrayList<>();
          templist.add(newone);
          cmplist.put(num, templist);
        }
        else
        {
          cmplist.get(num).add(newone);
        }
      }
      else if(optionclass == 2)
      {

        int type = sc.nextInt();
        int num = sc.nextInt();
        for(int j = 0 ; j < cmplist.get(num).size();j++)
        {
          if(cmplist.get(num).get(j).classes == type)
          {
            mylist.remove(cmplist.get(num).get(j));
            cmplist.get(num).remove(j);
            break;
          }
        }
//        mylist.remove(deleteone, deleteone);
      }
      else
      {
        int K = sc.nextInt();
        int[] ktotal = new int[m];
//        List<commoditys> recycle = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for(int j = 0 ; j < m ; j++)
        {
          ktotal[j] = sc.nextInt();
          lists.add(new ArrayList<Integer>());
        }
        for(commoditys good : mylist.keySet())
        {
          if(K == 0)
          {
            break;
          }
          if(ktotal[good.classes] > 0)
          {
            lists.get(good.classes).add(good.num);
            ktotal[good.classes]--;
            K--;
          }
        }
        
        for(int j = 0 ; j < m ; j++)
        {
//          Collections.sort(lists.get(j));
          if(lists.get(j).size() == 0)
            System.out.print(-1);
          for(int k = 0 ; k < lists.get(j).size(); k++)
          {
            System.out.print(lists.get(j).get(k) + " ");
          }
          System.out.println();
        }
      }
    }
    
  }
  
}

class MComparator implements Comparator<commoditys>
{

  @Override
  public int compare(commoditys o1, commoditys o2) {
    return o2.compareTo(o1);
  }
  
}

class commoditys implements Comparable<commoditys>
{
  int classes;
  int num;
  int points;
  public commoditys(int classes , int num , int points) {
    this.classes = classes;
    this.num = num;
    this.points = points;
  }
  
  @Override
  public int compareTo(commoditys o) {
      if(this.points < o.points)
      {
        return -1;
      }
      else if(this.points == o.points)
      {
        if(this.classes > o.classes)
        {
          return -1;
        }
        else if(this.classes == o.classes)
        {
          if(this.num > o.num)
            return -1;
          else if(this.num == o.num)
            return 0;
          else 
            return 1;
        }
        else
        {
          return 1;
        }
      }
      else 
        return 1;
  }
  
  @Override
  public boolean equals(Object obj) {
    commoditys c = (commoditys)obj;
    if(c.classes == this.classes && c.num == this.num)
    {
      return true;
    }
    else
      return false;
  }
}