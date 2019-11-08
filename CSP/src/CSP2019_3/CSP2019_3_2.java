package CSP2019_3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CSP2019_3_2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    boolean[] flag = new boolean[n];
    sc.nextLine();
    for(int i = 0 ; i < n ; i++)
    {
      String equation = sc.nextLine();
      Deque<Integer> numstack = new ArrayDeque<>();
      Deque<Character> charstack = new ArrayDeque<>();
      for(int j = 0 ; j < 7 ; j++)
      {
        if(equation.charAt(j) >= '1' && equation.charAt(j) <= '9')
        {
          numstack.addFirst(Integer.valueOf(equation.charAt(j))-48);
        }
        if(equation.charAt(j) == '+' || equation.charAt(j) == '-')
        {
          charstack.addFirst(equation.charAt(j));
        }
        if(equation.charAt(j) == '/' || equation.charAt(j) == 'x')
        {
          int num1 = numstack.removeFirst();
          int num2 = Integer.valueOf(equation.charAt(j+1))-48;
          if(equation.charAt(j) == '/')
            num1 = num1 / num2;
          else
            num1 = num1 * num2;
          numstack.addFirst(num1);
          j++;
        }  
//        System.out.println(charstack);
//        System.out.println(numstack);
      }      
      while(charstack.peekFirst()!= null)
      {
        char f = charstack.removeLast();
        int num1 = numstack.removeLast();
        int num2 = numstack.removeLast();
        if(f == '+')
        {
          num1 = num1 + num2;
        }
        else
        {
          num1 = num1 - num2;
        }
        numstack.addLast(num1);;
      }
      if(numstack.peekFirst() == 24)
      {
        System.out.println("Yes");
      }
      else
      {
        System.out.println("No");
      }
    }
  

  }
}
