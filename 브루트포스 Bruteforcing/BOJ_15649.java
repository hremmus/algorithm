import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N, M;
  static int[] array;
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] line = br.readLine().split(" ");
    N = Integer.parseInt(line[0]); // 자연수 최대 1 <= N <= 8
    M = Integer.parseInt(line[1]); // 수열의 길이 1 <= M <= N <= 8


    array = new int[M];
    visited = new boolean[N];

    dfs(N, M, 0);

    // +) 출력되는 줄의 개수 = 가능한 수열의 개수는 순열로 구함
    //    => 서로 다른 N개의 원소 중에서 겹치지 않도록 '순서에 상관 있게' M개의 원소를 선택
    //       nPm = n! / (n - m)!
    System.out.println(sb);
    br.close();
  }

  private static void dfs(int N, int M, int depth) {
    if (depth == M) { // 수열의 마지막 원소에 도달하면(=배열을 전부 채우면) 출력
      for (int element : array) {
        sb.append(element).append(' ');
      }
      sb.append('\n');
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!visited[i]) { // 한 수열에 중복된 원소가 나오지 않도록 함
        visited[i] = true;
        array[depth] = i + 1;
        dfs(N, M, depth + 1); // 다음 원소 출력
        visited[i] = false;
      }
    }
  }
}
