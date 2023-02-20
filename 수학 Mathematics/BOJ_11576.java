import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  // BOJ_2745 + BOJ_11005
  static int A, B, m; // 미래 진법 A, 정이가 사용하는 진법 B, A진법으로 표현된 숫자의 자릿수 m개

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    A = Integer.parseInt(st.nextToken()); // 2 <= A <= 30
    B = Integer.parseInt(st.nextToken()); // 2 <= B <= 30
    m = Integer.parseInt(br.readLine());

    // A진법 -> 10진법
    int decimalNumber = 0; // 2의 20승보다 작다 => int
    st = new StringTokenizer(br.readLine());
    for (int i = m - 1; i >= 0; i--) {
      // 높은 자릿수부터 nextToken()으로 받기 때문에 Math.pow 함수를 사용하여 자릿수를 1씩 제하며 거듭제곱
      int inputNumber = Integer.parseInt(st.nextToken());
      decimalNumber += inputNumber * Math.pow(A, i);
    }

    // 10진법 -> B진법
    // 한 자리마다 공백을 두고 출력
    Stack<Integer> stack = new Stack<>();
    while (decimalNumber != 0) {
      stack.push(decimalNumber % B);

      decimalNumber /= B;
    }

    while (!stack.isEmpty()) {
      sb.append(stack.pop()).append(" ");
    }

    System.out.println(sb);
    br.close();
  }
}
