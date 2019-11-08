package CSP2018_12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

//思路错了，0分！
//用并查集那个算法就能得到满分！非常不应该错！
//低级错误！
public class CSP2018_12_4 {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    Map<Integer, Map<Integer, Integer>> newmap = new HashMap<>();//表示新的生成树。
    Set<Integer> set = new HashSet<>();
    int n = sc.nextInt();
    int m = sc.nextInt();
    int root = sc.nextInt();
    for(int i = 0 ; i < m ; i++)
    {
      int v = sc.nextInt();
      int u = sc.nextInt();
      int t = sc.nextInt();
      if(map.get(v) == null)
      {
        Map<Integer, Integer> point = new HashMap<>();
        point.put(u, t);
        map.put(v, point);
      }
      else
      {
        map.get(v).put(u, t);
      }
    }
    int[] nearest = new int[n+1];
    int[] connectpoint = new int[n+1];
    int times = 0 , min = -1, minnum = -1;
    Arrays.fill(nearest, -1);
    Arrays.fill(connectpoint, root);
    set.add(root);
    for(Integer i : map.get(root).keySet())
    {
      if(times == 0)
      {
        minnum = i;
        min = map.get(root).get(i);
      }
      nearest[i] = map.get(root).get(i);
      if(nearest[i] < min)
      {
        minnum = i;
        min = nearest[i];
      }
      times++;
    }
    while(set.size()!=n)
    {
//      System.out.println(minnum);
//      System.out.println(min);
      set.add(minnum);
      //构造新的生成树.
      if(newmap.get(connectpoint[minnum]) == null)
      {
        Map<Integer, Integer> point = new HashMap<>();
        point.put(minnum, min);
        newmap.put(connectpoint[minnum], point);
      }
      else
      {
        newmap.get(connectpoint[minnum]).put(minnum, min);
      }
      if(map.get(minnum) != null)
      {
        for(Integer i : map.get(minnum).keySet())
        {
          if(nearest[i] == -1)
          {
            nearest[i] = map.get(minnum).get(i);
            connectpoint[i] = minnum;
          }
          if(min + map.get(minnum).get(i) < nearest[i])
          {
            nearest[i] = min + map.get(minnum).get(i);
            connectpoint[i] = minnum;
          }
        }
      }
      times = 0;
      for(int i = 1 ; i <= n ; i++ )
      {
        if(times == 0 && nearest[i] != -1 && !set.contains(i))
        {
          min = nearest[i];
          minnum = i;
          times++;
        }
        if(nearest[i] != -1 && !set.contains(i) && nearest[i] < min)
        {
          min = nearest[i];
          minnum = i;
        }
      } 
    }
    System.out.println(findTmax(newmap , root));
  }
  
  public static int findTmax(Map<Integer, Map<Integer, Integer>> map , int root)
  {
    Set<Integer> set = new HashSet<>();
    set.add(root);
    Queue<Integer> q = new LinkedList<>();
    q.offer(root);
    int Tmax = -1;
    while(q.peek()!=null)
    {
      int node = q.poll();
      if(map.get(node) != null)
      {
        for(Integer i : map.get(node).keySet())
        {
          if(!set.contains(i))
          {
            set.add(i);
            q.offer(i);
            if(map.get(node).get(i)>Tmax)
            {
              Tmax = map.get(node).get(i);
            }
          }
        }
      }
    }
    return Tmax;
  }
}
