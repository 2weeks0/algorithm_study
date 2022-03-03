package _2weeks0;

import java.util.*;

public class 신고_결과_받기 {
    public static void main(String[] args) {
        new Solution().solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3);
    }


    static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            Map<String, Integer> keyMap = getKeyMap(id_list);
            int[] cnt = new int[id_list.length];

            Set<Report> reportSet = new HashSet<>();
            for (String str : report) {
                StringTokenizer st = new StringTokenizer(str);
                Report report1 = new Report(st.nextToken(), st.nextToken());
                if (!reportSet.contains(report1)) {
                    reportSet.add(report1);
                    cnt[keyMap.get(report1.targetId)]++;
                }
            }

            Set<String> pausedIdSet = new HashSet<>();
            for (String id : id_list) {
                if (k <= cnt[keyMap.get(id)]) {
                    pausedIdSet.add(id);
                }
            }

            int[] answer = new int[id_list.length];
            for (Report r : reportSet) {
                if (pausedIdSet.contains(r.targetId)) {
                    answer[keyMap.get(r.id)]++;
                }
            }

            return answer;
        }

        Map<String, Integer> getKeyMap(String[] id_list) {
            Map<String, Integer> result = new HashMap<>();
            int key = 0;
            for (String id : id_list) {
                result.put(id, key++);
            }
            return result;
        }

        static class Report {
            String id;
            String targetId;

            public Report(String id, String targetId) {
                this.id = id;
                this.targetId = targetId;
            }

            @Override
            public boolean equals(Object obj) {
                if (!(obj instanceof Report)) {
                    return false;
                }
                return id.equals(((Report) obj).id) && targetId.equals(((Report) obj).targetId);
            }

            @Override
            public int hashCode() {
                return id.hashCode() + targetId.hashCode();
            }
        }
    }
}
