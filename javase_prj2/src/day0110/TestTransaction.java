package day0110;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnetion;

/**
 * Transaction 처리 
 * @author owner
 */
public class TestTransaction {
	//Commit과 rollback을 DB작업 외부에서 처리할 수 있도록 class field 정의.
	private Connection con = null;

	public boolean insert(TransactionVO tv)throws SQLException {
		//transaction에 사용할 쿼리의 수만큼 쿼리실행객체 선언.
		
		boolean flag = false;
		
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		
		try {
		//1
		//2
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass ="tiger";
			
			con = GetConnetion.getInstance().getConn(url, id, pass);
			//auto commit 해제
			con.setAutoCommit(false);
			
			//3
			String sql = "insert into test_transaction1(subject,writer)values(?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tv.getSubject());
			pstmt.setString(2, tv.getWriter());
			//4
			int cnt = pstmt.executeUpdate();
			//---------------------------------------------------------------------------
			//3
			String sql1 = "insert into test_transaction2(subject,writer)values(?,?)";
			pstmt1 = con.prepareStatement(sql1);
			pstmt1.setString(1, tv.getSubject());
			pstmt1.setString(2, tv.getWriter());			
			//4
			int cnt1 = pstmt1.executeUpdate();
			
			//트랜잭션에 해당하는 모든 쿼리의 목표수행수를 비교하여 
			//commit 과 rollback 여부를 설정한다.
			if(cnt==1&&cnt1==1) {
				flag = true;
			}//end else
		//5
		}finally {
			//6
		}//end catch
		return flag;		
	}//insert
	
	public void add() {
		String inputData = 
		JOptionPane.showInputDialog("제목과 작성자를 입력해주세요.\n 제목-작성자");
		
		String[] data= inputData.split("-");
		
		if(data.length!=2) {
			JOptionPane.showMessageDialog(null,"입력형식을 확인해주세요.");
			
			return;
		}//end if
		TransactionVO tv =new TransactionVO(data[0],data[1]);
		
		try {
			//DB 업무를 사용하는 곳에서 수행 결과를 받아 호출한 곳에서 
			boolean flag = insert(tv);
			if(flag) {
				//커밋하거나
				con.commit();
				System.out.println("커밋!! ");
			}else {//update나 delete가 transaction 일 때 
				//롤백한다.
				con.rollback();
				System.out.println("update나 delete롤백!!");
			}//end else
	
		} catch (SQLException e) {
			try {
				con.rollback();
				System.out.println("insert롤백!!");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}//end catch
		}
		
		
	}//add
	
	public static void main(String[] args) {
		TestTransaction tt = new TestTransaction();
		tt.add();
	}//main

}//class
