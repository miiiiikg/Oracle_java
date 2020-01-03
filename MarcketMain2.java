package marcket;

import java.util.Scanner;

public class MarcketMain2 {
	// 내부저장소
	// 관리자 계정 ID와 PW 선언
	String id = "admain";
	String pw = "1234";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductDAO pDao = new ProductDAO();
		MarcketMain2 mm = new MarcketMain2();
		Boolean flag = false;
		
		String userid = "";
		String userpw = "";

		System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
		System.out.println("▦▦▦▦▦ marcket System ver1.0 ");
//		do {
//			System.out.println("▦▦▦▦ [MSG] Please login to user.");
//			System.out.print("▦▦▦▦ ID >>");
//			userid = sc.nextLine();
//			System.out.print("▦▦▦▦ PW >>");
//			userpw = sc.nextLine();			
//		}while(mm.login(userid, userpw));
		
		while (true) {
			System.out.println("▦▦▦▦▦ 1. 제품 판매");
			System.out.println("▦▦▦▦▦ 2. 제품 등록 & 추가");
			System.out.println("▦▦▦▦▦ 3. 제품 수정");
			System.out.println("▦▦▦▦▦ 4. 제품 삭제");
			System.out.println("▦▦▦▦▦ 5. 제품 조회");
			System.out.println("▦▦▦▦▦ 6. 제품 검색");
			System.out.println("▦▦▦▦▦ 7. 일일 매출현황");
			System.out.println("▦▦▦▦▦ 8. 프로그램 종료");
			
			int code = 0;
			while (true) {
				System.out.print("▦▦▦▦▦ code >>");
				code = sc.nextInt();

				if (code >= 1 && code <= 8) {
					break;
				} else {
					continue;
				}

				
			}
			
			if(code == 1) {
				
			} else if(code == 2) {
				System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
				System.out.print("▦▦▦▦▦▦▦ 제품을 입력하세요 >>>");
				String pname = sc.nextLine();
				
				if(pDao.pdtAlready(pname)) {
					System.out.print("▦▦▦▦▦▦▦ 수량을 입력하세요 >>>");
					int cnt = sc.nextInt();

					pDao.CntPlusPdt(pname, cnt);
				} else { 
					System.out.print("▦▦▦▦▦▦ 제품회사를 입력해주세요 >>");
					String company = sc.nextLine();
					System.out.print("▦▦▦▦▦▦ 가격을 입력해주세요 >>");
					int price = sc.nextInt();
					System.out.print("▦▦▦▦▦▦▦ 수량을 입력하세요 >>>");
					int cnt = sc.nextInt();
					
					pDao.insertPdt(pname, company, price, cnt);
				}
				
				
			} else if(code == 3) {
				
			} else if(code == 4) {
				
			} else if(code == 5) {
				
			} else if(code == 6) {
				
			} else if(code == 7) {
				
			} else if(code == 8) {
				System.out.println("▦▦▦▦ [Msg] Exit the program ");
				System.exit(0);
				
			}
				
		}

	}
	public boolean login(String userid, String userpw) {
		Boolean flag = true; // 로그인 유무 판별(true : 실패 , false : 성공)
		if(userid.equals(id)  && userpw.contentEquals(pw)) {
			flag = false;
			System.out.println("▦▦▦▦ 환영합니다 관리자님");
		} else {
			System.out.println("▦▦▦▦ [Msg] Login denied. ");
		}
		return flag;
				
	}

}
