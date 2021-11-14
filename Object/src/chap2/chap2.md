
[결론]
1) 영화 예매 시스템이라는 예제를 통해 객체지향 설계방법을 알아본다.
2) 객체 지향 프로그래밍을 하기 위해서는 어떤 객체가 필요한지를 먼저 생각하고, 객체간의 협력관계를 설정하는 것이 중요하다.
3) 객체는 자율적인 객체(캡슐화를 통해)를 생성하는 것이 바람직하며, 협력관계는 메세지 전달을 통해서 이루어진다. 그리고 좋은 협력을 하기 위
해서는 메세지와 메서드의 구분이 필요하며 이는 다형성의 개념으로 부터 출발된다.
4) 컴파일 시점에서의 의존성과 런타임시의 의존성은 달라질 수 있다. 이는 상속과 다형성을 통해 이루어질 수 있다. 이런 구조는 설계가 유연해 질 수 있다. 
5) 추상화는 설계에 대한 유연성을 증가시킨다. 상속 보다는 합성이 더 유연한 구조를 갖게 한다.

## 01. 영화 예매 시스템

- 할인액을 결정하는 두가지 규칙이 존재한다
    - 할인조건(discount condition) : 순서조건, 기간조건
    - 할인정책(discount policy) : 금액 할인 정책, 비율 할인 정책

1. 사용자의 예매가 할인조건 중 하나라도 만족하는지 검사
2. 할인 조건을 만족할 경우, 할인 정책을 이용해 할인 요금을 계산

## 02. 객체지향 프로그래밍을 향해

### 협력, 객체, 클래스

- 객체지향은 객체를 지향하는 것이다.
- 첫째, 어떤 클래스가 필요한지를 고민하기 전에 어떤 객체들이 필요한지를 고민해라
- 둘쨰, 객체를 독집적인 존재가 아니라, 기능을 구현하기 위해 협력하는 공동체의 일원으로 봐야한다.

### 도메인의 구조를 따르는 프로그램 구조

- 도메인이란?
    - 문제를 해결하기 위해 사용자가 프로그램을 사용하는 분야를 도메인 이라고 부른다.

- 일반적으로, 클래스의 이름은 대응되는 도메인 개념과 동일하게 적어도 유사하게 만들어서, 프로그램의 구조를 이해하고 예상하기 쉽게 만들어야 한다.

- [ ]  만들고자 하는 클래스들 정보
- Movie : 영화
- Screening : 상영
- DiscountPolicy : 할인정책
- AmountDiscountPolicy : 금액할인정책
- PercentDiscountPolicy : 비율 할인 정책
- SequenceCondition : 순번조건
- PeriodCondition : 기간조건
- Reservation : 예약

### 클래스 구현하기

```java
package chap2;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public LocalDateTime getStartTime() {
        return whenScreened;
    }

    public boolean isSequence(int sequence){
        return this.sequence == sequence;
    }

    public Money getMovieFee(){
        return movie.getFee();
    }

}
```

- 여기서 주목해야 할것은 인스턴스의 변수는 private, 인스턴스의 메서드는 public 이라는 것이다.
- 캡슐화란, 훌륭한 클래스를 설계하기 위한 핵심은 외부에 공개하고 어떤 부분을 감출지를 결정하는 것이다.
- 그렇다면, 클래스의 내부와 외부를 구분해야 하는 이유는 무엇인가?
    - 경계의 명확성이 객체의 자율성을 보장하기 떄문이다.

자율적인 객체

- 객체가 상태(state)와 행동(behavior)을 함께 가지는 복합적인 존재라는 것이다.
- 객체가 스스로 판단하고 행동하는 자율적인 존재라는 것이다.

- 캡슐화
    - 데이터와 기능을 객체 내부로 함께 묶는 것을 말함.
