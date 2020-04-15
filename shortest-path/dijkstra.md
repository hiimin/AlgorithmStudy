# Dijkstra

* 하나의 시작 정점으로부터 다른 모든 정점까지의 최단 경로를 찾을 경우
* 음수 가중치가 없을 경우

{% embed url="https://www.youtube.com/watch?v=icqzGct4V1s" %}

{% embed url="https://jason9319.tistory.com/307" %}



## CODE

### - for으로만\(O\(V^2\)\)

{% embed url="https://www.crocus.co.kr/532" %}

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

####  우선순위 큐를 사용안하면 dist 값들을 다 비교해서 찾는것이 매번 O\(V\) 이고, V-1번 루프를 돌기 때문에 O\(V^2\)의 시간복잡도가 발생한다. 우선순위 큐를 사용하면 정점 u를 방문해서 인접한 정점 v의 거리를 갱신할 때마다 큐에 \(dist\[v\], v\)쌍을 넣는다. pop을 하면 dist값이 가장 작은 값이 먼저 나오게 된다. 이렇게 하면, 한 정점에 최대한 많은 갱신이 이루어진다고 해도 총 V^2번 갱신이 이루어져서 V^2개의 정보가 들어있다고 해도 원래 연산에 O\(logN\)의 시간이 드는 우선순위 큐 입장에서는 O\(log\(V^2\)\) = O\(2logV\) = O\(logV\).  즉, 최대 O\(E\)번 우선순위 큐에서 top을 꺼내는 연산 O\(logV\), 루프 전체를 통틀어서 인접한 정점으로의 거리를 갱신하는 부분도 최대 O\(E\)번 이루어질 것이므로 총 시간복잡도 합은 O\(ElogV\)이다. 여기서 O\(E\)라는 시간복잡도 또한 그래프를 인접리스트로 구현했을 경우이다. 인접행렬로 구현했다면 매번 인접한 정점을 찾아야 되기 때문에 루프마다 O\(V\)의 시간이 소요되어서 총합 O\(V^2\)가 될 것이다.

### - 1261\(알고스팟\)

### - 4485\(녹색 옷 입은 애가 젤다지?\)

### - 1504\(특정한 최단 경로\)

### - 6593\(상범 빌딩\)

### - 5719\(거의 최단 경로\)

### - 11779\(최소비용 구하기 2\)

### - 6118\(숨바꼭질\)

### - 9205\(맥주 마시면서 걸어가기\)

### - 10282\(해킹\)

## Reference

{% embed url="https://hsp1116.tistory.com/42" %}



