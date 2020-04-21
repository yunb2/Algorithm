package programmers;

import java.util.Arrays;
import java.util.Optional;

public class 방금그곡 {

    public static void main(String[] args) {
        String m = "ABC#";
        String[] musicinfos = {
                "12:00,12:14,HELLO,C#DEFGAB",
                "13:00,13:14,WORLD,ABCDEF"
        };
        System.out.println(solution(m, musicinfos));
    }

    static class MusicInfo implements Comparable<MusicInfo> {
        String title, melody;

        public MusicInfo(String title, String melody) {
            this.title = title;
            this.melody = melody;
        }

        @Override
        public int compareTo(MusicInfo o) {
            return o.melody.length() - this.melody.length();
        }
    }

    public static String solution(String m, String[] musicinfos) {

        Optional<MusicInfo> answer = Arrays.stream(musicinfos)
                                            .map(방금그곡::makeMusicInfo)
                                            .filter(musicinfo -> musicinfo.melody.contains(replaceMelody(m)))
                                            .sorted()
                                            .findFirst();

        return (answer.isPresent())? answer.get().title : "(None)";
    }

    public static String replaceMelody(String melody) {
        return melody.replace("C#", "c")
                    .replace("D#", "d")
                    .replace("F#", "f")
                    .replace("G#", "g")
                    .replace("A#", "a");
    }

    public static MusicInfo makeMusicInfo(String musicinfo) {
        String[] str = musicinfo.split(",");
        int playTime = timeToMin(str[1]) - timeToMin(str[0]);
        return new MusicInfo(str[2], makeMelody(playTime, str[3]));
    }

    public static String makeMelody(int playTime, String melody) {
        melody = replaceMelody(melody);
        StringBuilder sb = new StringBuilder();

        if(playTime > melody.length()) {
            int division = playTime/melody.length();
            for(int i=0; i<division; ++i) sb.append(melody);
            playTime %= melody.length();
        }
        sb.append(melody, 0, playTime);

        return sb.toString();
    }

    public static int timeToMin(String time) {
        String[] str = time.split(":");
        int h = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        return (h * 60) + m;
    }

}
