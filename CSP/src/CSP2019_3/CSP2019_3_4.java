package CSP2019_3;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class CSP2019_3_4 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    int n = sc.nextInt();
    List<List<String>> Ttotal = new ArrayList<>();
    int[] recorder = new int[T]; 
    //nextLine会读取回车，要注意！
    sc.nextLine();
    for(int i = 0 ; i < T ; i++)
    {
      for(int j = 0 ; j < n ; j++)
      {
        String[] temp = sc.nextLine().split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(temp));
//        for(int k = 0 ; k < temp.length ; k++)
//        {
//          list.add(temp[k]);
//        }
        Ttotal.add(list);
      }
      recorder[i] = Judge(Ttotal);
      Ttotal = new ArrayList<>();
    }
    for(int i = 0 ; i < recorder.length; i++)
    {
      System.out.println(recorder[i]);
    }
  }
  
  
  public static int Judge(List<List<String>> Ttotal) {
    
    Deque<String> stack = new ArrayDeque<>();
    Deque<Integer> numstack = new ArrayDeque<>();
    for(int i = 0 ; i < Ttotal.size() ; i++)
    {
      while(Ttotal.get(i).size() != 0)
      {
        String temp = Ttotal.get(i).get(0);
        String stackstr = reverse(temp,i);
        int desnum = Integer.valueOf(temp.substring(1));
        numstack.addFirst(desnum);
        stack.addFirst(stackstr);
        while(stack.peekFirst() != null)
        {
          if(Ttotal.get(desnum).size() == 0)
          {
            return 1;
          }
          String next = Ttotal.get(desnum).get(0);  
                 
          if(next.equals(stack.peekFirst()))
          {
            String last = stack.pop();
            desnum = numstack.pop();
            int lastnum = Integer.valueOf(last.substring(1));
            last = reverse(last,desnum);
            Ttotal.get(desnum).remove(next);
            Ttotal.get(lastnum).remove(last);
            if((last = stack.peekFirst()) != null)
            {
              desnum = numstack.peekFirst();
            }
          }
          else
          {
            int nextnum = Integer.valueOf(next.substring(1));
            stackstr = reverse(next,desnum);
            if(stack.contains(stackstr))
              return 1;
            else
            {
              stack.addFirst(stackstr); 
            }
            desnum = nextnum;
            numstack.addFirst(desnum);
          }
        }
      }
    }
    
    return 0;
  }
  public static String reverse(String a ,int num) {
    
    String reverse;
//    String operation = a.substring(0,1);
    if(a.charAt(0) == 'S')
      reverse = "R"+ num;
    else
      reverse = "S"+ num;
    return reverse;
  }
}
