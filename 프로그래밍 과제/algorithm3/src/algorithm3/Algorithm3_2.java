package algorithm3;

import java.io.File;
import java.util.Scanner;

public class Algorithm3_2 {
	public static final int PATHWAY_COLOUR = 0;
	public static final int WALL_COLOUR = 1;
	public static final int BLOCKED_COLOUR = 2;
	public static final int PATH_COLOUR = 3;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int T;
		int N;
		int K;
		int maze[][];
		Scanner sc = new Scanner(new File("input2.txt"));
		T = sc.nextInt();
		
		for(int t = 0;t<T;t++) {
			N = sc.nextInt();
			maze = new int[N][N];
			
			for(int i = 0;i<N;i++)
				for(int j = 0;j<N;j++)
					maze[i][j] = sc.nextInt();
			
			if(findMazePath(0, 0, maze, N))
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}
	
	public static boolean findMazePath(int x,int y,int maze[][],int n) {
		if(x==n-1&&y==n-1)
			return true;
		if(x>=n||y>=n||x<0||y<0||maze[x][y]!=PATHWAY_COLOUR)	//길이 아닐 경우
			return false;
		else {
			maze[x][y] = PATH_COLOUR;
			if(findMazePath(goStraightUp(x, y, maze, n),y,maze,n)||
			findMazePath(x,goStraightRight(x, y, maze, n),maze,n)||
			findMazePath(goStraightDown(x, y, maze, n),y,maze,n)||
			findMazePath(x,goStraightLeft(x, y, maze, n),maze,n))
				return true;
		}
		maze[x][y] = BLOCKED_COLOUR;
		return false;
	}
	
	public static int goStraightLeft(int x, int y, int maze[][], int n) {
		while(true) {
			y--;
			if(y<0||maze[x][y]==WALL_COLOUR)
				break;
		}
		y++;
		return y;
	}
	public static int goStraightRight(int x, int y, int maze[][], int n) {
		while(true) {
			y++;
			if(y>n-1||maze[x][y]==WALL_COLOUR)
				break;
		}
		y--;
		return y;
	}
	public static int goStraightUp(int x, int y, int maze[][], int n) {
		while(true) {
			x--;
			if(x<0||maze[x][y]==WALL_COLOUR)
				break;
		}
		x++;
		return x;
	}
	public static int goStraightDown(int x, int y, int maze[][], int n) {
		while(true) {
			x++;
			if(x>n-1||maze[x][y]==WALL_COLOUR)
				break;
		}
		x--;
		return x;
	}
	/*public static int goStraightLeft(int x, int y, int maze[][], int n) {
		do {
			y--;
		}while(y>0&&maze[x][y]!=WALL_COLOUR);
		y++;
		return y;
	}
	public static int goStraightRight(int x, int y, int maze[][], int n) {
		do {
			y++;
		}while(y<n&&maze[x][y]!=WALL_COLOUR);
		y--;
		return y;
	}
	public static int goStraightUp(int x, int y, int maze[][], int n) {
		do {
			x--;
		}while(x>0&&maze[x][y]!=WALL_COLOUR);
		x++;
		return x;
	}
	public static int goStraightDown(int x, int y, int maze[][], int n) {
		do {
			x++;
		}while(x<n&&maze[x][y]!=WALL_COLOUR);
		x--;
		return x;
	}*/
}
