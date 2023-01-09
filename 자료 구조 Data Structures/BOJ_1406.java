import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
  /* ListIterator 이용: Iterator와 달리 양방향 접근이 가능 previous/next */
  static int M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    LinkedList<Character> list = new LinkedList<>();
    String str = br.readLine();
    for (int i = 0; i < str.length(); i++)
      list.add(str.charAt(i));

    // index = list.size(); => 커서를 초기문자열 맨 뒤에 위치
    ListIterator<Character> cursor = list.listIterator(list.size());

    M = Integer.parseInt(br.readLine());
    while (M-- > 0) {
      String command = br.readLine();
      switch (command.charAt(0)) {
        case 'L':
          if (cursor.hasPrevious())
            cursor.previous();
          break;
        case 'D':
          if (cursor.hasNext())
            cursor.next();
          break;
        case 'B':
          if (cursor.hasPrevious())
            cursor.previous();
          cursor.remove();
          break;
        case 'P':
          char ch = command.charAt(2);
          cursor.add(ch);
          break;
      }
    }

    for (char ch : list)
      sb.append(ch);

    System.out.println(sb);
  }
}
