const pw = document.getElementById("pw");
const pw2 = document.getElementById("pw2");
const pwResult = document.getElementById('pwResult');
const pwResult2 = document.getElementById('pwResult2');
const id=document.getElementById('id');
const idResult = document.getElementById('idResult');
const file = document.getElementById('file');
const name = document.getElementById("name");
const phone = document.getElementById("phone");


const form=document.getElementById('form');
const btn = document.getElementById('btn');

let idcheck=false;
let pwcheck=false;
let namecheck=false;
let phonecheck=false;
let filecheck=false;
id.addEventListener("blur",function(){
    if(id.value!=""){
        idcheck=true;
    }else {
        idcheck=false;
        alert('id를 입력하세요');
        id.focus();
    }
});
name.addEventListener("blur",function(){
    if(name.value!=""){
        namecheck=true;
    }else {
        namecheck=false;
        alert('이름을 입력하세요');
        name.focus();
    }
});
phone.addEventListener("blur",function(){
    if(phone.value!=""){
        phonecheck=true;
    }else {
        phonecheck=false;
        alert('핸드폰번호를 입력하세요');
        phone.focus();
    }
});
file.addEventListener("blur",function(){
    if(file.value!=""){
        filecheck=true;
    }else {
        alert('사진을 등록하세요');
        filecheck=false;
    }
});


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


//join 버튼 클릭시 필수요소 확인
btn.addEventListener('click',function(){
    
    if(idcheck&&pwcheck&&namecheck&&phonecheck&&filecheck){
        form.submit();
    }else{
        console.log(idcheck);
        console.log(pwcheck);
        console.log(namecheck);
        console.log(phonecheck);
        console.log(filecheck);
        alert("조건을 확인하세요");
    }

})
