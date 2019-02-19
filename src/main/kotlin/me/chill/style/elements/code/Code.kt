package me.chill.style.elements.code

import me.chill.style.Box
import me.chill.style.FontFamily
import me.chill.style.FontFamily.BaseFontFamily.MONOSPACE
import me.chill.style.elements.Element
import me.chill.utility.c

open class Code(
  elementName: String,
  fontSize: Double = 16.0,
  fontFamily: FontFamily = FontFamily(MONOSPACE)
) : Element(elementName, fontSize, fontFamily) {
  override var fontColor = c("FF3D00")
  override var backgroundColor = c("#F5F5F5")
  override var padding: Box<Double>? = Box(10.0)
}