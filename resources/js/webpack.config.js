module.exports = {
    entry: {
        reserve : './reserve/reserve.js',
        comment : './comment/comment.js'
    },

    output: {
        path: __dirname + '/public/',
        filename: '[name]bundle.js'
    },

    module: {
        loaders: [
            {
                test: /\.js$/,
                loader: 'babel-loader',
                exclude: /node_modules/,
                query: {
                    cacheDirectory: true,
                    presets: ['es2015']
                }
            }
        ]
    }
};