import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // 1) 1차원 배열로 풀이
  // BOJ_1912 응용, 제거되는 수를 고려해야 하므로 양방향에서 가장 큰 연속합을 구하고, 그 결과를 짝지어 더함
  static int n;
  static int[] input, dp_r, dp_l;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    input = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < input.length; i++) {
      input[i] = Integer.parseInt(st.nextToken());
    }

    int max = input[0];

    // ======================>
    dp_r = new int[n];
    dp_r[0] = input[0];
    for (int i = 1; i < n; i++) {
      dp_r[i] = Math.max(input[i], dp_r[i - 1] + input[i]);
      max = Math.max(max, dp_r[i]); // 수를 제거하지 않고 연속합의 최댓값 도출
    }

    // <======================
    dp_l = new int[n];
    dp_l[n - 1] = input[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      dp_l[i] = Math.max(input[i], dp_l[i + 1] + input[i]);
    }

    // 수열에서 특정한 수를 하나 제거하면 아래와 같은 식을 세울 수 있다.
    for (int i = 1; i < n - 1; i++) {
      max = Math.max(max, dp_r[i - 1] + dp_l[i + 1]); // 제거하기 전 최댓값과 비교-선택
    }

    System.out.println(max);
    br.close();
  }
}
