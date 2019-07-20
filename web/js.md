# JS

## function\(함수\)

### 정의 방법

```javascript
function numbering(){
    i = 0;
    while(i < 10){
        document.write(i);
        i += 1;
    }
}

numbering = function (){
    i = 0;
    while(i < 10){
        document.write(i);
        i += 1;
    }   
}
```

### 익명함수

```javascript
(function (){
    i = 0;
    while(i < 10){
        document.write(i);
        i += 1;
    }   
})();
```

## Object\(객체\)

```javascript
var grades = {'egoing': 10, 'k8805': 6, 'sorialgi': 80};
```

### object와 json의 차이점

Object는 **JS Engine 메모리 안에 있는 데이터 구조**

JSON은 **객체의 내용을 기술하기 위한 text 파일**

JSON은 "파일"이므로 확장자 명이 **.JSON인 파일**이 존재한다.

## 유효범위

JS에서의 지역변수는 함수 안에 정의된 변수만 지역변수로 취급한다.

```java
for(int i = 0; i < 10 ; i++){
    String str = "test";
}
System.out.println(str);
```

java에서는 위와 같이 for문안에 정의된 변수도 지역변수 이므로 for문 밖에서 str을 사용하지 못하기때문에 출력문에서 오류가 생긴다. 

하지만 JS에서는 함수 안의 변수만 지역변수이기 때문에 for문이나 if문 안에 정의된 변수는 전역변수가 된다. 따라서 아래와 같은 코드가 가능하다.

```javascript
for(var i = 0; i < 10; i++){
    var str = "test";
}
console.log(str);
```

