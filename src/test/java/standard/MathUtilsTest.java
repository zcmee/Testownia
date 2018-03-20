package standard;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(value = Parameterized.class)
public class MathUtilsTest {
    private MathUtils mathUtils;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        mathUtils = new MathUtils();
    }

    private int numberA; //{0} w parameters
    private int numberB;
    public Class<? extends Exception> expectedException;
    private int expected; //{3} w parameters

    public MathUtilsTest(int numberA, int numberB, Class<? extends Exception> expectedException,  int expected) {
        this.numberA = numberA;
        this.numberB = numberB;
        this.expectedException = expectedException;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: testAdd({0} + {1}) = {3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { -1, 5, IllegalArgumentException.class, 0 },
                { 0, -1, IllegalArgumentException.class, 0 },
                { 0, 0, null, 0 },
                { 1, 1, null, 2 },
                { 5, 12, null, 17 }
        });
    }

    @Test
    public void add() throws Exception {
        if (expectedException != null) { thrown.expect(expectedException); }
        Assert.assertEquals(expected, mathUtils.addPositiveValues(numberA, numberB));
    }

}