# Kruskal

 크루스칼 알고리즘은 가장 적은 비용으로 모든 노드를 연결하기 위해 사용되는 알고리즘이다. 다시 말해 최소 비용 신장 트리를 만들기 위한 대표적인 알고리즘이라고 할 수 있다. 예들 들어 여러개의 도시가 있을 때 각 도시를 도로를 이용해 연결하고자 할 때 비용을 최소한으로 하고자 할 때 실제로 적용되는 알고리즘이다. 

##  알고리즘

1. 모든 간선을 길이에 대해 오름차순으로 정렬
2. 순서대로\(거리가 짧은 순서대로\) 그래프에 포함시킴
3. 포함시키기 전에 사이클 테이블을 확인
4. 사이클을 형성하는 경우 간선을 포함하지 않음

 여기서 사이클이라는 것은 그래프가 서로 연결되어 사이클을 형성하는 경우를 말한다. 최소 비용 신장 트리에서는 사이클이 발생하면 안된다. 애초에 모든 노드를 이어붙이기만 하면 되는데 사이클이 발생할 이유가 없이 때문이다. 비용순으로 정렬은 우선순위 큐를 사용하면 되고, 사이클 발생 여부는 Union - Find 알고리즘을 적용하면 된다. 사이클을 형성한다는 것은 두 정점의 그룹이 같은 경우 사이클을 형성한다는 것을 뜻한다. find를 통해 자신이 속한 그룹을 찾고, 두 정점이 다른 그룹에 속했을 경우 union을 통해 두 그룹을 합칠 수 있다.

{% embed url="https://victorydntmd.tistory.com/101" %}

### Union - Find

```java
//자신이 속한 그룹을 찾음
public static int find(int a) {
		if (parent[a] == a)
			return a;

		parent[a] = find(parent[a]);
		return parent[a];
	}

//그룹을 합
public static void union(int a, int b) {
	int parentA = find(a);
	int parentB = find(b);

	if (parentA > parentB) {
		int tmp = parentA;
		parentA = parentB;
		parentB = tmp;
	}

	parent[parentB] = parentA;
}
```

###   관련 문제

* 1197\(최소 스패닝 트리\)
* 17472\(다리 만들기 2\)
* 1922\(네트워크 연결\)
* 1647\(도시 분할 계획\)
* 2887\(행성 터널\)
* 6497\(전력난\)

