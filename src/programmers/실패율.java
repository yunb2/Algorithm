package programmers;

import java.util.Arrays;

public class 실패율 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(solution(4, new int[]{4,4,4,4,4})));
    }

    public static int[] solution(int N, int[] stages) {

        Stage[] stageArr = new Stage[N];
        for(int i=0; i<N; ++i) stageArr[i] = new Stage(i+1);

        for(int stage : stages) {
            if(stage > N) continue;
            stageArr[stage-1].fail++;
        }

        double clear = stages.length;
        for(Stage stage : stageArr) {
            stage.total = clear;
            clear = stage.total - stage.fail;
        }

        return Arrays.stream(stageArr)
                .sorted()
                .mapToInt(stage -> stage.num)
                .toArray();
    }

    static class Stage implements Comparable<Stage> {
        int num;
        double fail, total;

        Stage(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(Stage o) {
            double rate1 = (this.total==0)? 0 : this.fail / this.total;
            double rate2 = (o.total==0)? 0 : o.fail/o.total;

            if(rate1 == rate2) return 0;
            return (rate1 > rate2)? -1 : 1;
        }

    }

}
