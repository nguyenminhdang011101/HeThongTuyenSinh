<%-- 
    Document   : login
    Created on : Apr 15, 2023, 2:36:57 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-success">ĐĂNG KÝ NGƯỜI DÙNG</h1>
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>
<c:url value="/action-register" var="action" />
<section class="text-center">
    <div class="card mx-4 mx-md-5 shadow-5-strong" style="
        margin-top: 50px;
        background: hsla(0, 0%, 100%, 0.8);
        backdrop-filter: blur(30px);
        ">
        <div class="card-body py-5 px-md-5">

            <div class="row d-flex justify-content-center">
                <div class="col-lg-8">
                    <h2 class="fw-bold mb-5">Sign up now</h2>
                    <form method="post" action="${action}" modelAttribute="user" enctype="multipart/form-data">
                        <div class="row">
                            <div class="col-md-6 mb-4">
                                <div class="form-outline">
                                    <input type="text" class="form-control" id="firstName" placeholder="Họ" name="firstName">
                                </div>
                            </div>
                            <div class="col-md-6 mb-4">
                                <div class="form-outline">
                                    <input type="text" class="form-control" id="lastName" placeholder="Tên" name="lastName">
                                </div>
                            </div>
                        </div>
                        <div class="form-outline mb-4">
                            <input type="text" class="form-control" id="phone" placeholder="Số điện thoại" name="phone">
                        </div>
                        <div class="form-outline mb-4">
                            <input type="text" class="form-control" id="email" placeholder="Email" name="email">
                        </div>
                        <div class="form-outline mb-4">
                            <input type="text" class="form-control" id="username" placeholder="Tên đăng nhập" name="username">
                        </div>
                        <div class="form-outline mb-4">
                            <input type="password" class="form-control" id="pwd" placeholder="Mật khẩu" name="password">
                        </div>
                        <div class="form-outline mb-3 mt-3">
                            <form:label path="file">Chọn ảnh đại diện</form:label>
                            <input type="file" name="file" accept="image/png, image/jpeg"/>
                        </div>
                        <c:if test="${user.file != null && user.file != ''}">
                            <div class="form-floating mb-3 mt-3">
                                <img src="${user.file}" width="120" />
                            </div>
                        </c:if>
                        <input type="submit" value="Đăng ký" class="btn btn-danger" />
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
