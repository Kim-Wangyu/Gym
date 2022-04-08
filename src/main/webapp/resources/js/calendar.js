const tb_body = document.getElementById("tb_body");
const preMonth = document.getElementById("preMonth");
const nextMonth = document.getElementById("nextMonth");
const year = document.getElementById("year");
const month = document.getElementById("month");









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