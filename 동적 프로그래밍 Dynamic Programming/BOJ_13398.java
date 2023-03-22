import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // 2) 2차원 배열로 풀이
  static int n;
  static int[] input;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    input = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < input.length; i++) {
      input[i] = Integer.parseInt(st.nextToken());
    }

    dp = new int[n][2]; // 0: 제거X 1: 제거O 상태일 때 구해지는 최대 연속합
    dp[0][0] = dp[0][1] = input[0];

    int max = input[0];
    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.max(input[i], dp[i - 1][0] + input[i]);
      // 1) i번째 원소가 지워지는 경우 2) i번쨰 이전 원소가 지워진 경우
      dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + input[i]);

      max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
    }

    System.out.println(max);
    br.close();
  }
}
