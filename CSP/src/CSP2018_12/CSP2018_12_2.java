package CSP2018_12;

import java.util.Scanner;

// 25min，检查不清有点小错误！不该！
public class CSP2018_12_2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long r;
    long g;
    long y;
    r = sc.nextInt();
    y = sc.nextInt();
    g = sc.nextInt();
    int n = sc.nextInt();
    long sum = r + g + y;
    long total = 0;
    for (int i = 0; i < n; i++) {
      int k = sc.nextInt();
      int t = sc.nextInt();
      if (k == 0) {
        total += t;
      } else if (k == 1) {
        long m = (r - t + total) % sum;
        total += compute(m, r, g, y);
      } else if (k == 2) {
        long m = (sum - t + total) % sum;
        total += compute(m, r, g, y);
      } else {
        long m = (r + g - t + total) % sum;
        total += compute(m, r, g, y);
      }
    }
    System.out.println(total);
  }

  public static long compute(long m, long r, long g, long y) {
    long time = 0;
    if (m <= r)
      time = r - m;
    else if (m > r && m < r + g)
      time = 0;
    else
      time = r + (y + g + r - m);
    return time;
  }
}
