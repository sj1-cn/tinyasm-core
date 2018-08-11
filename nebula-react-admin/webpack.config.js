// webpack.config.js
const WebpackRequireFrom = require('webpack-require-from')
const webpackRequireFromConfig = {
  // see configuration options below
}
module.exports = {
    output: {
      publicPath: '/webpack/'
    },
    plugins: [
      new WebpackRequireFrom(webpackRequireFromConfig)
    ]
}