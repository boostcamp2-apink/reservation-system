import dasd from "handlebars/lib/handlebars";

define(['Handlebars'],function(Handlebars){
    var position;
    var source;
    var template;
    var cache = {

    };

    var createTemplate = function(handlebarsId) {
        position=$("#"+handlebarsId);
        source = position.html();
        template = Handlebars.compile(source);
        return template;
    };


    return {
        create : function(handlebarsId,data,method,target) {
            var template = cache[handlebarsId];
            if(!template){
                cache[handlebarsId] = createTemplate(handlebarsId);
                template = cache[handlebarsId];
            }
            target[method](template(data));
        },
        customHelper : function(helperName, func) {
            Handlebars.registerHelper(helperName,func);
        },
        setPartial: function(partialName,partialHandlebarsId){
            var partialSource = $(partialHandlebarsId).html();
            Handlebars.registerPartial(partialName, partialSource);
        }
    }

});



