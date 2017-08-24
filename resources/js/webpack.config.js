module.exports = {
    entry: {
        "mainpage" : './mainpage/mainpage.js',
        "detail" :  './detail/detail.js',
        "myreservation" : './myreservation/myreservation.js',
        "reviewWrite" : "./reviewWrite/reviewWrite.js",
        'reserve' : './reserve/reserve.js',
        'comment' : './comment/comment.js'
        // "reserve" : './reserve/reserve.js'
    },

    output: {
        path: __dirname + '/bundle/',
        filename: '[name]bundle.js'
    },
    devServer: {
        inline: true,
        port: 7777,
        contentBase: __dirname + '/public/'
    },
    // module: {
    //     loaders: [
    //         {
    //             test: /\.js$/,
    //             loader: 'babel-loader',
    //             exclude: /node_modules/,
    //             query: {
    //                 cacheDirectory: true,
    //                 presets: ['es2015']
    //             }
    //         }
    //     ]
    // }
};
