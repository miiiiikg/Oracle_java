package chapter08;

public class DmbCellPhoneMain {
	public static void main(String[] args) {
		// cellPhone 클래스를 상속받고 있는
		// 자식 DmbCellPhone 클래스를 객체 생성
		DmbcellPhone dmb = new DmbcellPhone("어머나폰", "화이트", 5);
		
		// cellPhone 부모클래스로부터 상속받은 필드
		System.out.println("모델:" +dmb.model);
		System.out.println("색상:" +dmb.color);
		
		// 자기자신의 필드
		System.out.println("채널:" + dmb.channel);	
		
		// cellPhone 부모클래스로부터 상속받은 메서드
		dmb.powerOn();
		dmb.bell();
		dmb.SendVoice("여보세요");
		dmb.receiveVoice("안녕하세요. 체리에요!");
		dmb.SendVoice("강아지가 말도 하네요??");
		dmb.hang();
		
		// 자기자신의 메서드
		dmb.turnOnDmb();
		dmb.ChangeChannelDmb(12);
		dmb.turnoffDmb();
	}

}
