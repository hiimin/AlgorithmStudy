---
description: '여러가지 일 들에 순서가 정해져 있을 때, 순서에 맞게 나열하는 것'
---

# topological sort

### 위상정렬\(topological sorthing\)

**위상 정렬**\(topological sorting\)은 유향 그래프의 꼭짓점들\(vertex\)을 변의 방향을 거스르지 않도록 나열하는 것을 의미한다. 위상정렬을 가장 잘 설명해 줄 수 있는 예로 대학의 선수과목\(prerequisite\) 구조를 예로 들 수 있다. 만약 특정 수강과목에 선수과목이 있다면 그 선수 과목부터 수강해야 하므로, 특정 과목들을 수강해야 할 때 위상 정렬을 통해 올바른 수강 순서를 찾아낼 수 있다. 이와 같이 선후 관계가 정의된 그래프 구조 상에서 선후 관계에 따라 정렬하기 위해 위상 정렬을 이용할 수 있다. 정렬의 순서는 유향 그래프의 구조에 따라 여러 개의 종류가 나올 수 있다. 위상 정렬이 성립하기 위해서는 반드시 그래프의 순환이 존재하지 않아야 한다. 즉, 그래프가 **비순환 유향 그래프\(directed acyclic graph\)**여야 한다.

일반적인 위상 정렬의 적용은 주로 업무의 일정을 일어나야 할 순서에 따라 배치하기 위하는 것으로, 이 알고리즘은 프로젝트 관리 기법을 평가 및 분석하기 위한 기법\(PERT\)에 적용하기 위한 목적을 위해 1960년대 초반부터 연구되었다 \(Jarnagin 1960\). 이 때, 해당 업무는 [꼭짓점](https://ko.wikipedia.org/wiki/%EA%BC%AD%EC%A7%93%EC%A0%90)으로 표현되었고, 각 꼭짓점을 연결하는 변은 해당 업무 간의 선후 관계를 표현하였다. 가령, 옷을 다리기 위한 업무는 반드시 옷을 세탁기에 돌리는 업무 뒤에 배치되어야 한다. 이와 같이, 위상정렬은 각 업무를 수행하기 위한 순서를 제공하였다.

### 위상정렬의 수행과정

1. 자기 자신을 가리키는 변이 없는 꼭짓점을 찾음.
2. 찾은 꼭짓점을 출력하고 출력한 꼭짓점과 그 꼭짓점에서 출발하는 변을 삭제
3. 아직 그래프에 꼭짓점이 남아있으면 단계 1로 돌아가고, 아니면 알고리즘을 종료시킨다.

자세히..

1. 자신을 가리키고 있지 않는 정점\(해당 일을 하기 전에 반드시 해야할 일이 없는 일\)을 전부 찾아서 큐에 넣는다.
2. 자신을 가리키고 있지 않는 정점은 곧 정해진 순서의 여러 가지에서 각각 맨 처음에 이루어 지게 된단 뜻이므로 첫 순서를 가진다. 해당 일을 한다.\(정점을 결과 리스트에 넣는다.\)
3. 이미 실행한 일\(정점\)은 실행했으므로 그래프에서 삭제하고, 다음 해야할 일\(가리키고 있는 정점\)에게 앞의 일이 끝났음을 알린다.\(다음 정점이 받고 있는 간선을 하나 지운다.\) 이 때, 자신을 가리키는 정점\(해당 일을 하기 전에 해야하는 일\)이 하나도 없다면 다음 이어서 해야할 일이 되므로 큐에 넣어준다.
4. 큐에 정점이 없을때까지 1-3을 반복한다.

### 

### CODE\(백준 1005 - ACM Caft \)

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		//테스트 케이스 T만큼 반복
		for(int i = 0; i < T; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());	//건물 개수
			int K = Integer.parseInt(st.nextToken());	//건설순서규칙 개수
			int W;
			
			int D[] = new int[N+1];	//건물당 걸리는 시간
			
			ArrayList<Integer>[] nodeArray = new ArrayList[N+1];	//각 정점이 향하고 있는 정점들을 가진 리스트(0번지는 사용 안함)
			int targetedNodeCount[] = new int[N+1];	//자기 자신을 가리키고 있는 정점의 개수
			LinkedList<Integer> que = new LinkedList<Integer>();
			int result[] = new int[N+1];	//최종 걸설 시간
			
			st = new StringTokenizer(br.readLine());
			
			for(int j = 1; j <= N; j++) {
				nodeArray[j] = new ArrayList<Integer>();
			}
			
			//건물당 걸리는 시간 입력
			for(int j = 1; j <= N; j++) {
				D[j] = Integer.parseInt(st.nextToken());
			}
			
			//건설순서규칙 입력
			for(int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				nodeArray[a].add(b);
				targetedNodeCount[b]++;
			}
			
			W = Integer.parseInt(br.readLine());
			
			for(int j = 1; j <= N; j++) {
				if(targetedNodeCount[j]==0) {	//자기자신을 가리키는 정점이 없는 정점만 큐에 넣는다.(head)
					que.add(j);
					result[j] = D[j];
				}
			}
			
			while(!que.isEmpty()) {	//큐가 빌때까지 반복
				int currentNode = que.poll();
				
				for(int k = 0; k < nodeArray[currentNode].size(); k++) {
					int getArrowNode = nodeArray[currentNode].get(k);
					targetedNodeCount[getArrowNode]--;
					
					if(result[getArrowNode] < result[currentNode] + D[getArrowNode]) {
						result[getArrowNode] = result[currentNode] + D[getArrowNode];
					}
					
					if(targetedNodeCount[getArrowNode] == 0) {
						que.add(getArrowNode);
					}
				}
			}
			
			bw.write(String.valueOf(result[W])+"\n");
			bw.flush();
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

```

### 위상정렬 알고리즘 시간복잡도

1. 최초에 targetedNodeCount 이 0인 정점\(처음 시작해야 하는 정점\)을 찾는데 V
2. targetedNodeCount를 빼주기 위해 현재 정점이 가리키는 간선을 다 탐색하는데 E
3. 이를 각 정점마다 해주므로 V

총 2V + E번 반복하게 되어 **O\(V+E\)**의 시간복잡도를 가짐

