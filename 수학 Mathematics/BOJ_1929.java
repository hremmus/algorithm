import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // 소수 구하기 1) 주어진 범위의 수를 모두 검사하여 약수가 있는지 확인
  static int M, N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    for (int i = M; i <= N; i++) {
      boolean isPrime = true;
      if (i == 1) continue;
      for (int j = 2; j <= Math.sqrt(i); j++) {
        if (i % j == 0) {
          isPrime = false;
          break;
        }
      }

      if (isPrime) sb.append(i).append("\n");
    }

    System.out.println(sb);
    br.close();
  }
}
