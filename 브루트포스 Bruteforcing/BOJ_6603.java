import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int k;
  static int[] S, result;
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      String[] line = br.readLine().split(" ");
      if (line[0].equals("0")) break;

      k = Integer.parseInt(line[0]); // 6 < k < 13
      S = new int[k];

      for (int i = 0; i < k; i++) {
        S[i] = Integer.parseInt(line[i + 1]); // 1 <= S[i] <= 49, 오름차순으로 주어짐
      }

      visited = new boolean[k];
      result = new int[6];

      dfs(0, 0);
      sb.append("\n");
    }

    System.out.println(sb);
    br.close();
  }

  private static void dfs(int start, int depth) {
    if (depth == 6) {
      for (int i = 0; i < 6; i++) {
        sb.append(result[i] + " ");
      }

      sb.append("\n");

      return;
    }

    for (int i = start; i < k; i++) {
      if (!visited[i]) {
        visited[i] = true;
        result[depth] = S[i];
        dfs(i + 1, depth + 1);
        visited[i] = false;
      }
    }
  }
}
