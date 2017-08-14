define(['HandlebarsWrapper','MainpageModel'],function(HandlebarsWrapper,mainpageModel){

    var page;
    var activeCategoryIndex;
    var left;
    var right;
    var categories;
    var productCount;

    function init(){
        page =1;
        activeCategoryIndex = 0;
        categories = $(".event_tab_lst");
        left = $("#left_box");
        right = $("#right_box");
        productCount = $(".event_lst_txt span.pink");

        setEvent();

    }

    function setEvent(){
        $(categories).on("click", "a",changeCategory);
    }

    function changeCategory(e){
        activeCategory(e.currentTarget);
        mainpageModel.getProductsByCategoryId(activeCategoryIndex,page,drawProducts);
    }

    function activeCategory(target) {
        categories.find("li[data-category=" + activeCategoryIndex + "] a").removeClass("active");
        $(target).addClass("active");
        activeCategoryIndex = $(target).closest("li").data("category");

    }

    function drawProducts(data){
        left.empty();
        right.empty();

        var leftData = [];
        var rightData = [];

        for(var i = 0, l = data.length; i < l; i++){
            if(i%2){
                leftData.push(data[i]);
            }else{
                rightData.push(data[i]);
            }
        }


        HandlebarsWrapper.create("product-main-template",leftData,"append",left);
        HandlebarsWrapper.create("product-main-template",rightData,"append",right);


        productCount
            .html(categories.find("li[data-category=" + activeCategoryIndex +"]").data("productcount"));


    }

    return {
        init : init
    }







});