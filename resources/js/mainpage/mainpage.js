require.config({

    baseUrl:"/resources/js/mainpage",

    paths: {
        jquery: '../node_modules/jquery/dist/jquery',
        Handlebars: '../node_modules/handlebars/dist/handlebars.amd',
        component: '../node_modules/@egjs/component/dist/component',
        HandlebarsWrapper : '../util/HandlebarsWrapper',
        AjaxWrapper : '../util/AjaxWrapper',
        mainpageModel:'mainpageModel',
        ProductList : 'ProductList'
    }
});

require(['ProductList'],function(ProductList){

    ProductList.init();
});