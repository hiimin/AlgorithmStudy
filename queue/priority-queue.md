# priority queue

* 일반적인 큐는 먼저 들어간 데이터가 먼저 나오는 FIFO
* 우선순위 큐는 우선순위가 가장 높은 데이터가 가장 먼저 나옴
* 우선순위 큐는 힙을 이용하여 구현하는 것이 일반적
* 데이터를 삽입할 때 우선순위를 기준으로 최대힙 혹은 최소힙을 구성하고 데이터를 꺼낼 때 루트 노드를 얻어냄
* 루트 노드를 삭제할 때는 빈 루트 노드 위치에 맨 마지막 노드를 삽입한 후 아래로 내려가면서 적절한 자리를 찾아서 옮김

## 사용법

```java
//생성
PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		
//추가
priorityQueue.add(5);
priorityQueue.add(4);
priorityQueue.add(3);
priorityQueue.add(2);
priorityQueue.add(1);
		
//poll
while(!priorityQueue.isEmpty()) {
	System.out.println(priorityQueue.poll());
}
```

### 실행 결과

default로 min heap 상태이다. 따라서 작은 값부터 출력됨

```text
1
2
3
4
5
```

## 우선순위 조건 설정

Edge 라는 클래스가 있다. `dest`과 `weight` 속성을 가지고 있다. 거리를 기준으로 거리가 짧은 순 으로 우선순위 큐를 구성해서 사용해 보려고 한다.

> 우선순위가 한 가지의 속성으로만 결정될 필요는 없다. 새로운 속성 값을 추가하고 `Comparable`, `Comparator` 를 잘 구현해주면 여러가지의 조건으로 우선 순위를 결정할 수 있다.

#### Comparable 구현 <a id="comparable-&#xAD6C;&#xD604;"></a>

Edge 클래스에 `Comparable`의 `compareTo()` 를 오버라이딩 하여 구현한다. weight 값을 기준으로 반환 값이 음수, 양수 인지에 따라 우선순위가 결정된다. 아래의 예제는 거리가 짧은 순을 구현한 것이다. \(거리가 짧을수록 우선순위가 높다.\)

```java
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
		return this.weight - o.weight;	//음수일 경우 더 높은 우선순
	}
}


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

		pq.add(new Edge(1, 1000));
		pq.add(new Edge(2, 500));
		pq.add(new Edge(3, 100));
		pq.add(new Edge(4, 600));
		pq.add(new Edge(5, 800));

		while (!pq.isEmpty()) {
			Edge poll = pq.poll();
			System.out.printf("dest : %d	weight : %d\n", poll.dest, poll.weight);
		}
	}
}
```

#### 실행결과

```text
dest : 3	weight : 100
dest : 2	weight : 500
dest : 4	weight : 600
dest : 5	weight : 800
dest : 1	weight : 1000
```

