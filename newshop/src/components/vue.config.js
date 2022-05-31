module.exports = {
  devServer: {
    port: 9090,
    proxy: {
      '/api': {
        target: 'http://localhost:8081',
        changeOrigin: true,
        pathRewrite: {
          '/api': ''
        }
      }
    }
  }
}
