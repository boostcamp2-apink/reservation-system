import * as $ from 'jquery'
import Handlebars from "handlebars"

let position;
let source;
let template;
let cache = {};

function createTemplate(handlebarsId) {
    position = $("#" + handlebarsId);
    source = position.html();
    template = Handlebars.compile(source);
    return template;
}

export function create(handlebarsId, data, method, target) {
    let template = cache[handlebarsId];
    if (!template) {
        cache[handlebarsId] = createTemplate(handlebarsId);
        template = cache[handlebarsId];
    }
    target[method](template(data));
}
export function customHelper(helperName, func) {
    Handlebars.registerHelper(helperName, func);
}
export function setPartial(partialName, partialHandlebarsId) {
    let partialSource = $(partialHandlebarsId).html();
    Handlebars.registerPartial(partialName, partialSource);
}




