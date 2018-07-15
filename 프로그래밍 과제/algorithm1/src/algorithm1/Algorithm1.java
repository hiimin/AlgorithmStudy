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
		int [] arrM;		//�� �׷��� �ּҰ��� �����ϴ� �迭
		int I,J;
		
		N = scan.nextInt();
		M = (int)Math.sqrt((double)N);
		arrN = new int[N];
		arrM = new int[(int)Math.ceil((double)N/(double)M)];
		
		//���Ͽ� �ִ� ���ڵ� �迭�� ����
		for(int i = 0; i<N; i++) {
			arrN[i] = scan.nextInt();
		}
		scan.close();
		
		int min = arrN[0];				//�ּҰ��� �迭�� ù��° ������ ����
		for(int i = 0; i<N; i++) {
			if(arrN[i]<min)
				min = arrN[i];
			if(i%M==M-1||i==N-1) {		//�� �׷��� ������ index���� �Ǵ� ������ index���� �ּҰ��� ����
				arrM[arrM_index++]=min;
				if(i!=N-1)				//������ index������ ���� �׷��� ���� ������ ������ index�� �ƴ� ��쿡��
					min = arrN[i+1];	//�ּҰ��� ������ �ڿ��� �����׷��� ù��° ���� �ּҰ����� ����
			}
		}
		
		/*for(int i = 0;i<arrM_index;i++)
			System.out.println(arrM[i]);*/
		
		while(true) {
			Scanner input = new Scanner(System.in);
			I = input.nextInt();
			if(I==-1)	//-1���� �ԷµǸ� ����
				break;
			J = input.nextInt();
			
			int minNum;
			int IgroupIndex;
			int JgroupIndex;
			
			IgroupIndex = I/M;	//I�� �����ִ� �׷��� index
			JgroupIndex = J/M;	//J�� �����ִ� �׷��� index
			
			if(IgroupIndex==JgroupIndex||IgroupIndex+1==JgroupIndex) {	//I�� J�� ���� �׷� ���� �ְų� J�� I�� �ٷ� ���� �׷쿡 ���� ���� ���
				minNum = arrN[I];
				for(int i = I;i<=J;i++) {
					if(arrN[i]<minNum)
						minNum = arrN[i];
				}
			}
			else {
				minNum = arrN[I];
				int firstIndexOfnextGroup = (IgroupIndex+1)*M;	//I�׷� ���� �׷��� ù��° index
				int lastIndexOfpreviousGroup = JgroupIndex*M-1;	//J�׷� ���� �׷��� ������ index
				
				for(int i = I;i<firstIndexOfnextGroup;i++)		//I���� �׷� ���� ������ �ּҰ�
					if(arrN[i]<minNum)
						minNum = arrN[i];
				for(int i = IgroupIndex+1;i<JgroupIndex;i++)	//���� ���� �׷�� ������ �ּҰ�
					if(arrM[i]<minNum)
						minNum = arrM[i];
				for(int i = lastIndexOfpreviousGroup+1;i<=J;i++)//�׷� ���ĺ��� J������ �ּҰ�	
					if(arrN[i]<minNum)
						minNum = arrN[i];
			}
			System.out.println(minNum);
		}
	}

}
