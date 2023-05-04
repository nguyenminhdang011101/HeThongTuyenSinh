<%-- 
    Document   : index
    Created on : 4 thg 5, 2023, 02:36:12
    Author     : LENOVO-E14
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>

</header>
<h1>Thêm livestream video</h1>
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
                    <c:url value="/admin/add-livestream-acion" var="action" />
                    <form method="post" action="${action}" modelAttribute="livestream" enctype="multipart/form-data">
                        <div class="row">
                            <div class="col-md-6 mb-4">
                                <div class="form-outline">
                                    <input type="text" class="form-control" id="name" placeholder="Tiêu đề" name="name">
                                </div>
                            </div>
                            <div class="col-md-6 mb-4">
                                <div class="form-outline">
                                    <input type="text" class="form-control" id="description" placeholder="Tên" name="description">
                                </div>
                            </div>
                        </div>
                        <div class="form-outline mb-4">
                            <input type="text" class="form-control" id="phone" placeholder="Số điện thoại" name="phone">
                        </div>
                        <td><form:label path = "userID">Người Phụ trách</form:label></td>
                        <td class="form-outline mb-4">
                            <form:select path = "userID" class="form-outline mb-4">
                                <form:option class="form-outline mb-4" value = "" label = "Trống"/>
                                <form:options class="form-outline mb-4" items = "${userList}" />
                            </form:select>
                        </td>
                        <div class="form-outline mb-3 mt-3">
                            <form:label path="file">Chọn ảnh đại diện</form:label>
                            <input type="file" name="file" accept="image/png, image/jpeg"/>
                        </div>
                        <c:if test="${user.file != null && user.file != ''}">
                            <div class="form-floating mb-3 mt-3">
                                <img src="${user.file}" width="120" />
                            </div>
                        </c:if>
                        <input type="submit" value="Thêm" class="btn btn-danger" />
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
