
require.config({

    baseUrl:"/resources/js/comment",

    paths: {
        jquery: '../node_modules/jquery/dist/jquery',
        Handlebars: '../node_modules/handlebars/dist/handlebars',
        Component: '../node_modules/@egjs/component/dist/component',
        AjaxWrapper : '../utils/AjaxWrapper',
        HandlebarsWrapper : '../utils/HandlebarsWrapper',
        Extend : '../utils/Extend',
        Scroll : 'Scroll',
        Review : 'Review',
        CommentModel : 'commentModel'
    }
});

require(['jquery', 'Scroll', 'Review'],function($, Scroll, Review){

    Review.init();

    Review.setDownScroll();
    Review.setUpScroll();

});