package org.firstinspires.ftc.teamcode;

public class Utilities {
    public static double map393(double requestedPower) {
        return map(requestedPower, -1, 1, Constants.VEX_393_LOWER_BOUND, Constants.VEX_393_UPPER_BOUND);
    }

    public static double map(double value, double in_min, double in_max, double out_min, double out_max) {
        return (value - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }
}
