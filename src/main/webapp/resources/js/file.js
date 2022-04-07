const fileResult = document.getElementById('fileResult');
const fileAdd = document.getElementById("fileAdd");
const del = document.getElementsByClassName("del");


let i=0;

let num=0;   //id용도


fileAdd.addEventListener("click",function(){
    console.log("fileAdd Click");
    i=i+1;
    
    if(i<6){

        let div = document.createElement("div");    //div
        div.setAttribute("id", "del"+num);
        

    let data = document.createElement("input");
    data.setAttribute("type","file");
    data.setAttribute("name","files");

    let button = document.createElement("button");
    button.setAttribute("type","button");
    button.className="del";
    button.setAttribute("data-num","del"+num)
    button.innerHTML="DEL";

        div.append(data);
        div.append(button);

    fileResult.append(div);
    num++


    }else{
        alert("5개 이상 못만듬");
        i--;
    }
});
 
fileResult.addEventListener("click",function(event){
    
    let cn = event.target;
    i--;

    if(cn.classList.contains('del')){
       let delNum = cn.getAttribute("data-num");
       document.getElementById(delNum).remove();
    }
});



//----------------------------
const fileDeleteBtn = document.querySelectorAll(".fileDeleteBtn");
const files = document.querySelector("#files");

//각각의 fileNum을 console에 출력
files.addEventListener("click",function(event){
	if(event.target.classList.contains("fileDeleteBtn")){
	
		let check = confirm("삭제시 복구 불가능, 삭제할거임?");
		
		if(!check){
		return;
		}
	
		let fileNum = event.target.getAttribute("data-fileNum");
		console.log(fileNum);

	//ajax 파라미터 : fileNum, Method post, URL : fileDelete, Controller메서드명 : fileDelete
	
	
	let xhttp = new XMLHttpRequest();
	
	xhttp.open("POST","./fileDelete");
		
				//요청 header정보
   	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		
	xhttp.send("fileNum="+fileNum);
		

    
		xhttp.onreadystatechange=function(){
			if(this.readyState==4 && this.status==200){
				console.log(this.responseText);
				let result = this.responseText.trim();
			if(result=='1'){
				console.log("file 삭제");
				event.target.parentNode.remove();
			
				}else{

				}
				
			}
		}
	
	}

});


