<%-- 
    Document   : products
    Created on : Mar 18, 2023, 1:45:57 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-info text-center">Danh sách livestream</h1>
<section class="container">
    <div class="row">
        <c:forEach items="${livestreams}" var="p">
            <c:url value="/livestream/${p.id}" var="detail" />
            <a  href="${detail}">
                <div class="col-md-10 col-xs-3 " style="padding:1rem;">
                    <div class="card">
                        <img class="card-img-top"src="${p.thumbnail}" alt="Card image" >
                        <h4 class="card-title">${p.name}</h4>
                    </div>
                </div>
            </a>

        </c:forEach>
    </div>
</section>