const num = document.querySelector('#num');
const writer =  document.querySelector('#writer');
const contents =  document.querySelector('#contents');
const reply = document.querySelector('#reply');
const replyResult = document.querySelector('#replyResult');

//update
replyResult.addEventListener("click",function(event){
    if(event.target.classList.contains('update')){
        let num=event.target.getAttribute('data-index');
        let replyNum = document.getElementById("up"+num);

        let text=replyNum.innerText;
        
        replyNum.innerText="";

        let uptext = document.createElement("textarea");
        uptext.setAttribute("id","update"+num);
        uptext.classList.add("reply");
        uptext.setAttribute("data-num",num);
        uptext.value=text;
        replyNum.append(uptext);
    }
})
replyResult.addEventListener("change",function(event){
    if(event.target.classList.contains("reply")){
        let contents = event.target.value;
        let replyNum = event.target.getAttribute("data-num");

        let check = window.confirm("수정하시겠습니까?");
        if(check){
            const xhttp = new XMLHttpRequest();
            xhttp.open("POST","../qnaReply/update");
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttp.send("replyNum=" + replyNum+"&contents="+contents);
            xhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    if (this.responseText.trim() == '1') {
                        alert("UPDATE 성공")
                        document.getElementById("up"+replyNum).innerHTML=contents;
                    } else {
                        alert('UPDATE 실패')
                    }
                }
            }
        }
    }
})

//delete
replyResult.addEventListener('click', function(event){
    if(event.target.classList.contains('del')){

        let replyNum = event.target.getAttribute("data-num");

        const xhttp = new XMLHttpRequest();

        xhttp.open("POST","../qnaReply/delete");
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("replyNum="+replyNum);

        xhttp.onreadystatechange = function(){
            if(this.readyState ==4&&this.status==200){
                let res = this.responseText.trim();
                if(res == '1'){
                    alert('delete 성공');
                    getList();
                   
                }else{
                    alert('delete 실패');
                }
            }
        }
    }

})

//list
function getList(){
    const xhttpp = new XMLHttpRequest();
	console.log("list");
    xhttpp.open("GET", "../qnaReply/list?num="+num.value);
    xhttpp.send();
    xhttpp.onreadystatechange = function(){
        if(this.readyState==4&&this.status==200){
            replyResult.innerHTML= this.responseText.trim();
        }
    }
}

getList();

//add
reply.addEventListener("click", function(){
    console.log("click");

    //js에서 요청 객체 생성
    const xhttp = new XMLHttpRequest();
    //요청 정보입력
    xhttp.open("POST", "../qnaReply/add");
    //요청 헤더 정보
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    //요청전송
    xhttp.send("num=" + num.value + "&writer=" + writer.value + "&contents=" + contents.value);
    //응답처리
    xhttp.onreadystatechange = function(){
        if(this.readyState ==4&&this.status==200){
            let res = this.responseText.trim();
            if(res == '1'){
                alert('댓글 등록 성공');
                getList();
                contains.value="";
            }else{
                alert('댓글 등록 실패');
            }
        }
    }

});