import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine()); // 0 <= N <= 500000
    M = Integer.parseInt(br.readLine()); // 0 <= M <= 10
    boolean[] broken = new boolean[10];
    if (M != 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < M; i++) {
        broken[Integer.parseInt(st.nextToken())] = true;
      }
    }

    // 초기값을 최대로 설정 => 1) + 또는 - 버튼으로만 채널을 조정하는 경우
    int min = Math.abs(N - 100);
    // 2) 숫자 버튼을 눌러 채널을 조정하는 경우를 탐색
    for (int i = 0; i <= 999999; i++) { // N의 최대값이 6자리이므로, 고장나지 않은 버튼을 최소 여섯 번 눌러야 한다
      int count = remote(i, broken); 
      if (count == -1) continue;
      min = Math.min(min, count + Math.abs(N - i)); // 숫자 버튼과 +/- 버튼 누르는 값 합산하여 비교
    }

    System.out.println(min);
    br.close();
  }
  
  // 숫자 버튼을 누르는 횟수 계산 (모두 고장난 버틑이면 -1을 리턴)
  private static int remote(int number, boolean[] broken) {
    int count = 0;
    
    if (number == 0) {
      if (broken[0]) return -1;
      return 1;
    }
    
    while (number > 0) { // 0.?이 될 떄 까지 number / 10 반복
      if (broken[number % 10]) return -1; // mod 연산 시 나머지로 맨 뒷자리 숫자만 남음
      
      count++;
      number /= 10;
    }
    
    return count;
  }
}
