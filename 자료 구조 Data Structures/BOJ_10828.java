import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int[] stack;
  static int size = 0; // element의 개수를 집계할 변수가 필요

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // System.out보다 빠름
    N = Integer.parseInt(br.readLine());
    stack = new int[N];

    StringTokenizer st;
    while (N-- > 0) {
      st = new StringTokenizer(br.readLine());
      String command = st.nextToken();
      switch (command) {
        case "push":
          push(Integer.parseInt(st.nextToken()));
          break;
        case "pop":
          bw.write(String.valueOf(pop())); // int 값을 그대로 넣으면 ASCII 코드에 따른 char형 값으로 변환
          bw.newLine(); // 줄바꿈 '\n'이 포함
          break;
        case "size":
          bw.write(String.valueOf(size()));;
          bw.newLine();
          break;
        case "empty":
          bw.write(String.valueOf(empty()));
          bw.newLine();
          break;
        case "top":
          bw.write(String.valueOf(top()));
          bw.newLine();
          break;
      }
    }

    bw.flush();
    br.close();
    bw.close();
  }

  static void push(int element) {
    stack[size] = element;
    size++;
  }

  static int pop() {
    if (size == 0) {
      return -1;
    } else {
      int element = stack[size - 1];
      stack[size - 1] = 0;
      size--;
      return element;
    }
  }

  static int size() {
    return size;
  }

  static int empty() {
    return size == 0 ? 1 : 0;
  }

  static int top() {
    if (size == 0) {
      return -1;
    } else {
      return stack[size - 1];
    }
  }
}
