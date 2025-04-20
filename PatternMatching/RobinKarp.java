public class RobinKarp {
    private static void search(String text, String pattern) {
        int M = pattern.length();
        int N = text.length();
        int h = 1;
        int d = 256;
        int q = 101;

        for (int i = 0; i < M - 1; i++) {
            h = (h * d) % q;
        }

        int p = 0;
        int t = 0;

        for (int i = 0; i < M; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        for (int i = 0; i <= N - M; i++) {
            if (p == t) {
                int j;
                for (j = 0; j < M; j++) {
                    if (pattern.charAt(j) != text.charAt(i + j)) {
                        break;
                    }
                }
                if (j == M) {
                    System.out.println("Pattern found at index " + i);
                }
            }
            if (i < N - M) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + M)) % q;
                if (t < 0) {
                    t += q;
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABABABDAVGTDS";
        String pattern = "ABDA";
        search(text, pattern);
    }
}
