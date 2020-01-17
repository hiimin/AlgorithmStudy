# Floyd Warshall

플로이드 와샬 알고리즘은 동적계획법을 기반으로 구현되는 알고리즘이다. 다익스트라, 벨만 포드 알고리즘은 하나의 시작점에서의 최단 경로를 구하지만 플로이드 와샬 알고리즘은 모든 꼭짓점에서의 최단 경로를 구한다. 플로이드 와샬 알고리즘의 핵심 아이디어는 **거쳐가는 정점을 기준**으로 최단 거리를 구하는 것이다. 3중 for문을 쓰는데 가장 바깥쪽 for문은 거쳐가는 꼭짓점, 다음 안쪽은 출발 꼭짓점, 가장 안쪽은 도착 꼭짓점이다. 거쳐가는 꼭짓점을 다르게 하면서 현재 두 정점사이의 거리가 출발점에서 중간점까지의 거리 + 중간점에서 도착점까지의 거리보다 크면 업데이트해준다.

## 구현

### 11403 - 경로찾기

```java
import java.util.Scanner;

public class Main {
	static int n;
	static int map[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = scan.nextInt();
			}
		}

		//Floyd Warshall
		for (int mid = 0; mid < n; mid++) {
			for (int start = 0; start < n; start++) {
				for (int end = 0; end < n; end++) {
					if (map[start][mid] == 0 || map[mid][end] == 0)
						continue;

					if (map[start][end] == 0 || (map[start][end] > map[start][mid] + map[mid][end]))
						map[start][end] = map[start][mid] + map[mid][end];
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != 0)
					map[i][j] = 1;
				System.out.printf("%d ", map[i][j]);
			}
			System.out.println("");
		}
	}
}
```

### [- 11404\(플로이드\)](https://app.gitbook.com/@hiimin/s/jeongmin_book/~/drafts/-Lym5bLUoOm5aMRK8gnC/baekjoon/11404)

### [- 1613\(역사\)](https://app.gitbook.com/@hiimin/s/jeongmin_book/~/drafts/-Lym5bLUoOm5aMRK8gnC/baekjoon/1613)

### [- 1389\(케빈 베이컨의 6단계 법칙\)](https://app.gitbook.com/@hiimin/s/jeongmin_book/~/drafts/-Lym5bLUoOm5aMRK8gnC/baekjoon/1389-6)

### [- 1238\(파티\)](https://app.gitbook.com/@hiimin/s/jeongmin_book/~/drafts/-Lym5bLUoOm5aMRK8gnC/baekjoon/1238)

### [- 2458\(키 순서\)](https://app.gitbook.com/@hiimin/s/jeongmin_book/~/drafts/-Lym5bLUoOm5aMRK8gnC/baekjoon/2458)

### [- 10159\(저울\)](https://app.gitbook.com/@hiimin/s/jeongmin_book/~/drafts/-Lym5bLUoOm5aMRK8gnC/baekjoon/10159)

### [- 9205\(맥주 마시면서 걸어가기\)](https://app.gitbook.com/@hiimin/s/jeongmin_book/~/drafts/-Lym5bLUoOm5aMRK8gnC/baekjoon/9205)

## 시간복잡도

3중 for문으로 O\(N^3\)

## Reference

{% embed url="https://www.crocus.co.kr/536" %}

