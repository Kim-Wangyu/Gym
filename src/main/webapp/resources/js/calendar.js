const tb_body = document.getElementById("tb_body");
const preMonth = document.getElementById("preMonth");
const nextMonth = document.getElementById("nextMonth");
const year = document.getElementById("year");
const month = document.getElementById("month");
const apply = document.getElementById("apply");




//날짜를 클릭했을때----------------------------------------------------------------------------------------
//전송하면 1. 선택한 운동, 2.날짜 3.시간 4.회원아이디 전송 
//date 전송해서 pt선생이 갖고잇는 시간에 멤버가 신청한 시간이 들어가고 pt선생이 가지고 있는 시간은 한정적이라 그게 다 빠지면 화면에 반영되고 
//pt선생이 21일에 4타임 10~11(member-12) 11~12 14~15 15~16
//버튼 눌럿을때 신청하시겟습니까? 신청완료
//1,2,3,4,5
//trainer 각 날마다 1~8 and 1~8에 각각 한명의 멤버만 연결되야 하고 and 1~8에 한명이 연결되면 calendar페이지에서 빗금처리라던가 이런처리 and 데이터베이스에 저장되어야하고 
//1 = 9~10 2= 10~11 3= 11~12 4= 12~13 5=13~14 6= 14~15 7= 15~16  8= 16~17 


tb_body.addEventListener("click",function(event){

    //form태그 생성
    let form = document.createElement("form");
    form.setAttribute("action","./calendar");
    form.setAttribute("method","post");
    //inpuy id생성
    let id = document.createElement("input");
    id.setAttribute("type","hidden");
    id.setAttribute("name","id");
    id.setAttribute("id","id");
    //선택한 날짜div에 넣기
    let day=document.createElement("div")
    day.innerHTML=current_year+"년"+current_month+"월"+event.target.innerText+"일"
    //select 운동종목 만들기
    let exercise = document.createElement("select");//<select></select>
    exercise.setAttribute("id","exercise");//<select id="exercise"></select>
    exercise.setAttribute("style","width:80px;display: initial;")//<select id="exercise" class="form-control" style="width:80px;display: initial;" >
    exercise.setAttribute("name","exercise");
    for(let i = 1 ; i<= 3 ; i++){
        let option = document.createElement("option");//<option></option>
        option.setAttribute("value","pt"+i);//<option value="pt1"></option>
        option.innerText="pt"+i;//<option value="pt1">pt1</option>
        exercise.append(option);
    }
    let option1 = document.createElement("option")
    option1.setAttribute("value","pilates");
    option1.innerText="pilates";
    exercise.append(option1);
    //select 시간 만들기
    let time = document.createElement("select");
    time.setAttribute("id","time");
    time.setAttribute("name","time")
    time.setAttribute("style","width:80px;display: initial;");
    for(let i = 1 ; i<= 8 ; i++){
        let option = document.createElement("option");
        option.setAttribute("value",i);
        option.innerText=8+i+":00~"+(9+i)+":00";
        time.append(option);
    }
    //button 만들기
    let button = document.createElement("button");
    button.setAttribute("type","submit");
    button.setAttribute("id","btn");
    button.innerText="apply";
    //form태그 안에 id 날짜, 운동종목, 시간 넣기
    form.append(id);
    form.append(day);
    form.append(exercise);
    form.append(time);
    form.append(button);
    //날짜를 클릭 했을때 그 날짜와 함께 선택할 운동 시간 띄우기
    if(event.target.classList.contains("day")){
       if(event.target.innerText!=""){ //날짜가 공백인곳을 클릭하지 않았을때
         apply.innerHTML="";
         apply.append(form);
       }
    }
})  

//신청 버튼 눌럿을때========================================================================
    apply.addEventListener("click",function(event){
        if(event.target.getAttribute("id")=="btn"){
           let delConfirm = confirm("신청하시겠습니까?");
           if(delConfirm){
               alert("신청이 완료되었습니다");
           }
        }
       
    })
    



