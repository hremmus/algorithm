import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
  // 후위 표기식 -> 중위 표기식 변환
  // 괄호와 연산자는 사칙연산의 우선순위를 고려하기 위해 스택을 이용, 피연산자는 바로 출력한다.
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    Stack<Character> stack = new Stack<>();
    String expression = br.readLine();
    for (int i = 0; i < expression.length(); i++) {
      char ch = expression.charAt(i);
      // 피연산자
      if (ch >= 'A' && ch <= 'Z') {
        bw.write(ch);

        // 연산자 or 괄호
      } else {
        switch (ch) {
          case '(':
            stack.push(ch);
            break;
          case ')':
            while (!stack.isEmpty() && stack.peek() != '(') {
              bw.write(stack.pop());
            }
            stack.pop(); // '('
            break;

          case '+':
          case '-':
          case '*':
          case '/':
            // 우선순위가 높은 연산자가 있으면 꺼내어 먼저 출력하고, 해당 연산자는 스택에 삽입
            while (!stack.isEmpty() && priority(stack.peek()) <= priority(ch)) {
              bw.write(stack.pop());
            }
            stack.push(ch);
            break;
        }
      }
    }

    while (!stack.isEmpty()) {
      bw.write(stack.pop());
    }

    bw.flush();
    bw.close();
    br.close();
  }

  private static int priority(char ch) {
    switch (ch) {
      case '*':
      case '/':
        return 0;
      case '+':
      case '-':
        return 1;
      case '(':
      case ')':
        return 2;
    }

    return -1;
  }
}
