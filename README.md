2014년 개발 경험 프로젝트
=========

1. 로컬 개발 환경에 Tomcat 서버를 시작한 후 http://localhost:8080으로 접근하면 질문 목록을 확인할 수 있다. http://localhost:8080으로 접근해서 질문 목록이 보이기까지의 소스 코드의 호출 순서 및 흐름을 설명하라.

* 

FrontController서블릿으로 처음에 요청이 가서 service()메서드를 실행한다.

request의 list.next에 매핑되는 컨트롤러 인스턴스를 얻고 execute()메서드를 호출한다. execute에서 DAO를 사용하여 모델객체들을 생성해낸다. 그리고 뷰 객체를 받는다. 이 때 뷰는 View 인터페이스를 구현한 jstlView 이고 render함수 모델객체를 파라미터로 넣어주어 호출하면 list.jsp로 포워딩 해준다. list.jsp는 model객체를 이용하여 동적으로 페이지를 만들어낸다. 
