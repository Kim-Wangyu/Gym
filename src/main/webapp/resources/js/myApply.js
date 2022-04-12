const myApplyDiv = document.getElementById("myApplyDiv");


myApplyDiv.addEventListener("click",function(event){
    if(event.target.classList.contains("ApplyDelBtn")){
      let applyDelConfirm = confirm("삭제하시겠습니까?");
      if(applyDelConfirm){
         const xhttps = new XMLHttpRequest();
         xhttps.open("POST","../apply/delApply");
         xhttps.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
         xhttps.send("applyNum="+event.target.getAttribute("data-num"));
         xhttps.onreadystatechange=function(){
            if(this.readyState==4 && this.status==200){
                event.target.parentNode.parentNode.remove();
                document.getElementById(event.target.getAttribute("data-index")).remove();
            }
         }
      }  
        
    }

    if(event.target.classList.contains("StudyDelBtn")){
      let studyDelConfirm = confirm("삭제하시겠습니까?");
      if(studyDelConfirm){
         const xhttps = new XMLHttpRequest();
         xhttps.open("POST","../apply/delStudy");
         xhttps.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
         xhttps.send("applyNum="+event.target.getAttribute("data-num"));
         xhttps.onreadystatechange=function(){
            if(this.readyState==4 && this.status==200){
             event.target.parentNode.parentNode.remove();
             document.getElementById(event.target.getAttribute("data-index1")).remove();
            }
         }
      }

   }
   
})



