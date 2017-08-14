
define(['Extend', 'Component'], function (extend, Component) {
    var Ticket = extend(Component, {
        init : function(id){
            this.countEle = $(id + " .count_control_input");
            this.price = $(id + " .price").text();
            this.totalPrice = $(id + " .total_price");
            this.minusBtn = $(id + " .ico_minus3");
            $(id).on("click", ".ico_plus3", this.plus.bind(this));
            $(id).on("click", ".ico_minus3", this.minus.bind(this));
        }
    });
    Ticket.prototype.plus = function(e){
        e.preventDefault();
        var count = this.getCount() + 1;
        this.countEle.val(count);
        this.totalPrice.text(this.getTotalPrice());
        this.trigger("change",{
            "count" : count
        })
        this.removeDisabled();
    };
    Ticket.prototype.minus = function(e){
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
    };
    Ticket.prototype.addDisabled = function(){
        this.countEle.addClass("disabled");
        this.minusBtn.addClass("disabled");

    };
    Ticket.prototype.removeDisabled = function(){
        this.countEle.removeClass("disabled");
        this.minusBtn.removeClass("disabled");
    };
    Ticket.prototype.getCount = function(){
        return parseInt(this.countEle.val(), 10);
    };
    Ticket.prototype.getTotalPrice = function(){
        return this.getCount() * this.price;
    };
    return Ticket;
});


