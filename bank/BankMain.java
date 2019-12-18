package problem.bank;

import java.util.Scanner;

public class BankMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankDAO bDao = new BankDAO();
		int code = 0;
		while(true) {
			System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
			System.out.println("▦▦▦▦▦ 허쉬 은행");
			System.out.println("▦▦▦▦▦ 1. 계좌 개설");
			System.out.println("▦▦▦▦▦ 2. 입금");
			System.out.println("▦▦▦▦▦ 3. 출금");
			System.out.println("▦▦▦▦▦ 4. 계좌조회");
			System.out.println("▦▦▦▦▦ 5. 사용자 검색");
			System.out.println("▦▦▦▦▦ 6. 프로그램 종료");
			System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
			System.out.print("▦▦▦▦▦  번호 >>");
			code = sc.nextInt();
			
			if(code > 7 || code < 0) {
				System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
				System.out.println("숫자를 다시 입력해주세요.");
				continue;
			} else {
				break;
			}
		}
		
		if(code == 1) { // 계좌계설
			System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
			System.out.print("▦▦▦▦▦ 성함을 작성해주세요 >> ");
			sc.nextLine();
			String bname = sc.nextLine();
			System.out.print("▦▦▦▦▦ 계좌 비밀번호를 입력해주세요 >> ");
			String pw = sc.nextLine();
			
			BankDTO bDto = new BankDTO(bname, pw);
			bDao.BankInsert(bDto);
			
		} else if(code == 2) { // 입금
			System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
			System.out.print("▦▦▦▦▦ 성함을 작성해주세요. >>  " );
			sc.nextLine();
			String bname = sc.nextLine();
			System.out.print("▦▦▦▦▦ 입금하실 돈을 넣어주세요. >> ");
			int money = sc.nextInt();
			
			BankDTO bDto = new BankDTO(bname, money);
			bDao.BankUpdate(bDto);

		} else if(code == 3) { // 출금
			
		} else if(code == 4) { // 계좌조회
			
		} else if(code == 5) { // 사용자검색
			
		} else if(code == 6) { // 프로그램 종료
			
		}	
		
		
		// 1. 프로그램 전체반복
		// 2. 1~6번까지 번호만 허용(나머지는 무한반복 다시입력)
		// 3. 계좌 개설 만들기(INSERT)
		// 4. 계좌 조회 만들기(SELECT, 전체조회)
		// 5. 사용자 검색 만들기(이름으로)
		// 6. 프로그램 종료기능 만들기
		
	}

}
