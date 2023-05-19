package etc;

import java.util.Arrays;

public class lotto {
    public static void main(String[] args) {
        int n = 6;
        int[] lotto = new int[n];

        // 번호 생성
        for (int i = 0; i < n; i++) {
            lotto[i] = (int) (Math.random() * 45) + 1;

            // 중복 번호 제거
            for (int j = 0; j < i; j++) {
                if (lotto[i] == lotto[j]) {
                    i--;
                    break;
                }
            }
        }

        Arrays.sort(lotto);
        System.out.print("로또 번호: ");
        // 번호 출력
        for (int i = 0; i < n; i++) {
            System.out.print(lotto[i] + " ");
        }
    }
}