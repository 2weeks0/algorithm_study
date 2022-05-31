package _2weeks0;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_22859 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String html = br.readLine();

        StringBuilder sb = new StringBuilder();
        int idxDivOpen = 0;
        while ((idxDivOpen = html.indexOf("<div", idxDivOpen)) != -1) {
            int idxDivClose = html.indexOf("</div>", idxDivOpen);

            int titleIdxLeft = html.indexOf("title=\"", idxDivOpen) + 7;
            int titleIdxRight = html.indexOf("\"", titleIdxLeft);
            String title = html.substring(titleIdxLeft, titleIdxRight);
            sb.append(String.format("title : %s\n", title));

            int idxPOpen = idxDivOpen;
            while ((idxPOpen = html.indexOf("<p>", idxPOpen)) != -1 && idxPOpen < idxDivClose) {
                int idxPClose = html.indexOf("</p>", idxPOpen);
                String p = html.substring(idxPOpen + 3, idxPClose).trim();

                char prev = '>';
                for (int i = 0; i < p.length(); i++) {
                    char cur = p.charAt(i);
                    if (cur == '<' || cur == '>') {
                        prev = cur;
                        continue;
                    } else if (prev == '<' || (cur == ' ' && sb.charAt(sb.length() - 1) == ' ')) {
                        continue;
                    }
                    prev = cur;
                    sb.append(cur);
                }
                sb.append('\n');
                idxPOpen = idxPClose;
            }

            idxDivOpen = idxDivClose;
        }

        System.out.print(sb);
        br.close();
    }
}