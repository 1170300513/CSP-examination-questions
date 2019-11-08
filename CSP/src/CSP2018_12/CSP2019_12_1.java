package CSP2018_12;

import java.util.Scanner;

public class CSP2019_12_1 {
  // 12min
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long r;
    long g;
    long y;
    r = sc.nextInt();
    y = sc.nextInt();
    g = sc.nextInt();
    int n = sc.nextInt();
    long total = 0;
    for (int i = 0; i < n; i++) {
      int k = sc.nextInt();
      int t = sc.nextInt();
      if (k == 0) {
        total += t;
      } else if (k == 1) {
        total += t;
      } else if (k == 2) {
        total += t + r;
      } else {
        total += 0;
      }
    }
    System.out.println(total);
  }
}
