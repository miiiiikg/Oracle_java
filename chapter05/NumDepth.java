package chapter05;

import java.util.Scanner;

public class NumDepth {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요>>");
		int num = sc.nextInt();
		
		int fir = 1;
		int end = 1;
		int sum = fir+end;
		for(int i = 2; i<num; i++) {
			sum = end;
			end = fir + end;
			fir = sum;
			
			System.out.print(end+ " ");
		 }
		System.out.println();
		
	}

}
