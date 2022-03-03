package _2weeks0;

public class k진수에서_소수_개수_구하기 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(1_000_000, 3));
    }

    static class Solution {
        public int solution(int n, int k) {
            int answer = 0;

            String kString = getKString(n, k);
            System.out.println(kString);
            int idx = -1;
            for (int i = 0; i < kString.length(); i++) {
                if (kString.charAt(i) != '0') {
                    if (idx == -1) {
                        idx = i;
                    }
                } else {
                    if (idx != -1) {
                        if (isPrime(Long.parseLong(kString.substring(idx, i)))) {
                            answer++;
                        }
                    }
                    idx = -1;
                }
            }
            if (idx != -1) {
                if (isPrime(Long.parseLong(kString.substring(idx)))) {
                    answer++;
                }
            }
            return answer;
        }

        boolean isPrime(long n) {
            if (n == 1) {
                return false;
            }
            long sqrt = (long) Math.sqrt(n);
            for (long i = 2; i <= sqrt; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }

        String getKString(int n, int k) {
            StringBuilder sb = new StringBuilder();
            int temp = 1;
            while (temp <= n) {
                temp *= k;
            }
            temp /= k;
            while (temp != 0) {
                for (int i = k - 1; 0 <= i; i--) {
                    if (0 <= n - i * temp) {
                        n -= i * temp;
                        temp /= k;
                        sb.append(i);
                        break;
                    }
                }
            }
            return sb.toString();
        }
    }
}
