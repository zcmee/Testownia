package standard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(value = Parameterized.class)
public class MathUtilsTest {
    private MathUtils mathUtils;

    @Before
    public void setUp() {
        mathUtils = new MathUtils();
    }

    private int numberA; //{0} w parameters
    private int numberB;
    private int expected; //{2} w parameters

    public MathUtilsTest(int numberA, int numberB, int expected) {
        this.numberA = numberA;
        this.numberB = numberB;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: testAdd({0}+{1}) = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 0, 0, 0 }, { 1, 1, 2 }, { 5, 12, 17 }
        });
    }

    @Test
    public void add() throws Exception {
        Assert.assertEquals(expected, mathUtils.add(numberA, numberB));
    }

}