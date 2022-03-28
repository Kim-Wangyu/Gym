const num =document .getElementById("num");
const writer =document .getElementById("writer");
const contents =document .getElementById("contents");
const reply =document .getElementById("reply");
const replyResult = document.getElementById("replyResult");



function getList(){
    const xhttps = new XMLHttpRequest();
    xhttps.open("get","../exerciseReply/list?num="+num.value);
    xhttps.send();
    xhttps.onreadystatechange=function(){
        if(this.readyState==4&&this.status==200){
            replyResult.innerHTML=this.responseText.trim();
        }
    }
}
getList();
reply.addEventListener("click",function(){
    //1. JS에서 요청 객체 생성(준비)
    const xhttps = new XMLHttpRequest();
    //요청 정보 입력
    //open('method형식', 'URL주소')
    xhttps.open("POST","../exerciseReply/add");
    //요청 header 정보 post
    xhttps.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    //요청 전송
    //post 요청시 파라미터
    //send("이름=값&이름2=값2...")
    xhttps.send("num="+num.value+"&writer="+writer.value+"&contents="+contents.value);
    //응답처리
    xhttps.onreadystatechange=function(){
        
        if(this.readyState==4 && this.status==200){
            let result ="1" ;
            if(result == this.responseText.trim()){
                alert("댓글 등록 완료");
                getList();
                contents.value="";//내용초기화
            }
        }
     }
   
})

replyResult.addEventListener("click",function(event){
    if(event.target.classList.contains("del")){
        let replyNum= event.target.getAttribute("data-num");
        const xhttps = new XMLHttpRequest();
        xhttps.open("POST","../exerciseReply/delete");
        xhttps.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttps.send("replyNum="+replyNum);
        xhttps.onreadystatechange=function(){
            if(this.readyState==4 && this.status==200){
                let result = "1";
                if(result==this.responseText.trim()){
                    alert("댓글삭제완료")
                    getList();
                }else{
                    alert("댓글삭제실패")
                }
            }
        }

    }
})

replyResult.addEventListener("click",function(event){
    if(event.target.classList.contains("update")){
        let num =  event.target.getAttribute("data-index");
        let replyNum = document.getElementById("up"+num);
        let text =  replyNum.innerText;
        replyNum.innerText='';
        let tx =  document.createElement('textarea');
        tx.setAttribute("id","update"+num);
        tx.classList.add("reply");
        tx.setAttribute("data-num",num);
        tx.value=text;
        replyNum.append(tx);
    }
})


replyResult.addEventListener("change",function(event){
    if(event.target.classList.contains("reply")) {  
    let contents = event.target.value;
    let replyNum=event.target.getAttribute("data-num");
    let check = window.confirm("수정하시겠습니까?");
    if(check){
        const xhttps =  new XMLHttpRequest();
        xhttps.open("POST","../exerciseReply/update");
        xhttps.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttps.send("replyNum="+replyNum+"&contents="+contents);
        xhttps.onreadystatechange=function(){
            if(this.readyState==4&&this.status==200){
                if(this.responseText.trim()=="1"){
                    alert("수정완료")
                    document.getElementById("up"+replyNum).innerHTML=contents;
                }else{
                    alert("수정실패");
                }
            }
        }

    }
    }
})