//달력시작--------------------------------------------------------------------------------------------

//윤년계산 
//윤년= 400으로 나누어 떨어지거나 100으로 나누어 떨어지고 4로도 나누어 떨어질때 
function checkLeapYear(year){
    if(year%400==0){
        return true;
    }else if(year%100==0 && year%4==0){
        return true;
    }else {
        return false;
    }
}

//해당 달의 첫 날이 무슨 요일인지 구하는 함수
// getDay : 0->일 1->월 2->화 3->수 4->목 5->금 6->토
function getFirstDayOfWeek(year,month){
  //  if(month<10){
     //   month="0"+month;  
    //}//2->02
    return (new Date(year+"-"+month+"-01")).getDay();
    
}

function changeYearMonth(year, month){
    let month_day= [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    //윤년이면 2월 변경
    if(month==2){
        if(checkLeapYear(year)){
            month_day[1]=29;
        }
    }
        let first_day_of_week = getFirstDayOfWeek(year,month); //해당 달의 첫 날이 무슨 요일인지 구하기
        let arr_calendar=[]; //calendar배열 선언
        // 달력 앞 공백 넣기 일요일이면 공백0 월요일이면 공백1 화요일이면 공백 2
        for(let i = 0; i<first_day_of_week;i++){
            arr_calendar.push("");
        } 
        //해당 월의 일 만큼 추가(배열은 0부터 시작이므로 month-1)
        for(let i=1;i<=month_day[month-1];i++){
            arr_calendar.push(String(i));
        }
        let remain_day = 7-(arr_calendar.length%7);
        // 달력 뒤 공백 넣기 
        if(remain_day<7){
            for(let i=0 ;i<remain_day;i++){
                arr_calendar.push("");
            }
        }
        renderCalendar(arr_calendar);
}
//달력만드는 함수
function renderCalendar(data){
    let h = [];

    for(let i = 0; i<data.length;i++){
        if(i==0){
            h.push('<tr>');//첫 시작때 tr태그 넣기
        }else if(i%7==0){
            h.push('</tr>');//7번째마다 tr 닫고 열기
            h.push('<tr>');
        }
        h.push('<td class="day">'+data[i]+'</td>');//매번 td넣기 
    }
    h.push('</tr>');//맨 마지막에 tr태그 닫기
    $("#tb_body").html(h.join("")); //tb_body 안에 html형태로 h를 join해서 뿌리기
    //tb_body.innerHTML=h.join("");
}
//달이 바뀔때
function changeMonth(diff){
    if(diff==undefined){
        current_month = parseInt($("#month").val());//숫자를 넣지 않으면 month에 잇는 벨류를 뽑아서 직접 넣기
    }else{
        current_month =current_month +diff;
        //달이 0월이 되면 작년 12월로 이동 달이 13월이 되면 다음해1월로 이동
        if(current_month==0){
            current_year = current_year-1;
            current_month = 12;
        }else if(current_month==13){
            current_year= current_year+1;
            current_month=1;
        }
    }
    loadCalendar();
}
//해가 바뀌면
function changeYear(){
    current_year=parseInt($("#year").val()); //바뀐 해의 벨류값 불러오기
    loadCalendar();
}
//달력 호출 함수
function loadCalendar(){
    $("#year").val(current_year); // = year.value=current_year;
    $("#month").val(current_month);
    changeYearMonth(current_year,current_month);
}

//이전달 클릭하면 이전달로 이동
preMonth.addEventListener("click",function(){
    changeMonth(-1);
});
//다음달 클릭하면 다음 달로 이동
nextMonth.addEventListener("click",function(){
    changeMonth(1);
});
//달을 직접 바꿀때
month.addEventListener("change",function(){
    changeMonth();
});
//해가 직접 바뀔때
year.addEventListener("change",function(){
    changeYear();
});

let current_year = (new Date()).getFullYear();
let current_month = (new Date()).getMonth()+1;

loadCalendar();

//달력시작 끝--------------------------------------------------------------------------------------------