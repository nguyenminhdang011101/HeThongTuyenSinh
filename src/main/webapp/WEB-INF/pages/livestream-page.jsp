<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info">LIVESTREAM</h1>

<!-- 16:9 aspect ratio -->
<div class="d-flex justify-content-center embed-responsive embed-responsive-16by9 ">
    <iframe class="embed-responsive-item"
            width="1440"
            height="900" src="https://www.youtube.com/embed/OYXBigPJI_c" title="YouTube video player"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
</div>

<c:url value="/api/products/livestream/comments" var="url" />
<div>
    <textarea class="form-control" rows="5" id="content-comment" name="content"></textarea>
    <input type="button" value="Them binh luan" onclick="addComment('${url}')" class="btn btn-danger m-1" />
</div>

<div class="spinner-grow text-primary spinner"></div>

<div class="row d-flex justify-content-center">
    <div class="col-md-8 col-lg-6">
        <div class="card shadow-0 border" style="background-color: #f0f2f5;">
            <div class="card-body p-4">
                <div class="d-flex">
                    <div class="form-outline flex-grow-1">
                        <input type="text" id="addANote" class="form-control" placeholder="Type comment..." />
                    </div>
                    <input class="p-2" type="button" value="Them binh luan" onclick="addComment('${url}')"/>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="comments" class="card-body p-4">
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>

<script src="<c:url value="/js/comment.js" />"></script>
<script>
    window.onload = function() {
        loadComments('${url}');
    };
</script>
