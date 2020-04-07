package codingtest.line;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(solution("4132315142", new String[] {"3241523133","4121314445","3243523133","4433325251","2412313253"}));
        System.out.println(solution("53241", new String[] {"53241", "42133", "53241", "14354"}));
        System.out.println(solution("24551", new String[] {"24553", "24553", "24553", "24553"}));
    }

    public static int solution(String answer_sheet, String[] sheets) {
        int answer = -1;

        for(int i=0; i<sheets.length-1; ++i) {
            for(int j=i+1; j<sheets.length; ++j) {

                int score = calScore(answer_sheet, sheets[i], sheets[j]);

                answer = Math.max(answer, score);

            }
        }

        return answer;
    }

    private static int calScore(String answer_sheet, String sheet1, String sheet2) {

        int cnt = 0, max = 0, len = 0;

        for(int i=0; i<answer_sheet.length(); ++i) {

            char[] chars = {answer_sheet.charAt(i), sheet1.charAt(i), sheet2.charAt(i)};

            if(chars[1] == chars[2] && chars[0] != chars[1]) {
                cnt++;
                len++;
                continue;
            }

            max = Math.max(max, len);
            len = 0;
        }

        max = Math.max(max, len);
        return cnt + (max * max);
    }

}
