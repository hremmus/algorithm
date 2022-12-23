import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  /* 
   * int형 2차원 배열을 이용하여 파티 번호와 참석자 번호를 저장
   * 반복문으로 파티마다 사람들의 번호가 곧 인덱스인 boolean 배열과 대조하여 과장할 수 없는 파티를 가려냄
   */
  static int N, M;
  static boolean[] knows;
  static int party[][];
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 최대 참석자 수
    M = Integer.parseInt(st.nextToken()); // 파티 수

    st = new StringTokenizer(br.readLine());
    int knowingPersonCount = Integer.parseInt(st.nextToken());
    if (knowingPersonCount == 0) { // 아무도 진실을 모르면 최댓값은 M. 실행 종료
      System.out.println(M);
      return;
    }

    boolean[] knows;
    knows = new boolean[N + 1];
    for (int i = 1; i <= knowingPersonCount; i++) {
      knows[Integer.parseInt(st.nextToken())] = true;
    }

    party = new int[M + 1][];
    for (int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());
      int length = Integer.parseInt(st.nextToken());
      party[i] = new int[length];
      for (int j = 0; j < length; j++) {
        party[i][j] = Integer.parseInt(st.nextToken()); // 파티 참석자
      }
    }

    int change = 0;
    while (knowingPersonCount != change) { // 아는 사람 수가 더이상 증가하지 않으면(변화 X) 멈춤
      change = knowingPersonCount;
      knowingPersonCount = 0;
      // 파티 수만큼 반복
      for (int i = 1; i <= M; i++) {
        // 해당 파티의 참석자 수만큼 반복
        for (int person : party[i]) { // party[1][0], party[1][1], party[2][0], party[2][1], ..., party[i][j]
          if (!knows[person]) continue; // 모르는 사람이면 아래 문장을 실행하지 않고 다음 턴으로 넘김
          // 아는 사람이 있으면 해당 파티의 모든 참석자를 아는 사람으로 처리(다른 파티에 해당 참석자가 있으면 과장할 수 없음)
          for (int knowingPerson : party[i]) knows[knowingPerson] = true;
        }
      }

      // 결과가 입력 순서에 영향을 받아서는 안 된다.
      for (int i = 1; i <= N; i++) {
        if (!knows[i]) continue;
        knowingPersonCount++;
      }
    }

    int impossible = 0;
    for (int i = 1; i <= M; i++) {
      for (int person : party[i]) {
        if (knows[person]) {
          impossible++;
          break; // 해당 파티에서 과장 불가. 반복문 종료
        }
      }
    }

    System.out.println(M - impossible);
  }
}
