
define(['Extend', 'Component'], function (extend, Component) {

    var Ticket = extend(Component, {
        "init" : function(rootTarget){
            this.rootTarget = $(rootTarget);
            this.countEle = $(rootTarget + " .count_control_input");
            this.price = $(rootTarget + " .price").text();
            this.totalPrice = $(rootTarget + " .total_price");
            this.minusBtn = $(rootTarget + " .ico_minus3");

            this.count = 0;
            this.setEvent();
        },

        setEvent : function(){
            this.rootTarget.on("click", ".ico_plus3", this.plus.bind(this));
            this.rootTarget.on("click", ".ico_minus3", this.minus.bind(this));
        },

        plus : function(e){
            e.preventDefault();
            this.countEle.val(++this.count);
            this.totalPrice.text(this.getTotalPrice());
            this.trigger("change",{
                "sign" : 1,
                "price" : this.price
            })
            this.removeDisabled();
        },

        minus : function(e){
            e.preventDefault();
            if(this.count > 0){
                this.countEle.val(--this.count);
                this.totalPrice.text(this.getTotalPrice());
            }
            if(this.count == 0){
                this.addDisabled();
            }
            this.trigger("change",{
                "sign" : -1,
                "price" : this.price
            })
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
            return this.count * this.price;
        }
    });
    return Ticket;
});


