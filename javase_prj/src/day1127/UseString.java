package day1127;

/**
 * ���ڿ�������� �ּҸ� �����ϰ�, ���ڿ��� �ٷ�� ����� �����ϴ� String class ���.<br>
 * java���� �����ϴ� Ŭ������ �̸��� �������� Ŭ������ �̸��� ���ٸ� �������� Ŭ������ ���� ����ϰԵȴ�. java���� �����ϴ� Ŭ������
 * ����� ������ "full path: ��Ű������ ��� ����Ͽ� Ŭ������ ����ϴ� ��"�� ����ؾ��Ѵ�. ��Ű����.Ŭ������
 * 
 * @author owner
 */
public class UseString {

	public static void main(String[] args) {
		// �⺻������ ��� .
		String str = "AbcdEfg";
//		//������ ���� ���. 
		String mail = new String("gkwl7878@gmail.com");
		System.out.println(str);
		System.out.println(mail);

		System.out.println(str + "�� ����" + str.length());
		System.out.println(mail + "�� ����" + mail.length());

		System.out.println(str + "�� ��� �빮��" + str.toUpperCase());
		System.out.println(str + "�� ��� �ҹ���" + str.toLowerCase());
		// "AbcdEfg"
		// 0123456
		// indexOf�� L-> R�� �����ϸ� ���� ó�� ã������ ���ڿ��� �ε�����´�.
		System.out.println(str + "���� 'd'�� �ε���: " + str.indexOf("d"));
		System.out.println(str + "���� 'z'�� �ε���: " + str.indexOf("z"));

		System.out.println(mail + "���� \"@\"�� �ε���: " + mail.indexOf("@"));
		str = "AbcdEfAg";
		// lastIndexOf�� L=>R�� �����ϸ鼭 ���� ó�� ã������ ���ڿ��� �ε����� ��´�.
		System.out.println(str + "���ڿ����� �ڷκ��� 'A'�� �ε���: " + str.lastIndexOf("A"));

		// Ư�� �ε����� ���ھ��
		char temp = str.charAt(2);
		System.out.println(str + "���� 2��° �ε����� �ش��ϴ� ���� " + temp);

		// �ڽĹ��ڿ� �ڸ���
//		str="AbcdEfAg";
		System.out.println(str+"���� �ε����� 2~5��° �ش��ϴ� ���ڿ�"+
				str.substring(2,6));
		//gkwl7878@gmail.com
		//01234567 8 91011121314 15 161718 
//		System.out.println(mail+"���� ���� �ּҸ� ��� "+mail.substring(0,mail.indexOf("@")));
//		System.out.println(mail+"���� ������ �ּҸ� ��� "+mail.substring(mail.indexOf("@")+1,mail.length()));
		//substring�� �����ε����� ���� ������ ���´�.
		System.out.println(mail+"���� ������ �ּҸ� ��� "+mail.substring(mail.indexOf("@")+1));
		
		//�յڰ����ڸ���
		str="   A BC   ";
		System.out.println("["+str+"]���� �յڰ������� ["+str.trim()+"]");
		
		//���ڿ� ���̱�
		str= "Abcd";
		String str1=str.concat("Efg");
		String str2=str+"Efg";
		System.out.println(str1);
		System.out.println(str2);
		
		//���ڿ��� �Ϻ��ϰ԰����� ��
		str="���ü�";
		System.out.println(str+"��(��)"+(str.equals("������")?"����":"���"));
		
		//���ڿ��� �� ���ڿ��� �����ϴ���
		str="�Ǿ���";
		if(str.startsWith("����")) {
			System.out.println("���� ����ϽǼ� �����ϴ�");
		}else {
			System.out.println(str);
		}//else
		
		str="����� ������";
		str1="������ �ȴޱ�";
		
		System.out.println(str+"��(��)"+(str.startsWith("����")?"������Դϴ�":"������ �ƴմϴ�"));
		System.out.println(str1+"��(��)"+(str1.startsWith("����")?"������Դϴ�":"������ �ƴմϴ�"));
		
		//Ư�� ���ڿ��� ��������
		str="����� ������ ���ﵿ";
		str1="��⵵ ������ ������";
		System.out.println(str+"��(��)"+(str.endsWith("��")?"����":"�ð�"));
		System.out.println(str1+"��(��)"+(str1.endsWith("��")?"����":"�ð�"));
		
		//ġȯ:���ڿ� ���� ��� ���ڿ� ã�Ƽ� ġȯ
		str="�� ���� �Ǿ����ε� �� ���� �������";
//		System.out.println(str.replaceAll("����","**" ));
		//method�� �����ؼ� ȣ���ϴ� ���� method chain
		System.out.println(str.replaceAll("��","*").replaceAll("��", "*"));
		
		str="   A BC   ";
		System.out.println(str.replaceAll(" ","").replaceAll("A","B"));
		
		int i=27;
//		str=i; int �� String���� �Ҵ� �� �� ����.
		//�⺻�� ���������� ���ڿ��� ��ȯ
		str=String.valueOf(i);
		System.out.println(str);
		double d=11.27;
		str=d+"";
		System.out.println(d);
		
		str="";
		System.out.println(str.isEmpty());
		
		//��ü������ ���� �ʾ��� �� �� Ŭ������ �����ϴ� method��
		//����� �� ����. Error
//		str=null;
//		System.out.println(str.isEmpty());
		
		/////////////////////////////////11-28-2018 split ��� �ڵ� �߰�///////////////////////////////////
		String data=
		"������, ������, ���ü�~������~�����.������,������,������.������";
		//split�� �ѹ��� �ϳ��� ���ڷ� �����Ͽ� �ڸ���.
		String[] arr=data.split("[.]");//.�� �׳� ���� ���� ���� �ʴ´�. []��� ����.
		System.out.println("���е� �迭 ���� ����: "+arr.length);
		for(String name: arr) {
			System.out.println(name);
		}
		
	}// main

}// class