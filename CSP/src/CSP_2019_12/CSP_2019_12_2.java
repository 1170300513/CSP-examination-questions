package CSP_2019_12;

import java.util.*;

public class CSP_2019_12_2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
//    int minx , miny , maxx , maxy;
    int[] counter = new int[5];
    Map<Integer,Map<Integer,Integer>> mymap = new HashMap<>();
//    Map<Integer,Map<Integer,Integer>> isin = new HashMap<>();
//    int x = sc.nextInt();
//    int y = sc.nextInt();
//    if(mymap.get(x) == null)
//    {
//      Map<Integer,Integer> tempmap = new HashMap<Integer, Integer>();
//      tempmap.put(y, 1);
//      mymap.put(x, tempmap);
//    }
//    else
//    {
//      mymap.get(x).put(y, 1);
//    }
//    minx = x;
//    maxx = x;
//    miny = y;
//    maxy = y;
    for(int i = 0 ; i < n; i++)
    {
      int x = sc.nextInt();
      int y = sc.nextInt();
      if(mymap.get(x) == null)
      {
        Map<Integer,Integer> tempmap = new HashMap<Integer, Integer>();
        tempmap.put(y, 1);
        mymap.put(x, tempmap);
      }
      else
      {
        mymap.get(x).put(y, 1);
      }
    }
//    for(int x1 : mymap.keySet())
//    {
//      for(int y1 : mymap.get(x).keySet())
//      {
//        if(x1 > maxx)
//        {
//          maxx = x1;
//        }
//        if(x1 < minx)
//        {
//          minx = x1;
//        }
//        if(y1 > maxy)
//        {
//          maxy = y1;
//        }
//        if(y1 < miny)
//        {
//          miny = y1;
//        }
//      }
//    }
//    System.out.println("maxx :" + maxx);
//    System.out.println("minx :" + minx);
//    System.out.println("maxy :" + maxy);
//    System.out.println("miny :" + miny);
    if( n < 5)
    {
      for(int i = 0 ; i < 5 ; i++)
      {
        System.out.println(counter[i]);
      }
    }
    else
    {
      for(int x : mymap.keySet())
      {
        for(int y : mymap.get(x).keySet())
        {
          int point = getpoints(x, y , mymap);
//          System.out.println( x + "," + y + ":" + point);
          if(point != -1) {
            counter[point]++;
          }
        }
        
      }
      
//      for(int i = minx ; i <= maxx ; i++)
//      {
//        for(int j = miny ; j <= maxy ; j++)
//        {
//          int point = getpoints(i, j , mymap);
////          System.out.println( i + "," + j + ":" + point);
//          if(point != -1)
//          {
//            counter[point]++;
//          }
//        }
      }
//      for(int x : mymap.keySet())
//      {
//        for(int y : mymap.get(x).keySet())
//        {
////          System.out.println(x + "," +y);
//          int tempx , tempy , points;
//          tempx = x-1;
//          tempy = y;
//          points = getpoints(tempx, tempy, mymap);
//          if(points != -1 && (isin.get(tempx) == null || isin.get(tempx).get(tempy) == null))
//          {
//            counter[points] ++;
//            if(isin.get(tempx) == null)
//            {
//              Map<Integer,Integer> tempmap = new HashMap<Integer, Integer>();
//              tempmap.put(tempy, 1);
//              isin.put(tempx, tempmap);
//            }
//            else
//            {
//              isin.get(tempx).put(tempy, 1);
//            }
//          }
//          
//          tempx = x+1;
//          tempy = y;
//          points = getpoints(tempx, tempy, mymap);
//          if(points != -1 && (isin.get(tempx) == null || isin.get(tempx).get(tempy) == null))
//          {
//            counter[points] ++;
//            if(isin.get(tempx) == null)
//            {
//              Map<Integer,Integer> tempmap = new HashMap<Integer, Integer>();
//              tempmap.put(tempy, 1);
//              isin.put(tempx, tempmap);
//            }
//            else
//            {
//              isin.get(tempx).put(tempy, 1);
//            }
//          }
//          
//          tempx = x;
//          tempy = y-1;
//          points = getpoints(tempx, tempy, mymap);
//          if(points != -1 && (isin.get(tempx) == null || isin.get(tempx).get(tempy) == null))
//          {
//            counter[points] ++;
//            if(isin.get(tempx) == null)
//            {
//              Map<Integer,Integer> tempmap = new HashMap<Integer, Integer>();
//              tempmap.put(tempy, 1);
//              isin.put(tempx, tempmap);
//            }
//            else
//            {
//              isin.get(tempx).put(tempy, 1);
//            }
//          }
//          
//          tempx = x;
//          tempy = y+1;
//          points = getpoints(tempx, tempy, mymap);
//          if(points != -1 && (isin.get(tempx) == null || isin.get(tempx).get(tempy) == null))
//          {
//            counter[points] ++;
//            if(isin.get(tempx) == null)
//            {
//              Map<Integer,Integer> tempmap = new HashMap<Integer, Integer>();
//              tempmap.put(tempy, 1);
//              isin.put(tempx, tempmap);
//            }
//            else
//            {
//              isin.get(tempx).put(tempy, 1);
//            }
//          }
//                
//        }
//      }
      for(int i = 0 ; i < 5 ; i++)
      {
        System.out.println(counter[i]);
      }
   }
  
  public static int getpoints(int x , int y , Map<Integer,Map<Integer,Integer>> mymap)
  {
    int points = -1;
    if(mymap.get(x-1) != null && mymap.get(x-1).get(y) != null)
    {
      if(mymap.get(x+1) != null && mymap.get(x+1).get(y) != null)
      {
        if(mymap.get(x) != null && mymap.get(x).get(y-1) != null)
        {
          if(mymap.get(x) != null && mymap.get(x).get(y+1) != null)
          {
            if(mymap.get(x) != null && mymap.get(x).get(y) != null)
            {
              points++;
              if(mymap.get(x-1) != null && mymap.get(x-1).get(y-1) != null)
              {
                points++;
              }
              
              if(mymap.get(x-1) != null && mymap.get(x-1).get(y+1) != null)
              {
                points++;
              }
              
              if(mymap.get(x+1) != null && mymap.get(x+1).get(y+1) != null)
              {
                points++;
              }
              
              if(mymap.get(x+1) != null && mymap.get(x+1).get(y-1) != null)
              {
                points++;
              }
            }
           }
        }
      }
    }
    
    

    return points;
  }

}
