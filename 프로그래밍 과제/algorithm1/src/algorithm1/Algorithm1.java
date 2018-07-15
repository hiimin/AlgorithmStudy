package algorism1;

import java.io.*;
import java.util.Scanner;

public class Algorithm1 {
	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(new File("./data.txt"));
		
		int N;
		int M;
		int arrM_index = 0;
		int [] arrN;
		int [] arrM;		//각 그룹의 최소값을 저장하는 배열
		int I,J;
		
		N = scan.nextInt();
		M = (int)Math.sqrt((double)N);
		arrN = new int[N];
		arrM = new int[(int)Math.ceil((double)N/(double)M)];
		
		//파일에 있는 숫자들 배열에 저장
		for(int i = 0; i<N; i++) {
			arrN[i] = scan.nextInt();
		}
		scan.close();
		
		int min = arrN[0];				//최소값을 배열의 첫번째 값으로 지정
		for(int i = 0; i<N; i++) {
			if(arrN[i]<min)
				min = arrN[i];
			if(i%M==M-1||i==N-1) {		//각 그룹의 마지막 index에서 또는 마지막 index에서 최소값을 저장
				arrM[arrM_index++]=min;
				if(i!=N-1)				//마지막 index에서는 다음 그룹이 없기 때문에 마지막 index가 아닐 경우에만
					min = arrN[i+1];	//최소값을 저장한 뒤에는 다음그룹의 첫번째 값을 최소값으로 지정
			}
		}
		
		/*for(int i = 0;i<arrM_index;i++)
			System.out.println(arrM[i]);*/
		
		while(true) {
			Scanner input = new Scanner(System.in);
			I = input.nextInt();
			if(I==-1)	//-1값이 입력되면 종료
				break;
			J = input.nextInt();
			
			int minNum;
			int IgroupIndex;
			int JgroupIndex;
			
			IgroupIndex = I/M;	//I가 속해있는 그룹의 index
			JgroupIndex = J/M;	//J가 속해있는 그룹의 index
			
			if(IgroupIndex==JgroupIndex||IgroupIndex+1==JgroupIndex) {	//I와 J가 같은 그룹 내에 있거나 J가 I의 바로 다음 그룹에 속해 있을 경우
				minNum = arrN[I];
				for(int i = I;i<=J;i++) {
					if(arrN[i]<minNum)
						minNum = arrN[i];
				}
			}
			else {
				minNum = arrN[I];
				int firstIndexOfnextGroup = (IgroupIndex+1)*M;	//I그룹 다음 그룹의 첫번째 index
				int lastIndexOfpreviousGroup = JgroupIndex*M-1;	//J그룹 이전 그룹의 마지막 index
				
				for(int i = I;i<firstIndexOfnextGroup;i++)		//I부터 그룹 직전 까지의 최소값
					if(arrN[i]<minNum)
						minNum = arrN[i];
				for(int i = IgroupIndex+1;i<JgroupIndex;i++)	//구간 내의 그룹들 까지의 최소값
					if(arrM[i]<minNum)
						minNum = arrM[i];
				for(int i = lastIndexOfpreviousGroup+1;i<=J;i++)//그룹 직후부터 J까지의 최소값	
					if(arrN[i]<minNum)
						minNum = arrN[i];
			}
			System.out.println(minNum);
		}
	}

}
