<%@page import="java.io.File"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	/*
		파일 업로드 처리
	*/
	
	//  파일 업로드 경로 구하기
	String savedDirectory = application.getRealPath("/unload");
	System.out.println("savedDirectory : " + savedDirectory);

	// 파일 업로드 디렉토리가 없으면 생성하기
	File sfile = new File(savedDirectory);
	
	if(!sfile.exists()){
		sfile.mkdir();
	}
	
	// 첨부 파일 정보 구하기
	Part part = request.getPart("fname"); // Part는 업로드한 파일 정보객체
	String partHeader = part.getHeader("content-disposition");
	System.out.println("partHeader : " + partHeader); // form-data 로 출력
	
	String[] filenames = partHeader.split("filename=");
	String fileName = filenames[1].trim().replace("\"", "");
	System.out.println("fileName : " + fileName); // 첨부한 파일명 출력
	
	// 업로드한 파일 저장
	if(!fileName.isEmpty()){
		part.write(savedDirectory + File.separator + fileName);
	}
	
	// 폼 이동
	response.sendRedirect("../1_fileUpload.jsp");
%>