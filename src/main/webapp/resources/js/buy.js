const select2 = document.getElementById("select2");
const select3 = document.getElementById("select3");
const select4 = document.getElementById("select4");
const select5 = document.getElementById("select5");
const select6 = document.getElementById("select6");
const total = document.getElementsByClassName("dataprice");
const btn = document.getElementById("btn");
const form = document.getElementById("form");
const sum = document.getElementById("sum");
const startDate = document.getElementById("startDate");
const finishDate = document.getElementById("finishDate");

let price1 = 0;
let day1 = null;
//가격계산함수
function sumPrice(){
    for(t of total){
        if(t.selected){
            price1 = t.getAttribute("data-price")*select3.value;
        }
    }
   let price2=select4.value*10000*select6.value; 
   let price3=select5.value*10000*select6.value;
   let price4=0;
   if (select6.value==1){
        price4=120000;
   }else if(select6.value==3){
        price4=300000;
   }else if(select6.value==6){
    price4=500000;
    }else if(select6.value==12){
        price4=800000;
   }

   let price=price1+price2+price3+price4;
    sum.value=price;
} 

select2.addEventListener("change",function(){
    sumPrice();
})

select3.addEventListener("change",function(){
    sumPrice();
})

select4.addEventListener("change",function(){
    sumPrice();
})

select5.addEventListener("change",function(){
    sumPrice();
})

select6.addEventListener("change",function(){
    if(startDate.value!="달력에서 시작날짜 클릭"){
        let monthh=current_month;
        let yearr = current_year;
        
        let dayy= parseInt(day1)-1;
        let lastDay= [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
        monthh =current_month + parseInt(select6.value);
        //년이 바뀌면 계산
        if(monthh>12){
            yearr = current_year+1;
            monthh = monthh-12;
        }
        //날이 지난달로 이동하면 계산
        if(dayy==0){
            //윤년계산
            if(checkLeapYear(yearr)){
               lastDay[1]=29;
            }
            monthh=monthh-1;
            dayy= lastDay[monthh-1];
        }
    
        finishDate.value= yearr+"년"+monthh+"월"+dayy+"일";
    }
    sumPrice();
})

btn.addEventListener("click",function(){ 
    let buyConfirm = confirm("총 신청한 가격은 "+sum.value+"원 입니다. 신청하시겠습니까?");
    if(buyConfirm){
        form.submit();
    } 
})


tb_body.addEventListener("click",function(event){
    if(event.target.classList.contains("day")){
        if(event.target.innerText!=""){
            day1=event.target.innerText;
            startDate.value=current_year+"년"+current_month+"월"+ event.target.innerText+"일";
            let click =  current_year+"-"+current_month+"-"+ event.target.innerText;
            let clickdate = new Date(click);
            let today = new Date();
            today.setHours(0,0,0,0);
            //let clickYesterday = new Date();
            // clickYesterday.setDate(clickdate.getDate()+1);
            console.log(today);
            console.log(clickdate);
            console.log(clickdate<today);
           if(clickdate<today){
            alert('유효하지 않은 날짜입니다.')
            startDate.value="달력에서 시작날짜 클릭";
        }
        }
    }
})