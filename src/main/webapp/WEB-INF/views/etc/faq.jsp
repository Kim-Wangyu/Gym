<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../resources/css/faq.css" rel="stylesheet">
<c:import url="../template/header_css.jsp"></c:import>
    <link rel="stylesheet" href="/s1/resources/css/home.css">
</head>
</head>
<body>

<c:import url="../template/header.jsp"></c:import>

<div id="wrapper">
  
   <div id="faqBox">
     
	<ul class="faq"> 
			<li><h1>&nbsp&nbsp&nbsp&nbsp자주 묻는 질문</h1></li>
            <li>
                <input type="checkbox" id="faq-1">
                <label for="faq-1">런닝머신 밖에 할 줄 모르는데 헬스장 다닐 수 있을까요?</label>
                <div>
                    <p>PT를 받으시면 트레이너 강사님의 섬세한 코칭이 가능하기 때문에 기구사용법, 내게 맞는 운동루틴까지 체계적인 트레이닝이 가능합니다.</p>
                	<p>PT 없이도 최근에는 유튜브를 활용하여 독학을 하시는 분들도 많습니다.</p>
                </div>
            </li>
            <li>
                <input type="checkbox" id="faq-2">
                <label for="faq-2">헬스장은 매일 다니는게 좋을까요?</label>
                <div>
                    <p>매일 꾸준히 일정시간을 반복하시면서 하나의 라이프스타일로 자리잡는게 좋습니다.</p>
                    <p>초반에 힘들더라도 꼭 시간을 정하셔서 그시간에는 무조건 운동을 할 수있도록 해보세요.</p>
					<p>초보시라면 하루 1시간 이내로 규치적인 운동을 반복하시기 바랍니다.</p>
                </div>
            </li>
            <li>
                <input type="checkbox" id="faq-3">
                <label for="faq-3">헬스 시 운동 순서는 어떻게 해야 하나요?</label>
                <div>
                    <p>스트레칭 > 유산소 > 근력운동 > 정리운동으로 반복하시면 쉽습니다.</p>
                    <p>반품철회 후 택배사에서 상품 수거가 된 것으로 확인될 경우 해당 주문은 반품처리한 것으로 재 변경됩니다.</p>
                </div>
            </li>
            <li>
                <input type="checkbox" id="faq-4">
                <label for="faq-4">여자는 헬스 시 근육이 커져서 보기 싫지 않을까요?</label>
                <div>
                    <p>여성분들은 남성분들과 호르몬이 다르기 때문에 남성분들처럼 우락부락한 근육이 생기지 않습니다.</p>
					<p>오히려 헬스를 통해 유산소와 근력운동을 꾸준하게 반복할 수록 군살은 빼고 탄탄하고 매력있는 몸매를 만들 수 있게 됩니다.</p>

					
                </div>
            </li>
            <li>
                <input type="checkbox" id="faq-5">
                <label for="faq-5">헬스 PT 시 어떤 부분을 케어받을 수 있나요?</label>
                <div>
                    <p>실력있는 트레이너강사님께서 회원님 개인의 체형에 맞는 맞춤형 트레이닝을 제공합니다.</p>
					<p>개인이 원하시는 목표를 설정한 뒤 그에 효과적으로 도달할 수 있는 맞춤 운동루틴을 제공하며 강사님과 함께 운동하시기 때문에 효과 또한 뛰어납니다.</p>
                </div>
            </li>
            <li>
                <input type="checkbox" id="faq-6">
                <label for="faq-6">무산소 운동? 유산소 운동? 운동의 종류를 알려주세요.</label>
                <div>
                    <p>무산소 운동은 운동 중 몸 안에 많은 양의 산소를 공급하지 않고 단발적인 힘을 내는 운동을 말합니다. 단거리 달리기 등이 대표적인 예입니다.</p>
					<p>유산소 운동은 운동 중 몸 안에 최대한 많은 산소를 공급함으로써 심폐기능을 향상 시키는 운동을 말합니다. 헬스장에서는 런닝머신을 통한 걷기, 장거리 달리기 등이 있습니다.</p>
                </div>
            </li>
            <li>
                <input type="checkbox" id="faq-7">
                <label for="faq-7">초보자는 헬스장에서 어떤 운동을 위주로 시작하면 좋을까요?</label>
                <div>
                    <p>“ 런닝머신(유산소) 5분 + 웨이트(무산소) 60분이내 + 런닝머신(유산소) 20분 ”을 기본 코스로 진행하면 좋습니다.</p>
					<p>웨이트 운동법 대해서 알려드리자면, 초보자에게는 부위별 고립 운동보다는 몸 전체의 큰 근육들을 다 쓸 수 있는 이른바 헬스의 3대 운동을 추천합니다. 헬스의 3대 운동에는 벤치 프레스, 데드 리프트, 스쿼트가 있습니다.</p>
                </div>
            </li>
            <li>
                <input type="checkbox" id="faq-8">
                <label for="faq-8">운동을 시작하면 언제쯤부터 살이 빠질까요?</label>
                <div>
                    <p>체중이 줄어드는 것은 간단히 말해서 다음과 같은 공식을 따른다고 보면 쉽습니다.<br>
						“기초대사량 + 운동량 = 음식 섭취량“</p>
					<p>‘기초 대사량’ 이라는 것은 사람이 가만히 있어도 자신의 몸을 유지하기 위해 사용되는 에너지의 양을 말합니다. <br>
					위의 식에서 등호를 중심으로 양 변이 같을 경우 몸무게가 유지 되고, 한 쪽이 클 경우 몸무게에 변화가 생긴다고 보면 됩니다. <br>
					우리는 흔히 이 것을 계산하기 쉽게 칼로리라는 단위를 사용하고 있습니다. <br>몸무게를 줄이기 위해선 하루에 섭취하는 칼로리보다 
					사용하는 칼로리가 더 많으면 된다는 것입니다.<br> 하지만 이것만 생각하고 다이어트를 하면 여러 가지 부작용이 있을 수 있습니다.<br>
					 다음질문에서 더 자세히 다루도록 하겠습니다.</p>
                </div>
            </li>
            <li>
            
            </li>
        </ul>
        </div>
        <div id="faqPicBox">
        <img id="faqPic" alt="" src="/s1/resources/images/faqPic.jpg">
        </div>
        </div>
        <footer>
        <c:import url="../template/bottom.jsp"></c:import>
        </footer>
</body>
</html>