package com.github.woojiahao.style.elements

import com.github.woojiahao.style.utility.FontFamily
import com.github.woojiahao.style.utility.FontFamily.BaseFontFamily.SANS_SERIF

class Image(
  fontSize: Double = 16.0,
  fontFamily: FontFamily = FontFamily(SANS_SERIF)
) : Element("img", fontSize, fontFamily) {

  val figCaption = FigCaption(fontSize, fontFamily.clone())

  fun figcaption (style: FigCaption.() -> Unit) = figCaption.style()
}