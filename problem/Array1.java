package problem;

import java.util.Scanner;

public class Array1 {
	static int[] data = new int[5];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("===========================");
		System.out.println("== 보글보글 버블정렬 Ver.10");
		
		for(int i = 0; i< data.length; i++) {
			System.out.println("== " + (i+1) + "번수>>");
			data[i] = sc.nextInt();
		}
	}
	public static void viewData() {
		for(int i = 0; i < data.length; i++) {
			System.out.println(data[i]+"");
		}		
		
	}

}
