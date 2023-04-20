import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int N;
  static int[] input, result;
  static boolean[] visited;
  static int max = Integer.MIN_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine()); // 3 <= N <= 8

    input = new int[N];
    String[] line = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      input[i] = Integer.parseInt(line[i]); // -100 <= input[i] <= 100
    }
    Arrays.sort(input);

    result = new int[N];
    visited = new boolean[N];

    dfs(0);

    System.out.println(max);
    br.close();
  }

  private static void dfs(int index) {
    if (index == N) {
      int sum = 0;
      for (int i = 0; i < N - 1; i++) {
        sum += Math.abs(result[i] - result[i + 1]);
      }

      max = Math.max(max, sum);
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        result[index] = input[i];
        dfs(index + 1);
        visited[i] = false;
      }
    }
  }
}
