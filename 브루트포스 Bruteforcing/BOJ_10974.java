import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  // 반복문 내에서 재귀함수와 visited를 사용해 중복 원소 건너뛰고 순열 사전순 출력
  static int N;
  static int[] array;
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine()); // 1 <= N <= 8
    array = new int[N];
    visited = new boolean[N];

    for (int i = 0; i < N; i++) {
      visited[i] = true;
      array[0] = i + 1; // 첫번째 원소 입력. depth = 0
      permutation(1);
      visited[i] = false;
    }

    System.out.println(sb);
    br.close();
  }

  private static void permutation(int depth) {
    if (depth == array.length) { // 배열의 length에 도달하면 출력 후 함수 실행 종료
      for (int i = 0; i < N; i++) {
        sb.append(array[i]).append(' ');
      }
      sb.append('\n');

      return;
    }

    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        array[depth] = i + 1;
        permutation(depth + 1);
        visited[i] = false;
      }
    }
  }
}
