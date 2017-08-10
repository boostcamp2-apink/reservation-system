define(['Handlebars'],function(Handlebars){
    var position;
    var source;
    var template;

    var createTemplate = function(handlebarsId) {
        position=$(handlebarsId);
        source = position.html();
        template = Handlebars.compile(source);
        return template;
    };

    var cache = {

    };
    return {
        create : function(handlebarsId,data,method,target) {
            var template = cache[handlebarsId];
            if(!template){
                cache[handlebarsId] = createTemplate(handlebarsId);
                template = cache[handlebarsId];
            }

            $(target)[method](template(data));
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



