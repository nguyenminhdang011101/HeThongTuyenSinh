<%-- 
    Document   : index
    Created on : 4 thg 5, 2023, 02:36:12
    Author     : LENOVO-E14
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>
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
                    <c:url value="/admin/add-livestream-action" var="action" />
                    <form method="post" action="${action}" modelAttribute="livestream" enctype="multipart/form-data">
                        <div class="col-md-6 mb-4">
                            <div class="form-outline">
                                <input type="text" class="form-control" id="name" placeholder="Tiêu đề" name="name">
                            </div>
                        </div>
                        <textarea class="form-control" rows="5" id="description" placeholder="Mô tả" name="description"></textarea>
                        <div class="form-outline mb-4">
                            <input type="text" class="form-control" id="phone" placeholder="Số điện thoại" name="phone">
                        </div>
                        <div class="row">
                            <form:label path="file">Chọn người đại diện</form:label>
                            <select name="username">
                                <option value="">Không ai</option>
                                <c:forEach items="${userList}" var="user">
                                    <option value="${user.key}">${user.value}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-outline mb-3 mt-3">
                            <form:label path="thumbnailFile">Chọn ảnh thumbnail</form:label>
                            <input type="file" name="thumbnailFile" accept="image/png, image/jpeg"/>
                        </div>
                        <div class="form-outline mb-3 mt-3">
                            <form:label path="videoFile">Chọn video</form:label>
                            <input type="file" name="videoFile" accept="video/*"/>
                        </div>
                        <input type="submit" value="Thêm" class="btn btn-danger" />
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
