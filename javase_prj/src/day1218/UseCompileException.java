package day1218;

/**
 *Compile Exception : byte code를 정상적으로 생성하기 위한 것.
 *개발자가 반드시 예외상황을 처리해야하는 예외.
 * @author owner
 */
public class UseCompileException {
	
	public static void main(String[] args) {
		
		try {
			
//			Object obj = Class.forName("java.lang.String");
			Object obj = Class.forName("day1217.UseRuntimeException");
			System.out.println("로딩한 클래스" +obj);
		} catch (ClassNotFoundException cnfe) {
			System.err.println("죄송합니다.");
			System.err.println("예외 메시지 출력 :"+ cnfe.getMessage());
			System.err.println("예외처리 객체와 메세지 :" +cnfe);
			cnfe.printStackTrace();
//			System.err.println("====="); //println은 printStackTrace보다 먼저 출력될 수 있다.
		}finally{
			System.out.println("사용해주셔서 감사합니다");
		}//end catch
	}//main

}//class
