import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    boolean composite[] = new boolean[1000000 + 1];
    composite[1] = true;
    for (int i = 2; i < Math.sqrt(composite.length - 1); i++) {
      if (composite[i]) continue;

      for (int j = i * i; j < composite.length; j += i) {
        composite[j] = true;
      }
    }

    int n;
    boolean correct = false;
    while ((n = Integer.parseInt(br.readLine())) != 0) { // 0이 아닌 입력값을 계속 받아 실행
      for (int i = 1; i <= n / 2 + 1; i += 2) { // a, b는 홀수
        // n = a + b일 때, b - a의 차가 크도록 아래와 같이 대입
        int a = i;
        int b = n - i;
        if (!composite[a] && !composite[b]) {
          sb.append(n).append(" = ").append(a).append(" + ").append(b).append("\n");
          correct = true;
          break; // b - a의 차가 가장 커야 함
        }
      }

      if (!correct) {
        sb.delete(0, sb.length()); // 모든 n에 대해 추측이 성립해야 함 + break
        sb.append("Goldbach's conjecture is wrong.");
        break;
      }
    }

    System.out.println(sb);
    br.close();
  }
}
