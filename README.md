# 뉴스 기사 열람 웹 애플리케이션

뉴스 카테고리 선택 > 기사 리스트 > 기사 본문 흐름으로 이어지는 웹 애플리케이션입니다.

- Frontend: Freemarker (SSR), HTML/CSS, jQuery
- Backend: Spring Boot
- 데이터베이스: SQLite (news.db)

## 화면 구성
### 1) 뉴스 카테고리 선택 (http://localhost:8081/home)
<img width="1712" height="1256" alt="1-1  카테고리 선택화면" src="https://github.com/user-attachments/assets/9b89a34b-41ad-482e-9a94-d305d974e148" />

- 버튼 마우스 오버
  <img width="1718" height="1266" alt="1-2 카테고리 선택화면_(버튼마우스오버)" src="https://github.com/user-attachments/assets/80032f97-ce64-4a79-bec2-d9ff220fa35c" />


### 2) 기사 리스트 (http://localhost:8081/news?categoryId=)
<img width="2180" height="1490" alt="2-1  카테고리별 기사 리스트 화면" src="https://github.com/user-attachments/assets/1dd6b556-a14e-43ff-99a6-adba77c0f8a3" />

- 기사 제목, 작성자, 발행 시간, 읽음/읽지 않음 표시
- '홈으로 이동하기' 버튼 클릭 시 1) 화면으로 이동

<img width="726" height="370" alt="image" src="https://github.com/user-attachments/assets/55ced959-5f42-48f2-b0bd-db671dc694dd" />

- 읽음 표시


### 3) 기사 본문
<img width="2144" height="1492" alt="3  본문 페이지_(기사 타이틀 클릭시 새 탭이동)" src="https://github.com/user-attachments/assets/39c614ed-622c-4e7b-b405-e50001e3b63a" />

- 2)에서 기사 제목 클릭 > 새 탭에서 기사 본문 출력

### 공통 에러페이지
<img width="1722" height="1254" alt="공통_에러페이지" src="https://github.com/user-attachments/assets/7d983203-b377-423d-947d-3ac5d10cd388" />

- 예기치 못한 에러 발생 시 출력 페이지

## 구현
### Frontend + Backend (SSR-PageController)
- ftl 파일 마크업 구성
  `src/main/resources/static, src/main/resources/templates 디렉토리 하위`
- PageController에서 Model에 담을 값 세팅 및 전달
- 페이지 렌더링

### Backend (REST API-ApiController)
- ftl 파일 내 jquery에서 ajax로 api 호출
- ApiController에서 카테고리 목록, 뉴스 목록 등 json 응답

### Backend (로깅 및 에러처리)
- Slf4j 활용하여 ErrorExceptionHandler에서 로깅
- throw 발생 시 enum ErrorCode와 원하는 값 Map에 담아 로깅
- info/warn은 콘솔에만, error는 콘솔+파일(/logs 디렉토리 하위)에 생성 (logback-spring.xml) 

### DB
- JPA 활용 
- news.db > categories, readlog 테이블 생성, 조회
<img width="404" height="342" alt="image" src="https://github.com/user-attachments/assets/258af732-96af-4c5b-b641-b7ab4273f18b" />

- categories 테이블
- <img width="1406" height="874" alt="image" src="https://github.com/user-attachments/assets/a6d63ee0-24bf-489c-8f51-7bb189d60b30" />
- readlog 테이블
- <img width="1292" height="530" alt="image" src="https://github.com/user-attachments/assets/600ea366-76f4-4744-928c-5e6bd0a85cac" />
- RSS 데이터에서 추출한 link의 article_id를 저장 `(라이브에서는 유저 ID와 함께 저장)`


## 실행
Frontend, Backend, DB 모두 하나의 서버에 있으므로 각각 실행 불필요함. 해당 app만 실행 
- gradle > Tasks > application > bootRun



