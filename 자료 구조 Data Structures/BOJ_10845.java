import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
  /* 배열로도 구현이 가능 */
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    LinkedList<Integer> queue = new LinkedList<>();
    N = Integer.parseInt(br.readLine());
    while (N-- > 0) {
      String[] command = br.readLine().split(" ");
      switch (command[0]) {
        case "push":
          queue.offer(Integer.parseInt(command[1]));
          break;
        case "pop":
          if (queue.isEmpty())
            sb.append("-1\n");
          else
            sb.append(queue.poll()).append("\n");
          break;
        case "size":
          sb.append(queue.size()).append("\n");
          break;
        case "empty":
          if (queue.isEmpty())
            sb.append("1\n");
          else
            sb.append("0\n");
          break;
        case "front":
          if (queue.isEmpty())
            sb.append("-1\n");
          else
            sb.append(queue.peekFirst()).append("\n");
          break;
        case "back":
          if (queue.isEmpty())
            sb.append("-1\n");
          else
            sb.append(queue.peekLast()).append("\n");
          break;
      }
    }

    System.out.println(sb);
  }
}
