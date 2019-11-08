package CSP2019_3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
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
//    String aString = "23";
//    System.out.println(aString.charAt(0) == '2');
    Deque<Character> charstack = new ArrayDeque<>();
    charstack.add('a');
    charstack.add('b');
    System.out.println(charstack.removeLast());
  }
}
