const btn = document.getElementById("btn");
const pw = document.getElementById("pw");
const pw2 = document.getElementById("pw2");
const pw3 = document.getElementById("pw3");
const bpw = document.getElementById("bpw");
const form=document.getElementById('form');
const pwResult = document.getElementById('pwResult');
const pwResult2 = document.getElementById('pwResult2');



//pw, pw2 check 후 pw를 수정했을때 pw2의 비밀번호 초기화
pw2.addEventListener("change", function(){
    pw.value="";
    pwResult.innerHTML="";
    pw2.focus();
})
//pw글자수 확인
pw2.addEventListener("keyup",function(){
    let length=pw2.value.length;
    let message ="잘못된 비밀번호 입니다.";

    if(length>=6&&length<=10){
        message="적합한 비밀번호 입니다."
    }
    pwResult2.innerHTML=message;

})
pw.addEventListener("keyup",function(){
    let pw2value=pw2.value;
    let message ="비밀번호가 일치하지 않습니다.";

    if(pw2.value==pw.value){
        message="비밀번호가 일치합니다."
    }
    pwResult.innerHTML=message;

})
btn.addEventListener("click", function(){
    console.log("click");

    if(pw1.value == bpw.value){
       if(pw2.value==pw.value){
            alert("수정 완료 성공")
            form.submit();
        }
        else{
            alert("비밀번호 다르다")
        }
    }
        
    else{
        alert("기존 비번 다르다")
    }
})
