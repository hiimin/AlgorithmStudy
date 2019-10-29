# stack

* 스택은 일종의 리스트
* 단, 데이터의 삽입과 삭제가 한쪽 끝에서만 이루어짐
* LIFO\(Last - In, First - Out\)
* 삽입/삭제가 일어나는 쪽을 스택의 top이라고 부름

### 스택이 지원하는 연산

* push : 스택에 새로운 원소를 삽입하는 연산
* pop : 스택의 top에 있는 원소를 스택에서 제거하고 반환
* peek : 스택 top의 원소를 제거하지 않고 반환
* empty : 스택이 비었는지 검사

## CODE

```java
public class MyStack<T> {
	private static class StackNode<T>{
		private T data;
		private StackNode next;
		
		public StackNode(T data) {
			this.data = data;
		}
	}
	
	private StackNode top;
	
	public <T> T pop() {
		if(top == null)
			return null;
		else {
			T pop = (T) top.data;
			top = top.next;
			
			return pop;
		}
	}
	
	public void push(T item) {
		StackNode<T> node = new StackNode<T>(item);
		node.next = top;
		top = node;
	}
	
	public <T> T peek() {
		return (T) top.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
}
```

