define(['HandlebarsWrapper','MainpageModel'],function(HandlebarsWrapper,mainpageModel){

    var page;
    var activeCategoryIndex;
    var left;
    var right;
    var categories;
    var productCountTarget;
    var productCount;

    function init(){
        page =1;
        activeCategoryIndex = 0;
        categories = $(".event_tab_lst");
        left = $("#left_box");
        right = $("#right_box");
        productCountTarget = $(".event_lst_txt span.pink");
        productCount = productCountTarget.text();
        setEvent();

    }

    function setEvent(){
        $(categories).on("click", "a",changeCategory);
        $(window).on("scroll",scrollUpdate);
    }

    function scrollUpdate(e){
        var top = $(".more .btn").offset().top;
        var scrollIndex =  window.scrollY + window.innerHeight;
        if((productCount > page * 10) && scrollIndex > top -100) {
            page++;
            mainpageModel.getProductsByCategoryId(activeCategoryIndex,page,drawProducts);
        }
    }
    function changeCategory(e){
        activeCategory(e.currentTarget);
        page = 1;
        mainpageModel.getProductsByCategoryId(activeCategoryIndex,page,removeAndDrawProducts);
    }

    function activeCategory(target) {
        categories.find("li[data-category=" + activeCategoryIndex + "] a").removeClass("active");
        $(target).addClass("active");
        activeCategoryIndex = $(target).closest("li").data("category");

    }
    function drawProducts(data) {
        var leftData = [];
        var rightData = [];

        for(var i = 0, l = data.length; i < l; i++){
            if(i%2 === 0){
                leftData.push(data[i]);
            }else{
                rightData.push(data[i]);
            }
        }


        HandlebarsWrapper.create("product-main-template",leftData,"append",left);
        HandlebarsWrapper.create("product-main-template",rightData,"append",right);


        productCount = categories.find("li[data-category=" + activeCategoryIndex +"]").data("productcount")
        productCountTarget.html(productCount);

    }

    function removeAndDrawProducts(data){
        left.empty();
        right.empty();
        drawProducts(data);
    }

    return {
        init : init
    }
});