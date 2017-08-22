define(['AjaxWrapper'],function(AjaxWrapper){

    function addReservation(data){

        AjaxWrapper.postData("/reservations", data).then(function(result){
            $(location).attr('href', "/reservations");
        });
    }

    return {
        addReservation : addReservation
    }


});