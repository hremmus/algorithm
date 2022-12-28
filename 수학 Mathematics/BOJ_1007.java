import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  /*
   * 집합 P의 벡터 매칭은 모든 원소를 한번씩 사용해 만들어진 벡터들의 집합이다.
   * 두 점 A, B를 이은 벡터 AB는 결국 원점을 기준으로 OB - OA이므로 N개의 점의 절반은 뺄셈, 나머지 절반은 덧셈을 적용한 것
   * 벡터매칭의 벡터들을 모두 더한 합벡터의 길이의 최솟값을 구하고자 할 때
   * 20개의 점을 두 개씩 묶어 순차적으로 계산하는 대신 20개의 점 중 절반인 10개를 골라 뺄셈을 적용
   * 경우의 수 축소 20C2 + 18C2 + ... + 2C2 => 20C10
   */
  static int T, N;
  static int[][] point;
  static double minSumLength;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      N = Integer.parseInt(br.readLine()); // 1 <= N <= 20, N % 2 = 0
      point = new int[N][2]; // [점의 개수][좌표 x, y]

      int sumX = 0, sumY = 0;
      for (int i = 0; i < N; i++) {
        String[] temp = br.readLine().split(" ");
        point[i][0] = Integer.parseInt(temp[0]);
        point[i][1] = Integer.parseInt(temp[1]);

        // 먼저 X와 Y의 좌표값을 전부 더함
        sumX += point[i][0];
        sumY += point[i][1];
      }

      minSumLength = Double.MAX_VALUE; // min 함수 호출 전 최댓값으로 초기화
      calc(0, 0, sumX, sumY);
      StringBuilder sb = new StringBuilder();
      sb.append(minSumLength).append("\n");
    }
    System.out.println(minSumLength);
  }

  static void calc(int index, int count, int x, int y) {
    if (count == N / 2) { // 점의 개수가 절반이 되면 벡터의 길이를 구함
      minSumLength = Math.min(minSumLength, Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
      return;
    }

    // 전체 좌표의 합에서 해당 좌표값을 두 번 제함(0에서 한 번 뺀 것과 같도록)
    // 인덱스를 부여하여 앞에서 선택된 원소 배제
    for (int i = index; i < point.length; i++) {
      calc(i + 1, count + 1, x - 2 * point[i][0], y - 2 * point[i][1]);
    }
  }
}
