define(['HandlebarsWrapper', 'CommentModel'], function (HandlebarsWrapper, commentModel) {

    var productId;
    var prevPage;
    var nextPage;
    var pagePerNum;
    var target;
    var commentDivSize;
    var nextLock;
    var prevLock;

    init = function () {

        productId = 1;
        prevPage = 0;
        nextPage = 1;
        pagePerNum = 10;
        target = $("ul.list_short_review");
        commentDivSize = $("div._comment").height;
        nextLock = false;
        prevLock = true;
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

    setDownScroll = function () {
        $(window).scroll(function () {
            if (!nextLock) {
                if ($(document).height() == $(window).scrollTop() + $(window).height()) {
                    incrementPage();
                    prevLock = false;
                    console.log(prevPage + " " + nextPage);
                    commentModel.getCommentsByProductId(productId, nextPage, pagePerNum, appendComments);
                }
            }
        })
    },

    setUpScroll = function () {
        $(window).scroll(function() {
            if(!prevLock){
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
                    console.log(prevPage + " " + nextPage);
                }
            }
        })
    },

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
        init: init,
        setUpScroll: setUpScroll,
        setDownScroll: setDownScroll
    }

});