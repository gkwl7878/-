package day1203;

/**
 *사람의 공통특징을 부모(Person)로 부터 사용하고 자신만의
 *특징만(싸움을 잘한다) 정의 
 * @author owner
 */
public class HongGilDong extends Person{
	private int level;// 싸움레벨
	
	/**
	 * 홍길동은 싸움을 평민보다 잘하므로 7로 시작
	 */
	public HongGilDong() {
		super();
		level = 7;
	}//HongGilDong
//	public int returnLevel() {
//		return level;
//	}

	/**
	 * 싸움하는 일 :입력된 레벨보다 낮다면 패배, 입력된 레벨보다 높다면 승리, 입력된 레벨과 같다면 비김.<br>
	 * 승리하면 레벨이 1증가, 패배하면 레벨이 1감소, 비기면 레벨변화없음<br>
	 * 레벨은 최대 10, 최소 1을 가진다.
	 * @param inputLevel 싸움상대자의 레벨
	 * @return 싸움의 결과
	 */
	public String fight(int inputLevel) {
		String result="";
		
		if(level>inputLevel) {//승리
			result="이겼다.s('. ^)V";
			level++;
			if(level>10) {
				level=10;
			}//end if
		}else if(level<inputLevel){//패배
			result="졌다. ~(_-_)~";
			level--;
			if(level<1) {
				level=1;
			}//end if
		}else {//비김
			result="비김 ㅡㅡ+;;";
		}//end else
		return result;
	}
	@Override //annotation
	public String toString() {
		return "홍길동 객체의 값 눈: "+ getEye()+"/"+",코 : "+getNose()+", 입: "+getMouse();
	}//toString
	/** 
	 * 부모클래스가 제공하는 method의 기능이 자식에서 맞지 않아<br>
	 * 장소인 식당이 주막으로 변경<br>
	 * 화폐단위인 원이 냥으로 변경
	 * 	 */
	@Override
	public String eat(String menu,int price) {
		return getName()+" 이(가) 주막에서"+menu+"인 음식을"+price+"냥 내고 사먹는다";
	}

	@Override
	public String eat() {
		return getName()+"이 집에서 밥을 먹는다";
	}
	@Override	
	public String[] language(String lang) {
		return "한국어, 중국어, 수화".split(",");
	}//language
	
		

}//class
