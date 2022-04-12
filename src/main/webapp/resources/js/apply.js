const applyDiv = document.getElementById("applyDiv");
const selectName = document.getElementById("selectName");
//날짜를 클릭했을때----------------------------------------------------------------------------------------
//전송하면 1. 선택한 운동, 2.날짜 3.시간 4.회원아이디 전송 
//date 전송해서 pt선생이 갖고잇는 시간에 멤버가 신청한 시간이 들어가고 pt선생이 가지고 있는 시간은 한정적이라 그게 다 빠지면 화면에 반영되고 
//pt선생이 21일에 4타임 10~11(member-12) 11~12 14~15 15~16
//버튼 눌럿을때 신청하시겟습니까? 신청완료
//1,2,3,4,5
//trainer 각 날마다 1~8 and 1~8에 각각 한명의 멤버만 연결되야 하고 and 1~8에 한명이 연결되면 calendar페이지에서 빗금처리라던가 이런처리 and 데이터베이스에 저장되어야하고 
//1 = 9~10 2= 10~11 3= 11~12 4= 12~13 5=13~14 6= 14~15 7= 15~16  8= 16~17 
function getTime(){
    const xhttp1 =new XMLHttpRequest();
    const day = document.getElementById("day");
    const memberNum = document.getElementsByClassName("optionName");
    for(m of memberNum){
        if(m.selected){
            xhttp1.open("GET","../apply/getTime?day="+day.value+"&memberNum="+m.value);
        }
    }
    xhttp1.send();
    xhttp1.onreadystatechange = function(){
        if(this.readyState==4&&this.status==200){
        document.getElementById("time").innerHTML = this.responseText.trim();
        }
    }
}

let day=document.createElement("input");
let addDiv = document.createElement("div");

tb_body.addEventListener("click",function(event){

    //form태그 생성
    let form = document.createElement("form");//<form></form>
    form.setAttribute("method","post");//<form action="./calendar" method="post"></form>


    //select 시간 만들기
    let time = document.createElement("select");
    time.setAttribute("id","time");
    time.setAttribute("style","width:130px;display: initial;");
        let  time1= document.createElement("option");
        time1.setAttribute("value","09:00~10:00");
        time1.innerText="09:00~10:00";
        time1.setAttribute("name","time")
        time.append(time1);
        time.setAttribute("style","width:130px;display: initial;");
        let  time2= document.createElement("option");
        time2.setAttribute("value","10:00~11:00");
        time2.innerText="10:00~11:00";
        time2.setAttribute("name","time")
        time.append(time2);
        time.setAttribute("style","width:130px;display: initial;");
        let  time3= document.createElement("option");
        time3.setAttribute("value","11:00~12:00");
        time3.innerText="11:00~12:00";
        time3.setAttribute("name","time")
        time.append(time3);
        time.setAttribute("style","width:130px;display: initial;");
        let  time4= document.createElement("option");
        time4.setAttribute("value","12:00~13:00");
        time4.innerText="12:00~13:00";
        time4.setAttribute("name","time")
        time.append(time4);
        time.setAttribute("style","width:130px;display: initial;");
        let  time5= document.createElement("option");
        time5.setAttribute("value","13:00~14:00");
        time5.innerText="13:00~14:00";
        time5.setAttribute("name","time")
        time.append(time5);
        let  time6= document.createElement("option");
        time6.setAttribute("value","14:00~15:00");
        time6.innerText="14:00~15:00";
        time6.setAttribute("name","time")
        time.append(time6);
        let  time7= document.createElement("option");
        time7.setAttribute("value","15:00~16:00");
        time7.innerText="15:00~16:00";
        time7.setAttribute("name","time")
        time.append(time7);
        let  time8= document.createElement("option");
        time8.setAttribute("value","16:00~17:00");
        time8.innerText="16:00~17:00";
        time8.setAttribute("name","time")
        time.append(time8);
        let  time9= document.createElement("option");
        time9.setAttribute("value","17:00~18:00");
        time9.innerText="17:00~18:00";
        time9.setAttribute("name","time")
        time.append(time9);
    //button 만들기
    //apply, add버튼 
    let button = document.createElement("button");
    //submit 버튼 만들기
    let button1 = document.createElement("button");
    button1.setAttribute("type","submit");
    button1.innerText="submit";
    
    //날짜를 클릭 했을때 그 날짜와 함께 선택할 운동 시간 띄우기
    if(event.target.classList.contains("day")){
       if(event.target.innerText!=""){ //날짜가 공백인곳을 클릭하지 않았을때
            //선택한 날짜 넣기
         day.value=year.value+"년"+month.value+"월"+event.target.innerText+"일";
         day.setAttribute("name","applyDay")
         day.setAttribute("readonly","readonly")
        //관리자면 add버튼 add 메소드 전송 회원이면 apply버튼 apply메소드 전송
         if(applyDiv.getAttribute("data-id")==1){
            form.setAttribute("action","./addApply");
            button.setAttribute("id","addBtn");
            button.innerText="add";
            button.setAttribute("type","button");
            form.append(day);
            form.append(time);
            form.append(button); 
            form.append(button1);
            form.append(addDiv);
            
        }else{
            const xhttps = new XMLHttpRequest();
            xhttps.open("POST","../apply/clickDay");
            xhttps.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttps.send("cday="+day.value);
            xhttps.onreadystatechange=function(){
                if(this.readyState==4 && this.status==200){
                    let f = "0";
                    form.setAttribute("action","./apply");
                    if(this.responseText.trim()==f){
                        alert("해당날짜에 수강신청을 할 수 없습니다.");
                    }else{
                         form.innerHTML=this.responseText.trim();
                         document.getElementById("selectName").addEventListener("change",function(){
                            getTime();
                         })
                    }

                }
             }
        }

        applyDiv.innerHTML="";
        applyDiv.append(form);   
   

       }
     
    }

})  

    //Button눌럿을때=================================================================================

    applyDiv.addEventListener("click",function(event){
        //apply버튼 눌럿을때
        if(event.target.getAttribute("id")=="applyBtn"){
           let delConfirm = confirm("신청하시겠습니까?");
           if(delConfirm){
               alert("신청이 완료되었습니다");
           }
        }
        //add버튼 눌럿을때
         if(event.target.getAttribute("id")=="addBtn"){
             //삭제버튼 생성
            let deleteBtn = document.createElement("button");
            deleteBtn.setAttribute("type","button");
            deleteBtn.innerText="del";
            deleteBtn.setAttribute("class","del");
            let diva = document.createElement("div");
            //addDiv에 선택한 날짜, 시간, 삭제버튼 추가
            let input= document.createElement("input");
            let input1= document.createElement("input");
            input.setAttribute("value",day.value);
            input.setAttribute("name","addDay");
            input1.setAttribute("name","addTime");
            input1.setAttribute("value",time.value);
            diva.append(input);
            diva.append(input1);
            diva.append(deleteBtn);
            addDiv.append(diva);
        
        }

       
    })
    //딜리트버튼 선택하면 지우기
    addDiv.addEventListener("click",function(event){
        if(event.target.classList.contains("del")){
            //부모 선택해서 지우기
            event.target.parentNode.remove();
        }
    })
