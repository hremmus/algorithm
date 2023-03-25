import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int[] input;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    input = new int[9];
    int sum = 0;
    for (int i = 0; i < input.length; i++) {
      input[i] = Integer.parseInt(br.readLine()); // 1 <= input[i] <= 100, 모두 다른 수
      sum += input[i]; // 먼저 총합을 구함
    }

    Arrays.sort(input);

    bruteForce:
    for (int i = 0; i < input.length - 1; i++) {
      for (int j = i + 1; j < input.length; j++) {
        if (sum - (input[i] + input[j]) == 100) { // 합이 100이 되게 하는 i, j를 축출
          for (int k = 0; k < input.length; k++) {
            if (k == i || k == j) continue; // i, j 제외하고 출력
            sb.append(input[k]).append("\n");
          }
          break bruteForce;
          // if문이 true인 경우가 여러 개라면 결과에 변동이 생길 수 있다. (스페셜 저지 문제)
          // => 반복문을 명명하고 출력을 마친 시점에 맨 바깥 반복문을 종료시킴
        }
      }
    }

    System.out.println(sb);
    br.close();
  }
}
