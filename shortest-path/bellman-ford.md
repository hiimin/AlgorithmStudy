# Bellman-Ford

 다익스트라 알고리즘은 한 시작점에서 다른 모든 정점까지의 최단 거리를 구하는 알고리즘 중 가장 유용한 알고리즘이지만, 음수 간선이 있는 그래프의 경우에는 적용할 수 없습니다. 벨만-포드 알고리즘은 음수 간선이 있는 그래프에 대해서도 최단 경로를 찾을 수 있으며 그래프에 음수 사이클이 있어서 최단 거리가 제대로 정의되지 않을 경우 이것도 알려줍니다. 

 벨만-포드 알고리즘은 시작점에서 각 정점까지 가는 최단 거리의 상한을 적당히 예측한 뒤 예측 값과 실제 최단 거리 사이의 오차를 반복적으로 줄여가는 방식으로 동작합니다. 이것은 너비 우선 탐색을 기반으로 해서 한 번에 하나씩 한 정점의 최단 거리를 확정해 가는 다익스트라 알고리즘과는 많이 다릅니다. 벨만-포드 알고리즘은 수행 과정에서 각 정점까지의 최단 거리의 상한을 담은 배열 upper\[\]를 유지합니다. 이 값은 알고리즘이 진행됨에 따라 점점 줄어들고, 알고리즘이 종료할 때는 실제 최단 거리를 담게 됩니다.

 벨만-포드 알고리즘은 relax\(완화\) 작업을 기본으로 하는데 relax란 예를들어 현재 노드 v까지의 최단 경로가 50일 경우, \(u, v\)의 가중치가 30이고 u까지의 최단경로가 10일 경우 v까지의 최단 경로를 40으로 감소하는 작업을 말합니다. 

 relax를 x번 반복하면 x개 이하의 간선을 사용하는 최단 경로들을 전부 찾을 수 있습니다. 음수 사이클이 없는 그래프에서 최단 경로는 최대 \|V\|개의 정점을 갖기 때문에 최대 \|V\|-1개의 간선을 가질 수 있습니다. 따라서 모든 간선에 대한 relax과정은 전체 \|V\|-1번이면 충분합니다.

 음수 사이클의 존재 여부를 판정하려면 \|V\|-1번 모든 간선에 대한 relax를 시도하고 한번더 relax를 시도하면 됩니다. 그래프에 음수 사이클이 없다면 \|V\|-1 번만의 반복으로 모든 최단 거리를 찾아내기 때문에, 마지막 반복의 relax는 전부 실패하게 됩니다. 반면 음수 사이클이 있다면 마지막 시도에서 relax가 한 번은 성공하게 된다는 점을 증명할 수 있습니다.

## 구현\(백준 11657 - 타임머신\)

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	static int Answer;
	static int N;	//도시 개수
	static int M;	//버스 노선 개수
	static int upper[];	//1번 도시에서 출발해서 N번 도시로 가는 가장 빠른 시간
	static int isInfinite[];	//0이면 무한대	1이면 무한대 아님
	//static LinkedList<Integer> W = new LinkedList<>();
	static int W[][];

	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		upper = new int[N+1]; //0 ~ N
		isInfinite = new int[N+1];	//0 ~ N
		W = new int[M][3];
		
		upper[1] = 0;
		isInfinite[1] = 1;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int column = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			W[i][0] = row;
			W[i][1] = column;
			W[i][2] = weight;
		}
		
		/*for(int i = 0; i < W.size(); i++) {
			System.out.println(W.get(i));
		}*/
		
		boolean updated = false;
		
		//relax
		for(int i = 0; i < N; i++) {	//|V|-1번 반복 대신 |V|번 반복
			updated = false;			//relax가 한번이라도 성공할 경우 true
			
			for(int j = 0; j < M; j++) {//모든 간선에 대해
				int start = W[j][0];
				int end = W[j][1];
				int w = W[j][2];
				
				//System.out.println(start);
				if(isInfinite[start] != 0)
					if(isInfinite[end] == 0 || upper[start] + w < upper[end]) {
						isInfinite[end] = 1;
						upper[end] = upper[start] + w;
						updated = true;
					}
			}
		}
		
		//마지막 relax후 updated값이 true이면 relax가 적어도 한 번은 성공했다는 것
		//이라는 뜻이고 이는 음수사이클이 존재한다는 것
		if(updated) {
			bw.write("-1");
			bw.write("\n");
			//System.out.println(-1);
		}else {
			for(int i = 2; i <= N; i++) {
				if(isInfinite[i] == 0) {
					bw.write("-1");
					bw.write("\n");
					//System.out.println(-1);	
				}
				else {
					bw.write(String.valueOf(upper[i]));
					bw.write("\n");
					//System.out.println(upper[i]);
				}
			}
		}
		bw.flush();
		bw.close();
		//System.out.println(Answer);
	}
}
```

## 시간복잡

벨만-포드 알고리즘은 51-67줄입니다. 가장 바깥에 있는 for문은 \|V\|번 수행되고, 안의 for문은 모든 간선을 순회하므로 O\(\|E\|\)번 수행됩니다. 따라서 벨만-포드 알고리즘의 전체 시간복잡도는 O\(\|V\|\|E\|\)입니다.

## Reference

{% embed url="https://ratsgo.github.io/data%20structure&algorithm/2017/11/27/bellmanford/" %}

{% embed url="https://www.youtube.com/watch?v=QH-Btq8SgLQ&list=PL52K\_8WQO5oUuH06MLOrah4h05TZ4n38l&index=38" %}



