import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  // 원소가 오름차순을 이루는 길이가 가장 긴 부분 수열을 찾아내야 함
  // {4, 1, 2, 3, 4, 5} => {1, 2, 3, 4, 5}
  // {10, 20, 10, 30, 20, 50} => {10, 20, 30, 50)
  // => 최장 증가 부분 수열 (LIS, Longest Increasing Subsequence)
  static int N;
  static int[] sequence, dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine()); // 1 <= N <= 1000
    sequence = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      sequence[i] = Integer.parseInt(st.nextToken()); // 1 <= sequence[i] <= 1000
    }

    System.out.println(LIS(sequence));
    br.close();
  }

  static int LIS(int[] sequence) {
    dp = new int[sequence.length]; // sequence의 길이 만큼 초기화, sequence와 index를 공유함
    for (int i = 0; i < sequence.length; i++) {
      dp[i] = 1; // 먼저, dp[i]를 '자기 자신만을 지닌 부분 수열'의 길이인 1로 초기화

      // i = 1, j = 0부터 시작 => 2, 0 => 2, 1 => 3, 0 => 3, 1 => 3, 2 => 4, 1 => 4, 2 => 4, 3 => ...
      // 자기 자신보다 왼쪽에 위치한 원소를 전부 검사
      for (int j = 0; j < i; j++) {
        // 왼쪽의 원소보다 크더라도, dp[i]가 dp[j] + 1보다 크거나 같을 때 dp 값을 높여서는 안 된다 (원소 중복 포함 방지)
        // 배열 dp의 값은 기존의 부분 수열의 원소보다 큰 원소가 존재한다면 기존 부분 수열의 길이에 1을 추가하여 만든 값으로
        // dp[i]가 dp[j]보다 크다면 같은 값을 지닌 원소가 이미 부분 수열에 포함되어 있다는 것
        if (sequence[j] < sequence[i] && dp[j] + 1 > dp[i]) {
          dp[i] = dp[j] + 1; // 해당 index의 dp 값을 높임(sequence[i]가 부분 수열의 맨 뒤에 포함되므로 +1)
        }
      }
    }

    Arrays.sort(dp); // sequence의 마지막 원소가 가장 큰 원소가 아닐 수 있음!
    return dp[sequence.length - 1]; // 오름차순 정렬을 통해 구하고자 하는 부분 수열의 최장 길이를 리턴함
  }
}
