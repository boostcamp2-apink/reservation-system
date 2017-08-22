// webpack.config.js
module.exports = {
    resolve : {
        alias : {
            MyreservationModel :  './myreservationModel',
            ReservationList : './reservationList',
            ReservationPopup : './reservationPopup'
        }
    },
    entry: {
        'myreservation': './myreservation/myreservation.js'
    },
    output: {
        filename: './bundle/[name]bundle.js'
    }
};
