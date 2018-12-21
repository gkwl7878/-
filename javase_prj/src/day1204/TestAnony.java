package day1204;

/**
 * �������̽��� method�� �Ű������� �� �����ϰ� ����ϴ� ���.<br>
 * 
 * @author owner
 */
public class TestAnony {
	public void useAnonInter(AnonyInter ai){
		System.out.println(ai.getMsg()+" "+ai.getName());
	}//useAnonyInter
	
	public static void main(String[] args) {
//		AnonyInter ai = new AnonyInter(); //�������̽��� ��üȭ X
		//�������̽��� �Ű����� ���� ����
		//1. �������̽��� ������ Ŭ������ ����.
		//2. ����Ŭ������ ��ü�� ����.
		AnonyImpl ai=new AnonyImpl();
		//3. �Ű������� ���� method�� ȣ���ϱ� ���� ��ü����
		TestAnony ta= new TestAnony();
		//4. method ȣ��
		ta.useAnonInter(ai);

		
		System.out.println("--------------------anonymous innerclass--------------------");
		//anonymous inner class �� ����ϸ� Ŭ������ ���� ���� �ʿ䰡 ����.
		
		ta.useAnonInter(new AnonyInter() {
			@Override
			public String getName() {
				return "������"+test();
			}//getName
			@Override
			public String getMsg() {
				return  "�´���";
			}//getMsg
			public String test() {
				return "�ڽ� method ";
			}
		});	
		
	}//main

}//class