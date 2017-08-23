import Handlebars from "../node_modules/handlebars/dist/handlebars"

var position;
var source;
var template;
var cache = {};

function createTemplate(handlebarsId) {
    position = $("#" + handlebarsId);
    source = position.html();
    template = Handlebars.compile(source);
    return template;
};


export function create(handlebarsId, data, method, target) {
    var template = cache[handlebarsId];
    if (!template) {
        cache[handlebarsId] = createTemplate(handlebarsId);
        template = cache[handlebarsId];
    }
    target[method](template(data));
}


function customHelper(helperName, func) {
    Handlebars.registerHelper(helperName, func);
}

function setPartial(partialName, partialHandlebarsId) {
    var partialSource = $(partialHandlebarsId).html();
    Handlebars.registerPartial(partialName, partialSource);
}





