# SOLUTION

## JAVA/JSP에서 POST, GET 한글 깨질 때

1. jsp/java/html 페이지의 context type과 charset 문서타입을 일치 시킨다.

```markup
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<meta charset="EUC-KR">
```

  2. post 한글 깨짐을 방지하기 위

```java
request.setCharacterEncoding("EUC-KR");
response.setContentType("text/html;charset=EUC-KR");
```

위 코드를 `request.getParameter("paran")` 위에 선언

  3. get 방식 깨짐을 방지하기 위해 `URIEncoding="EUR-KR"` 추가

```markup
<Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="EUR-KR" />
```

  4. 서버 재시

