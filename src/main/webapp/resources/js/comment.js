/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function loadSpinner(flag) {
    let els = document.getElementsByClassName("spinner");
    for (let d of els) 
        d.style.display = flag;
}

function loadComments(endpoint) {
    loadSpinner("block");
    fetch(endpoint).then(res => res.json()).then(data => {
        let msg = "";
        for (let d of data) {
            msg += `
                 <div class="card mb-4">
                    <div class="card-body">
                        <p>${d.content}</p>
                        <div class="d-flex justify-content-between">
                            <div class="d-flex flex-row align-items-center">
                                <img src=${d.user.avatar} alt="avatar" width="50"
                                     height="50" />
                                <p class="small mb-0 ms-2">Comment bởi ${d.user.username} lúc ${moment(d.created_date).locale("vi").fromNow()}</p>
                            </div>
                        </div>
                    </div>
                     <div class="d-flex flex-row align-items-center">
                      
                    </div>
                </div>
            `;
        }
        let el = document.getElementById("comments");
        el.innerHTML = msg;
        loadSpinner("none");
    });
}

function addComment(endpoint) {
    loadSpinner("block");
    fetch(endpoint, {
        method: "POST",
        body: JSON.stringify({
            "content": document.getElementById("content-comment").value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(res => {
        console.log(res.message)
        return res.json();
    }).then(d => {
        if(d.status !== 500){
            let el = document.getElementById("comments");
            el.innerHTML = `
                <div class="row bg-light m-1">
                    <div class="col-md-1 col-xs-3">
                        <h5>${d.user.firstName} ${d.user.lastName}</h5>
                    </div>
                    <div class="col-md-10 col-xs-9">
                        <p>${d.content}</p>
                        <p class="small mb-0 ms-2">Comment bởi ${d.user.username} lúc ${moment(d.created_date).locale("vi").fromNow()}</p>
                    </div>
                </div>
            ` + el.innerHTML;
            loadSpinner("none");
        }
    });
}

