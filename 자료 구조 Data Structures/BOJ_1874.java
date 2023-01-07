import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
  static int n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    Stack<Integer> stack = new Stack<>();
    n = Integer.parseInt(br.readLine());

    int start = 0; // last push value
    while (n-- > 0) {
      int input = Integer.parseInt(br.readLine());
      if (input > start) {
        for (int i = start + 1; i <= input; i++) {
          stack.push(i);
          sb.append("+\n");
        }
        start = input;
      }

      if (stack.peek() != input) {
        System.out.println("NO");
        return; // main() 종료
      }

      // 마지막으로 push된 숫자 또한 stack에서 뽑아 나열되어야 함 => - 연산을 포함, stack.peek() 값 변동
      stack.pop();
      sb.append("-\n");

      // for (int i : stack) System.out.print(i + " ");
    }

    System.out.println(sb);
  }
}
