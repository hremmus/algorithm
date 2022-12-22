import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
  /*
   * 양방향 순환 큐 문제: 양 끝 요소가 반대편으로 이동하는 방식으로 순환
   * => deque을 JAVA의 LinkedList로 구현
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.valueOf(st.nextToken()); // queue size
    int M = Integer.valueOf(st.nextToken()); // poll count(1 <= M <= N)
    LinkedList<Integer> deque = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      deque.offer(i); // 1 ~ n 원소 주입
    }

    int[] targets = new int[M];
    int minCount = 0;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      targets[i] = Integer.parseInt(st.nextToken()); // M개의 뽑아내려는 숫자 배열에 차례로 담기
    }

    for (int target : targets) {
      while(true) {
        // 뽑아내려는 수가 맨 앞에 있으면 원소를 삭제 후 break
        if (target == deque.peekFirst()) {
          deque.pollFirst();
          break;
        }
        else {
          // 뽑으려는 수의 위치가 어느 쪽에 가까운 지 판별하기 위한 기준을 가운데로 설정 -> 인덱스와 비교
          // 왼쪽으로 이동하는 게 빠를 경우
          if (deque.indexOf(target) < (double) deque.size() / 2) {
            while (target != deque.getFirst()) {
              deque.offerLast(deque.pollFirst()); // 맨 앞 원소를 제거하고 맨 끝에 추가
              minCount++;
            }
            // 오른쪽으로 이동하는 게 빠를 경우
          } else {
            while (target != deque.getFirst()) {
              deque.offerFirst(deque.pollLast());  // 맨 끝 원소를 제거하고 맨 앞에 추가
              minCount++;
            }
          }
        }
      } /* 연산이 끝나면 덱의 맨 앞에 target이 위치할 것이므로
      while(true)문을 사용하지 않고 이 시점에 deque.pollFirst();를 실행해도 된다. */
    }
    System.out.println(minCount);
  }
}