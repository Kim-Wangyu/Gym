<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
</head>
<body>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <div class="container">
        <div style="width:300px;">
        	<div>
        		<button type="button"><i class="fa fa-chevron-left"></i></button>
                <input type="number" id="year" value="2022" style="width: 80px;display: initial;" class="form-control"/>
                <select id="month" class="form-control" style="width:80px;display: initial;">
                    <option value="1">1월</option>
                    <option value="2">2월</option>
                    <option value="3">3월</option>
                    <option value="4">4월</option>
                    <option value="5">5월</option>
                    <option value="6">6월</option>
                    <option value="7">7월</option>
                    <option value="8">8월</option>
                    <option value="9">9월</option>
                    <option value="10">10월</option>
                    <option value="11">11월</option>
                    <option value="12">12월</option>
                </select>
				<button type="button"><i class="fa fa-chevron-right"></i></button>
        	</div>
            <table class = "table table-bordered">
                <thead>
                    <tr>
                        <th>일</th>
                        <th>월</th>
                        <th>화</th>
                        <th>수</th>
                        <th>목</th>
                   		<th>금</th>
                        <th>토</th>
                    </tr>
                </thead>
                <tbody id="tb_body"></tbody>
            </table>
        </div>
    </div>
    <script>
        function checkLeapYear(year){
            if(year%400==0){
                return true;
            }else if(year%100==0 && year%4==0){
                return true;
            }else {
                return false;
            }
        }

        function getFirstDayOfWeek(year,month){
            if(month<10){
                month="0"+month;  
            }
            return (new Date(year+"-"+month+"-01")).getDay();
        }
        function changeYearMonth(year, month){
            let month_day= [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
            if(month==2){
                if(checkLeapYear(year)){
                    month_day[1]=29;
                }
            }

                let first_day_of_week = getFirstDayOfWeek(year,month);
                let arr_calendar=[];
                for(let i = 0; i<first_day_of_week;i++){
                    arr_calendar.push("");
                }
                for(let i=1;i<=month_day[month-1];i++){
                    arr_calendar.push(String(i));
                }
                let remain_day = 7-(arr_calendar.length%7);
                if(remain_day<7){
                    for(let i=0 ;i<remain_day;i++){
                        arr_calendar.push("");
                    }
                }
                renderCalendar(arr_calendar);
        }

        function renderCalendar(data){
            let h = [];
            for(let i = 0; i<data.length;i++){
                if(i==0){
                    h.push('<tr>');
                }else if(i%7==0){
                    h.push('</tr>');
                    h.push('<tr>');
                }
                h.push('<td>'+data[i]+'</td>');
            }
            h.push('</tr>');
            $("#tb_body").html(h.join(""));
        }
        changeYearMonth(2022,11);
    </script>

</body>
</html>