package me.chill.style

/**
 * Handles the font families to be rendered. A set of [fonts] can be given during object
 * creation to load into the [FontFamily] before hand.
 */
class FontFamily(private vararg val fonts: String) {

  private val fontFamily = mutableListOf<String>()

  init {
    fontFamily.addAll(fonts)
  }

  /**
   * Unary + used in DSL to add a new font to the [FontFamily].
   */
  operator fun String.unaryPlus() = fontFamily.add(this)

  /**
   * Clears fonts stored in [FontFamily].
   */
  fun emptyFontFamily() = fontFamily.clear()

  /**
   * Converts the [FontFamily] to the string format appropriate for CSS styles to use.
   */
  fun getFontFamilyString() = fontFamily.joinToString(", ") { "\"$it\"" }
}