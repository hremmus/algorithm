import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Stack {
  public Stack() {
    arr = new char[600000]; // 100000 + 500000
    top = -1;
  }

  private char arr[];
  private int top;

  public void push(char x) {
    arr[++top] = x;
  }

  public char pop() {
    if (empty())
      return 'E';
    return arr[top--];
  }

  public boolean empty() {
    if (top == -1)
      return true;
    return false;
  }

  public int top() {
    return top;
  }
}

public class Main {
  /* 스택 구조를 간략화하여 시간 단축 */
  static int M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    // 커서를 기준으로 하는 왼쪽-오른쪽 스택을 생성
    Stack lStack = new Stack();
    Stack rStack = new Stack();

    String str = br.readLine();
    for (char ch : str.toCharArray())
      lStack.push(ch);

    M = Integer.parseInt(br.readLine());
    while (M-- > 0) {
      String command = br.readLine();
      switch (command.charAt(0)) {
        case 'L': // 좌측으로 이동
          if (!lStack.empty()) // 커서가 문장의 맨 앞이면 무시
            rStack.push(lStack.pop());
          break;
        case 'D': // 우측으로 이동
          if (!rStack.empty()) // 커서가 문장의 맨 뒤면 무시
            lStack.push(rStack.pop());
          break;
        case 'B': // 커서 왼쪽 문자 삭제
          if (!lStack.empty()) // 커서가 문장의 맨 앞이면 무시
            lStack.pop();
          break;
        case 'P': // 커서 왼쪽 문자 추가
          char ch = command.charAt(2);
          lStack.push(ch);
          break;
      }
    }

    // "abcd" + "P x", "L", "P y"
    while (!lStack.empty())
      rStack.push(lStack.pop()); // x + ydcba
    while (!rStack.empty())
      sb.append(rStack.pop()); // abcdyx

    System.out.println(sb);
  }
}
