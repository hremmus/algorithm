import java.io.IOException;

public class Main {
  // 아래에서 위로 쌓아 올리는 쇠막대기를 스택 구조로 구현
  public static void main(String[] args) throws IOException {
    int stack = 0, count = 0;
    boolean flag = false;

    while (true) {
      int ch = System.in.read(); // char를 입력 받아 ASCII 코드를 반환. IOException 처리 필요
      if (ch == '\n')
        break;
      if (ch == '(') {
        stack++; // push
        flag = true; // 다음 입력으로 닫힌 괄호가 들어올 때 레이저 여부 체크 위함
      }
      if (ch == ')') {
        stack--; // pop
        if (flag) {
          count += stack; // 레이저를 만나면 스택에 쌓인 쇠막대기들이 절단됨 => 그 조각을 더함
          flag = false;
        } else { // 레이저가 아닐 때는 쇠막대기 하나를 의미
          count++;
        }
      }
    }

    System.out.print(count);
  }
}
