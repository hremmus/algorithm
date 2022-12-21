import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Circle {
  public Circle(int x, int y, int radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
  }
  int x, y, radius;
}

public class Main {
  /*
   * 시작점과 도착점 모두 원 안/밖에 있으면 진입/이탈이 일어나지 않는다.
   * 시작점과 도착점이 각각 원 안-밖에 있으면 진입/이탈이 일어난다.
   * => 원과 직선의 위치 관계에 의해, 중점과 직선 사이의 거리가 반지름보다 작으면 카운트한다.
   *    (문제에서 점이 원의 경계에 걸쳐지는 경우는 제외됨)
   */
  static int T;

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());
    Circle circle[];
    boolean checkA, checkB;

    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      int passCount = 0;

      int n = Integer.parseInt(br.readLine());
      circle = new Circle[n];

      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        int cx = Integer.parseInt(st.nextToken());
        int cy = Integer.parseInt(st.nextToken());
        int radius = Integer.parseInt(st.nextToken());
        circle[i] = new Circle(cx, cy, radius);

        // 시작점-중점, 도착점-중점의 거리를 각각 구하고, 원의 반지름과 비교하여 그보다 작으면 점은 원의 내부에 위치
        checkA = isInside(x1, y1, circle[i]);
        checkB = isInside(x2, y2, circle[i]);

        // 시작점과 도착점이 각각 원의 안-밖에 있으면
        if ((checkA && !checkB) || (!checkA && checkB)) passCount++;
      }
      System.out.println(passCount);
    }
  }

  private static boolean isInside(int x, int y, Circle c) {
    // 피타고라스 정리를 활용한 유클리디안 거리
    double distance = Math.sqrt(Math.pow(c.x - x, 2) + Math.pow(c.y - y, 2));
    return distance < c.radius;
  }
}