import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
  /* 스택을 이용한 단어 뒤집기 (후입선출 LIFO 활용) */
  static int T;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      Stack<Character> stack = new Stack<>();
      String sentence = br.readLine() + "\n";
      for (char character : sentence.toCharArray()) { // String.toCharArray(): String -> char[]
        if (character == ' ' || character == '\n') {
          while (!stack.isEmpty()) {
            bw.write(stack.pop()); // 공백 or 개행문자를 만난 시점에 stack에서 알파벳을 꺼내 버퍼에 담음
          }

          bw.write(character); // 공백 or 개행문자를 버퍼에 담음
        } else {
          stack.push(character); // stack에 알파벳을 저장
        }
      }

      // 개행문자 \n를 문장 뒤와 조건에 추가하지 않는 대신 아래 문장으로 처리할 수 있다.
      // while(!stack.isEmpty()) bw.write(stack.pop());
      // bw.newLine();
    }

    bw.flush();
    br.close();
    bw.close();
  }
}
