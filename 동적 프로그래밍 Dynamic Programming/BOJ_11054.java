import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  // 바이토닉 수열(오름차순이거나 내림차순이거나 오름차순-내림차순의 형태인 수열) 중 최장 길이를 찾아 출력
  // => 오름차순-내림차순의 형태인 수열의 최정상 원소는 곧 오름차순과 내림차순 부분 수열의 최장 길이를 구하여
  //    같은 index끼리 더한 값 중 가장 큰 값에 해당하는 원소가 된다.
  // => 결국 오름차순-내림차순의 형태인 수열이 최장 길이를 가진다.
  static int N;
  static int[] input, dp_l, dp_r;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    input = new int[N];
    String[] line = br.readLine().split(" ");
    for (int i = 0; i < input.length; i++) {
      input[i] = Integer.parseInt(line[i]);
    }

    // LIS - 오른쪽으로 이동하며 증가하는 가장 긴 수열을 탐색
    dp_r = new int[N];
    for (int i = 0; i < N; i++) {
      dp_r[i] = 1;
      for (int j = 0; j < i; j++) {
        if (input[i] > input[j]) { // 기준이 왼쪽보다 클 때
          dp_r[i] = Math.max(dp_r[i], dp_r[j] + 1);
        }
      }
    }

    // LDS - 왼쪽으로 이동하며 감소하는 가장 긴 수열을 탐색
    dp_l = new int[N];
    for (int i = N - 1; i >= 0; i--) {
      dp_l[i] = 1;
      for (int j = N - 1; j > i; j--) {
        if (input[i] > input[j]) { // 기준이 오른쪽보다 클 때
          dp_l[i] = Math.max(dp_l[i], dp_l[j] + 1);
        }
      }
    }

    int result = 0;
    for (int i = 0; i < N; i++) {
      result = Math.max(result, dp_r[i] + dp_l[i]);
    }

    // 해당 길이는 dp_r과 dp_l을 더하는 과정에서 자기 자신이 중복으로 더해졌기 때문에(겹침) -1
    System.out.println(result - 1);
    br.close();
  }
}
