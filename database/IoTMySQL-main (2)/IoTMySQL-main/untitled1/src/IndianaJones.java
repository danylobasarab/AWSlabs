import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IndianaJones {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("ijones.in"));
            FileWriter writer = new FileWriter("ijones.out");

            String[] dimensions = reader.readLine().split(" ");
            int W = Integer.parseInt(dimensions[0]);
            int H = Integer.parseInt(dimensions[1]);

            char[][] corridor = new char[W][H];
            for (int i = 0; i < H; i++) {
                String line = reader.readLine();
                for (int j = 0; j < W; j++) {
                    corridor[j][i] = line.charAt(j);
                }
            }

            long result = countPaths(W, H, corridor);
            writer.write(Long.toString(result));

            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long countPaths(int W, int H, char[][] corridor) {
        long[][] dp = new long[H][W];
        dp[H - 1][W - 1] = 1;

        for (int i = H - 2; i >= 0; i--) {
            for (int j = W - 1; j >= 0; j--) {
                if (corridor[j][i] == corridor[j][i + 1]) {
                    dp[i][j] += dp[i + 1][j];
                }
                dp[i][j] += dp[i][j + 1];
                dp[i][j] %= (long) (1e9 + 7);
            }
        }

        return dp[0][0];
    }
}
