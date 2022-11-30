package com.charter.assesmentByDipes.helper;

public class RewardUtils {
    public static Integer calculateRewardPoint(Long value) {
        int rewardPoint = 0 ;
        if (value > 100) {
            rewardPoint = (int) (((value - 100) * 2) + 50);
        } else if (value > 50 && value < 100) {
            rewardPoint = (int) (value - 50);
        }
        return rewardPoint;
    }
}
