package com.github.woojiahao.style.elements.lists

import com.github.woojiahao.style.css.CssAttributes
import com.github.woojiahao.style.css.CssSelector
import com.github.woojiahao.style.elements.Element
import com.github.woojiahao.style.utility.FontFamily
import com.github.woojiahao.style.utility.FontFamily.BaseFontFamily.SANS_SERIF

open class List(
  private val elementName: String,
  fontSize: Double = 16.0,
  fontFamily: FontFamily = FontFamily(SANS_SERIF)
) : Element(elementName, fontSize, fontFamily) {

  enum class ListStylePosition {
    INSIDE, OUTSIDE
  }

  enum class ListStyleType {
    CIRCLE,
    DISC,
    SQUARE,
    ARMENIAN,
    CJK_IDEOGRAPHIC,
    DECIMAL,
    DECIMAL_LEADING_ZERO,
    GEORGIAN,
    HEBREW,
    HIRAGANA,
    HIRAGANA_IROHA,
    KATAKANA,
    KATAKANA_IROHA,
    LOWER_ALPHA,
    LOWER_GREEK,
    LOWER_LATIN,
    LOWER_ROMAN,
    UPPER_ALPHA,
    UPPER_GREEK,
    UPPER_LATIN,
    UPPER_ROMAN,
    NONE;

    fun toCss() = name.toLowerCase().replace("_", "-")
  }

  open var listStyleType = ListStyleType.CIRCLE

  open var listStylePosition = ListStylePosition.OUTSIDE

  var listStyleImage: String? = null

  override fun toCss(): String {
    val listAttributes = CssAttributes()
      .add("list-style-type", listStyleType.toCss())
      .add("list-style-image", listStyleImage?.let { "url($it)" })
      .add("list-style-position", listStylePosition.name.toLowerCase())
    val listSelector = CssSelector(elementName, listAttributes)
    css.add(listSelector)
    return super.toCss()
  }
}