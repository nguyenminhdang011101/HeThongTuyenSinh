<%-- 
    Document   : index
    Created on : 4 thg 5, 2023, 02:36:12
    Author     : LENOVO-E14
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chu</title>
    </head>
    <body>
        <header>
            <c:url value="/" var="action" />
                <form class="d-flex" action="${action}">
                    <input class="form-control me-2" type="text" name="kw" placeholder="Nhập tên...">
                    <button class="btn btn-primary" type="submit">Tìm</button>
                </form>
        </header>
        <h1>Ho Tro Tuyen Sinh</h1>
        <section class="container">
        <div class="row">
            <c:forEach items="${thongtintss}" var="p">
                <div class="col-md-3 col-xs-12" style="padding:1rem;">
                    <div class="card">
                        <img class="card-img-top" src="${p.banner}" width="500px" height="500px" alt="Card image">
                        <div class="card-body">
                            <h4 class="card-title">${p.tieude}ss</h4>
                            <p class="card-text">${p.noidung}...</p>
                            <a href="${detail}" class="btn btn-primary">Xem chi tiết</a>
                   
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </section>
    </body>
    
</html>
