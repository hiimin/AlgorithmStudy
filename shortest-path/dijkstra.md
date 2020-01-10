# Dijkstra

* 하나의 시작 정점으로부터 다른 모든 정점까지의 최단 경로를 찾을 경우
* 음수 가중치가 없을 경우

## CODE

### - for으로만

```java
import java.util.Scanner;

public class Main {
	static int map[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int v;
		int e;
		int k;

		v = scan.nextInt();
		e = scan.nextInt();
		k = scan.nextInt() - 1;

		map = new int[v][v];

		int check[] = new int[v];
		int distance[] = new int[v];

		for (int i = 0; i < v; i++)
			distance[i] = -1; // 최단거리 무한대로 초기화

		check[k] = 1;
		distance[k] = 0;

		for (int i = 0; i < e; i++) {
			int start = scan.nextInt() - 1;
			int end = scan.nextInt() - 1;
			int w = scan.nextInt();

			map[start][end] = w;
		}

		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				if (i != j && map[i][j] == 0)
					map[i][j] = -1; // -1을 inf로 표현
			}
		}

		int current = k;
		for (int i = 0; i < v - 1; i++) {
			for (int j = 0; j < v; j++) {
				if (map[current][j] != -1) {
					if (distance[j] == -1 || distance[j] > distance[current] + map[current][j])
						distance[j] = distance[current] + map[current][j];
				}
			}

			int min = -1;
			for (int j = 0; j < v; j++) {
				if (check[j] == 0) {
					if (distance[j] != -1) {
						if (min == -1 || distance[min] > distance[j])
							min = j;
					}
				}
			}

			if (min == -1)
				continue;

			check[min] = 1;
			current = min;
		}

		for (int i = 0; i < v; i++) {
			if (distance[i] == -1)
				System.out.println("INF");
			else
				System.out.printf("%d\n", distance[i]);
		}
	}
}
```

### - Queue 사용

```java

```

