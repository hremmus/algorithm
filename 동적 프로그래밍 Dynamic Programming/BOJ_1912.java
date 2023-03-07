import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // 연속된 수의 개수는 한 개 이상 N개 이하 => 반복문과 Math.max() 이용하여 최댓값을 갱신
  static int n;
  static Integer[] input, dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine()); // 1 <= n <= 100000

    input = new Integer[n];
    dp = new Integer[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < input.length; i++) {
      input[i] = Integer.parseInt(st.nextToken());
    }

    dp[0] = input[0];
    int max = input[0]; // 0이면 최댓값이 음수일 때 오답 발생
    for (int i = 1; i < n; i++) {
      // 이전 배열의 누적합 + 현재 값이거나 현재 값
      dp[i] = Math.max(input[i], dp[i - 1] + input[i]);
      max = Math.max(max, dp[i]); // 배열을 정렬 or 탐색하는 대신 변수에 담아 출력
    }
    // 메모이제이션이 완료되면 dp[i]에는 index가 0 ~ i인 원소의 누적합 중 최댓값이 저장됨

    System.out.println(max);
    br.close();
  }
}
