---
description: 백준 2579
---

# 계단오르기

### 문제

계단 오르기 게임은 계단 아래 시작점부터 계단 꼭대기에 위치한 도착점까지 가는 게임이다. &lt;그림 1&gt;과 같이 각각의 계단에는 일정한 점수가 쓰여 있는데 계단을 밟으면 그 계단에 쓰여 있는 점수를 얻게 된다.

![](https://www.acmicpc.net/upload/images/k64or2GOK1vmpEig7Ud.png)

예를 들어 &lt;그림 2&gt;와 같이 시작점에서부터 첫 번째, 두 번째, 네 번째, 여섯 번째, 계단을 밟아 도착점에 도달하면 총 점수는 10 + 20 + 25 + 20 = 75점이 된다.

![](https://www.acmicpc.net/upload/images/f62omMF2kQYD5rDct.png)

계단 오르는 데는 다음과 같은 규칙이 있다.

1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
2. 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
3. 마지막 도착 계단은 반드시 밟아야 한다.

따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다. 하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.

각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.

### solution

n-1번째 계단을 밟을 경우와 밟지 않을 경우의 값을 비교하여 더 큰값을 구하면 됨

n-1번째 계단을 밟을 경우 최대값은 n-2를 밟으면 안되기 때문에 n-3번째 까지의 최대값 + n-1번째 계단의 점수이다.

n-1 번째 계단을 밟지 않을 경우 최대값은 n-2번째 까지의 최대값이다.

따라서 max\[n-3\] + step\[n-1\]과 max\[n-2\]를 비교

### code

```java
import java.util.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		int step[] = new int[n];
		int max[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			step[i] = scan.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			// 첫번째, 두번째, 세번째 계단까지의 최대점수
			if(i==0)
				max[i] = step[i];
			else if(i==1)
				max[i] = step[i-1] + step[i];
			else if(i==2) {
				if(step[0]>step[1])
					max[i] = step[0] + step[i];
				else
					max[i] = step[1] + step[i];
			}
			//네번째 계단부터의 최대점수
			else {
				if(max[i-2] > max[i-3] + step[i-1])
					max[i] = max[i-2] + step[i];
				else
					max[i] = max[i-3] + step[i-1] + step[i];
			}
		}
		
		System.out.println(max[n-1]);
	}
}
```

