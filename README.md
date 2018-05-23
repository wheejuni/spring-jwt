### 봄이네집 스프링 - (1) Spring Security + Auth0 JWT Library
---

#### 안녕하세요.

안녕하세요.

봄이네집 스프링의 첫 세션입니다.

이번 세션에서는 Spring Security의 기본 개념을 알아보고, 레퍼런스 문서를 함께 읽습니다. 또 내장된 기본 구현체들을 까 보는(?) 시간도 가질 예정입니다.

또한 Auth0 Java-JWT( https://github.com/auth0/java-jwt )를 사용해 JWT를 발급하고, 인증하는 방법을 알아봅니다. 소셜 공급자 연동도 간단히 맛봅니다.

감사합니다!


**방송 일지**

[제 1회차 방송](https://www.youtube.com/watch?v=SMZm2aqI_dQ&index=1&list=PLcsqrv8NxApXzHViDU2fB1ew7KoLoaB02) 

[제 2회차 방송](https://www.youtube.com/watch?v=x2i96t1aA3s&index=2&list=PLcsqrv8NxApXzHViDU2fB1ew7KoLoaB02&t=0s)

[제 3회차 방송](https://www.youtube.com/watch?v=qCA3JB4W_cw) 

[제 4회차 방송](https://www.youtube.com/watch?v=jNNJnGiLMl8&list=PLcsqrv8NxApXzHViDU2fB1ew7KoLoaB02&index=4&t=0s)

[제 5회차 방송](https://www.youtube.com/watch?v=qhCVfz1t68I&t=0s&index=6&list=PLcsqrv8NxApXzHViDU2fB1ew7KoLoaB02)

[방송 바로가기](https://www.youtube.com/watch?v=SMZm2aqI_dQ)

---
#### Account 객체 요구사항

* 기본적인 유저 정보

    * 아이디, 비밀번호, 이름, 프사 링크(profileHref)
    * 서비스상에서 유저에게 부여하고싶은 권한 
    * 소셜 로그인한 사용자의 경우, 소셜 서비스가 부여한 ID 코드 **(로그인 ID 아님)**
    
 * 유저 정보를 인증과정에서 처리하는 방식
 
    * 유저 모델을 그대로 사용
    * 유저디테일즈 구현체를 사용
    
---
###오늘의 할일

* 카카오 로그인을 구현한다.
    
    * 유저의 카카오 토큰으로 유저 정보를 얻어오는 로직 (서비스) 작성.
        * 추후 다른 소셜 공급자와도 연동할 수 있게 확장성있게 구현.
        * 최대한 객체지향적으로 설계. 
        * DTO 작성. 
        
    * 인증 후 JWT를 발급해야 한다. 
        * 데이터베이스에서 검색되지 않는 사용자는 회원가입 처리 후 발급.
        * 데이트베이스에 있는 사용자는 바로 발급.
        
#### 소셜 공급자에서 빼올 데이터.
    - email
    - 고유번호('id')
    - 프사 href
    - 닉네임 
    
### 인터페이스부터 구현합시다.
    * SocialUserProperty
    
---
###오늘의 할 일 

* 네이버 로그인을 구현한다.

