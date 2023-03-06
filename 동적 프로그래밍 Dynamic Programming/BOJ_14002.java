import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  // BOJ_11503 참고
  // 원소가 오름차순을 이루는 길이가 가장 긴 부분 수열을 찾아내야 함
  // {4, 1, 2, 3, 4, 5} => {1, 2, 3, 4, 5}
  // {10, 20, 10, 30, 20, 50} => {10, 20, 30, 50)
  // => 최장 증가 부분 수열 (LIS, Longest Increasing Subsequence)
  static int N;
  static int[] sequence, dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(br.readLine()); // 1 <= N <= 1000
    sequence = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      sequence[i] = Integer.parseInt(st.nextToken()); // 1 <= sequence[i] <= 1000
    }

    int result = LIS(sequence);
    sb.append(result).append("\n");

    Stack<Integer> stack = new Stack<>();
    int value = result;
    // 역순으로 스택에 담음
    // result를 이용, index가 일치하는 sequence 배열의 원소를 찾아 차례로 push
    for (int i = sequence.length - 1; i >= 0; i--) {
      if (value == dp[i]) {
        stack.push(sequence[i]);
        value--;
      }
    }

    while (!stack.isEmpty()) {
      sb.append(stack.pop() + " ");
    }
    System.out.println(sb);
    br.close();
  }

  static int LIS(int[] sequence) {
    dp = new int[sequence.length];
    for (int i = 0; i < sequence.length; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (sequence[j] < sequence[i] && dp[j] + 1 > dp[i]) {
          dp[i] = dp[j] + 1;
        }
      }
    }

    // 원소 출력을 해야 하기 때문에 index가 변해선 안 됨
    // Arrays.sort(dp);
    // return dp[sequence.length - 1];
    int length = 0;
    for (int i = 0; i < dp.length; i++) {
      length = Math.max(length, dp[i]); // 최장 길이를 구함
    }

    return length;
  }
}
