package Josh

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class TestThing {

    fun double(x: Int): Int {
        return 2 * x
    }

    @Test
    internal fun testSum() {

        val underTest = TestThing()
        val expected = 42
        assertEquals(expected, underTest.double(21))
    }
}