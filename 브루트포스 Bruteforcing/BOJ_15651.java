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

    N = Integer.parseInt(line[0]); // 자연수 최대 1 <= N <= 7
    M = Integer.parseInt(line[1]); // 수열의 길이 1 <= M <= N <= 7

    array = new int[M];

    dfs(1, 0);

    System.out.println(sb);
    br.close();
  }

  private static void dfs(int current, int depth) {
    if (depth == M) { // 수열의 마지막 원소에 도달하면(=배열을 전부 채우면) 출력
      for (int element : array) {
        sb.append(element).append(' ');
      }
      sb.append('\n');
      return;
    }

    // 다음에 오는 원소(depth + 1)는 1부터 N까지 증가하는 형태
    // 수열 내에서 같은 수를 여러 번 고를 수 있다.
    for (int i = 1; i <= N; i++) {
      array[depth] = i;
      dfs(i + 1, depth + 1);
    }
  }
}
