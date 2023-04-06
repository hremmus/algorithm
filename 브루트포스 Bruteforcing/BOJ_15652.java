import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N, M;
  static int[] array;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");

    N = Integer.parseInt(line[0]); // 자연수 최대 1 <= N <= 8
    M = Integer.parseInt(line[1]); // 수열의 길이 1 <= M <= N <= 8

    array = new int[M];

    dfs(1, 0);

    System.out.println(sb);
    br.close();
  }

  private static void dfs(int current, int depth) {
    if (depth == M) {
      for (int element : array) {
        sb.append(element).append(' ');
      }
      sb.append('\n');
      return;
    }

    for (int i = current; i <= N; i++) {
      array[depth] = i;
      // 비내림차순 (이전 항과 같은 수를 허용하며 증가) 정렬이므로 현재 값 i를 넘김
      dfs(i, depth + 1);
    }
  }
}
