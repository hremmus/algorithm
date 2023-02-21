import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(br.readLine()); // 1 <= N <= 10000000
    for (int i = 2; i <= Math.sqrt(N); i++) {
      while (N % i == 0) {
        sb.append(i).append("\n");

        N /= i;
      }
    }

    // N을 i로 나누고 나머지가 0이면 인수분해가 끝난 걸로 간주하고 반복을 끝냄
    // but, N의 제곱근보다 큰 소인수가 남을 수 있다 (ex) N이 34
    // 몫이 1이 아니라면 그 수는 소인수이므로 출력
    if (N != 1) sb.append(N);

    System.out.println(sb);
    br.close();
  }
}
