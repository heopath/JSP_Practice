<%@page import="jakarta.servlet.jsp.tagext.Tag"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2_JSTLTest</title>
</head>
<body>
	<h3>2.JSTL(Java Standards Tag Library)</h3>
	
	<h4>스크립트릿 방식</h4>
		<%
			// 변수선언
			String str = "hello";
			out.print("<p>str : " + str + "</p>");
			
			// 조건문
			int num1 = 1;
			int num2 = 2;
			int num3 = 3;
			
			if(num1 < num2){
				out.println("<p>num1은 num2보다 작다.</p>");
			}
			
			if(num1 > num2){
				out.println("<p>num1은 num2보다 크다.</p>");
			}else{
				out.println("<p>num1은 num2보다 작다.</p>");
			}

			
			// 반복문
			for(int i=0; i<3; i++){
				out.print("<p>" + i + "</p>");
			}
			
			int sum = 0;
			for(int k=1; k<=10; k++){
				sum += k;
			}
			out.print("<p>1부터 10까지 합 : " + sum + "</p>");
			
			String[] cities = {"서울", "대전", "대구", "부산", "광주"};
			for(String city : cities){
				out.println("<p>city : " + city + "</p>");
			}
			
			// 문자열 처리
			String hello = "Hello World";
			
			out.println("<p>문자열 길이 : " + hello.length() + "</p>");
			out.println("<p>문자열 자르기 : " + hello.substring(1, 5) + "</p>");
			out.println("<p>문자열 교체 : " + hello.replace("World", "Korea") + "</p>");
			out.println("<p>문자열 길이 : " + hello.indexOf("l") + "</p>");
			
		%>
		
		<!-- 변수선언 -->
		<c:set var="str" value="hello"/>
		<p>str : %{str}</p>
		
		<!-- 조건문 -->
		<c:set var="num1" value="1"/>
		<c:set var="num2" value="2"/>
		<c:set var="num" value="3"/>
		
		<c:if test="${num1 lt num2}">
			<p>num1은 num2보다 작다.</p>
		</c:if>
		
		<c:choose>
			<c:when test="${num1 gt num2 }">
			</c:when>
			<c:otherwise>
				<p>num1은 num2보다 작다.</p>
			</c:otherwise>
		</c:choose>
		
		<c:choose>
			<c:when test="${num1 gt num2}">
				<p>num1은 num2보다 크다.</p>
			</c:when>
			<c:when test="${num2 gt num3}">
				<p>num2는 num3보다 크다.</p>
			</c:when>
			<c:otherwise>num3가 제일 크다.</c:otherwise>
		</c:choose>
		
		<!-- 반복문 -->
		<c:forEach var="i" begin="1" end="3">
			<p>i : ${i}</p> 
		</c:forEach>
		
		<c:set var="sum" value="0"/>
		<c:forEach var="k" begin="1" end="10">
			<c:set var="sum" value="${sum + k}"/>
		</c:forEach>
			<p>1부터 10까지의 합 : ${sum}</p>
			
		<c:set var="cities">서울,대전,대구,부산,광주</c:set>
		<c:forEach var="city" items="${cities}">
			<p>city : ${city}</p>
		</c:forEach>
		
		<!-- 문자열 처리 -->
		<c:set var="hello" value="Hello World"/>
		<p>문자열 길이 : ${f:length(hello)}</p>
		<p>문자열 자르기 : ${f:substring(hello, 1, 5)}</p>
		<p>문자열 교체 : ${f:replace(hello, "World", "Busan")}</p>
		<p>문자열 인덱스 : ${f:indexOf(hello,"l")}</p>
		
		
</body>
</html>