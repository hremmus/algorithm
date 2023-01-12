import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
  // Deque: 양방향(시작/끝)으로 삽입과 삭제 연산이 가능
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();

    Deque<Integer> deque = new ArrayDeque<>();
    N = Integer.parseInt(br.readLine());
    while (N-- > 0) {
      String[] command = br.readLine().split(" ");
      switch (command[0]) {
        case "push_front":
          deque.addFirst(Integer.parseInt(command[1]));
          break;
        case "push_back":
          deque.addLast(Integer.parseInt(command[1]));
          break;
        case "pop_front":
          if (deque.isEmpty())
            sb.append(-1).append("\n");
          else
            sb.append(deque.pollFirst()).append("\n");
          break;
        case "pop_back":
          if (deque.isEmpty())
            sb.append(-1).append("\n");
          else
            sb.append(deque.pollLast()).append("\n");
          break;
        case "size":
          sb.append(deque.size()).append("\n");
          break;
        case "empty":
          int i = deque.isEmpty() ? 1 : 0;
          sb.append(i).append("\n");
          break;
        case "front":
          if (deque.isEmpty())
            sb.append(-1).append("\n");
          else
            sb.append(deque.peekFirst()).append("\n");
          break;
        case "back":
          if (deque.isEmpty())
            sb.append(-1).append("\n");
          else
            sb.append(deque.peekLast()).append("\n");
          break;
      }
    }

    System.out.println(sb);
  }
}
