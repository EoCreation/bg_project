﻿==================================
++ <ver_1.0>			++
++ ReadMe.txt			++
++ 수정날짜 : 2018/05/14 14:19	++
==================================
 
* 업로드되어 있는 <ver_1.0>는 절대로 수정하지 마세요!
** 수정하려면 <ver_1.0>를 다운을 받은 뒤 컴퓨터에서 작업하세요!
*** 수정할 때에는 파일 인덱스를 다음과 같이 합니다.
	(코드번호) 이예찬: 1, 백종훈: 2, 채규병: 3
	   => ver_1.0.(수정횟수)(코드번호)
	(예시) 예찬 씨가 1번 수정한 ver_1.0은 다음과 같은 인덱스를 가집니다.
 	   => ver_1.0.11

**** 페이지에 기능을 추가하거나 수정할 때마다 아래 <페이지 명세>에 작성할 수 있도록 따로 기록해놓아야 합니다!

***** 파일을 실행하기 전에 해야할 것!
 1. DB 만들기
  파일을 실행하기 전에 sql.txt에서 쿼리문을 복사하여 그대로 mysql에서 실행하면 됩니다.
  첫 줄에 drop databases를 넣어 놓았기 때문에 언제든 그대로 실행하면 초기화됩니다.

 2. 폴더 만들기 및 설명
  이클립스 프로젝트를 만들어서 아래 주소에 파일들을 복사해 붙여넣으시면 됩니다.
  WebContent/
   - index
   - main
  src/
   - image
   - pubg

 index : 로그인 창. 로그인을 해야만 메인창이 실행됩니다.
 main : 하위 폴더에 intro, notice, freeboard, qa가 있습니다. 해당하는 코딩을 여기서 작업하시면 됩니다.
 image : 웹사이트에 사용하는 모든 이미지는 여기에 저장합니다.
 pubg : 하위 폴더로 util이 있습니다. 여기에 자바 파일을 모두 저장합니다.

****** 페이지 명세
(예시)
 free_board.jsp
- 자유게시판
- 글 리스트 전체 출력(f_text{글 내용} 제외)
- 제목 클릭시 페이지 이동 : free_board_post.jsp
- 검색란에 text입력 가능 및 검색버튼 누를 시 페이지 이동 : free_board_search.jsp
- 글쓰기 버튼 클릭시 페이지 이동 : free_board_writing.jsp

 free_board_search.jsp
- 자유게시판(제목검색)
- 제목(f_title) 검색된 글의 리스트 출력(f_text{글 내용} 제외)
- 이하 기능은 free_board.jsp와 동일

 free_board_post.jsp
- 클릭한 글 보기
- free_board table의 모든 속성 출력
- 목록 버튼 클릭시 페이지 이동 : free_board.jsp

 free_board_writing.jsp
- 글쓰기
- 작성자(user_id), 제목(f_title), 내용(f_text) 입력가능 
(발견한 문제점 : 아무것도 입력하지 않고 작성버튼 클릭시에도 글 작성이 완료됨.
단, 예외처리되며 DB에는 등록되지않음)
- 작성버튼 클릭시 페이지 이동 : free_board_writing_submit.jsp
- 다시쓰기 클릭시 기본값으로 초기화 (작성자 : "최대 10자", 제목 : "최대 50자", 내용 : "최대 200자")
- 목록으로 클릭시 페이지 이동 : free_board.jsp

 free_board_writing_submit.jsp
- 작성완료페이지
- DB에 입력하기위한 함수 및 파라미터 설정
- alert("글 작성이 완료되었습니다."); 작동 완료 후에
- document.location.href="free_board.jsp"; 작동 (free_board.jsp 페이지로 이동)
- 이동 시 바로 갱신된 table 확인 가능


==============================