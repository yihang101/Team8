function throttle(fn, delay) {
  var t = null
  var begin = new Date().getTime()

  return function() {
    var _self = this
    var args = arguments
    var cur = new Date().getTime()

    clearTimeout(t)

    if (cur - begin >= delay) {
      fn.apply(_self, args)
      begin = cur
    } else {
      t = setTimeout(function() {
        fn.apply(_self, args)
      }, delay)
    }
  }
}

export {
  throttle
}
