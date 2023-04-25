import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  // 두 팀의 능력 차를 최소로 하기 위해 모든 조합의 경우의 수를 탐색
  static int N;
  static int[][] S;
  static boolean[] visited;
  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine()); // 4 <= N <= 20
    S = new int[N][N];
    visited = new boolean[N];

    for (int i = 0; i < N; i++) {
      String[] line = br.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        S[i][j] = Integer.parseInt(line[j]); // 1 <= S[i][j] <= 100
      }
    }

    combination(0, 0);

    System.out.println(min);
    br.close();
  }

  private static void combination(int index, int depth) {
    if (depth == N / 2) {
      int value = subtract();
      if (value == 0) {
        System.out.println(value);
        System.exit(0);
      }

      min = Math.min(min, value);
      return;
    }

    for (int i = index; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        combination(i + 1, depth + 1);
        visited[i] = false;
      }
    }
  }

  private static int subtract() {
    int team1 = 0;
    int team2 = 0;

    for (int i = 0; i < N - 1; i++) {
      for (int j = i + 1; j < N; j++) {
        // 팀원 i와 j의 t/f에 따라 팀을 배정
        if (visited[i] == true && visited[j] == true) {
          team1 += S[i][j];
          team1 += S[j][i];
        } else if (visited[i] == false && visited[j] == false) {
          team2 += S[i][j];
          team2 += S[j][i];
        }
      }
    }

    return Math.abs(team1 - team2);
  }
}
