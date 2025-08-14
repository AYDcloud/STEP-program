import java.util.*;

class largeString {
    static long[] testStringConcat(int iterations) {
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < iterations; i++) s += "abc";
        long end = System.currentTimeMillis();
        return new long[]{end - start, s.length()};
    }

    static long[] testStringBuilder(int iterations) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) sb.append("abc");
        long end = System.currentTimeMillis();
        return new long[]{end - start, sb.length()};
    }

    static long[] testStringBuffer(int iterations) {
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) sb.append("abc");
        long end = System.currentTimeMillis();
        return new long[]{end - start, sb.length()};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of iterations: ");
        int iterations = sc.nextInt();
        long[] concatRes = testStringConcat(iterations);
        long[] builderRes = testStringBuilder(iterations);
        long[] bufferRes = testStringBuffer(iterations);
        System.out.printf("%-15s %-15s %-15s%n", "Method", "Time(ms)", "Final Length");
        System.out.printf("%-15s %-15d %-15d%n", "String", concatRes[0], concatRes[1]);
        System.out.printf("%-15s %-15d %-15d%n", "StringBuilder", builderRes[0], builderRes[1]);
        System.out.printf("%-15s %-15d %-15d%n", "StringBuffer", bufferRes[0], bufferRes[1]);
        sc.close();
    }
}
