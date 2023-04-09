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

    N = Integer.parseInt(line[0]); // 원소의 개수 1 <= N <= 8
    M = Integer.parseInt(line[1]); // 수열의 길이 1 <= M <= N <= 8

    input = new int[N];
    result = new int[M];

    line = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      input[i] = Integer.parseInt(line[i]);
    }
    Arrays.sort(input);

    dfs(0, 0);

    System.out.println(sb);
    br.close();
  }

  private static void dfs(int current, int depth) {
    if (depth == M) {
      for (int element : result) {
        sb.append(element).append(' ');
      }
      sb.append('\n');
      return;
    }

    for (int i = current; i < N; i++) { // 오름차순 => 현재 index를 알아야 함
      result[depth] = input[i];
      dfs(i + 1, depth + 1); // 다음 원소 출력
    }
  }
}
