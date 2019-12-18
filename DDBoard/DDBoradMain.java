package problem.DDBoard;

import java.util.Scanner;

public class DDBoradMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BoardDAO bDao = new BoardDAO();
		int code = 0; // 사용자가 선택한 프로그램 번호 
		
		while(true) {
			System.out.println("▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩");
			System.out.println("▩▩▩ 더블디 게시판");
			bDao.BoardSelect();
			System.out.println("▩▩▩ 1. 게시글 등록");
			System.out.println("▩▩▩ 2. 게시글 수정");
			System.out.println("▩▩▩ 3. 게시글 삭제");
			System.out.println("▩▩▩ 4. 게시글 조회");
			System.out.println("▩▩▩ 5. 게시글 검색");
			System.out.println("▩▩▩ 6. 게시글 정렬");
			System.out.println("▩▩▩ 7. 상세 게시글");
			System.out.println("▩▩▩ 8. 만든이");
			System.out.println("▩▩▩ 9. 프로그램 종료");
			System.out.println("▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩");
			while(true) {
				System.out.print("▩▩▩ 번호>>");
				code = sc.nextInt();
				
				if(code >= 1 && code <= 9) {
					break;
				} else {
					System.out.println("▩▩▩ 1 ~ 9의 값을 입력하세요.");
					continue;
				}
			}
			
			if(code == 1 ) {
				System.out.println("▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩");
				System.out.println("▩▩▩▩ 게시글을 입력하세요.");
				System.out.print("▩▩▩▩ 제목 입력 >> ");
				sc.nextLine();
				String title = sc.nextLine();
				System.out.print("▩▩▩▩ 내용 입력 >>");
				String content = sc.nextLine();
				System.out.print("▩▩▩▩ 작성자 입력 >>");
				String writer = sc.nextLine();
				
				BoardDTO bDto = new BoardDTO(title, content, writer);
				bDao.BoardInsert(bDto);
				
			} else if(code == 2) {
				System.out.println("▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩");
				System.out.println("▩▩▩▩ 수정하실 번호를 입력하세요.");
				System.out.print("▩▩▩▩ 번호 입력>>");
				int bno = sc.nextInt();
				System.out.print("▩▩▩▩ 제목 입력 >>");
				sc.nextLine();
				String title =sc.nextLine();
				System.out.print("▩▩▩▩ 내용 입력");
				String content = sc.nextLine();
				System.out.print("▩▩▩▩ 작성자 ");
				String writer = sc.nextLine();
				
				BoardDTO bDto = new BoardDTO(bno, title, content, writer);
				bDao.BoardUpdate(bDto);
			
				
			} else if(code == 3) { // 삭제
				System.out.println("▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩");
				System.out.println("▩▩▩▩▩▩ 삭제하고 싶은 게시글 번호를 입력하세요.");
				System.out.print("▩▩▩▩▩▩ 번호를 입력하세요 >>");
				int bno = sc.nextInt();
				
				bDao.BoardDelete(bno);
				
			} else if(code == 4) { // 게시글 조회
				System.out.println("▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩");
				System.out.println("▩▩▩▩▩▩ 게시글 조회 목록입니다.");
				
				
			} else if(code == 5) {
				System.out.println("▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩");
				System.out.println("▩▩▩▩▩▩ 검색할 키워드를 입력하세요.");
				System.out.print("▩▩▩▩▩▩ 검색 >>");
				sc.nextLine();
				String keyword = sc.nextLine();

				bDao.BoardSearch(keyword);
			} else if(code == 6) { //게시글 정렬
				System.out.println("▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩");
				System.out.println("▩▩▩▩▩▩ 게시글 조회수 정렬입니다.");
				bDao.BoardSort();

				
			} else if(code == 7) {
				System.out.println("▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩");
				System.out.println("▩▩▩▩ 보고싶은 게시글번호를 입력하세요. ");
				System.out.print("▩▩▩▩ 게시글번호 >>");
				int bno = sc.nextInt();
				
				bDao.BoardView(bno);
			} else if(code == 8) { // 만든이
				System.out.println("▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩");
				System.out.println("▩▩▩▩ Name : DD Boaed Program ");
				System.out.println("▩▩▩▩ Version: 1.7");
				System.out.println("▩▩▩▩ Use : JAVA, ORACLE");
				System.out.println("▩▩▩▩ Date : 2019. 12. 17");
				System.out.println("▩▩▩▩ by Miiiik2 ");
				System.out.println("▩▩▩▩ dbflalrud@gmail.com");
			} else if(code == 9) { // 프로그램 종료
				System.out.println("▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩");
				System.out.println("▩▩▩ [프로그램 종료]");
				System.exit(0);
		}
		
		
	}

   }
}
