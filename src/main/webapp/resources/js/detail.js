const priceDiv = document.getElementById("priceDiv");
const detailForm = document.getElementById("detailForm");
const detailBtn =document.getElementById("detailBtn");
const trainerOption = document.getElementById("trainerOption");
const gradeOption = document.getElementsByClassName("gradeOption");

detailForm.addEventListener("change",function(event){
    if(event.target.classList.contains("gradeSelect")){
        for(g of gradeOption){
            if(g.selected){
                if(g.value==1){
                    priceDiv.innerHTML="";
                    priceDiv.innerText="가격 :";
                    let gradeInput = document.createElement("input");
                    gradeInput.setAttribute("name","price");
                    gradeInput.setAttribute("type","number");
                    gradeInput.setAttribute("value","0");
                    gradeInput.setAttribute("class","memberdetail");
                    gradeInput.setAttribute("style","font-size: larger;font-weight: bold;");
                    priceDiv.append(gradeInput);
                }else if(g.value==0){
                    priceDiv.innerHTML="";
                }
            } 
        }
    }
});

detailBtn.addEventListener("click",function(){
    detailForm.submit();
})


