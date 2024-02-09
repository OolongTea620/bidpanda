## 싱글벙글 리펙토링

#### 1.코드 리펙토링 목적

    1. Service layter에서 DIP를 적용하여 controller-service-dao-dto사이의 코드 의존성 줄이기
    2. 변경된 리펙토링에 따라서 기능 모듈 테스트 추가하기

#### 2.변경 구조

    - [Domain 명]
        - action : 
            - api :
        - application :
            - port :
                - in :
                - out :
            - service :
        - domain : 
        - infrastructure :
            - persistence : domain에서

규칙

    1. layer마다 dto로 통신을 하도록 했다.
    2. layer마다 역할을 독립 시키려 했다.

### 리펙토링 기록

#### 2024.02.09
* 생각보다 user 도메인 분리가 어려운 것 같다. 이유 : spring security, 다른 도메인으로 관여가 많은 도메인이라서
* 
---
#### 2024.02.08

* User 버전 리펙토링 시작
---
#### 2024.02.06
* User 도메인 부분 재작성
* SW architech부분 재작성 
---
#### 2024.02.05
* 내가 만든 STOMP 적용 채팅의 문제 인식 -> 코드 수정이 어렵다
* TDD -> 헥사고날 아키텍처 도입 고민
* [만들면서 배우는 클린 아키텍처 구입](https://ebook-product.kyobobook.co.kr/dig/epd/ebook/E000005295801)
---
#### 2024.02.04
* Member 도메인 리펙토링
* Member -> User로 도메인명 변경
* User명 과정 추가

## 참고 레퍼런스 URL 
헥사고날 아키텍처(Hexagonal Architecture) : 유연하고 확장 가능한 소프트웨어 디자인:  
https://tech.osci.kr/hexagonal-architecture/

[프로젝트에-새로운-아키텍처-적용하기](https://medium.com/naverfinancial/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%EC%97%90-%EC%83%88%EB%A1%9C%EC%9A%B4-%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98-%EC%A0%81%EC%9A%A9%ED%95%98%EA%B8%B0-99d70df6122b)

## 참고 서적

[만들면서 배우는 클린 아키텍처 구입](https://ebook-product.kyobobook.co.kr/dig/epd/ebook/E000005295801)