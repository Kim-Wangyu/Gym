const reply = document.getElementById("reply");
const replyBtn  = document.querySelector("#replyBtn");
const num = document.getElementById("num");
const contents = document.getElementById("contents");
const writer = document.getElementById("writer");
const replyResult = document.querySelector("#replyResult")



replyResult.addEventListener("change",function(event){
    if(event.target.classList.contains('reply')){
        let contents = event.target.value;
        

        
    
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