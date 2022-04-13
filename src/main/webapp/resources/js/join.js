const pw = document.getElementById("pw");
const pw2 = document.getElementById("pw2");
const pwResult = document.getElementById('pwResult');
const pwResult2 = document.getElementById('pwResult2');
const id=document.getElementById('id');
const idResult = document.getElementById('idResult');
const file = document.getElementById('file');
const name1 = document.getElementById('name1');

const form=document.getElementById('form');
const btn = document.getElementById('btn');

let idcheck=true;
let pwcheck=false;
let namecheck=true;
let phonecheck=true;
let filecheck=true;

//pw글자수 확인
pw.addEventListener("keyup",function(){
    let length=pw.value.length;
    let message ="잘못된 비밀번호 입니다.";
  
    if(length>=6&&length<=10){
        message="적합한 비밀번호 입니다.";
        pwcheck=true;
    }
    pwResult.innerHTML=message;
})
//pw, pw2 비번 일치하는지 확인
let check=true;
pw2.addEventListener("blur",function(){
    let message="비밀번호가 일치 하지 않습니다.";

    if(pw.value==pw2.value){
        message="비밀번호가 일치합니다.";
        check=false;
        
    }else{
        check=true;
        pw2.value="";
    }
    pwResult2.innerHTML=message;

})
//pw, pw2 check 후 pw를 수정했을때 pw2의 비밀번호 초기화
pw.addEventListener("change", function(){
    check=false;
    pw2.value="";
    pwResult2.innerHTML="";
    pw.focus();
})
file.addEventListener("change",function(){
    filecheck=true;
})
//join 버튼 클릭시 필수요소 확인
btn.addEventListener('click',function(){
    
    if(id.value==""){
        alert("id를 입력하세요");
        id.focus();
        idcheck=false;
       return;
    }

    if(check){
        alert("pw가 일치하지 않습니다.")
        pw.focus();
        pwcheck=false;
        return;
    }
    if(name1.value==""){
        alert("이름을 입력하세요");
        name.focus();
        namecheck=false;
        return;
    }
    if(phone.value==""){
        alert("전화번호를 입력하세요");
        phone.focus();
        phonecheck=false;
        return;
    }
    if(file.value==""){
        alert("file 넣으세요");
        file.focus();
        filecheck=false;
        return;
    }
    if(idcheck&&pwcheck&&namecheck&&phonecheck&&filecheck){
        form.submit();
    }else{
        alert("조건을 확인하세요");
    }
})