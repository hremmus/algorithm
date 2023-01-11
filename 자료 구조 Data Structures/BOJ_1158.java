import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  /* LinkedList를 이용하여 K - 1번 반복하여 poll한 값을 add하고, poll한 값을 출력하는 방법 => 메모리 소모가 큼 */
  static int N, K;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    ArrayList<Integer> queue = new ArrayList<>();
    for (int i = 1; i <= N; i++) {
      queue.add(i);
    }

    sb.append('<');
    int index = 0;
    while (!queue.isEmpty()) {
      index += K - 1; // K번째 => K - 1만큼 이동
      if (index >= queue.size()) // IndexOutOfBoundsException 방지
        index %= queue.size();
      sb.append(queue.remove(index));

      if (!queue.isEmpty()) // 마지막 원소에 붙는 불필요한 문자열 ", "을 버퍼에 넣지 않기 위함
        sb.append(", ");
    }
    sb.append('>');

    System.out.println(sb);
    br.close();
  }
}
