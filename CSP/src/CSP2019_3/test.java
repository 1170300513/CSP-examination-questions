package CSP2019_3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class test {

  public static void main(String[] args) {
//    List<String> stack = new ArrayList<>();
//    stack.add("1");
//    System.out.println(stack.contains(1));
//    stack.remove("1");
//    System.out.println(stack);
//    if(stack == null)
//      System.out.println(1);
//    Scanner sc = new Scanner(System.in);
//    int T = sc.nextInt();
//    int n = sc.nextInt();
//    sc.nextLine();
//    String a = sc.nextLine();
//    String b = sc.nextLine();
//    System.out.println(a);
//    System.out.println(b);
    String bString = "23";
    System.out.println(bString.charAt(0) == '2');
//    Deque<Character> charstack = new ArrayDeque<>();
//    charstack.add('a');
//    charstack.add('b');
//    System.out.println(charstack.removeLast());
//    Map<Integer, String> disks = new HashMap<Integer, String>();
//    System.out.println(disks.get(1));
//    Scanner sc = new Scanner(System.in);
//    int a = sc.nextInt();
//    sc.nextLine();
//    System.out.println(sc.nextLine());
//    int b = sc.nextInt();
//    sc.nextLine();
//    System.out.println(sc.nextLine());
//    int p = 7;
//    for(int i = 0 ; i < 100 ; i++)
//    {
//      p = p -1;
//      System.out.println(p%8);
//    }
    String aString = "00010203";
    long ja = Long.valueOf(aString, 16);
    String ans = Long.toHexString(ja);
    int loss;
    if((loss = ans.length()) < 8)
    {
      for(int j = 0 ; j < 8 - loss ; j++)
      {
        ans = "0" + ans;
      }
    }
    System.out.println(ans.toUpperCase());
  }
}
