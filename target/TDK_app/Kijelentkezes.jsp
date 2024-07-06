<%-- 
    Document   : Kijelentkezes
    Created on : Jul 6, 2024, 8:21:52 AM
    Author     : misim
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    session.invalidate(); // Érvényteleníti a munkamenetet
    response.sendRedirect("Hirek.jsp"); // Átirányítja a felhasználót a kezdőlapra vagy egy bejelentkezési oldalra
%>
