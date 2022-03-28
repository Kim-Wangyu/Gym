const del = document.getElementById("del");
const frm = document.getElementById("frm");

del.addEventListener("click",function(){
    frm.setAttribute("action","./delete");
    frm.submit();
})

//ajax
// del.addEventListener("click",function(event){
//     let result = false;
//     const dataNum= del.getAttribute("data-num");
//     const xhttps = new XMLHttpRequest();
//     xhttps.open("POST","../exercise/delete");
//     xhttps.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//     xhttps.send("num="+dataNum);
//     xhttps.onreadystatechange=function(){
//         if(this.readyState==4&&this.status==200){
//             console.log("1");
//             result=ture;
//         }
//     }
//     if(result){
//         location.href="./list";
//     }
    
// })
