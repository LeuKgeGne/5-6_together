package by.bsuir.Processor

import by.bsuir.logic.Manipulations
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner.class)
@SpringBootTest
class ManipulationsTest {

    @Test
    void testIsIsoscelesTriangle() {
        int side1 = 1
        int side2 = 2
        int side3 = 3

        boolean actual = Manipulations.instance.isEquilateralTriangle(side1, side2, side3)
        boolean expected = false

        Assert.assertEquals(expected, actual)
    }

    @Test
    void testIsEquilateralTriangle() {
        int side1 = 1
        int side2 = 2
        int side3 = 3

        boolean actual = Manipulations.instance.isEquilateralTriangle(side1, side2, side3)
        boolean expected = false

        Assert.assertEquals(expected, actual)
    }

    @Test
    void testIsRightTriangle() {
        int side1 = 3
        int side2 = 4
        int side3 = 5

        boolean actual = Manipulations.instance.isRightTriangle(side1, side2, side3)
        boolean expected = true

        Assert.assertEquals(expected, actual)
    }
}
