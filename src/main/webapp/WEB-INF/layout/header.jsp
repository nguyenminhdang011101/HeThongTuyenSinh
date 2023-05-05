<%-- 
    Document   : headers
    Created on : Mar 11, 2023, 3:12:14 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="se" uri="http://www.springframework.org/security/tags"  %>

<header>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>
        {% if page.title %}{{ page.title | escape }} - {{ site.title | escape }}
        {% else %}{{ site.title | escape }}{% endif %}
    </title>

    <meta name="description" content="{{ page.excerpt | default: site.description | strip_html | normalize_whitespace | truncate: 160 | escape }}">

    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="{{"/assets/main.css" | relative_url }}">
    <link rel="canonical" href="{{ page.url | replace:'index.html','' | absolute_url }}">
    <link rel="alternate" type="application/rss+xml" title="{{ site.title | escape }}" href="{{ "/feed.xml" | relative_url }}">

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
                    <li class="nav-item">
                        <a class="nav-link text-info" href="<c:url value="/livestreams"/>"> Livestreams</a>
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
