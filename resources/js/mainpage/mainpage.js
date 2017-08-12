require.config({

    baseUrl:"/resources/js/mainpage",

    paths: {
        jquery: '../node_modules/jquery/dist/jquery',
        Handlebars: '../node_modules/handlebars/dist/handlebars',
        Component: '../node_modules/@egjs/component/dist/component',
        HandlebarsWrapper : '../utils/HandlebarsWrapper',
        AjaxWrapper : '../utils/AjaxWrapper',
        MainpageModel:'mainpageModel',
        ProductList : 'ProductList',
        Rolling : '../components/Rolling',
        Extend : '../utils/Extend',
        MainTimeout : 'mainTimeout'
    }
});

require(['jquery','ProductList','Rolling','MainTimeout'],function($,ProductList,Rolling,MainTimeout){

    ProductList.init();
    var rolling = new Rolling('ul.visual_img','div.prev_inn > a.btn_pre_e', 'div.nxt_inn > a.btn_nxt_e');

    MainTimeout.init(rolling.animator.bind(rolling,"next"));
    MainTimeout.setSafetySector('._safetySector');

});