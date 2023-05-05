<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info">LIVESTREAM</h1>

<!-- 16:9 aspect ratio -->
<div class="d-flex justify-content-center embed-responsive embed-responsive-16by9 ">
    <iframe class="embed-responsive-item"
            width="1440"
            height="900" src="${livestream.video}" title="${livestream.name}"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
</div>
<br>${livestream.description}
<br>${livestream.name}
<c:url value="/api/livestream-page/${livestream.id}/comments" var="url" />
<div class="spinner-grow text-primary spinner"></div>

<div class="row d-flex justify-content-center">
    <div class="col-md-8 col-lg-6">
        <div class="card shadow-0 border" style="background-color: #f0f2f5;">
            <div class="card-body p-4">
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        <div class="d-flex">
                            <div class="form-outline flex-grow-1">
                                <input type="text" id="content-comment" class="form-control" placeholder="Type comment..." />
                            </div>
                            <input class="p-2" type="button" value="Them binh luan" onclick="addComment('${url}')"/>
                        </div>
                    </c:when>
                </c:choose>
            </div>
            <div id="comments" class="card-body p-4">
              
            </div>
        </div>
    </div>
</div>


<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>

<script src="<c:url value="/js/comment.js" />"></script>
<script>
    window.onload = function() {
        loadComments('${url}');
    };
</script>
