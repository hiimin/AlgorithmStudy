# linked list

```text
package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList();
		Scanner scan = new Scanner(System.in);
		String command;
		int N = scan.nextInt();
		
		for(int i = 0; i < N; i++) {
			command = scan.next();
			if(command.equals("push")) {
				ll.push(scan.nextInt());
			}else if(command.equals("front")) {
				System.out.println(ll.front());
			}else if(command.equals("back")) {
					System.out.println(ll.back());
			}else if(command.equals("size")) {
				System.out.println(ll.size());
			}else if(command.equals("pop")) {
				System.out.println(ll.pop());
			}else if(command.equals("empty")) {
				if(ll.is_empty())
					System.out.println(1);
				else
					System.out.println(0);
			}else {
				System.out.println("wlong command");
			}
		}
		
	}
}

class LinkedList{
	private Node head = null;
	private Node tail = null;
	private int size = 0;
	private class Node{
		private int data;
		private Node next;
		
		public Node(int input) {
			this.data = input;
			this.next = null;
		}
	}
	
	public void push(int input) {
		Node newNode = new Node(input);
		if(size==0) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;	
		}
		size++;
	}
	
	public int pop() {
		if(size==0)
			return -1;
		else{
			int pop = head.data;
			size--;
			head = head.next;
			return pop;
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean is_empty() {
		if(size==0)
			return true;
		else
			return false;
	}
	
	public int front() {
		if(size==0)
			return -1;
		else
			return head.data;
	}
	
	public int back() {
		if(size==0)
			return -1;
		else
			return tail.data;
	}
}
```

