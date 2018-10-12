package arthmetic;

public class JumpFloorII {
    public int jumpFloorII(int target) {
        if(target <= 0){
            return -1;
        }else if (target == 1){
            return 1;
        }else {
            return 2*jumpFloorII(target - 1);
        }
    }
}
