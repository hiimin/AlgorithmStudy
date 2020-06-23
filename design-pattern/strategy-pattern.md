# Strategy pattern

## strategy pattern

 알고리즘군\(행동\)을 정의하고 각각을 캡슐화하여 교환해서 사용할 수 있도록 만든다. 스트래티지패턴을 활용하면 알고리즘을 사용하는 클라이언트와는 독립적으로 알고리즘을 변경할 수 있다.

*  행위를 클래스로캡슐화해 동적으로 행위를 자유롭게 바꿀 수 있게 해주는 패턴
  *  같은 문제를 해결하는 여러 알고리즘이 클래스별로 캡슐화되어 있고 이들이 필요할 때 교체할 수 있도록 함으로써 동일한 문제를 다른 알고리즘으로 해결할 수 있게 하는 디자인 패턴
  *  '행위\(Behavioral\) 패턴'의 하나
* 즉, 전략을 쉽게 바꿀 수 있도록 해주는 디자인 패턴이다.
  * 전약이란 ? 어떤 목적을 달성하기 위해 일을 수행하는 방식, 비즈니스 규칙, 문제를 해결하는 알고리즘 등
* 특히 게임 프로그래밍에서 게임 캐릭터가 자신이 처한 상황에 따라 공격이나 행동하는 방식을 바꾸고 싶을 때 스트래티지 패터은 매우 유용하다.

![](../.gitbook/assets/image%20%28140%29.png)

*  역할이 수행하는 작업
  * Strategy
    * 인터페이스나 추상 클래스로 외부에서 동일한 방식으로 알고리즘을 호출하는 방법을 명시
  * ConcreteStrategy
    *  스트래티지 패턴에서 명시한 알고리즘을 실제로 구현한 클래스
  * Context
    * 스트래티지 패턴을 이용하는 역할을 수행한다.
    * 필요에 따라 동적으로 구체적인 전략을 바꿀 수 있도록 setter 메서드\('집약 관계'\)를 제공한다.

```java
interface FlyBehavior{
    fly();
}

class FlyWithWings implements FlyBehavior{
    fly(){
        System.out.println("fly");
    }
}

class FlyNoWay implements FlyBehavior{
    fly(){
        System.out.println("walk");
    }
}

class Duck{
    FlyBehavior flyBehavior;
    public void  setFlyBehavior(FlyBehavior flyBehavior){
        this.flyBehavior = flyBehavior;
    }
    
    public void flyAction(){
        flyBehavior.fly();
    }
}
```

*  무엇이 변화되었는지를 찾음\(위 예에서는 나는 행위\)
*  변화되는 행위를 클래스로 캡슐
  * 나는행위를 위한 인터페이스를 만들고 이들을 실제 실현한 클래스를 만든
* setter를 만들어 행위가 상황에 따라 변할수 있게

