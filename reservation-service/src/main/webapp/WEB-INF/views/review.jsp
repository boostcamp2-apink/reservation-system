<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="description" content="네이버 예약, 네이버 예약이 연동된 곳 어디서나 바로 예약하고, 네이버 예약 홈(나의예약)에서 모두 관리할 수 있습니다.">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
    <title>네이버 예약</title>
    <link href="/resources/css/style.css" rel="stylesheet">
</head>

<body>
    <div id="container">
		<!-- [D] 예약하기로 들어오면 header에 fade 클래스 추가로 숨김 -->
		<div class="header fade" >
			<header class="header_tit" data-product_id="${id}">
				<h1 class="logo">
					<a href="http://naver.com" class="lnk_logo" title="네이버"> <span class="spr_bi ico_n_logo">네이버</span> </a>
					<a href="/" class="lnk_logo" title="예약"> <span class="spr_bi ico_bk_logo">예약</span> </a>
				</h1>
				<a href="/myreservation" class="btn_my"> <span title="내 예약">MY</span> </a>
			</header>
		</div>
        <div class="ct">
            <div class="wrap_review_list">
                <div class="review_header">
                    <div class="top_title gr">
                        <a href="/products/${id}" class="btn_back" title="이전 화면으로 이동"> <i class="fn fn-backward1"></i> </a>
                        <h2><a class="title" href="#">${product.name}</a></h2>
                    </div>
                </div>
                <div class="section_review_list">
                    <div class="review_box">
                        <h3 class="title_h3">예매자 한줄평</h3>
                        <div class="short_review_area">
                            <div class="grade_area">
                                <span class="graph_mask">
                                    <em class="graph_value" style="width:88%"></em>
                                </span>
                                <strong class="text_value">
                                    <span>
                                        <fmt:formatNumber value="${product.totalScore/product.commentCount}" pattern=".00"/>
                                    </span>
                                    <em class="total">5.0</em>
                                </strong>
                                <span class="join_count">
                                    <em class="green">${product.commentCount}</em> 등록
                                </span>
                            </div>
                            <ul class="list_short_review">
                                <div class="_comment">
                                <c:forEach var="comment" items="${comments}" varStatus="status">
                                    <li class="list_item">
                                        <div>
                                            <div class="review_area">
                                                <div class="thumb_area" data-images=${comment.images}>
                                                    <a href="#" class="thumb" title="이미지 크게 보기"> <img width="90" height="90" class="img_vertical_top" src="/files/1" alt="리뷰이미지"> </a> <span class="img_count">1</span>                                                </div>
                                                <h4 class="resoc_name">${product.name}</h4>
                                                <p class="review">${comment.comment}</p>
                                            </div>
                                            <div class="info_area">
                                                <div class="review_info">
                                                    <span class="grade">${comment.score}</span>
                                                    <span class="name">${comment.username}</span>
                                                    <span class="date">${comment.createDate} 방문</span>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>
                                </div>
                            </ul>
                        </div>
                        <p class="guide"> <i class="spr_book2 ico_bell"></i> <span>네이버 예약을 통해 실제 방문한 이용자가 남긴 평가입니다.</span> </p>
                    </div>
                </div>
            </div>
        </div>
        <hr> </div>
		<footer>
	        <div class="gototop">
	            <a href="#" class="lnk_top"> <span class="lnk_top_text">TOP</span> </a>
	        </div>
	        <div id="footer" class="footer">
	            <p class="dsc_footer">네이버(주)는 통신판매의 당사자가 아니며, 상품의정보, 거래조건, 이용 및 환불 등과 관련한 의무와 책임은 각 회원에게 있습니다.</p>
	            <span class="copyright">© NAVER Corp.</span>
	        </div>
	    </footer>


    <div id="photoview" style="display:none;">
        <a class="popup_close" style = "color:white;">닫기</a>
        <div class="pagination">
            <div class="bg_pagination"></div>
            <div class="figure_pagination">
                <span class="num popup_image_num">1</span>
                <span class="num off ">/ <span class="popup_total_image_num">3</span></span>
            </div>
        </div>
        <div class="group_visual">
            <div>
                <div class="container_visual" style="width: 414px;">
                    <ul class="visual_img">

                    </ul>

                </div>
                <div class="prev">
                    <div class="prev_inn">
                        <a href="#" class="btn_prev" title="이전">
                            <!-- [D] 첫 이미지 이면 off 클래스 추가 -->
                            <i class="spr_book2 ico_arr6_lt off"></i>
                        </a>
                    </div>
                </div>
                <div class="nxt">
                    <div class="nxt_inn">
                        <a href="#" class="btn_nxt" title="다음">
                            <i class="spr_book2 ico_arr6_rt"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script id="comment-image-template" type="text/apink-handlebars-template">
        {{#each this}}
        <li class="item" style="width: 414px;">
            <img alt="" class="img_thumb" src="/files/{{this}}"> <span class="img_bg"></span>
        </li>
        {{/each}}
    </script>

    <script type="text/javascript" src="/resources/js/public/commentbundle.js"></script>
    <script id="comment-comment-template" type="text/apink-handlebars-template">
        <div class="_comment">
        {{#each this}}
            <li class="list_item" data-comment_id="{{this.id}}">
                <div>
                    <div class="review_area">
                        <div class="thumb_area" data-images="[1,2,3,4]">
                            <a href="#" class="thumb" title="이미지 크게 보기"> <img width="90" height="90" class="img_vertical_top" src="/files/1" alt="리뷰이미지"> </a> <span class="img_count">1</span>                                                </div>
                        <h4 class="resoc_name">${product.name}</h4>
                        <p class="review">{{this.comment}}</p>
                    </div>
                    <div class="info_area">
                        <div class="review_info">
                            <span class="grade">{{this.score}}</span>
                            <span class="name">{{this.username}}</span>
                            <span class="date">{{this.createDate}} 방문</span>
                        </div>
                    </div>
                </div>
            </li>
        {{/each}}
        </div>
    </script>

</body>
</html>
