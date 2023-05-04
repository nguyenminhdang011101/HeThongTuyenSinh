<%-- 
    Document   : headers
    Created on : Mar 11, 2023, 3:12:14 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="se" uri="http://www.springframework.org/security/tags"  %>

<header>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">HỔ TRỢ TUYỂN SINH</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <c:url value="/" var="action" />
            <form class="d-flex" action="${action}">
                <input class="form-control me-2" type="text" name="kw" placeholder="Nhập tên...">
                <button class="btn btn-primary" type="submit">Tìm</button>
            </form>
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <c:url value="/" var="action" />
                        <a class="nav-link" href="${action}">Trang chủ</a>
                    </li>
                    <c:forEach items="${categories}" var="c">
                        <c:url value="/" var="url">
                            <c:param name="categoryId" value="${c.id}" />
                        </c:url>
                        <li class="nav-item">
                            <a class="nav-link" href="${url}">${c.name}</a>
                        </li>
                    </c:forEach>
                    <li class="nav-item">
                        <a class="nav-link text-info" href="<c:url value="/livestream" />">&#128722; Livestream</a>
                    </li>

                    <c:choose>
                        <c:when test="${pageContext.request.userPrincipal.name == null}">
                            <li class="nav-item">
                                <a class="nav-link text-danger" href="<c:url value="/login" />">Đăng nhập</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-danger" href="<c:url value="/register" />">Đăng ký</a>
                            </li>
                        </c:when>
                        <c:when test="${pageContext.request.userPrincipal.name != null}">
                            <li class="nav-item">
                                <a class="nav-link text-danger" href="<c:url value="/" />">Chào ${pageContext.session.getAttribute("currentUser").firstName} ${pageContext.session.getAttribute("currentUser").lastName}!</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-success" href="<c:url value="/logout" />">Đăng xuất</a>
                            </li>
                        </c:when>
                    </c:choose>
                    <se:authorize access="hasRole('ROLE_ADMIN')">
                        <li class="nav-item m-1">
                             <a class="btn btn-success" href="<c:url value="/admin/add-livestream" />">Thêm livestream</a>
                        </li>
                    </se:authorize>
                </ul>
                <c:url value="/" var="action" />
                <form class="d-flex" action="${action}">
                    <input class="form-control me-2" type="text" name="kw" placeholder="Nhập tên...">
                    <button class="btn btn-primary" type="submit">Tìm</button>
                </form>
            </div>
        </div>
    </nav>
</header>
