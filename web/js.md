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

