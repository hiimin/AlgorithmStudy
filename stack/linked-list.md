---
description: stack을 linked list로 구현
---

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
			}else if(command.equals("top")) {
				ll.top();
			}else if(command.equals("size")) {
				ll.size();
			}else if(command.equals("pop")) {
				ll.pop();
			}else if(command.equals("empty")) {
				ll.empty();
			}else {
				System.out.println("wlong command");
			}
		}
		
	}
}

class LinkedList{
	private Node head = null;
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
		newNode.next = head;
		head = newNode;
		size++;
	}
	
	public void pop() {
		if(size==0)
			System.out.println("-1");
		else{
			System.out.println(head.data);
			size--;
			head = head.next;
		}
	}
	
	public void size() {
		System.out.println(size);
	}
	
	public void empty() {
		if(size==0)
			System.out.println(1);
		else
			System.out.println(0);
	}
	
	public void top() {
		if(size==0)
			System.out.println(-1);
		else
			System.out.println(head.data);
	}
}
```

