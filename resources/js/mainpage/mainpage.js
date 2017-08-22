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
        Slider : '../components/Slider',
        Extend : '../utils/Extend',
        MainTimeout : 'mainTimeout'
    }
});

require(['jquery','ProductList','Slider','MainTimeout'],function($,ProductList,Slider,MainTimeout){

    ProductList.init();
    var slider = new Slider('ul.visual_img');
    slider.setButton('div.prev_inn > a.btn_pre_e', 'div.nxt_inn > a.btn_nxt_e');


    MainTimeout.init(slider.animator.bind(slider,"next"));
    MainTimeout.setSafetySector('._safetySector');

});