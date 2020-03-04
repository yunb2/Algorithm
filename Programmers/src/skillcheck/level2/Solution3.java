package skillcheck.level2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution3 {

    public static void main(String[] args) {

        String[] str = {"img120000bar020.zip", "amg12.png", "img02.png", "IMG01.GIF", "img1.png", "img2.JPG"};
        String[] answer = solution(str);
        System.out.println(Arrays.toString(answer));

    }

    static class File implements Comparable<File> {
        String name, head;
        Integer number, order;

        public File(String name, int order) {
            this.name = name;
            this.order = order;
        }

        @Override
        public String toString() {
            return "File{" +
                    "name='" + name + '\'' +
                    ", head='" + head + '\'' +
                    ", number=" + number +
                    ", order=" + order +
                    '}';
        }

        @Override
        public int compareTo(File o) {
            if(this.head.equals(o.head)) {
                if(this.number.equals(o.number)) return this.order-o.order;
                return this.number - o.number;
            }
            return this.head.compareTo(o.head);
        }
    }

    public static String[] solution(String[] files) {

        PriorityQueue<File> q = new PriorityQueue<>();

        for(int order = 0; order < files.length; ++order) {
            String name = files[order];
            File file = new File(name, order);

            out:
            for(int i=0; i<name.length(); ++i) {
                if(Character.isDigit(name.charAt(i))) {
                    file.head = name.substring(0, i).toUpperCase();

                    for(int j=i+1; j<name.length(); ++j) {
                        if(!Character.isDigit(name.charAt(j))) {
                            String num = name.substring(i, j);
                            if(num.length()>5) num = num.substring(0, 5);
                            file.number = Integer.parseInt(num);
                            break out;
                        }
                    }
                    String num = name.substring(i);
                    if(num.length()>5) num = num.substring(0, 5);
                    file.number = Integer.parseInt(num);
                    break;
                }
            }

            q.offer(file);
        }

        String[] answer = new String[q.size()];
        int i = 0;
        while(!q.isEmpty()) {
            File file = q.peek();
            answer[i++] = q.poll().name;
            System.out.println(file);
        }

        return answer;
    }

}
