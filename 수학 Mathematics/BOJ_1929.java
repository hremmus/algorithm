import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // 소수 구하기 2) 에라토스테네스의 체
  static int M, N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    boolean[] composite = new boolean[N + 1]; // 0 ~ N. 합성수 or 소수 기록
    composite[1] = true; // 1을 소수에서 제외
    for (int i = 2; i <= Math.sqrt(composite.length - 1); i++) {
      if (composite[i]) continue;

      // 이중 반복문을 이용해 범위 내에서 i를 제외한 i의 배수를 모두 true 처리
      // 2의 배수인 합성수가 첫 반복에서 걸러지기 때문에, 시작점을 i * 2가 아닌 제곱수 i * i로 설정할 수 있다.
      for (int j = i * i; j < composite.length; j += i) {
        composite[j] = true;
      }
    }

    // 걸러진 소수들 중에서 문제에서 주어진 범위의 소수를 출력
    for (int i = M; i <= N; i++) {
      if (!composite[i]) sb.append(i).append("\n");
    }

    System.out.println(sb);
    br.close();
  }
}
