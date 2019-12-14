package CSP2018_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSP2018_3_2 {
public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  List<Ball> display = new ArrayList<>();
  int n = sc.nextInt();
  int L = sc.nextInt();
  int t = sc.nextInt();
  for(int i = 0 ; i < n ; i++)
  {
    int pos = sc.nextInt();
    Ball ball = new Ball(pos, 1);
    display.add(ball);
  }
  for(int i = 0 ; i < t ; i++)
  {
    for(int j = 0 ; j < display.size();j++)
    {
      if(display.get(j).pos == L && display.get(j).v == 1)
      {
        continue;
      }
      if(display.get(j).pos == 0 && display.get(j).v == -1)
      {
        continue;
      }
      display.get(j).pos += display.get(j).v;
    }
    for(int j = 0 ; j < display.size();j++)
    {
      if(display.get(j).pos == 0 && display.get(j).v == -1)
      {
        display.get(j).v = 1;
      }
      if(display.get(j).pos == L && display.get(j).v == 1)
      {
        display.get(j).v = -1;
      }
    }
    for(int j = 0 ; j < display.size(); j++)
    {
      for(int k = j + 1 ; k < display.size() ; k++)
      {
        if(display.get(j).pos == display.get(k).pos)
        {
          display.get(j).v = -display.get(j).v;
          display.get(k).v = -display.get(k).v;
        }
      }
    }
  }
  for(int i = 0 ; i < display.size();i++)
  {
    System.out.print(display.get(i).pos+" ");
  }
}
}

class Ball{
  public int pos;
  public int v;
  public Ball(int pos , int v) {
    this.pos = pos;
    this.v = v;
  }
}