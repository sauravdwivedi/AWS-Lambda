import kotlin.test.Test
import kotlin.test.assertEquals

internal class ModelTest {

    private val testModel: Model = Model()

    @Test
    fun testSum() {
        val expected: Double = 42.0
        assertEquals(expected, testModel.arithOps(40.0, 2.0, "ADD"))
    }

    @Test
    fun testMultiply() {
        val expected: Double = 200.0
        assertEquals(expected, testModel.arithOps(40.0, 5.0, "MULTIPLY"))
    }

    @Test
    fun testSubtract() {
        val expected: Double = 38.0
        assertEquals(expected, testModel.arithOps(40.0, 2.0, "SUBTRACT"))
    }

    @Test
    fun testDivide() {
        val expected: Double = 8.0
        assertEquals(expected, testModel.arithOps(40.0, 5.0, "DIVIDE"))
    }
}
