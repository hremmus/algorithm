import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static int[][] input;
  static boolean[][] visited;

  // 왼, 오, 위, 아래 이동 시 x, y 위치
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  
  static int max = Integer.MIN_VALUE;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
   
    N = Integer.parseInt(st.nextToken()); // row. 4 <= N
    M = Integer.parseInt(st.nextToken()); // column. 1 <= M <= 500
   
    input = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        input[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    
    visited = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        visited[i][j] = true;
        calc(i, j, input[i][j], 1);
        visited[i][j] = false;
      }
    }
    
    System.out.println(max);
    br.close();
  }
  
  // 'ㅗ' 모양을 제외한 네 가지 도형은 depth가 4인 DFS로 구할 수 있다.
  private static void calc(int row, int column, int sum, int count) {
    // 네 칸을 고르면(depth = 4) 합의 최대값을 구하고 종료
    if (count == 4) {
      max = Math.max(max, sum);
      return;
    }
    
    for (int i = 0; i < 4; i++) {
      int currentRow = row + dx[i];
      int currentColumn = column + dy[i];
      // 현 위치가 범위 밖을 넘어서지 않도록 함
      if (currentRow < 0 || currentRow >= N || currentColumn < 0 || currentColumn >= M) continue;
      
      if (!visited[currentRow][currentColumn]) {
        if (count == 2) { // 'ㅗ' 모양을 구하기 위해 2번째 칸일 때는 탐색을 한번 더 함
        visited[currentRow][currentColumn] = true;
        calc(row, column, sum + input[currentRow][currentColumn], count + 1);
        visited[currentRow][currentColumn] = false;
        }
        
        visited[currentRow][currentColumn] = true;
        calc(currentRow, currentColumn, sum + input[currentRow][currentColumn], count + 1);
        visited[currentRow][currentColumn] = false;
      }
    }
  }
}
