import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int T; // 1 <= T <= 100

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    // 2 < N <= 1000000
    boolean[] isComposite = new boolean[1000000 + 1];
    for (int i = 2; i <= Math.sqrt(isComposite.length - 1); i++) {
      if (isComposite[i]) continue;
      for (int j = i * i; j < isComposite.length - 1; j += i) {
        isComposite[j] = true;
      }
    }

    T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      int N = Integer.parseInt(br.readLine());

      int count = 0;
      for (int i = 2; i <= N / 2; i++) { // 순서만 다를 때 중복 카운트되지 않도록 절반만 탐색
        // 한 소수가 i일 때 나머지 소수는 N - i
        if (!isComposite[i] && !isComposite[N - i]) count++;
      }

      sb.append(count).append("\n");
    }

    System.out.println(sb);
    br.close();
  }
}
