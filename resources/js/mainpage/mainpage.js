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
        Extend : '../utils/Extend'
    }
});

require(['ProductList','Rolling'],function(ProductList,Rolling){

    ProductList.init();
    var rolling = new Rolling('div.container_visual',1,'div.prev_inn > a.btn_pre_e', 'div.nxt_inn > a.btn_nxt_e');
});