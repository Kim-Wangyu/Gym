
const replyBtn  = document.querySelector("#replyBtn");
const num = document.getElementById("num");
const contents = document.getElementById("contents");
const writer = document.getElementById("writer");
const replyResult = document.querySelector("#replyResult")


replyResult.addEventListener("click",function(event){
    if(event.target.classList.contains("del")){
        let replyNum = event.target.getAttribute("data-num");

        const xhttp4 = new XMLHttpRequest();

        xhttp4.open("POST","../noticeReply/delete");

        xhttp4.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
   
        xhttp4.send("replyNum="+replyNum);

        xhttp4.onreadystatechange=function(){
            if(this.readyState==4 && this.status==200){
                if(this.responseText.trim()=="1"){
                    alert("삭제성공");
                    getList();
                }else{
                    alert("삭제실패")
                }
            }
        }
   
    }

})



//----------------UPDATE

replyResult.addEventListener("click",function(event){
    if(event.target.classList.contains("update")){
        let num= event.target.getAttribute("data-index");
        console.log(num);

        let replyNum = document.querySelector("#up"+num);
        console.log(replyNum);

        let text  = replyNum.innerText;
        replyNum.innerText='';

        let tx= document.createElement("textarea");
        tx.setAttribute("id","update"+num);
        tx.classList.add("replyUp");
        tx.setAttribute("data-num",num);
        tx.value=text;

        console.log(tx);
        replyNum.append(tx);

    }
});



replyResult.addEventListener("change",function(event){
    if(event.target.classList.contains('replyUp')){
        let contents = event.target.value;
        let replyNum = event.target.getAttribute("data-num");
        console.log(contents);
        
        let check = window.confirm("수정 하시겠습니까");

        if(check){
            const xhttp3 = new XMLHttpRequest();

            xhttp3.open("POST","../noticeReply/update");

            xhttp3.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

            xhttp3.send("replyNum="+replyNum+"&contents="+contents);

            console.log("replyNum"+replyNum)
            xhttp3.onreadystatechange=function(){
                if(this.readyState==4&&this.status==200){
                    if(this.responseText.trim()=="1"){
                        alert("성공");
                        document.querySelector("#up"+replyNum).innerHTML=contents;
                    }else{
                        alert("수정실패")
                    }
                }
            }
        }
        

        
    
    }
})





getList();

function getList(){
    const xhttp2 =new XMLHttpRequest();

    xhttp2.open("GET","../noticeReply/list?num="+num.value);

    xhttp2.send();

    xhttp2.onreadystatechange = function(){
        if(this.readyState==4&&this.status==200){
        replyResult.innerHTML = this.responseText.trim();
        }
    }
}


replyBtn.addEventListener("click",function(event){
    console.log(num.value);
    console.log(contents.value);
    console.log(writer.value);
    
    
    const xhttp = new XMLHttpRequest();
    
    xhttp.open("POST","../noticeReply/add");
    
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    xhttp.send("num="+num.value+"&contents="+contents.value+"&writer="+writer.value);

    xhttp.onreadystatechange = function(){
        if(this.readyState==4 && this.status==200){

            console.log(this.responseText);

            let result = this.responseText.trim();
            if(result == '1'){
                alert("댓글 등록 성공")
                getList();
            }else{
                alert("댓글 등록 실패")
            }
        }
    }
    


})