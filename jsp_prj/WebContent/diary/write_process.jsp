<%@page import="java.sql.SQLException"%>
<%@page import="kr.co.sist.diary.dao.DiaryDAO"%>
<%@page import="kr.co.sist.util.ShaUtil"%>
<%@page import="kr.co.sist.util.HangulConv"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    %>
    
<jsp:useBean id="d_vo" class="kr.co.sist.diary.vo.DiaryVO" scope="page"/>
<jsp:setProperty name="d_vo" property="*"/>
<jsp:setProperty name="d_vo" property="ip" value="<%=request.getRemoteAddr() %>"/>
<script type="text/javascript">

$(window).load(function() {
	
<%
	d_vo.setPass(ShaUtil.shaEncoding(d_vo.getPass()));
	Boolean flag=(Boolean)session.getAttribute("writeFlag");
	if(flag!=null&&!flag){
		DiaryDAO d_dao= DiaryDAO.getInstance();
		try{
			d_dao.insertEvent(d_vo);
			session.setAttribute("writeFlag", true);
			%>
			alert("이벤트가 정상적으로 등록 되었습니다.");
			location.href="diary.jsp?param_year=${param.param_year}&param_month=${param.param_month}";
			<%
		}catch(SQLException se){
			%>
			alert("죄송합니다! 이벤트가 정상적으로 등록되지 않았습니다.");
			<%
			se.printStackTrace();
		}
	}
%>
});//ready

</script>


