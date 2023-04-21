import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N;
  static int[][] W;
  static boolean[] visited;
  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine()); // 2 <= N <= 10
    W = new int[N][N];

    for (int i = 0; i < N; i++) {
      String line[] = br.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        W[i][j] = Integer.parseInt(line[j]);
      }
    }

    for (int i = 0; i < N; i++) {
      visited = new boolean[N];
      visited[i] = true;
      dfs(i, i, 0, 0);
    }

    System.out.println(min);
    br.close();
  }

  private static void dfs(int start, int current, int cost, int count) {
    if (count == N - 1) {
      if (W[current][start] != 0) {
        min = Math.min(min, W[current][start] + cost);
      }

      return;
    }

    for (int i = 1; i < N; i++) {
      if (!visited[i] && W[current][i] != 0) {
        visited[i] = true;
        dfs(start, i, W[current][i] + cost, count + 1);
        visited[i] = false;
      }
    }
  }
}
