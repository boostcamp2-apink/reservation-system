require.config({

    baseUrl:"/resources/js/reviewWrite",

    paths: {
        jquery: '../node_modules/jquery/dist/jquery',
        Handlebars: '../node_modules/handlebars/dist/handlebars',
        Component: '../node_modules/@egjs/component/dist/component',
        HandlebarsWrapper : '../utils/HandlebarsWrapper',
        AjaxWrapper : '../utils/AjaxWrapper',
        Slider : '../components/Slider',
        Extend : '../utils/Extend',
        Write : 'Write',
        reviewWriteModel : 'reviewWriteModel',
        Rating:'../components/rating'

    }
});

require(['jquery','Write'],function($,Write){

    Write.init();

});