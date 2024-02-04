## 싱글벙글 리펙토링

#### 1.코드 리펙토링 목적

    1. Service layter에서 DIP를 적용하여 controller-service-dao-dto사이의 코드 의존성 줄이기
    2. 변경된 리펙토링에 따라서 기능 모듈 테스트 추가하기

#### 2.변경 구조

    - [Domain 명]
        - infrastructure : 인터페이스를 구현 받아서 실제로 구현이 이루어지는 케이스
        - domain
        - entity : JPA에서 테이블 매핑이 이루어지 객체 클래스
        - repository
        - service
            - impl
        - controller


### 리펙토링 기록

---
#### 2024.02.04
* Member 도메인 리펙토링
* Member -> User로 도메인명 변경
* User명 과정 추가


## 참고 서적