import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int N, M;
  static int[] input, result;
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");

    N = Integer.parseInt(line[0]); // 원소의 개수 1 <= N <= 8
    M = Integer.parseInt(line[1]); // 수열의 길이 1 <= M <= N <= 8

    input = new int[N];
    line = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      input[i] = Integer.parseInt(line[i]);
    }
    Arrays.sort(input);

    visited = new boolean[N];
    result = new int[M];

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

    for (int i = 0; i < N; i++) { // input[index]
      if (!visited[i]) { // N개의 자연수 중에서 M개를 고른 수열 => 한 수열에 중복 원소 방지
        visited[i] = true;
        result[depth] = input[i];
        dfs(depth + 1);
        visited[i] = false;
      }
    }
  }
}
