---
description: 채워넣기
---

# 개념정리

## java 프로그래밍

### 프로그래

**`개발자 업무 영역(코딩)`** -&gt; 컴파일러 -&gt; 기계

### JRE

자바실행환경, 운영체제로부터 자유롭게 해줌\(실행환경을 위한\)

### JDK

자개발자도구\(개발을 위한\)

### GC

Garbage Collector, 자동 메모리 관리\(사용하지 않는 메모리 반환\)

### IDE

통합개발환경, 컴파일 + 실행 + 디버깅

### javac.exe

컴파일러

### java.exe

JVM 구동명령

### 환경변수 설정

위 두 파일을 다른 디렉토리에서도 실행할 수 있도록 하기 위해 환경변수에 bin파일 등록

## 기초 문법

### 기본자료형

기본 자료형은 데이터가 변수에 직접 저장되고, 객체 자료형은 객체의 메모리 주소가 변수에 저장 된다. 객체 자료형은 주소이기 때문에 항상 4 byte.\(배열 변수도 마찬가지로 배열 데이터의 주소를 담고 있음\)

## 객체 지향 프로그래밍

### 객체

세상에 존재하는 모든 것을 뜻하며, 프로그래밍에서 속성과 기능을 가지는 프로그램 단

ex\) 사람\(속성: 키, 몸무게  기능: 의사\), 승용차\(속성: 바퀴, 엔진  기능: 이동수단\), 날씨 프로그램\(속성: 온도, 미세먼지  기능: 날씨예보\), 사칙연산 프로그램\(속성: +-\*/  기능: 연산기능\)

### 클래스

객체를 생성하기 위한 틀로 모든 객체는 클래스로부터 생성된다.

구성요소 : 속성\(멤버 변수\), 기능\(메서드\)

### 중복 메서드\(overloading\)

이름은 같고, 매개변수의 개수 또는 타입이 다른 메서드를 만들 수 있다.

### 메모리에서 객체 생성\(동적 생성\)

객체는 메모리에서 동적으로 생성되며, 객체가 더 이상 필요 없게 된다면 GC\(Garbage Collector\)에 의해서 제거된다.

### reference

생성한 객체의 주소를 변수에 저장하는 

### 소멸자\(finalize\)

객체가 GC에 의해서 메모리에서 제거 될 때 `finalize()`메서드가 호출된다.

`System.gc();`를 사용해서 반환할 객체의 `finalize()` 메서드 호출한다.`System.gc()`를 사용한다고 해서 GC가 바로 작동하는 것이 아니라, 가급적 빨리 작동하도록 요청하는 것이다. 그러나 java는 기본적으로 메모리를 직접 관리하지 않으므로 일반적으로 `System.gc()`를 사용하는 경우는 드물다.

### 패키지

자바 프로그램은 많은 클래스로 구성되고, 이러한 클래스를 폴더 형식으로 관리하는 것을 패키지라고 한다. 패키지 이름은 유일성을 위해 일반적으로 도메인을 거꾸로 이용한다.

### static

클래스의 속성과 메서드에 static 키워드를 사용하면 어디서나 속성과 메서드를 공유할 수 있다.

### private

멤버 변수\(속성\)는 주로 private으로 설정해서, 외부로부터 데이터가 변질되는 것을 막는다.\(은닉\)

### setter, getter

멤버 변수를 외부에서 변경할 수 있도록 하는 메서

## Java 상속 및 클래스

### 상속

부모 클래스를 상속받은 자식 클래스는 부모 클래스의 속성과 기능을 이할 수 있다.

###  상속의 필요성

 기존의 검증된 class를 이용해서 빠르고 쉽게 새로운 class를 만들 수 있다.

 자바에서는 단일 상속만 지원. 하나의 클래스는 하나의 클래스만 상속 받을 수 있다.

###  부모 클래스의 private 접근자

 자식 클래스는 부모 클래스의 모든 자원을 사용할 수 있지만, private 접근자의 속성과 메서드는 사용할 수 없다.

### 메서드 재정의\(override\)

 부모 클래스의 기능을 자식 클래스에서 재정의해서 사용한다.

###  Object 클래스

 모든 클래스의 최상위 클래스는 Object 클래스이다.

###  super 클래스

 상위 클래스 호출할 때 super 키워드를 사용한다.\(자기 자신은 this\)

###  내부\(inner\) 클래스

 클래스 안에 또 다른 클래스를 선언하는 것으로 이렇게 하면 두 클래스의 멤버에 쉽게 접근할 수 있다. 그다지 많이 쓰이지 않음.

###   익명\(anonymous\) 클래스

  이름이 없는 클래스로 주로 메서드를 재정의 하는 목적으로 사용된다. 인터페이스와 추상클래스에 사

