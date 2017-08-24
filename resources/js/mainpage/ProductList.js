import * as MainpageModel from './mainpageModel'
import * as HandlebarsWrapper from "../utils/HandlebarsWrapper";
import $ from 'jquery'
import * as Spinner from '../components/Spinner'

let page;
let activeCategoryIndex;
let left;
let right;
let categories;
let productCountTarget;
let productCount;
let spintarget;
let spinner;

function setEvent() {
    $(categories).on("click", "a", changeCategory);
    $(window).on("scroll", scrollUpdate);
}

function scrollUpdate(e) {
    let top = $(".more .btn").offset().top;
    let scrollIndex = window.scrollY + window.innerHeight;
    if ((productCount > page * 10) && scrollIndex > top - 100) {
        page++;
        MainpageModel.getProductsByCategoryId(activeCategoryIndex, page, drawProducts);
        MainpageModel.getProductsByCategoryId(activeCategoryIndex,page).then(drawProducts);
    }
}

function changeCategory(e) {
    activeCategory(e.currentTarget);
    page = 1;
    // MainpageModel.getProductsByCategoryId(activeCategoryIndex, page, removeAndDrawProducts);
    MainpageModel.getProductsByCategoryId(activeCategoryIndex, page).then(removeAndDrawProducts);
}

function activeCategory(target) {
    categories.find("li[data-category=" + activeCategoryIndex + "] a").removeClass("active");
    $(target).addClass("active");
    activeCategoryIndex = $(target).closest("li").data("category");
}

function drawProducts(data) {
    let leftData = [];
    let rightData = [];
    let leftPromise;
    let rightPromise;

    for (let i = 0, l = data.length; i < l; i++) {
        if (i % 2 === 0) {
            leftData.push(data[i]);
        } else {
            rightData.push(data[i]);
        }
    }

    spinner.spin(spintarget);
    leftPromise = HandlebarsWrapper.create("product-main-template", leftData, "append", left);
    rightPromise = HandlebarsWrapper.create("product-main-template", rightData, "append", right);
    Promise.all([leftPromise, rightPromise]).then(function(result) {
        spinner.stop();
    });
    productCount = categories.find("li[data-category=" + activeCategoryIndex + "]").data("productcount")
    productCountTarget.html(productCount);
}

function removeAndDrawProducts(data) {
    left.empty();
    right.empty();
    drawProducts(data);
}
function setSpinnerOption(){

}

export function init() {
    page = 1;
    activeCategoryIndex = 0;
    categories = $(".event_tab_lst");
    left = $("#left_box");
    right = $("#right_box");
    productCountTarget = $(".event_lst_txt span.pink");
    productCount = productCountTarget.text();

    let opts = {
        lines: 13 // The number of lines to draw
        , length: 28 // The length of each line
        , width: 14 // The line thickness
        , radius: 42 // The radius of the inner circle
        , scale: 1 // Scales overall size of the spinner
        , corners: 1 // Corner roundness (0..1)
        , color: '#000' // #rgb or #rrggbb or array of colors
        , opacity: 0.25 // Opacity of the lines
        , rotate: 0 // The rotation offset
        , direction: 1 // 1: clockwise, -1: counterclockwise
        , speed: 1 // Rounds per second
        , trail: 60 // Afterglow percentage
        , fps: 20 // Frames per second when using setTimeout() as a fallback for CSS
        , zIndex: 2e9 // The z-index (defaults to 2000000000)
        , className: 'spinner' // The CSS class to assign to the spinner
        , top: '50%' // Top position relative to parent
        , left: '50%' // Left position relative to parent
        , shadow: false // Whether to render a shadow
        , hwaccel: false // Whether to use hardware acceleration
        , position: 'fixed' // Element positioning
    };
    spintarget = document.getElementById('container')
    spinner = new Spinner(opts)
    setEvent();
}
