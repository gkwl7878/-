<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--smart menu시작  -->
 <!-- SmartMenus core CSS (required) -->
    <link href="http://localhost:8080/mybatis_prj/common/smartmenu/css/sm-core-css.css" rel="stylesheet" type="text/css" />
    <!-- "sm-blue" menu theme (optional, you can use your own CSS, too) -->
    <link href="http://localhost:8080/mybatis_prj/common/smartmenu/css/sm-simple/sm-simple.css" rel="stylesheet" type="text/css" />
    	    <!-- jQuery -->
	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> -->
    <!-- SmartMenus jQuery plugin -->
    <script type="text/javascript" src="http://localhost:8080/mybatis_prj/common/smartmenu/jquery.smartmenus.min.js"></script>

    <!-- SmartMenus jQuery init -->
    <script type="text/javascript">
    	$(function() {
    		$('#main-menu').smartmenus({
    			subMenusSubOffsetX: 1,
    			subMenusSubOffsetY: -8
    		});
    	});
    </script>
<!--smart menu끝  -->
	<nav id="main-nav">
      <!-- Sample menu definition -->
      <ul id="main-menu" class="sm sm-simple">
        <li><a href="#void">홈으로</a></li>
        <li><a href="#void">쿼리실행</a>
          <ul>
            <li><a href="#void">1일차</a>
              <ul>
                <li><a href="main.jsp?page=day0404/single_column">컬럼하나에 레코드 하나</a></li>
                <li><a href="main.jsp?page=day0404/multi_column">컬럼여러개에 레코드 하나</a></li>
                <li><a href="main.jsp?page=day0404/multi_row">컬럼하나에 레코드 여러개</a></li>
              </ul>
            </li>
            <li><a href="#void">2일차</a>
              <ul>
                <li><a href="main.jsp?page=day0405/multi_column_row">컬럼 여러개 레코드 여러개</a></li>
                <li><a href="main.jsp?page=day0405/multi_param">where절의 값이 여러개</a></li>
                <li><a href="main.jsp?page=day0405/lessThan">&lt; 의 비교</a></li>
                <li><a href="main.jsp?page=day0405/greaterThan">&gt; 의 비교</a></li>
                <li><a href="main.jsp?page=day0405/like">like 사용</a></li>
              </ul>
            </li>
            <li><a href="#void">3일차</a>
              <ul>
                <li><a href="main.jsp?page=day0408/subquery">서브쿼리</a></li>
                <li><a href="main.jsp?page=day0408/union">union</a></li>
                <li><a href="main.jsp?page=day0408/join">join</a></li>
              </ul>
            </li>
            <li><a href="#void">4일차</a>
              <ul>
                <li><a href="main.jsp?page=day0409/join_subquery">join_subquery</a></li>
                <li><a href="main.jsp?page=day0409/dynamic_table">테이블명이 동적일때</a></li>
                <li><a href="main.jsp?page=day0409/dynamic_if">dynamic if</a></li>
              </ul>
            </li>
            <li><a href="#void">5일차</a>
              <ul>
                <li><a href="main.jsp?page=day0410/dynamic_choose">dynamic choose</a></li>
                <li><a href="main.jsp?page=day0410/dynamic_foreach">dynamic foreach</a></li>
                <li><a href="main.jsp?page=day0410/insert_procedure">insert procedure</a></li>
              </ul>
            </li>
            <li><a href="#void">6일차</a>
              <ul>
                <li><a href="main.jsp?page=day0411/select_procedure">select procedure</a></li>
              </ul>
            </li>
          </ul>
        </li>
        <li><a href="main.jsp?page=day0409/homework">동기방식 차량조회</a></li>
        </ul>
     </nav>







