<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c-rt"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="description"
	content="네이버 예약, 네이버 예약이 연동된 곳 어디서나 바로 예약하고, 네이버 예약 홈(나의예약)에서 모두 관리할 수 있습니다.">
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
<title>네이버 예약</title>
<link href="/resources/css/style.css" rel="stylesheet">
<style type="text/css">
	.invisible {
		display : none
	}
</style>
</head>

<body>
	<div id="container">
		<div class="header">
			<%@ include file="GNB.jsp"%>
		</div>
		<hr>
		<div class="event">
			<div class="section_visual">
				<div class="group_visual">
					<div class="container_visual">
						<div class="prev_e">
							<div class="prev_inn">
								<a class="btn_pre_e" title="이전"> <i
									class="spr_book_event spr_event_pre">이전</i>
								</a>
							</div>
						</div>
						<div class="nxt_e">
							<div class="nxt_inn">
								<a class="btn_nxt_e" title="다음"> <i
									class="spr_book_event spr_event_nxt">다음</i>
								</a>
							</div>
						</div>
						<div>
							<div class="container_visual">
								<!-- [D] 이전,다음 버튼을 클릭할때마다 캐러셀 형태로 순환 됨 --->
								<ul class="visual_img" id="slider">
									<c-rt:forEach var="product" items="${products}" varStatus="status">
										<li class="item" id="slide_idex_${status.index }" style="background-image: url(http://naverbooking.phinf.naver.net/20170209_66/1486628146913la6nC_JPEG/image.jpg); width: 338px;">
											<a href="#"> <span class="img_btm_border"></span> <span	class="img_right_border"></span> <span class="img_bg_gra"></span>
												<div class="event_txt">
													<h4 class="event_txt_tit">${product.name}</h4>
													<p class="event_txt_adr">${product.placeName}</p>
													<p class="event_txt_dsc">${product.description}</p>
												</div>
											</a>
										</li>
									</c-rt:forEach>
								</ul>
							</div>
							<span class="nxt_fix"></span>
						</div>
					</div>
				</div>
			</div>
			<div class="section_event_tab">
				<ul class="event_tab_lst tab_lst_min">
					<li class="item">
						<a class="anchor active">
							<span>전체</span>
						</a>
					</li>
					<c-rt:forEach var="category" items="${categories}" varStatus="status">
						<li class="item">
							<a class="anchor <c-rt:if test="${status.last}">last</c-rt:if>"  data-category-id="${category.id}">
								<span>${category.name}</span>
							</a>
						</li>
					</c-rt:forEach>
				</ul>
			</div>
			<div class="section_event_lst">
				<p class="event_lst_txt">
					바로 예매 가능한 전시, 공연, 행사가 <span class="pink" id="product_counts">${numberOfAll}개</span>
					있습니다
				</p>
				<div class="wrap_event_box" id="display_info_box">
					<!-- [D] lst_event_box 가 2컬럼으로 좌우로 나뉨, 더보기를 클릭할때마다 좌우 ul에 li가 추가됨 -->
					<ul class="lst_event_box" id="left_column">
						<c-rt:forEach var="product" items="${products}" varStatus="status">
							<c-rt:if test="${status.index % 2 == 0}">
								<li class="item" data-product-id="${product.id }">
									<a href="#" class="item_book">
										<div class="item_preview">
											<img alt="뮤지컬 드림걸즈(DREAMGIRLS) 최초 내한" class="img_thumb"
												src="https://ssl.phinf.net/naverbooking/20170303_271/1488514705030TuUK4_JPEG/17%B5%E5%B8%B2%B0%C9%C1%EE_%B8%DE%C0%CE%C6%F7%BD%BA%C5%CD_%C3%D6%C1%BE.jpg?type=l591_945">
											<span class="img_border"></span>
										</div>
										<div class="event_txt">
											<h4 class="event_txt_tit">
												<span>${product.name }</span> <small class="sm">${product.placeName}</small>
											</h4>
											<p class="event_txt_dsc">${product.description }</p>
										</div>
									</a>
								</li>
							</c-rt:if>
						</c-rt:forEach>
					</ul>
					<ul class="lst_event_box" id="right_column">
						<c-rt:forEach var="product" items="${products}" varStatus="status">
							<c-rt:if test="${status.index % 2 == 1}">
								<li class="item" data-product-id="${product.id }">
									<a href="#" class="item_book">
										<div class="item_preview">
											<img alt="뮤지컬 드림걸즈(DREAMGIRLS) 최초 내한" class="img_thumb"
												src="https://ssl.phinf.net/naverbooking/20170303_271/1488514705030TuUK4_JPEG/17%B5%E5%B8%B2%B0%C9%C1%EE_%B8%DE%C0%CE%C6%F7%BD%BA%C5%CD_%C3%D6%C1%BE.jpg?type=l591_945">
											<span class="img_border"></span>
										</div>
										<div class="event_txt">
											<h4 class="event_txt_tit">
												<span>${product.name }</span> <small class="sm">${product.placeName}</small>
											</h4>
											<p class="event_txt_dsc">${product.description }</p>
										</div>
									</a>
								</li>
							</c-rt:if>
						</c-rt:forEach>
					</ul>
					<!-- 더보기 -->
					<div class="more <c-rt:if test="${numberOfAll <= 10}">invisible</c-rt:if>">
						<button class="btn">
							<span>더보기</span>
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer>
		<div class="gototop">
			<a href="" class="lnk_top"> <span class="lnk_top_text">TOP</span>
			</a>
		</div>
		<div class="footer">
			<p class="dsc_footer">네이버(주)는 통신판매의 당사자가 아니며, 상품의정보, 거래조건, 이용 및
				환불 등과 관련한 의무와 책임은 각 회원에게 있습니다.</p>
			<span class="copyright">© NAVER Corp.</span>
		</div>
	</footer>
	<script type="text/javascript" src="resources/js/plugin/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="resources/js/plugin/handlebars-v4.0.10.js"></script>
	<script type="text/javascript" src="resources/js/etcData.js"></script>
	<script type="text/javascript" src="resources/js/slider.js"></script>
	<script type="text/javascript" src="resources/js/displayProducts.js"></script>
	<script id="display_info_box_template" type="text/x-handlebars-template">
			{{#items}}
				<li class="item" data-product-id="{{id}}">
		        	<a href="" class="item_book">
		            	<div class="item_preview"> <img alt="뮤지컬 드림걸즈(DREAMGIRLS) 최초 내한" class="img_thumb" src="https://ssl.phinf.net/naverbooking/20170303_271/1488514705030TuUK4_JPEG/17%B5%E5%B8%B2%B0%C9%C1%EE_%B8%DE%C0%CE%C6%F7%BD%BA%C5%CD_%C3%D6%C1%BE.jpg?type=l591_945"><span class="img_border"></span> </div>
		               	<div class="event_txt">
		                    <h4 class="event_txt_tit"> <span>{{name}}</span> <small class="sm">{{placeName}}</small> </h4>
		                    <p class="event_txt_dsc">{{description}}</p>
		                </div>
		            </a>
		        </li>
			{{/items}}
    </script>
	<script type="text/javascript">
    	$(document).ready(function(){
    		$('.more .btn').on('click', function() {
    			etcData.increaseFirstIndex();
    			if(etcData.getCategoryId()) {
					url = '/products/categories/' + etcData.getCategoryId() + '/firstindex/' + etcData.getFirstIndex();
    			} else {
    				url = '/products/firstindex/' + etcData.getFirstIndex();
    			}
    			$.ajax({
    			    method : 'get',
    			    url : url,
    			    success : appendProducts,
    			    error : function(request, status, error ) {   // 오류가 발생했을 때 호출된다. 
    			    	console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
    		    	}
    			});
    		});
    		$('.anchor').on('click', function(){
    			etcData.setCategoryId($(this).data('category-id'));
    			etcData.resetFirstIndex();
    			var url1;
    			var url2;
    			if(etcData.getCategoryId()) {
					url1 = '/products/categories/' + etcData.getCategoryId() + '/firstindex/' + etcData.getFirstIndex();
					url2 = '/products/categories/' + etcData.getCategoryId() + '/counts';
    			} else {
    				url1 = '/products/firstindex/' + etcData.getFirstIndex();
    				url2 = '/products/counts';
    			}
    			$.ajax({
    			    method : 'get',
    			    url : url1,
    			    success : refreshProducts,
    			    error : function(request, status, error ) {   // 오류가 발생했을 때 호출된다. 
    			    	console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
    		    	}
    			});
    			$.ajax({
    			    method : 'get',
    			    url : url2,
    			    success : changeCounts,
    			    error : function(request, status, error ) {   // 오류가 발생했을 때 호출된다. 
    			    	console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
    		    	}
    			});
       			if($(this).hasClass('active')) return;
       			else {
       				$('.anchor').removeClass('active');
       				$(this).addClass('active');
       			}
    		});
    		$(window).scroll(function() {
    			var maxHeight = $(document).height();
    			var currentScroll = $(window).scrollTop() + $(window).height();
    			if(maxHeight - currentScroll < 30) {
    				if(!$('.more .btn').hasClass('invisible')) $('.more .btn').click();
    			}
    		});
            var slide = slider($('#slider'), true);
        	$('.btn_nxt_e').on('click', function() {
        	    if ($('#slider').is(':animated')) return;
        	    slide.next();
        	});
        	$('.btn_pre_e').on('click', function() {
        	    if ($('#slider').is(':animated')) return;
        	    slide.prev();
        	});
    	});
    </script>
</body>

</html>
