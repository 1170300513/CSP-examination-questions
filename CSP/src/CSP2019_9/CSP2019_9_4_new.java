package CSP2019_9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class CSP2019_9_4_new {

  public static void main(String[] args) {
    Queue<commodity> maxHeap = new PriorityQueue<>(new maxComparator());
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();
//    List<commodity> list = new ArrayList<>(); 
    for(int i = 0 ; i < n ; i++)
    {
      int id = sc.nextInt();
      int score = sc.nextInt();
      for(int j = 0 ; j < m ; j++)
      {
        commodity goods = new commodity(j, id, score);
        maxHeap.add(goods);
      }
    }
    int opnum = sc.nextInt();
    for(int i = 0 ; i < opnum ; i++)
    {
      //String[] option = sc.nextLine().split(" ");
      int optionclass = sc.nextInt();
      if(optionclass == 1)
      {
        int type = sc.nextInt();
        int num = sc.nextInt();
        int point = sc.nextInt();
        commodity newone = new commodity(type, num, point);
        maxHeap.add(newone);
      }
      else if(optionclass == 2)
      {
        int type = sc.nextInt();
        int num = sc.nextInt();
        commodity pointer = new commodity(type, num, 0);
        maxHeap.remove(pointer);
      }
      else
      {
        int K =  sc.nextInt();
        int[] ktotal = new int[m];
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<commodity> recycle = new ArrayList<>();
        for(int j = 0 ; j < m ; j++)
        {
          ktotal[j] = sc.nextInt();
          lists.add(new ArrayList<Integer>());
        }
        Object[] list = maxHeap.toArray();

        while(K >= 1)
        {
          if(maxHeap.size() > 0)
          {
            commodity top = maxHeap.poll();
            recycle.add(top);
            if(ktotal[top.classes] > 0)
            {
              lists.get(top.classes).add(top.num);
              ktotal[top.classes]--;
              K--;
            }
          }
          else
          {
            break;
          }
        }
        for(int j = 0 ; j < recycle.size();j++)
        {
           maxHeap.add(recycle.get(j));
        }
        for(int j = 0 ; j < m ; j++)
        {
          //Collections.sort(lists.get(j));
          if(lists.get(j).size() == 0)
            System.out.print(-1);
          else
          {
            for(int k = 0 ; k < lists.get(j).size(); k++)
            {
              System.out.print(lists.get(j).get(k) + " ");
            }
          }
          System.out.println();
        }
      }
    }
  }
}

class maxComparator implements Comparator<commodity>
{

  @Override
  public int compare(commodity o1, commodity o2) {
    return o2.compareTo(o1);
  }
  
}

class commodity implements Comparable<commodity>
{
  int classes;
  int num;
  int points;
  public commodity(int classes , int num , int points) {
    this.classes = classes;
    this.num = num;
    this.points = points;
  }
  
  @Override
  public int compareTo(commodity o) {
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
    commodity c = (commodity)obj;
    if(c.classes == this.classes && c.num == this.num)
    {
      return true;
    }
    else
      return false;
  }
}