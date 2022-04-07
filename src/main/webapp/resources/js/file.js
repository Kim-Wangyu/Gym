const fileResult = document.getElementById('fileResult');
const fileAdd = document.getElementById('fileAdd');
const del = document.getElementsByClassName("del");

let count =0;
let num=0;//멤버id 전용

fileAdd.addEventListener("click",function(){
    count++;
    if(count>5){
        alert("파일 5개까지 등록가능");
        count =5;
        return;
    }
    let div = document.createElement('div');    //<div></div>
    div.setAttribute("id", "del" + num);    


    let file = document.createElement("input"); //<input>
    file.setAttribute("type", "file");          //<input type="file">
    file.setAttribute("name", "files");         ///<input type="file" name="files">

    let btn = document.createElement("button");
    btn.setAttribute("type", "button");
    btn.className = "del"
    btn.setAttribute("data-num", "del" + num)
    btn.innerHTML = "DEL";

    div.append(file);
    div.append(btn);

    fileResult.append(div);

    num++;
});
//--------------------------------------------------------------------

fileResult.addEventListener("click", function(event) {

    let cn = event.target;

    if (cn.classList.contains('del')) {
        let delNum = cn.getAttribute("data-num");
        document.getElementById(delNum).remove();
        count--;
    }
})

//---------------------------------------------------------------------
const fileDelteBtn = document.querySelectorAll(".fileDelteBtn");
const files = document.querySelector("#files");

//각각의 fileNum을 console에 출력
files.addEventListener("click", function (event) {
    if (event.target.classList.contains("fileDeleteBtn")); {
        let check = confirm("삭제시 복구 불가능 삭제??");
        if(!check){
            return ;
        }

        let fileNum = event.target.getAttribute("data-fileNum");

        //ajax 이용
        let xhttp = new XMLHttpRequest();

        xhttp.open("POST", "./deleteFile")

        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        xhttp.send("fileNum=" + fileNum);

        //응답처리
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                console.log(this.responseText);
                let result = this.responseText.trim();
                if (result == '1') {
                    console.log("file 삭제");
                    event.target.parentNode.remove();
                } else {
                  
                }
            }
        }
    }

});