# LietenerBox
#### 19.09.17 (화)
1. 프로젝트 생성 및 개발환경 셋팅
* spring-boot-starter-data-jpa
* spring-boot-starter-mustache
* spring-boot-starter-web
* spring-boot-starter-test
* spring-boot-devtools
* h2 Database (테스트 완료 후 Mysql로 변경예정)
* jackson-datatype-jsr310
* lombok
#### 19.09.18 (수)
1. 엔티티 생성
2. 엔티티 별 repository 생성
3. 엔티티 다이어그램 작성
4. members테이블 read API 생성 및 테스트

#### 19.09.19 (목)
1. import.sql파일에 실제 퀴즐렛 데이터 추가 
2. Wordlevel 컬럼 default값 설정
3. heroku 배포에 필요한 gradlew/gradlew.bat 파일 gitignore에서 제거
4. heroku 계정 생성, github 연동

#### 19.09.20 (금)
1. entity간 관계차수 설정
2. entity명 정리
 
#### 19.09.25 (수)
1. GroupsApi 구현
    - createGroups 날짜 형식 오류
    - Group Api get 구현

#### 19.09.30 (월)
1. Member테이블 -> members으로 명칭 변경

[추후 시나리오]
* 회원 정보 입력, 수정 api controller 구현
* 그룹(=class) ,그룹 세트, 그룹 단어 생성,수정 api controller 구현
* 멤버 개인이 생성하는 세트,단어 생성 , 수정 api controller 구현
* 화면 템플릿 resource 추가(메인화면,클래스 생성화면,클래스 수정화면,단어세트 생성화면)
* 서비스 클래스에 비즈니스 로직 추가

[Api]
* membersApi
    * 회원리스트 read
    * 회원 정보 read
    * 회원 정보 update
* GroupsApi
    * setlist만 read,write,update
    * folders id값을 기반으로 단어 리스트 read,write,update
* ItemApi
    * Group에 속한 setlist만 read,write,update
    * Group에 속한 folders id값을 기반으로 단어 리스트 read,write,update
* WordApi
    
   