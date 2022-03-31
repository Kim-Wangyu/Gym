const pw = document.getElementById("pw");
const pw2 = document.getElementById("pw2");
const pwResult = document.getElementById('pwResult');
const pwResult2 = document.getElementById('pwResult2');
const id=document.getElementById('id');
const idResult = document.getElementById('idResult');

const form=document.getElementById('form');
const btn = document.getElementById('btn');



//pw, pw2 check 후 pw를 수정했을때 pw2의 비밀번호 초기화
pw.addEventListener("change", function(){
    pwcheck=false;
    pw2.value="";
    pwResult2.innerHTML="";
    pw.focus();
})
//pw글자수 확인
pw.addEventListener("keyup",function(){
    let length=pw.value.length;
    let message ="잘못된 비밀번호 입니다.";

    if(length>=6&&length<=10){
        message="적합한 비밀번호 입니다."
    }
    pwResult.innerHTML=message;

})
//pw, pw2 비번 일치하는지 확인
let pwcheck=true;
pw2.addEventListener("blur",function(){
    let message="비밀번호가 일치 하지 않습니다."

    if(pw.value==pw2.value){
        message="비밀번호가 일치합니다."
        pwcheck=false;
        
    }else{
        pwcheck=true;
        pw2.value="";
    }
    pwResult2.innerHTML=message;
})

//join 버튼 클릭시 필수요소 확인
btn.addEventListener('click',function(){
    let check=true;
   
    if(id.value==""){
        alert("id를 입력하세요");
        id.focus();
        check=false;
       return;
    }
    if(pwcheck){
        alert("pw가 일치하지 않습니다.")
        pw.focus();
        check=false;
    }
    if(name.value==""){
        alert("이름을 입력하세요");
        name.focus();
        check=false;
    }
    if(phone.value==""){
        alert("전화번호를 입력하세요");
        phone.focus();
        check=false;
    }
    if(check){
        form.submit();
    }
})
