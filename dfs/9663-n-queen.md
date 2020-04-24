# 9663\(N-Queen\)

##  문제

N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

### 입력

첫째 줄에 N이 주어진다. \(1 ≤ N &lt; 15\)

### 출력

첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.

### 예제 입력 1

```text
8
```

### 예제 출력 1

```text
92
```

## CODE

```java
import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int n;
	static int answer = 0;
	static boolean board[][];
	static int dir[][] = { { -1, -1 }, { -1, 0 }, { -1, 1 } };

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		board = new boolean[n][n];

		dfs(0);

		System.out.println(answer);

		scan.close();
	}

	public static void dfs(int step) {
		if (step == n) {
			answer++;
			return;
		}

		for (int i = 0; i < n; i++) {
			int row = step;
			int col = i;

			boolean isPossible = true;
			for (int d = 0; d < 3; d++) {
				int nextRow = row;
				int nextCol = col;

				while (nextRow > -1 && nextCol > -1 && nextCol < n) {
					if (board[nextRow][nextCol]) {
						isPossible = false;
						break;
					}

					nextRow += dir[d][0];
					nextCol += dir[d][1];
				}

				if (!isPossible)
					break;
			}

			if (isPossible) {
				board[row][col] = true;
				dfs(step + 1);
				board[row][col] = false;
			}
		}
	}
}
```

