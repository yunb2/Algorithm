package programmers.kakao;

import java.util.Arrays;

public class 파일명정렬 {

    public static void main(String[] args) {

        String[] files = {"img12.png", "img10.png", "img100000.png", "IMG71111.GIF", "img2.JPG", "img02abc111.png"};
        System.out.println(Arrays.toString(files));
        System.out.println(Arrays.toString(solution(files)));

    }

    static class File implements Comparable<File> {
        String name, head;
        Integer number;

        public File(String name, String head, Integer number) {
            this.name = name;
            this.head = head;
            this.number = number;
        }

        @Override
        public int compareTo(File o) {
            return (this.head.equals(o.head))?
                    (this.number - o.number) :
                    (this.head.compareTo(o.head));
        }
    }

    public static String[] solution(String[] files) {

        return Arrays.stream(files)
                .map(파일명정렬::makeFile)
                .sorted()
                .parallel()
                .map((file) -> file.name)
                .toArray(String[]::new);
    }

    public static File makeFile(String name) {

        String head = name.split("\\d")[0].toUpperCase();
        String number = Arrays.stream(name.split("\\D"))
                            .filter(s -> s.length()>0)
                            .findFirst().get();

        return new File(name, head, Integer.parseInt(number));
    }

}


