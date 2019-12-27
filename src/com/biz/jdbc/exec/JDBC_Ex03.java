package com.biz.jdbc.exec;

import java.util.Scanner;

import com.biz.jdbc.service.IoService;

public class JDBC_Ex03 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		IoService ios = new IoService();
		ios.selectAll();
		
		while(true) {
			System.out.println("==============================");
			System.out.print("거래 SEQ(-Q :quit) : ");
			String strSeq = scanner.nextLine();
			if(strSeq.equals("-Q")) break;
			try {
				long io_seq = Long.valueOf(strSeq);
				ios.findBySeq(io_seq);
			} catch (Exception e) {
				System.out.println("거래 SEQ는 숫자만 입력하세요.");
			}
			System.out.println("=============================");
		}
		scanner.close();
		System.out.println("Game Over!!!");
	}

}
