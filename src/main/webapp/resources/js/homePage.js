const movePage = document.getElementById("movePage");
const beforeImage = document.getElementById("beforeImage");


let num=0;
function changePic(idx){
    if(idx){
        num++;
        if(num==7) num=0;
    }else{
        num--;
        if(num==0) num=7;

    }
    let imgTag = document.getElementById("photo");
    imgTag.setAttribute("src", "/s1/resources/images/img"+num+".jpg");
}