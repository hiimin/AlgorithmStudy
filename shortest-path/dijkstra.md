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

### - [Priority Queue](https://app.gitbook.com/@hiimin/s/jeongmin_book/~/drafts/-LyTKIgADT9yLcZ0qF1i/queue/priority-queue) 사용

```java
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
	int dest; // 목적지
	int weight; // 가중치

	Edge(int dest, int weight) {
		this.dest = dest;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.weight - o.weight;
	}
}

public class Main {
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int v; // 정점 개수
		int e; // 간선 개수
		int k; // 시작 정점

		v = scan.nextInt();
		e = scan.nextInt();
		k = scan.nextInt() - 1;

		ArrayList<Edge> map[] = new ArrayList[v];
		for (int i = 0; i < v; i++)
			map[i] = new ArrayList<Edge>();

		boolean check[] = new boolean[v];
		int distance[] = new int[v];

		for (int i = 0; i < v; i++)
			distance[i] = INF; // 최단거리 무한대로 초기화

		distance[k] = 0;

		for (int i = 0; i < e; i++) {
			int start = scan.nextInt() - 1;
			int end = scan.nextInt() - 1;
			int w = scan.nextInt();

			Edge edge = new Edge(end, w);
			map[start].add(edge);
		}

		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		
		pq.add(new Edge(k, 0));
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			check[edge.dest] = true;

			for (int i = 0; i < map[edge.dest].size(); i++) {
				int end = map[edge.dest].get(i).dest;
				int weight = map[edge.dest].get(i).weight;
				if (distance[end] == INF || distance[edge.dest] + weight < distance[end]) {
					distance[end] = distance[edge.dest] + weight;

					pq.add(new Edge(end, distance[end]));
				}
			}
		}

		for (int i = 0; i < v; i++) {
			if (distance[i] == INF)
				System.out.println("INF");
			else
				System.out.printf("%d\n", distance[i]);
		}
	}
}
```

### [- 1261\(알고스팟\)](https://app.gitbook.com/@hiimin/s/jeongmin_book/~/drafts/-LybuKctn05i-C9i0XSY/baekjoon/1261)

### [- 4485\(녹색 옷 입은 애가 젤다지?\)](https://app.gitbook.com/@hiimin/s/jeongmin_book/~/drafts/-LybuKctn05i-C9i0XSY/baekjoon/4485)

### [- 1504\(특정한 최단 경로\)](https://app.gitbook.com/@hiimin/s/jeongmin_book/~/drafts/-LycIsjdZOjQRSHqto2d/baekjoon/1504)

### [- 6593\(상범 빌딩\)](https://app.gitbook.com/@hiimin/s/jeongmin_book/~/drafts/-LycIsjdZOjQRSHqto2d/baekjoon/6593)

### [- 5719\(거의 최단 경로\)](https://app.gitbook.com/@hiimin/s/jeongmin_book/~/drafts/-LyhUSikMKDgGO0QfxJm/baekjoon/5719)

### [- 11779\(최소비용 구하기 2\)](https://app.gitbook.com/@hiimin/s/jeongmin_book/~/drafts/-LyhiTfeIDCBotZbyA0D/baekjoon/11779-2)

## Reference

{% embed url="https://hsp1116.tistory.com/42" %}



