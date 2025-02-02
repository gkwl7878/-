package day1123;

/**
 * 사람을 추상화 하여 만든 Person 클래스를 사용하는 클래스
 * @author owner
 */
public class UsePerson {

	public static void main(String[] args) {
		//객체생성 : heap에 생성되고 instance변수는 자동 초기화
		Person teacksung=new Person();
		//참조형 데이터형인 Person은 heap의 주소를 가지고 있다.
		System.out.println("객체를 출력하면 주소가 출력 "+teacksung);
		teacksung.setName("정택성");
//		teacksung.setEye(2);
//		teacksung.setMouse(1);
//		teacksung.setNose(1);
		System.out.format("생성된 사람 객체 정보 눈[%d],코[%d],입[%d],이름[%s]\n",
				teacksung.getEye(),teacksung.getNose(),teacksung.getMouse(),teacksung.getName());
		//생성된 객체에서 정의된 일을 시킴
		System.out.println(teacksung.eat());
		System.out.println(teacksung.eat("육회비빔밥",8000));

		
		Person jinban=new Person(3,1,1);
		jinban.setName("천진반");
//		jinban.setEye(3);
//		jinban.setNose(1);
//		jinban.setMouse(1);
		
		System.out.println("---------------------------------------------------------");
		System.out.format("생성된 사람 객체 정보 눈[%d],코[%d],입[%d],이름[%s]\n",
				jinban.getEye(),jinban.getNose(),jinban.getMouse(),jinban.getName());
		System.out.println(jinban.eat());
		System.out.println(jinban.eat("선두",1));
		
	}//main

}//class
