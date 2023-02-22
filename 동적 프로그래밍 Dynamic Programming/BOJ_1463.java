import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  // 2와 3의 최소공배수(=두 조건을 모두 만족하는 경우)인 6으로 나눠지는 경우 또한 고려해야 한다!
  static int N;
  static Integer[] dp; // Wrapper 클래스를 이용하여 초기값 null로 재귀함수 호출 여부 결정

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine()); // 1 <= N <= 1000000

    dp = new Integer[N + 1]; // 재귀함수 호출 시 이용할 메모이제이션 배열(중복 수행 제거)
    // 배열의 값은 index를 1로 만들기 위한 최솟값
    dp[0] = dp[1] = 0;

    System.out.println(recursive(N));
    br.close();
  }

  static int recursive(int N) {
    if (dp[N] == null) {
      if (N % 6 == 0) {
        dp[N] = Math.min(recursive(N - 1), Math.min(recursive(N / 3), recursive(N / 2))) + 1;
      } else if (N % 3 == 0) {
        dp[N] = Math.min(recursive(N / 3), recursive(N - 1)) + 1;
      } else if (N % 2 == 0) {
        dp[N] = Math.min(recursive(N / 2), recursive(N - 1)) + 1;
      } else {
        dp[N] = recursive(N - 1) + 1;
      }
    }

    return dp[N];
  }
}
