package me.chill.style

import me.chill.style.Border.BorderStyle.*
import me.chill.utility.c
import org.junit.Test
import java.awt.Color
import kotlin.test.assertEquals

class BorderTest {
  @Test
  fun `Default border is 0 width, black color and NONE`() {
    with (Border()) {
      checkBorderSettings(0.0, NONE, Color.BLACK)
    }
  }

  @Test
  fun `DSL sets border style to respective value`() {
    Border.BorderStyle
      .values()
      .forEach { it.testDSL() }
  }

  @Test
  fun `clearBorder resets border to default`() {
    with (Border()) {
      border {
        4.1 dashed c("EDE7F6")
      }
      clearBorder()
      checkBorderSettings(0.0, NONE, Color.BLACK)
    }
  }

  private fun Border.BorderStyle.testDSL() {
    val borderWidth = 2.0
    val borderColor = Color.RED

    with (Border()) {
      border {
        when (this@testDSL) {
          DOTTED -> borderWidth dotted borderColor
          DASHED -> borderWidth dashed borderColor
          SOLID -> borderWidth solid borderColor
          DOUBLE -> borderWidth double borderColor
          GROOVE -> borderWidth groove borderColor
          RIDGE -> borderWidth ridge borderColor
          INSET -> borderWidth inset borderColor
          OUTSET -> borderWidth outset borderColor
          NONE -> borderWidth none borderColor
          HIDDEN -> borderWidth hidden borderColor
        }
      }

      checkBorderSettings(borderWidth, this@testDSL, borderColor)
    }
  }

  private fun Border.border(load: Border.() -> Unit) = apply { load() }

  private fun Border.checkBorderSettings(
    borderWidth: Double,
    borderStyle: Border.BorderStyle,
    borderColor: Color?
  ) {
    assertEquals(borderWidth, this.borderWidth)
    assertEquals(borderStyle, this.borderStyle)
    assertEquals(borderColor, this.borderColor)
  }
}