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
		$("#group").change(function() {
			var name=$("#group").val();	
			if(name!= "none"){
				var queryString="name="+encodeURI( name );
				$.ajax({
					url:"html_result.jsp",
					type: "get",
					data: queryString,
					dataType: "html",
					error: function(xhr) {
						$("#memberView").html("<img src='../common/images/img.png'/>");
						for(var i=0; i<3; i++){
							$("#memberView").fadeOut(1000).fadeIn(2000);
						}//end for
					},
					success: function( html_data ) {
						
						$("#memberView").html(html_data);
					}//success
				});//ajax
			}//end if
		});//change
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
	<div >
		<select id="group">
			<option value="none">===조 선택===</option>
			<option value="이봉현">1조</option>
			<option value="박영민">2조</option>
			<option value="오영근">3조</option>
			<option value="김건하">조기취업</option>
		</select>
	</div>
	<div id="memberView"></div>
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
	</div>
</div>
</body>
</html>








