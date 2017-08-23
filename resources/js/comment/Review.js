import * as HandlebarsWrapper from '../utils/HandlebarsWrapper'
import * as Scroll from './Scroll'
import * as commentModel from './commentModel'

let productId;
let prevPage;
let nextPage;
let pagePerNum;
let target;
let commentDivSize;
let nextLock;
let prevLock;
let scroll;

export function init() {

    productId = $(".header_tit").data("product_id");
    prevPage = 0;
    nextPage = 1;
    pagePerNum = 10;
    target = $("ul.list_short_review");
    commentDivSize = $("div._comment").height;
    nextLock = false;
    prevLock = true;
    scroll = new Scroll();
    scroll.setDownScroll(getNextComments);
    scroll.setUpScroll(getPrevComments)
}

function appendComments(result, flag) {
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
}

function preppendComments(result) {
    HandlebarsWrapper.create("comment-comment-template", result, "prepend", target);
}


function getNextComments() {
    if (!nextLock) {
        console.log("next");
        if ($(document).height() == $(window).scrollTop() + $(window).height()) {
            incrementPage();
            prevLock = false;
            commentModel.getCommentsByProductId(productId, nextPage, pagePerNum, appendComments);
        }
    }
}


function getPrevComments() {
    if (!prevLock) {
        console.log("prev");
        var height = $(window).scrollTop();
        if (height < 200) {
            if (prevPage == 1) {
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

function deleteElement(id, index) {
    $(id).eq(index).remove();
}

function incrementPage() {
    prevPage++;
    nextPage++;
}

function decrementPage() {
    if (prevPage > 0) {
        prevPage--;
        nextPage--;
    } else {
        prevLock = false;
    }
}
