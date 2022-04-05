const movePage = document.getElementById("movePage");
const beforeImage = document.getElementById("beforeImage");
const cli = document.getElementById("cli");
const cli1 = document.getElementById("cli1");


let num=0;
function changePic(idx){
   
       if(idx){
           if(num==7) num=0;
            num++;
        }else{
            if(num==-1)num=7;
            if(num==0) num=7;
            num--;

        }
    
    let imgTag = document.getElementById("photo");
    imgTag.setAttribute("src", "/s1/resources/images/img"+num+".jpg");
}

cli.addEventListener("click",function(){
    changePic(0);
})

cli1.addEventListener("click",function(){
    changePic(1);
})

