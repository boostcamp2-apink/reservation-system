require.config({

    baseUrl:"/resources/js/detail",

    paths: {
        jquery: '../node_modules/jquery/dist/jquery',
        Handlebars: '../node_modules/handlebars/dist/handlebars',
        Component: '../node_modules/@egjs/component/dist/component',
        HandlebarsWrapper : '../utils/HandlebarsWrapper',
        AjaxWrapper : '../utils/AjaxWrapper',
        Slider : '../components/Slider',
        Extend : '../utils/Extend',
        ProductDetail:'ProductDetail',
        ImagePopup:'../components/ImagePopup'

    }
});

require(['jquery','ProductDetail','ProductComment'],function($,ProductDetail,ProductComment){

    ProductDetail.init();
    ProductComment.init();

});