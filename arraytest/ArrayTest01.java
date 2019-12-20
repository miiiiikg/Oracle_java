package arraytest;

public class ArrayTest01 {
	public static void main(String[] args) {
		// 배열: 1개 이상의 값을 저장할 때 사용
		// 변수: 1개의 값만 저장 가능
		
		// 배열 생성방법 2가지
		// 1. 배열 선언 및 초기화
		int[] num = {1,2,3};
		
		// 2. 선언과 초기화를 별개로
		// [3] <= 배열 공간의 크기(3칸)
		int[] arrNum2 = new int[3]; // 선언
		// int arrNum2[] = new int[3]; 
		arrNum2[0] = 1;
		arrNum2[1] = 2;
		arrNum2[2] = 3;
		// arrNum2[index번호]
		
		// 배열(Array)의 특징
		// 1. 배열공간의 수를 반드시 지정해야함
		// 2. 배열공간은 같은 자료형 값만 저장 가능
		// 3. 배열은 공간마다 index번호를 가짐(0부터 시작)
		// ※ 배열의 모든 공간을 꼭 사용해야하는 건 아님
		
		// 배열 공간에 값을 입력!!
		// arrNum2[2] = 3;
		
		// 배열 공간에 값을 출력!!!
		// System.out.println(arrNum2[2])
		
		// 5명의 학생이름을 저장하는 배열 생성
		String[] arrName = new String[5];
		arrName[0] = "오동선";
		arrName[1] = "김혜원";
		arrName[2] = "백진주";
		arrName[3] = "진미경";
		arrName[4] = "이승주";
		
		// System.out.println(arrName[2]);
		
		// 5칸
		// 인덱스: 0, 1, 2, 3, 4(5칸)
		// 배열.length <= 배열의 크기를 반환
		for(int i = 0; i < arrName.length; i++) {
			System.out.println(arrName[i]);
			
		}
	}

}
