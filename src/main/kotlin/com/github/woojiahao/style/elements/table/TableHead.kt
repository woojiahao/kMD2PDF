package com.github.woojiahao.style.elements.table

import com.github.woojiahao.style.FontFamily
import com.github.woojiahao.style.elements.Element

/**
 * <thead></thead> element.
 */
class TableHead(
  fontSize: Double = 16.0,
  fontFamily: FontFamily = FontFamily(FontFamily.BaseFontFamily.SANS_SERIF)
) : Element("thead", fontSize, fontFamily)