package codility.lesson;

public class FrogJump {

    public int solution(int X, int Y, int D) {
        return (Y - X) / D + (((Y - X) % D == 0)? 1 : 0);
    }

}
