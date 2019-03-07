package com.github.woojiahao.style

import com.github.woojiahao.style.utility.FontFamily
import com.github.woojiahao.style.utility.FontFamily.BaseFontFamily.MONOSPACE
import com.github.woojiahao.style.utility.FontFamily.BaseFontFamily.SANS_SERIF

class Settings {
  var fontSize = 16.0
  var font = FontFamily(SANS_SERIF)
    get() = field.clone()
  var monospaceFont = FontFamily(MONOSPACE)
    get() = field.clone()
}

inline fun settings(configuration: Settings.() -> Unit) = Settings().apply { configuration() }
