import Rating from "../components/Rating";
import * as reviewWriteModel from "./reviewWriteModel";
import * as HandlebarsWrapper from "../utils/HandlebarsWrapper";
import * as $ from 'jquery'

let productId;

let rootTarget;
let ratingScoreTarget;
let ratingTarget;
let reviewContentTarget;
let reviewTextTarget;
let reviewTextLengthTarget;
let reviewFooterTarget;
let imageUploadTarget;
let uploadedImageTarget;
let submitBtnTarget;

let reviewTextLength;
let ratingScore;

let imagesFileId;

let rating;


export function init() {
    rootTarget = $("#_reviewContainer");
    ratingTarget = rootTarget.find("._rating");
    ratingScoreTarget = ratingTarget.find("._ratingScore");
    reviewContentTarget = rootTarget.find(".review_contents");
    reviewTextTarget = reviewContentTarget.find(".review_textarea");
    reviewFooterTarget = rootTarget.find(".review_write_footer_wrap");
    reviewTextLengthTarget = reviewFooterTarget.find("#_reviewTextLength");
    imageUploadTarget = reviewFooterTarget.find(".hidden_input");
    uploadedImageTarget = rootTarget.find(".lst_thumb");
    submitBtnTarget = rootTarget.find(".bk_btn");

    ratingScore = 0;
    reviewTextLength = 0;

    imagesFileId = [];

    productId = rootTarget.data("productid");

    setEvent();
}

function setEvent() {
    rating = new Rating(ratingTarget);
    rating.on("change", updateRatingScore);
    reviewContentTarget.on("click", ".review_write_info", clickContent);
    reviewTextTarget.on("keyup", keyupText);
    imageUploadTarget.on("change", uploadImage);
    uploadedImageTarget.on("click", "._del", deleteImage);
    submitBtnTarget.on("click", submitComment);
}

function submitComment() {
    let commentData = {
        productId: productId,
        userId: 1,
        score: ratingScore,
        comment: reviewTextTarget[0].value,
        images: imagesFileId
    };

    reviewWriteModel.postCommentData({data:commentData, callback:redirectUrl});
}

function redirectUrl() {
    alert("리뷰 등록 성공하였습니다.");
    //$(location).attr('href',url);

}

function deleteImage(e) {
    e.preventDefault();
    let target = $(e.currentTarget);
    let index = imagesFileId.indexOf(target.data("fileId"));
    imagesFileId.splice(index, 1);
    target.closest("li").remove();
}

function uploadImage(e) {
    reviewWriteModel.postImage({data:e.currentTarget.files[0],callback: drawImage});
}

function drawImage(data) {
    let imageFileId = data[0];
    imagesFileId.push(imageFileId);
    HandlebarsWrapper.create('uploaded-image-template', imageFileId, "append", uploadedImageTarget);
}

function keyupText(e) {
    reviewTextLength = e.currentTarget.value.length;
    reviewTextLengthTarget.text(reviewTextLength);
}

function clickContent(e) {
    e.preventDefault();
    $(e.currentTarget).css("display", "none");
    reviewTextTarget.focus();
}

function updateRatingScore(data) {
    if (ratingScore === 0 || data.ratingScore === 0) {
        ratingScoreTarget.toggleClass("gray_star");
    }

    ratingScore = data.ratingScore;

    ratingScoreTarget.text(ratingScore);
}




