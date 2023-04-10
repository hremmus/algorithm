import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int N, M;
  static int[] input, result;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");

    N = Integer.parseInt(line[0]);
    M = Integer.parseInt(line[1]);

    input = new int[N];
    result = new int[M];

    line = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      input[i] = Integer.parseInt(line[i]);
    }
    Arrays.sort(input);

    dfs(0);

    System.out.println(sb);
    br.close();
  }

  private static void dfs(int depth) {
    if (depth == M) {
      for (int element : result) {
        sb.append(element).append(' ');
      }
      sb.append('\n');
      return;
    }

    for (int i = 0; i < N; i++) {
      result[depth] = input[i];
      dfs(depth + 1);
    }
  }
}
