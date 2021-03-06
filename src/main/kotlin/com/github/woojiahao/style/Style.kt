package com.github.woojiahao.style

import com.github.woojiahao.style.css.CssAttributes
import com.github.woojiahao.style.css.CssSelector
import com.github.woojiahao.style.elements.*
import com.github.woojiahao.style.elements.code.CodeBlock
import com.github.woojiahao.style.elements.code.InlineCode
import com.github.woojiahao.style.elements.document.DocumentFooter
import com.github.woojiahao.style.elements.document.DocumentHeader
import com.github.woojiahao.style.elements.headers.*
import com.github.woojiahao.style.elements.lists.OrderedList
import com.github.woojiahao.style.elements.lists.UnorderedList
import com.github.woojiahao.style.elements.table.Table

class Style(val settings: Settings = Settings()) {

  companion object {
    inline fun createStyle(settings: Settings = Settings(), style: Style.() -> Unit) =
      Style(settings).apply(style)
  }

  val h1 = HeadingOne(settings)
  val h2 = HeadingTwo(settings)
  val h3 = HeadingThree(settings)
  val h4 = HeadingFour(settings)
  val h5 = HeadingFive(settings)
  val h6 = HeadingSix(settings)
  val inlineCode = InlineCode(settings)
  val codeBlock = CodeBlock(settings)
  val strong = Bold(settings)
  val em = Emphasis(settings)
  val p = Paragraph(settings)
  val a = Link(settings)
  val ul = UnorderedList(settings)
  val ol = OrderedList(settings)
  val blockquote = BlockQuote(settings)
  val img = Image(settings)
  val table = Table(settings)
  val del = Strikethrough(settings)
  val hr = Ruler(settings)
  val header = DocumentHeader(settings)
  val footer = DocumentFooter(settings)

  val elements = listOf(
    h1,
    h2,
    h3,
    h4,
    h5,
    h6,
    p,
    inlineCode,
    codeBlock,
    strong,
    em,
    a,
    ul,
    ol,
    blockquote,
    img,
    img.figcaption,
    table,
    table.thead,
    table.tbody,
    table.th,
    table.td,
    table.tr,
    del,
    hr,
    header,
    header.left,
    header.right,
    header.center,
    footer,
    footer.left,
    footer.right,
    footer.center
  )

  val monospaceElements = listOf(codeBlock, inlineCode)

  val regularElements = elements.minus(monospaceElements)

  val customStyles = mutableListOf<CssSelector>()

  inline fun inlineCode(style: InlineCode.() -> Unit) = inlineCode.style()

  inline fun codeBlock(style: CodeBlock.() -> Unit) = codeBlock.style()

  inline fun strong(style: Bold.() -> Unit) = strong.style()

  inline fun em(style: Emphasis.() -> Unit) = em.style()

  inline fun p(style: Paragraph.() -> Unit) = p.style()

  inline fun a(style: Link.() -> Unit) = a.style()

  inline fun ul(style: UnorderedList.() -> Unit) = ul.style()

  inline fun ol(style: OrderedList.() -> Unit) = ol.style()

  inline fun blockquote(style: BlockQuote.() -> Unit) = blockquote.style()

  inline fun img(style: Image.() -> Unit) = img.style()

  inline fun table(style: Table.() -> Unit) = table.style()

  inline fun del(style: Strikethrough.() -> Unit) = del.style()

  inline fun hr(style: Ruler.() -> Unit) = hr.style()

  inline fun h1(style: HeadingOne.() -> Unit) = h1.style()

  inline fun h2(style: HeadingTwo.() -> Unit) = h2.style()

  inline fun h3(style: HeadingThree.() -> Unit) = h3.style()

  inline fun h4(style: HeadingFour.() -> Unit) = h4.style()

  inline fun h5(style: HeadingFive.() -> Unit) = h5.style()

  inline fun h6(style: HeadingSix.() -> Unit) = h6.style()

  inline fun header(style: DocumentHeader.() -> Unit) = header.style()

  inline fun footer(style: DocumentFooter.() -> Unit) = footer.style()

  inline fun selector(selector: String, style: CssAttributes.() -> Unit) {
    customStyles += CssSelector(selector, CssAttributes().apply(style))
  }

  fun getStyles(): String {
    val separator = "\n\n"
    val elementStyles = elements.joinToString(separator) { it.toCss() }
    val customStyles = customStyles.joinToString(separator) { it.toCss() }
    return "$elementStyles$separator$customStyles"
  }
}
