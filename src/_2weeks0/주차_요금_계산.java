package _2weeks0;

import java.util.*;

public class 주차_요금_계산 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})));
    }

    static class Solution {
        public int[] solution(int[] fees, String[] records) {
            Record[] recordArr = new Record[records.length];
            for (int i = 0; i < records.length; i++) {
                StringTokenizer st = new StringTokenizer(records[i]);
                String[] time = st.nextToken().split(":");
                int hour = Integer.parseInt(time[0]);
                int minutes = Integer.parseInt(time[1]);
                int num = Integer.parseInt(st.nextToken());
                recordArr[i] = new Record(num, hour, minutes);
            }

            FeeCalculator feeCalculator = new FeeCalculator(fees);
            for (Record record : recordArr) {
                feeCalculator.record(record);
            }
            return feeCalculator.getAnswer();
        }

        static class FeeCalculator {
            int cnt = 0;
            Map<Integer, Integer> keyMap = new HashMap<>();
            List<Stack<Record>> recentList = new ArrayList<>();

            int[] fees;

            public FeeCalculator(int[] fees) {
                this.fees = fees;
            }

            void record(Record record) {
                if (!keyMap.containsKey(record.num)) {
                    keyMap.put(record.num, cnt++);
                    recentList.add(new Stack<>());
                }

                recentList.get(keyMap.get(record.num)).add(record);
            }

            int[] getAnswer() {
                Map<Integer, Integer> feeMap = new HashMap<>();
                for (Stack<Record> stack : recentList) {
                    if (stack.size() % 2 != 0) {
                        stack.add(new Record(stack.peek().num, 23, 59));
                    }

                    int diffMinutes = 0;
                    int num = stack.peek().num;
                    while (!stack.isEmpty()) {
                        Record out = stack.pop();
                        Record in = stack.pop();
                        diffMinutes += (out.hour - in.hour) * 60 + (out.minute - in.minute);
                    }
                    int fee = calculate(diffMinutes);
                    feeMap.put(num, fee);
                }

                int[] answer = new int[cnt];
                int[] key = feeMap.keySet().stream().mapToInt(i -> i).toArray();
                Arrays.sort(key);
                for (int i = 0;i < cnt; i++) {
                    answer[i] = feeMap.get(key[i]);
                }
                return answer;
            }

            int calculate(int diffMinutes) {
                if (fees[0] < diffMinutes) {
                    return (int) Math.ceil(((double) diffMinutes - fees[0]) / fees[2]) * fees[3] + fees[1];
                } else {
                    return fees[1];
                }
            }
        }

        static class Record {
            int num;
            int hour;
            int minute;

            public Record(int num, int hour, int minute) {
                this.num = num;
                this.hour = hour;
                this.minute = minute;
            }
        }
    }

}
