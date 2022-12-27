import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static class Building {
    public Building(int time) {
      this.time = time;
      totalTime = -1;
    }

    int time; // 주어진 건설 시간
    int totalTime; // 건설 완료까지 소요되는 최소 시간

    ArrayList<Building> previous = new ArrayList<Building>(); // 규칙에 의해 먼저 건설되어야 할 건물

    void needs(Building building) {
      previous.add(building);
    }

    void calc() {
      if (previous.size() == 0) { // 먼저 지어야 할 건물이 없다면 주어진 건설 시간이 곧 출력값
        totalTime = time;
        return;
      }

      for (int i = 0; i < previous.size(); i++) {
        if (previous.get(i).totalTime == -1) // 앞서 요구되는 건물의 건설 시간을 먼저 계산해야 함
          previous.get(i).calc();
        
        // 같은 목표선상의 건물들은 동시에 건설이 가능 => 반복하여 들어오는 값 중 더 큰(오래 걸리는) 값을 선택
        totalTime = Math.max(totalTime, time + previous.get(i).totalTime); 
      }
    }
  }

  static int T, N, K, W; // 테스트 케이스, 건물 개수, 규칙 개수, 목표 건물 번호

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());

      Building[] buildings = new Building[N + 1];
      st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= N; i++) {
        buildings[i] = new Building(Integer.parseInt(st.nextToken()));
      }

      int X, Y; // 건설 규칙 X -> Y
      for (int k = 0; k < K; k++) {
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        buildings[Y].needs(buildings[X]);
      }

      W = Integer.parseInt(br.readLine());
      buildings[W].calc();

      sb.append(buildings[W].totalTime).append("\n");
    }

    System.out.println(sb);
  }
}
