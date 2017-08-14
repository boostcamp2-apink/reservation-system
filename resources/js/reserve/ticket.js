function extend(superClass, def) {
    var extendClass = function extendClass() {
        // Call a parent constructor
        superClass.apply(this, arguments);

        // Call a child constructor
        if (typeof def.init === "function") {
            def.init.apply(this, arguments);
        }
    };

    var ExtProto = function() {};
    ExtProto.prototype = superClass.prototype;

    var extProto = new ExtProto();
    for (var i in def) {
        extProto[i] = def[i];
    }
    extProto.constructor = extendClass;
    extendClass.prototype = extProto;

    return extendClass;
};

var Ticket = extend(eg.Component, {

    init : function(id){
        this.countEle = $(id + " .count_control_input");
        this.price = $(id + " .price").text();
        this.totalPrice = $(id + " .total_price");
        this.minusBtn = $(id + " .ico_minus3");
        $(id).on("click", ".ico_plus3", this.plus.bind(this));
        $(id).on("click", ".ico_minus3", this.minus.bind(this));
    },
    plus : function(e){
        e.preventDefault();
        var count = this.getCount() + 1;
        this.countEle.val(count);
        this.totalPrice.text(this.getTotalPrice());
        this.trigger("change",{
            "count" : count
        })
        this.removeDisabled();
    },
    minus : function(e){
        e.preventDefault();
        var count = this.getCount() - 1;
        if(count >= 0){
            this.countEle.val(count);
            this.totalPrice.text(this.getTotalPrice());
        }
        if(count == 0){
            this.addDisabled();
        }
        this.trigger("change",{
            "count" : count
        });
    },
    addDisabled : function(){
        this.countEle.addClass("disabled");
        this.minusBtn.addClass("disabled");

    },
    removeDisabled : function(){
        this.countEle.removeClass("disabled");
        this.minusBtn.removeClass("disabled");
    },
    getCount : function(){
        return parseInt(this.countEle.val(), 10);
    },
    getTotalPrice : function(){
        return this.getCount() * this.price;
    }
});


