package day1129;

/**
 *����� ����Ư¡�� �θ�(Person)�� ���� ����ϰ� �ڽŸ���
 *Ư¡��(�ο��� ���Ѵ�) ���� 
 * @author owner
 */
public class HongGilDong extends Person{
	private int level;// �ο򷹺�
	
	/**
	 * ȫ�浿�� �ο��� ��κ��� ���ϹǷ� 7�� ����
	 */
	public HongGilDong() {
		super();
		level = 7;
	}//HongGilDong
//	public int returnLevel() {
//		return level;
//	}

	/**
	 * �ο��ϴ� �� :�Էµ� �������� ���ٸ� �й�, �Էµ� �������� ���ٸ� �¸�, �Էµ� ������ ���ٸ� ���.<br>
	 * �¸��ϸ� ������ 1����, �й��ϸ� ������ 1����, ���� ������ȭ����<br>
	 * ������ �ִ� 10, �ּ� 1�� ������.
	 * @param inputLevel �ο������� ����
	 * @return �ο��� ���
	 */
	public String fight(int inputLevel) {
		String result="";
		
		if(level>inputLevel) {//�¸�
			result="�̰��.s('. ^)V";
			level++;
			if(level>10) {
				level=10;
			}//end if
		}else if(level<inputLevel){//�й�
			result="����. ~(_-_)~";
			level--;
			if(level<1) {
				level=1;
			}//end if
		}else {//���
			result="��� �Ѥ�+;;";
		}//end else
		return result;
	}
	@Override //annotation
	public String toString() {
		return "ȫ�浿 ��ü�� �� ��: "+ getEye()+"/"+",�� : "+getNose()+", ��: "+getMouse();
	}//toString
	/** 
	 * �θ�Ŭ������ �����ϴ� method�� ����� �ڽĿ��� ���� �ʾ�<br>
	 * ����� �Ĵ��� �ָ����� ����<br>
	 * ȭ������� ���� ������ ����
	 * 	 */
	@Override
	public String eat(String menu,int price) {
		return getName()+" ��(��) �ָ�����"+menu+"�� ������"+price+"�� ���� ��Դ´�";
	}

}//class