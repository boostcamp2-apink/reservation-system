define(['Extend', 'Component'], function (extend, Component) {

    var Rating = extend(Component, {
        "init": function (rootTarget) {
            this.rootTarget = $(rootTarget);
            this.ratingTarget = this.rootTarget.find(".rating_rdo");
            this.ratingScore = 0;
            this.setEvent();


        },

        setEvent : function(){
            this.ratingTarget.on("click",this.clickRating.bind(this));
        },

        clickRating : function(e){
            e.preventDefault();
            var clickValue = parseInt(e.target.value,10);
            this.drawRating(clickValue);
            this.trigger("change",{
                ratingScore: this.ratingScore
            })
        },

        drawRating : function(clickValue){
            if( clickValue > this.ratingScore){
                for(var i = this.ratingScore + 1 ; i<= clickValue;i++){
                    this.ratingTarget.eq(i).toggleClass("checked");
                }
            }else if(clickValue < this.ratingScore){
                for (var i = clickValue+1 ; i <= this.ratingScore ; i++){
                    this.ratingTarget.eq(i).toggleClass("checked");
                }
            }else if(clickValue === this.ratingScore){
                this.ratingTarget.eq(clickValue).toggleClass("checked");
                clickValue--;
            }
            this.ratingScore = clickValue;
        }
    });

    return Rating;
});