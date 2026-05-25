# 뉴스 기사 열람 웹 애플리케이션

뉴스 카테고리 선택 > 기사 리스트 > 기사 본문 흐름으로 이어지는 웹 애플리케이션입니다.

Frontend: Freemarker (SSR), HTML/CSS, jQuery
Backend: Spring Boot
데이터베이스: SQLite (news.db)

## 화면 구성
###1) 뉴스 카테고리 선택 (http://localhost:8081/home)
<img width="1712" height="1256" alt="1-1  카테고리 선택화면" src="https://github.com/user-attachments/assets/9b89a34b-41ad-482e-9a94-d305d974e148" />

- 버튼 마우스 오버
  <img width="1718" height="1266" alt="1-2 카테고리 선택화면_(버튼마우스오버)" src="https://github.com/user-attachments/assets/80032f97-ce64-4a79-bec2-d9ff220fa35c" />


###2) 기사 리스트 (http://localhost:8081/news?categoryId=)
<img width="2180" height="1490" alt="2-1  카테고리별 기사 리스트 화면" src="https://github.com/user-attachments/assets/1dd6b556-a14e-43ff-99a6-adba77c0f8a3" />
 - 기사 제목, 작성자, 발행 시간, 읽음/읽지 않음 표시
 - '홈으로 이동하기' 버튼 클릭 시 1) 화면으로 이동
   
- 읽음 표시
<img width="2228" height="1498" alt="2-2  카테고리별 기사 리스트 화면_(읽음 표시)" src="https://github.com/user-attachments/assets/952d9ec1-4e5a-409d-b969-dd83df56ce57" />


###3) 기사 본문
<img width="2144" height="1492" alt="3  본문 페이지_(기사 타이틀 클릭시 새 탭이동)" src="https://github.com/user-attachments/assets/39c614ed-622c-4e7b-b405-e50001e3b63a" />
 - 2)에서 기사 제목 클릭 > 새 탭에서 기사 본문 출력

###공통 에러페이지
<img width="1722" height="1254" alt="공통_에러페이지" src="https://github.com/user-attachments/assets/7d983203-b377-423d-947d-3ac5d10cd388" />
 - 예기치 못한 에러 발생 시 출력 페이지
