package CSP2018_9;


import java.util.Scanner;

public class CSP2018_9_4 {

  static boolean[][][] vis = new boolean[310][300][300];
  static int[] a = new int[310];
  static int[] b = new int[310];
  static int n;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      b[i] = sc.nextInt();
    }
    for (a[0] = 1; a[0] <= 2 * b[0]; a[0]++) {
      for (a[1] = 2 * b[0] - a[0]; a[1] <= 2 * b[0] - a[0] + 1; a[1]++) {
        if (a[1] > 0) {
          dfs(2);
        }
      }
    }
    return;
  }


  public static void dfs(int t) {

    if (t == n) {
      if (b[n - 1] != (a[n - 1] + a[n - 2]) / 2) {
        return;
      }
      for (int i = 0; i < n; i++) {
        if (i == n - 1) {
          System.out.println(a[i]);
        } else
          System.out.print(a[i] + " ");
      }
      System.exit(0);
    }
    for (a[t] = 3 * b[t - 1] - a[t - 1] - a[t - 2]; a[t] <= 3 * b[t - 1] - a[t - 1] - a[t - 2]
        + 2; a[t]++) {
      if (a[t] > 0) {
        if (vis[t][a[t]][a[t - 1]]) {
          continue;
        }
        vis[t][a[t]][a[t - 1]] = true;
        dfs(t + 1);
      }
    }

  }
}
