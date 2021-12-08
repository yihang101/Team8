module.exports = {
  devServer: {
    port: 8080,
    proxy: {
      '/api': {
        target: 'http://47.113.191.216:8081',
        changeOrigin: true,
        pathRewrite: {
          '/api': ''
        }
      }
    }
  }
}
