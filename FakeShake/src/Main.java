import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting");

        long start = System.currentTimeMillis();
        String s = MimicShake.mimicForThisManyLines(10000000, "thy");
        long stop = System.currentTimeMillis();

        System.out.println("Finished " + (start - stop) + " milliseconds");
    }
}
