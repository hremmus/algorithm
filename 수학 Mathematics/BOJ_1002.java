import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  /*
   * tangent point
   * 좌표 (x1, y1)와의 거리 r1, 좌표 (x2, y2)와의 거리 r2가 주어졌을 때
   * 두 점 사이의 거리 공식과 두 원의 위치 관계를 이용하여 있을 수 있는 좌표의 수 구하기
   */

  // 테스트 케이스의 개수 T는 정적 변수로 선언 => 여러 객체가 하나의 메모리를 참조하게 함
  static int T;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // java.util.Scanner는 1KB, java.io.BufferedReader는 8KB의 버퍼를 차지
    // (+) BufferedReader는 synchronized 이용 가능 => multi-thread 환경에 적합
    // br.readLine(): 오직 String 값만을 받음. IOException 예외처리 필요
    T = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine()); // 반환된 문장을 공백 기준으로 자름
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int r1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      int r2 = Integer.parseInt(st.nextToken());

      // 두 원의 중심 사이 거리
      // sqrt(square root): 제곱근, pow(power): 거듭제곱
      double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

      // 1) 두 원의 중점과 반지름이 같음 = 동심원 => 개수가 무한대
      if (x1 == x2 && y1 == y2 && r1 == r2) {
        sb.append(-1).append("\n");
        // 2) 서로 떨어져 있거나, 원 안에 있으나 내접하지 않음
      } else if (r1 + r2 < distance || Math.abs(r1 - r2) > distance) {
        sb.append(0).append("\n");
        // 3) 외접 혹은 내접
      } else if (r1 + r2 == distance || Math.abs(r1 - r2) == distance) {
        sb.append(1).append("\n");
        // 4) 두 원이 교차함
      } else if (Math.abs(r1 - r2) < distance && distance < r1 + r2 ) {
        sb.append(2).append("\n");
      }
    }
    System.out.print(sb);
  }
}
}