const upgrade =document.getElementById("list");
const frm = document.getElementById("frm");


upgrade.addEventListener("click",function(){
    frm.setAttribute("action","./list");
    frm.submit();    
})