![](../.gitbook/assets/image%20%281%29.png)

###  인터페이스\(interface\)

 클래스와 달리 객체를 생성할 수 없으며, 클래스에서 구현해야 하는 작업 명세서이다.  인터페이스를 사용하는 이유는 많지만, 가장 큰 이유는 객체가 다양한 자료형\(타입\)을 가질 수 있기 때문이다. 다시말해 인터페이스를 이용하여 클래스를 구현하면 다른 클래스와 대체가 유연해서 유지보수가 편해진다는 장점이 있다. 마치 규격만 맞으면 다른 부품으로 바꿀 수 있는 것처럼 쉽게 변경할 수 있기 때문이다.

![&#xC778;&#xD130;&#xD398;&#xC774;&#xC2A4;&#xB97C; &#xC0AC;&#xC6A9;&#xD55C; &#xB2E4;&#xC591;&#xD55C; &#xC790;&#xB8CC;&#xD615;](../.gitbook/assets/image%20%2869%29.png)

![&#xC778;&#xD130;&#xD398;&#xC774;&#xC2A4; &#xC0AC;&#xC6A9;](../.gitbook/assets/image%20%2828%29.png)

 인터페이스 클래스에서는 작업\(메서드\) 명세\(선언\)만 해놓고 인터페이스를 implements한 클래스에서 정의를 한다. 여기서 선언만 되어있는 메서드를 추상 메서드라고 한다.

![&#xC778;&#xD130;&#xD398;&#xC774;&#xC2A4; &#xC0AC;&#xC6A9; &#xC608;&#xC2DC;](../.gitbook/assets/image%20%2852%29.png)

 Toy 인터페이스를 implements해서 각각 Toy인터페이스의 추상 메서드를 구현하여 사용

{% tabs %}
{% tab title="Toy.java" %}
```java
public interface Toy {
    public void walk();
    public void run();
    public void alarm();
    public void light();
}
```
{% endtab %}

{% tab title="ToyRobot" %}
```java
public class ToyRobot implements Toy {
  public void walk() {
		System.out.println("robot walk");
	}
	
	public void run() {
		System.out.println("robot run");
	}
	
	public void alarm() {
		System.out.println("robot alarm");
	}
	
	public void light() {
		System.out.println("robot light");
	}
}
```
{% endtab %}

{% tab title="ToyAirplane" %}
```java
public class ToyAirplane implements Toy {
  public void walk() {
		System.out.println("ToyAirplane walk");
	}
	
	public void run() {
		System.out.println("ToyAirplane run");
	}
	
	public void alarm() {
		System.out.println("ToyAirplane alarm");
	}
	
	public void light() {
		System.out.println("ToyAirplane light");
	}
}
```
{% endtab %}
{% endtabs %}

{% embed url="https://xxxelppa.tistory.com/77" %}

###  추상\(abstract\)클래스

 클래스의 공통된 부분을 뽑아서 별도의 클래스\(추상클래스\)로 만들어 놓고, 이것을 상속해서 사용한다.

*  멤버변수를 가진다.
*  abstract 클래스를 상속하기 위해서는 extends를 이용한다.
*  abstract 메서드를 가지며, 상속한 클래스에서 반드 구현해야 한다.
*  일반 메서드도 가질 수 있다.
*  일반 클래스와 마찬가지로 생성자도 있다.

![](../.gitbook/assets/image%20%289%29.png)

![&#xC778;&#xD130;&#xD398;&#xC774;&#xC2A4; vs &#xCD94;&#xC0C1;&#xD074;&#xB798;&#xC2A4;](../.gitbook/assets/image%20%2865%29.png)

###  람다식

 익명함수\(anonymous function\)를 이용해서 익명 객체를 생성하기 위한 식이다. 람다식을 이용해서 기존의 객체 지향이 아닌 함수 지향 프로그래밍이 가능하다.

*  람다식을 사용하기 위해서는 구현할 인터페이스가 필요하다.
* 인터페이스는 한개의 추상메서드만 가지고 있어야한다.
* 이런 인터페이스를 함수적 인터페이스\(functional Interface\)라고 부른다.\(즉, 함수구현전용 인터페이스\)

![&#xB78C;&#xB2E4;&#xC2DD; &#xAD6C;&#xD604;](../.gitbook/assets/image%20%2899%29.png)

###  문자열 클래스

 문자열을 다루는 String객체는 데이터가 변화하면 메모리상의 변화가 많아 속도가 느리다.

![](../.gitbook/assets/image%20%2844%29.png)

###  StringBuffer, StringBuilder

![](../.gitbook/assets/image%20%2864%29.png)

###  List

 List는 인터페이스로 이를 구현한 클래스는 인덱스를 이용해서 데이터를 관리한다.

![](../.gitbook/assets/image%20%2816%29.png)

###  Map

![](../.gitbook/assets/image%20%28101%29.png)

## 예외처리

###  예외

 프로그램에 문제가 있는 것을 말하며, 예외로 인해 시스 동작이 멈추는 것을 막는 것을 '예외처리'라고 한다.

* Exception : 개발자가 대처할 수 있음
* Error : 개발자가 대처할 수 없음
* Checked Exception : 예외처리를 반드시 해야하는 경우\(네트워크, 파일 시스템 등\)
* Unchecked Exception : 예외처리를 개발자의 판단에 맞기는 경우\(데이터 오류 등\)

###  Exception 클래스

 Exception 클래스 하위 클래스로 NullPointerException, NumberFormatException 등이 있다.

* NullPointerException : 객체를 가리키지 않고 있는 레퍼런스를 이용할 때
* ArrayIndexOutOfBoundException : 배열에서 존재하지 않는 인덱스를 가리킬 때
* NumberFormatException : 숫자 데이터에 문자 데이터 등을 넣었을 

###  try ~ catch

 개발자가 예외처리하기가 가장 쉽고, 많이 사용되는 방법

![](../.gitbook/assets/image%20%2857%29.png)

![](../.gitbook/assets/image%20%2879%29.png)

###  finally

 예외 발생 여부와 상관없이 반드시 실행된다.

![](../.gitbook/assets/image%20%2897%29.png)

###  throws

 예외 발생 시 예외 처리를 직접 하지 않고 호출한 곳으로 넘긴다.

![](../.gitbook/assets/image%20%2839%29.png)

##  입력과 출력

###  입/출력

 다른 곳의 데이터를 가져오는 것을 입력이라 하고, 다른 곳으로 데이터를 내보내는 것을 출력이라고 한다.

![](../.gitbook/assets/image%20%2823%29.png)

###  입/출력 기본 클래스

![](../.gitbook/assets/image%20%28107%29.png)

###  FileInputStream / FileOutputStream

![](../.gitbook/assets/image%20%2825%29.png)

{% tabs %}
{% tab title="FileInputStream" %}
```java
InputStream inputStream = null;
		try {
			inputStream = new FileInputStream("C:\\java\\ex\\ex.txt");
			int data = 0;

			while (true) {
				try {
					data = inputStream.read();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}

				if (data == -1)
					break;
				System.out.println(data);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
```
{% endtab %}

{% tab title="FileOutputStream" %}
```java
		OutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream("C:\\java\\ex\\ex.txt");
			String data = "this is test";
			byte[] arr = data.getBytes();

			try {
				outputStream.write(arr);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (outputStream != null)
					outputStream.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
```
{% endtab %}
{% endtabs %}

### DataInputStream, DataOuputStream

![](../.gitbook/assets/image%20%2843%29.png)

{% tabs %}
{% tab title="DataOutputStream" %}
```java
OutputStream outputStream = null;
DataOutputStream = dataOuputStream = null;
		try {
			outputStream = new FileOutputStream("C:\\java\\ex\\ex.txt");
			dataOutputStream = new DataOutputStream(outputStream);
			String data = "this is test";
			dataOutputStream.writeUTF(data);

			try {
				outputStream.write(arr);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (outputStream != null)
					outputStream.close();
				if (dataOutputStream != null)
					dataOutputStream.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
```
{% endtab %}

{% tab title="DataInputStream" %}
```java
InputStream inputStream = null;
DataInputStream dataInputStream = null;
		try {
			inputStream = new FileInputStream("C:\\java\\ex\\ex.txt");
			dataInputStream = new DataInputStream(inputStream);
			String str = dataInputStream.readUTF();
			System.out.println(str);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
				if (dataInputStream != null)
					dataInputStream.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
```
{% endtab %}
{% endtabs %}

## 네트워킹

###  네트워크 데이터 입력 및 출력

 네트워크 대상\(객체\) 사이에 입/출력\(InputStream, OutputStream\)를 이용해서 데이터를 입력하고 출력한다.

![](../.gitbook/assets/image%20%2847%29.png)

###  소켓\(Socket\)

 네트워크에서 데이터를 주고받기 위한 장치 \(전화기, 출입구와 같음\)

![](../.gitbook/assets/image%20%2892%29.png)

 서버는 클라이언트를 맞을 준비를 하고 있다가 클라이언트의 요청에 반응한다.

![](../.gitbook/assets/image%20%2880%29.png)

![](../.gitbook/assets/image%20%2883%29.png)

###  양방향 통신

![](../.gitbook/assets/image%20%2835%29.png)

