package day0109;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnetion;

/**
 * 컬럼명이 동적으로 변경되는 경우<br>
 * 컬럼명을 입력받아 해당 컬럼명으로 조회<br>
 * EMP테이블 조회 사원번호와 컬럼명을 입력받아 조회
 * @author owner
 */
public class DynamicColumn {
	public DynamicColumn() throws SQLException {
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		String[] columnName= {"ename","job","mgr","hiredate","sal","comm","deptno"};
		
		String input = JOptionPane.showInputDialog("사원번호와 컬럼명 하나를 입력해주세요.");
		String[] temp = input.split(",");
		
		if(temp.length!=2) {
			JOptionPane.showMessageDialog(null,"입력형식을 확인하세요.");
			return;
		}//end if
		
		try {
		int empno = Integer.parseInt(temp[0].trim());
		String inputColumn = temp[1].trim();
		
		boolean columnFlag = false;
		for(String column:columnName) {
			if(column.equals(inputColumn.toLowerCase())) { //DB테이블의 컬럼명과 같은 컬럼명이라면
				columnFlag = true;
			}//end if
		}//end for
		if(!columnFlag) {
			JOptionPane.showMessageDialog(null, inputColumn+"은 EMP테이블에 컬럼으로 존재하지 않습니다.");
			return;
		}//end if
		
		try {
		//1.
		//2.
			String url ="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id = "scott";
			String pass="tiger";
			con=GetConnetion.getInstance().getConn(url, id, pass);
		//3.
			//컬럼명이 hiredate인경우 문자열로 처리하기 위해 to_char 함수 사용.
			if(inputColumn.equals("hiredate")) {
				inputColumn = "to_char(hiredate,'yyyy-mm-dd day hh24:mi:ss') hiredate";
			}//end if
			
			StringBuilder selectEmp=new StringBuilder();
			//컬럼명, 테이블명은 bind변수로 처리되지 않는다. 쿼리문에 직접 넣어 사용한다.
			selectEmp.append("select ").append(inputColumn).append(" from emp ")
			.append(" where empno =? ");
			
			pstmt= con.prepareStatement(selectEmp.toString());
		//4.
			pstmt.setInt(1, empno);
		//5.
			rs= pstmt.executeQuery();
			
			if(rs.next()) { //사원번호로 조회된 레코드가 존재
				String stringData="";
				int intData=0;
				if(temp[1].trim().equals("ename")|| temp[1].trim().equals("job")||
						temp[1].trim().equals("hiredate")){
					stringData=rs.getString(temp[1].trim());	
				}else {
					intData= rs.getInt(temp[1].trim());
				}//end else
				System.out.println(temp[1]+"으로 조회된 값:  "+(intData ==0? stringData:intData));
			}else {
				JOptionPane.showMessageDialog(null, "입력한 사원번호는 존재하지 않습니다.");
			}
			
			
		}finally {
			//6.
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "사원번호는 숫자여야합니다.");
		}
		
		
	}//DynamicColumn
	public static void main(String[] args) {
		try {
			new DynamicColumn();
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}

}
