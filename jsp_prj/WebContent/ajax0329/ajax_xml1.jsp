<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"  href="http://localhost:8080/jsp_prj/common/css/main_v190130.css">
<style type="text/css">
#wrap{ margin:0px auto; width:800px; height:860px; }
#header{  width:800px; height:140px; background: #FFFFFF url(http://localhost:8080/jsp_prj/common/images/header_bg.png) repeat-x;
			position: relative;	}
#headerTitle{ font-family: HT견고딕,고딕; font-size: 30px; font-weight: bold;text-align: center;
				position:absolute; top: 40px;left: 290px; }
#container{  width:800px; min-height:600px; }
#footer{  width:800px; height:120px; }
#footerTitle{ float: right;font-size: 15px; padding-top: 20px; padding-right: 20px }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#reqXml").click(function() {
			//xml을 직접 요청 (공공데이터 XML을 요청하여 응답 받는 것과 동일)
			//파라메터를 사용하지 않는다. : data를 사용하지 않는다.
			$.ajax({
				url:"../xml0326/dept.xml",
				type:"get",
				dataType: "xml",
				error: function(xhr) {
					alert(xhr.status+" / "+xhr.statusText);
				},
				success: function(xml) {
					//반복해야할 노드를 찾고
					var deptNodes=$(xml).find("dept")
					//찾은 노드를 반복 시킨다.
					if($("#tab tr").size()==1){
						$.each(deptNodes, function(idx,deptNode){
							//반복중인 노드의 값을 얻기
							//alert($(deptNode).find("loc").text());
							$("#tab:last").append("<tr><td>"+$(deptNode).find("deptno").text()
									+"</td><td>"+$(deptNode).find("dname").text()+"</td><td>"+$(deptNode).find("loc").text());
						});//each
					}//end if
				}//success
			});//ajax
		});//click
	});//ready
</script>
</head>
<body>
<div id="wrap">
	<div id="header">
	<div id="headerTitle">SIST Class4 </div>
	<div style="padding-top: 100px">
		<c:import url="../common/jsp/main_menu.jsp"/>
	</div>
	</div>
	<div id="container">
	<div>
		<a href="#void" id="reqXml">부서정보</a>
	</div>
	<div>
		<table border="1" id="tab">
			<tr>
				<th style="width: 80px">부서번호</th>
				<th style="width: 180px">부서명</th>
				<th style="width: 100px">부서위치</th>
			</tr>
		</table>
	</div>
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
	</div>
</div>
</body>
</html>








