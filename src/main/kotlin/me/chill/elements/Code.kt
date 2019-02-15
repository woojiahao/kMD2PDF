package me.chill.elements

import java.awt.Color

open class Code(fontSize: Double = 16.0) : Element(fontSize) {
  override var fontFamily = listOf("Courier")
  override var fontColor: Color = Color.decode("#FF3D00")
  override var backgroundColor: Color? = Color.decode("#FAFAFA")
}