- 대부분 객체지향 프로그래밍 언어들은 상태와 행동을 캡슐화 하는 것에 한걸음 더 나아가 외부에서의 접근을 통제할 수 있는 `접근제어` 메커니즘, `접근수정`도 함께 제공함.

- 캡슐화와 접근제어는 객체를 두부분으로 나눈다.
    - 외부에서 접근 가능한 부분으로 이를 퍼블릭 인터페이스 라고 부른다
    - 오직 내부에서만 접근 가능한 부분으로 이를 `구현`(implementation) 이라고 부른다.

- 결론 : 객체의 상태를 숨기고 행동만 외부에 공개해야한다.

프로그래머의 자유

- 설계가 필요한 이유는 변경을 관리하기 위해서라는 것을 기억하라
- 객체지향 언어는 객체 사이의 의존성을 적절히 관리함으로써 , 변경에 대한 파급효과를 제어할 수 있는 다양한 방법을 제공한다

### 협력하는 객체들의 공동체

- 1장에서는 금액을 구현하기 위해 Long 타입을 사용했다.
    - 이는 변수의 크기 및 관련된 구현 관점의 제약을 표현할 수 있는 있지만, 금액관 관련된 의미를 전달할 수는 없다.
    - 또한 , 서로 다른 곳에 중복되어 있는 것을 막을 수 없다.
- 하나의 인스턴스 변수만 포함하더라도, 개념을 명시적으로 표현하는것은 설계의 명확성과 유연성을 높일 수 있다.

- 어떤 시스템의 기능을 구현하기 위해 객체 사이에 이뤄지는 상호작용은 `Collaboration` 이라고 부른다.

### 협력에 관한 짧은 이야기

- 객체의 내부상태는 외부에서 접근하지 못하도록 감춰야 하며, 대신에 외부에서는 퍼블릭 인터페이스를 통해 내부 상태에 접근할 수 있도록 허용한다

- 객체가 다른 객체와 상호작용할 수 있는 유일한 방법은 메세지 전송(send a message)이다.
- 객체가 다른 객체로 부터 받은 메세지를 처리하기 위한 자신의 방법을 `메서드(method)` 라고 한다.

- 메세지와 메서드를 구분에서 부터 다형성(polymorphism)의 개념이 출반한다.

## 03. 할인금액 구하기

### 할인 요금 게산을 위한 협력 시작하기

```java
package chap2;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}

```

- 이 메서드 안에는 한가지 이상한 점이 있다.
    - 어떤 할인정책을 사용할 것인지 결정하는 코드가 존재하지 않는다는 것이다.
- 이 코드가 어색하다면, 여러분은 객체지향 패러다임에 익숙하지 않은 것이라고 봐도 무방하다.
    - 이 코드안에는 객체지향에서 중요하다고 생각하는 두가지 개념이 숨겨져 있다.
    - 상속 과 다형성이다. 그리고 그 기반에는 추상화라는 원리가 숨겨져 있다.

### 할인 정책과 할인 조건

- 할인 정책은 금액 할인 정책과 비율 할인 정책으로 구분된다

- 할인 조건을 만족하는 DiscountCondition이 하나라도 존재하는 경우에는 추상메소드인 getDiscountAmount 메서드에게 위임한다.
- 이처럼 중간에 필요한 처리를 자식 클래스에게 위임하는 디자인 패턴을 TEMPLATE METHOD 패턴이라고 부른다.

cf) overriding & overloading

- overriding : 부모 클래스에 정의된 같은 이름, 같은 파라미터 목록을 가진 메서드를 자식클래스에서 재정의 하는 경우를 의미
- overloading : 메서드 이름은 같지만 제공되는 파라미터의 목록이 다르다

    ```java
    public class Money {
    
    	public Money plus(Money amount) {
    		return new Money(this.amount.add(amount.amount))	
    
    	}
    
    	public Money plus(long amount){
    		return new Money(this.amount.add(BigDemical.valueOf(amount)))
    	}
    }
    ```


### 할인 정책 구성하기

