module.exports = {
  devServer: {
    port: 8080,
    proxy: {
      '/': {
        target: 'http://localhost:8081',
        changeOrigin: true,
        pathRewrite: {
          '/': ''
        }
      }
    }
  }
}
