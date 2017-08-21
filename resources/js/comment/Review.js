define(['HandlebarsWrapper', 'CommentModel', 'Scroll'], function (HandlebarsWrapper, commentModel, Scroll) {

    var productId;
    var prevPage;
    var nextPage;
    var pagePerNum;
    var target;
    var commentDivSize;
    var nextLock;
    var prevLock;
    var scroll;

    init = function () {

        productId = $(".header_tit").data("product_id");
        prevPage = 0;
        nextPage = 1;
        pagePerNum = 10;
        target = $("ul.list_short_review");
        commentDivSize = $("div._comment").height;
        nextLock = false;
        prevLock = true;
        scroll  = new Scroll();
        scroll.setDownScroll(getNextComments);
        scroll.setUpScroll(getPrevComments)
    }

    appendComments = function (result, flag) {
        console.log(result);
        if (flag) {
            if (prevPage > 1) {
                deleteElement("._comment", 0);
            }
            HandlebarsWrapper.create("comment-comment-template", result, "append", target);
        } else {
            nextLock = true;
            decrementPage();
        }
    },

    preppendComments = function (result) {
        HandlebarsWrapper.create("comment-comment-template", result, "prepend", target);
    },

    getNextComments = function(){
        if (!nextLock) {
            console.log("next");
            if ($(document).height() == $(window).scrollTop() + $(window).height()) {
                incrementPage();
                prevLock = false;
                commentModel.getCommentsByProductId(productId, nextPage, pagePerNum, appendComments);
            }
        }
    },


    getPrevComments = function(){
        if(!prevLock){
            console.log("prev");
            var height = $(window).scrollTop();
            if (height < 200) {
                if(prevPage == 1){
                    prevLock = true;
                } else {
                    deleteElement("._comment", 1);
                    decrementPage();
                    commentModel.getCommentsByProductId(productId, prevPage, pagePerNum, preppendComments);
                }
                nextLock = false;
            }
        }
    }

    deleteElement = function (id, index) {
        $(id).eq(index).remove();
    },

    incrementPage = function () {
        prevPage++;
        nextPage++;
    },

    decrementPage = function () {
        if (prevPage > 0) {
            prevPage--;
            nextPage--;
        } else {
            prevLock = false;
        }
    }

    return {
        init: init
    }

});