- 하나의 영화에 하나의 할인정책 제약조건
- 할인조건은 여러개 생성가능

## 04. 상속과 다형성

- Movie 내부에 할인정책을 결정하는 조건문이 없는데 불구하고, 어떻게 할인정책과 비율할인 정책을 선택할 수 있을까?
    - 이 질문에 대답하기 위해서는 상속과 다형성의 대해 알아봐야한다


### 컴파일 시간 의존성과 실행시간 의존성

- 코드의 의존성과 실행 시점의 의존성을 서로 다를 수 있다.
    - 다시말해, 클래스 사이의 의존성과 객체 사이의 의존성은 동일하지 않을 수 잇다.

- 설계가 유연해질수록 코드를 이해하고 디버깅하기 점점 어려워진다는 사실을 기억하라.
    - 반면 , 유연성을 억제하면 코드를 이해하고 디버깅 하기 쉽지만 재사용성과 확장 가능성은 낮아진다는 사실도 기억해라.

- 코드상에 존재하는 Movie 클래스에서 DiscountPolicy 클래스의 의존성이 어떻게 실행 시점에는 AmountDiscountPolicy or PeriodDiscountPolicy 인스턴스에 대한 의존성으로 바뀔수 있을까?

### 차이에 의한 프로그램밍

- 상속 : 코드를 재사용 하기 위해 가장 널리 사용되는 방법

- programming by difference : 부모클래스와 다른 부분만을 추가해서 새로운 클래스를 쉽고 빠르게 만드는 방법

### 상속과 인터페이스

```java
public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
```

- `calculateDiscountAmount` 는 AmountDiscountPolicy & PercentDiscountPolicy의 인터페이스에서도 이 오퍼레이션이 포함되어 잇다.
- Movie 입장에선 자신과 협력하는 객체가 어떤 클래스 어떤 인스터인지가 중요한것이 아닌, 저 메서드로 부터 받는 메세지가 중요하다.
    - 즉, AmountDiscountPolicy & PercentDiscountPolicy 는 Movie와 협력할 수 있다.

**upcasting** : 자식 클래스가 부모 클래스를 대신하는 것을

### 다형성


- 동일한 메세지를 전달하지, 메세지를 수신하는 객체의 클래스 무엇이냐에 따라 달라진다. => 이를 다형성이라고 한다.
- 구현상속과 인터페이스 상속
  - 구현상속(implementation inheritance) : 코드를 재사용하기 위한 목적으로 상속을 구현하는것을 구현 상속
  - 인터페이스 상속(interface inheritance) : 다형적인 협력을 위해 부모클래스와 자식클래스가 인터페이스를 공유할 수 있도록

## 추상화와 유연성

### 추상화의 힘
- 추상화를 이용해 상위정책을 기술한다는것 = 애플리케이션의 협력 흐름을 기술한다는 의미
- 추상화를 이용해 상위정책을 표현하면 기존 구조를 수정하기 않고도 새로운 기능을 쉽게 추가하고 확장

### 유연한 설계

### 추상클래스와 인터페이스 트레이드 오프
- NoneDiscountPolicy

### 코드의 재사용
- 코드를 재사용하기 위한 방법 중 ,상속보다 합성이 더 좋은 방법이라고 말할 수 있다.

### 상속
- 두가지 관점에서 설계에 안좋은 영향을 미친다.
- 캡슐화 위반 : 부모 클래스의 구현이 자식 클래스에게 노출 되기 때문. 즉 상속을 과도하게 사용된
  된 코드는 변경하기 어려운 구조를 가진다.
- 설계가 유연 X: 상속은 부모 클래스와 자식클래스 사이의 관계를 컴파일 시점에 결정. 따라서 실행
  시점에 객체의 종류를 변경하는 것이 불가능

### 합성
- 인터페이스에 정의된 메세지를 통해서만 코드를 재사용 하는 방법을 합성(composition)라고 부름