package me.chill.utility

import java.awt.Color

/**
 * Returns a number in pixel format.
 */
val <T : Number> T.px
  get() = "${this}px"

/**
 * Returns a matching [Color] based on the given [hexCode].
 */
fun c(hexCode: String): Color? {
  val convertedHexCode = hexCode.replace("#", "").toLowerCase()

  require(convertedHexCode.length == 6) { "Invalid hex code length (${convertedHexCode.length})" }

  convertedHexCode.forEach {
    require(it.isLetterOrDigit()) { "Invalid character ($it) in hex code" }
    if (it.isLetter()) {
      require(it in 'a'..'f') { "Invalid character ($it)" }
    }
  }

  return Color.decode("#$convertedHexCode")
}