package standard;

public class MathUtils {

    public int addPositiveValues(int a, int b) {
        if(a < 0 ) throw new IllegalArgumentException("a musi być >= 0 ");
        if(b < 0 ) throw new IllegalArgumentException("b musi być >= 0 ");
        return a + b;
    }

}
