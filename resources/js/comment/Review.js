define(['HandlebarsWrapper','CommentModel'],function(HandlebarsWrapper, commentModel){

    var url;
    var productId;
    var prevPage;
    var nextPage;
    var pagePerNum;
    var target;


    init = function(){

        productId = 1;
        prevPage = 0;
        nextPage = 1;
        pagePerNum = 10;
        target = $("ul.list_short_review");
    }
    drawComments = function(result){
        if(result.length != 0){
            HandlebarsWrapper.create("comment-comment-template", result, "append", target);
        }
    },

    preppendComments = function(){
        HandlebarsWrapper.create("comment-comment-template", result, "preppend", target);
    },

    setDownScroll = function(){
        $(window).scroll(function() {
            if ($(window).scrollTop() == $(document).height() - $(window).height()) {

                incrementPage();
                console.log(prevPage + " " + nextPage);

                url = "/api/products/" + productId + "/comments?page=" + nextPage + "&pagePerNum=" + pagePerNum;
                commentModel.getCommentsByProductId(url, productId, nextPage, drawComments);
            }
        })
    },

    setUpScroll = function(){
        $(window).scroll(function() {
            var height = $(window).scrollTop();
            var lock = true;

            if (height < 500 && lock && prevPage > 0) {
                decrementPage();
                console.log(prevPage + " " + nextPage);
                lock = false;
                url = "/api/products/" + productId + "/comments?page=" + prevPage + "&pagePerNum=" + pagePerNum;
                commentModel.getCommentsByProductId(url, productId, nextPage, preppendComments);
                lock = true;
            }
        })
    },

    incrementPage = function(){
        prevPage++;
        nextPage++;
    },

    decrementPage = function(){
        if(prevPage > 0){
            prevPage--;
            nextPage--;
        }
    }

    return {
        init : init,
        setUpScroll : setUpScroll,
        setDownScroll : setDownScroll

    }

});