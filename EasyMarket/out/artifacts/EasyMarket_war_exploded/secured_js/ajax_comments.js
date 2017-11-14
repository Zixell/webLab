function addComment(content) {
for(var i=0; i< Object.keys(content).length; i++) {
    var divToInsert = document.createElement("div");
    var spanToInsert1 = document.createElement("span");
    var spanToInsert2 = document.createElement("span");

    spanToInsert1.className = "text_1";
    spanToInsert1.innerHTML = content[i][0];
    spanToInsert2.innerHTML = content[i][1];
    divToInsert.style.fontFamily = "'Courier New', monospace;"
    divToInsert.style.background = "#ffffff;" /* Цвет фона */
    divToInsert.style.boxShadow= "0 0 10px #000000;" /* Параметры тени */
    divToInsert.style.height = "50px";
    divToInsert.style.backgroundColor = '#ffffff';
    divToInsert.style.border = "1px solid black";

    divToInsert.style.margin = "10px";
    divToInsert.style.padding = "10px";
    divToInsert.style.marginRight = "300px";
    spanToInsert2.style.float ="right";
    divToInsert.appendChild(spanToInsert1);
    divToInsert.appendChild(spanToInsert2);
    document.getElementById("latest_comments_insert").appendChild(divToInsert);

}
}


function ajaxPOST(extra_value) {
    var params = "params="+document.getElementById("comment_text_area").value+extra_value;

    //var f = callback || function (data) {};
   // alert("!hello ");
    var request = new XMLHttpRequest();
    var url = "/CommentHandler";
    request.onreadystatechange = function () {
        if (request.readyState == 4 && request.status == 200) {
            var responseData = JSON.parse(request.response);
           addComment(responseData);

        }
    };
    request.open("post", url);
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.send(params);
}

function basicInfo() {

}

window.onload = ajaxPOST("&all=all");