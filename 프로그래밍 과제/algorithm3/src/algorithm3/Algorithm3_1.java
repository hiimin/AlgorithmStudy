package algorithm3;

import java.io.*;
import java.util.Scanner;

public class Algorithm3_1 {
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
		Scanner sc = new Scanner(new File("input1.txt"));
		T = sc.nextInt();
		
		for(int t = 0;t<T;t++) {
			N = sc.nextInt();
			maze = new int[N][N];
			
			for(int i = 0;i<N;i++)
				for(int j = 0;j<N;j++)
					maze[i][j] = sc.nextInt();
			
			K= sc.nextInt();
			
			System.out.println(findMazePath(0, 0, maze, N, K, 0));	
		}
	}
	
	public static int findMazePath(int x,int y,int maze[][],int n, int k, int count) {
		if(x==n-1&&y==n-1)
			return 1;
		if(count>k||x>=n||y>=n||x<0||y<0||maze[x][y]!=PATHWAY_COLOUR)	//길이 아닐 경우
			return 0;
		else {
			maze[x][y] = PATH_COLOUR;
			int north =  findMazePath(x-1,y,maze,n,k,count+1);
			int east = findMazePath(x,y+1,maze,n,k,count+1);
			int south = findMazePath(x+1,y,maze,n,k,count+1);
			int west = findMazePath(x,y-1,maze,n,k,count+1);
			maze[x][y] = PATHWAY_COLOUR;
			return north+east+south+west;
		}
	}
}
