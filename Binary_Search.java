package problemC;

import java.util.Scanner;

public class Binary_Search {
    public static void main(String[] args) {
        int arrSize, searchNum, pos, left, right, plus = 0, minus = 0;
        int modulo = 1000000007;
        long ans = 1;
        Scanner scanner = new Scanner(System.in);
        arrSize = scanner.nextInt();
        searchNum = scanner.nextInt();
        pos = scanner.nextInt();
        left = 0;
        right = arrSize;
        while (left < right) {
            int middle = (left + right) / 2;
            if (middle <= pos) {
                left = middle + 1;
                minus++;
            } else {
                right = middle;
                plus++;
            }
        }
        minus--;
        for (int i = arrSize - 1 - minus - plus; i > 0; i--) {
            ans *= i;
            ans = ans % modulo;
        }
        int plusNum = arrSize - searchNum;
        for (int i = 0; i < plus; i++) {
            ans *= plusNum;
            ans = ans % modulo;
            plusNum--;
        }
        int minusNum = searchNum - 1;
        for (int i = 0; i < minus; i++) {
            ans *= minusNum;
            ans = ans % modulo;
            minusNum--;
        }

        System.out.println(ans);
    }
}
