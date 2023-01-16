import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(br.readLine());
    int[] input = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      input[i] = Integer.parseInt(st.nextToken());
    }

    int[] frequency = new int[1000001];
    for (int i = 0; i < N; i++) {
      frequency[input[i]] += 1;
    }

    int[] NGF = new int[N];
    int[] stack = new int[N];
    int index = -1;
    for (int i = N - 1; i >= 0; i--) { // 오 -> 왼
      int target = input[i];

      // 타겟의 오른쪽에 위치한 수의 발생 빈도가 타겟의 발생 빈도보다 작거나 같으면, 스택에서 꺼내 빈도가 큰 수를 찾음
      while (index > -1 && frequency[target] >= frequency[stack[index]]) { // 오등큰수가 없으면 index = -1
        index--;
      }

      if (index == -1) {
        NGF[i] = -1;
      } else {
        NGF[i] = stack[index];
      }

      // 스택에 담아 다음 반복문 때 타겟의 왼쪽에 위치한 수와 비교
      // while문을 거치면 index가 같은 기존 원소가 타겟으로 덮어씌워짐
      stack[++index] = target;
    }

    for (int i : NGF) {
      sb.append(i + " ");
    }

    System.out.println(sb);
    br.close();
  }
}
