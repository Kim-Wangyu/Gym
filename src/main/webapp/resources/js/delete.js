const frm = document.getElementById('frm');
const del = document.getElementById('del');

//qna delete
del.addEventListener("click",function(){
    console.log("SSS");
    frm.setAttribute("action","./delete");
    frm.submit();
})
