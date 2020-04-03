package programmers.kakao;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {

    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[] {7,4,5,6}));
        System.out.println(solution(100, 100, new int[] {10}));
        System.out.println(solution(100, 100, new int[] {10,10,10,10,10,10,10,10,10,10}));
        System.out.println(solution(10000, 10000, new int[10000]));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        int t = 0, total = truck_weights[0], next = 1;

        Queue<Truck> bridge = new LinkedList<>();
        bridge.add(new Truck(truck_weights[0], 1));

        while(!bridge.isEmpty()) {

            if(bridge.peek().t + bridge_length <= ++t) {
                Truck truck = bridge.poll();
                total -= truck.w;
            }

            if(next < truck_weights.length && (total + truck_weights[next]) <= weight) {
                bridge.add(new Truck(truck_weights[next], t));
                total += truck_weights[next++];
            }

        }

        return t;
    }

    static class Truck {
        int w, t;

        public Truck(int w, int t) {
            this.w = w;
            this.t = t;
        }

        @Override
        public String toString() {
            return "Truck{" +
                    "w=" + w +
                    ", t=" + t +
                    '}';
        }
    }

}
