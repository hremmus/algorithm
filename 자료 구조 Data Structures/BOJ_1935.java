import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
  // 후위 표기식은 중위 표기식과 달리 괄호나 사칙연산의 우선순위를 생각하지 않아도 된다.
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    String expression = br.readLine();

    double[] num = new double[N];
    for (int i = 0; i < N; i++) {
      num[i] = Integer.parseInt(br.readLine());
    }

    Stack<Double> stack = new Stack<>();
    double result = 0;
    for (int i = 0; i < expression.length(); i++) {
      char ch = expression.charAt(i);

      // 피연산자면 => 대응하는 수를 스택에 삽입
      if (ch >= 'A' && ch <= 'Z') {
        stack.push(num[ch - 'A']); // A부터 차례로 사용되는 식의 특성을 이용

        // 연산자면 => 최근에 넣은 수 두 개를 꺼내어 계산하고, 결과를 스택에 삽입
      } else {
        double a = stack.pop();
        double b = stack.pop();
        switch (ch) {
          case '+':
            result = b + a;
            stack.push(result);
            break;
          case '-':
            result = b - a;
            stack.push(result);
            break;
          case '*':
            result = b * a;
            stack.push(result);
            break;
          case '/':
            result = b / a;
            stack.push(result);
            break;
        }
      }
    }

    bw.write(String.format("%.2f", result)); // f: 실수형 .2: 소수점 둘째 자리까지 표기
    bw.flush();
  }
}
