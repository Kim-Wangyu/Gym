const select2 = document.getElementById("select2");
const select3 = document.getElementById("select3");
const select4 = document.getElementById("select4");
const select5 = document.getElementById("select5");
const total = document.getElementsByClassName("dataprice");
const btn = document.getElementById("btn");
const form = document.getElementById("form");
const sum = document.getElementById("sum");

let price=0;
let price1=0;
let price2=0;
let price3=0;
select2.addEventListener("change",function(){
    for(t of total){
        if(t.selected){
            price1 = t.getAttribute("data-price")*select3.value;
        }
    }
    price2=select4.value*20000; 
    price3=select5.value*20000;
    price=price1+price2+price3;
    sum.value=price;
})

select3.addEventListener("change",function(){
    for(t of total){
        if(t.selected){
            price1 = t.getAttribute("data-price")*select3.value;
        }
    }
    price2=select4.value*20000; 
    price3=select5.value*20000;
    price=price1+price2+price3;
    sum.value=price;
})

select4.addEventListener("change",function(){
    for(t of total){
        if(t.selected){
            price1 = t.getAttribute("data-price")*select3.value;
        }
    }
    price2=select4.value*20000; 
    price3=select5.value*20000;
    price=price1+price2+price3;
    sum.value=price;
})

select5.addEventListener("change",function(){
    for(t of total){
        if(t.selected){
            price1 = t.getAttribute("data-price")*select3.value;
        }
    }
    price2=select4.value*20000; 
    price3=select5.value*20000;
    price=price1+price2+price3;
    sum.value=price;
})

btn.addEventListener("click",function(){   
    alert("총 신청한 가격은 "+sum.value+"원 입니다. 신청하시겠습니까?");
    form.submit();
})
