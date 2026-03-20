package org.firstinspires.ftc.driveexamples;

public class Utilities {

    /**
     * Maps a value from one range to another.
     * Used to convert joystick input range to servo-safe output range.
     *
     * @param value  The value to map
     * @param in_min  The lower bound of the input range
     * @param in_max  The upper bound of the input range
     * @param out_min The lower bound of the output range
     * @param out_max The upper bound of the output range
     * @return The mapped value in the output range
     */
    public static double map(double value, double in_min, double in_max, double out_min, double out_max) {
        return (value - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }

    /**
     * Maps a joystick value (-1 to 1) to VEX 393 CR Servo safe range.
     * VEX 393 servos respond best within the bounds defined in Constants.
     *
     * @param power The raw power value from -1.0 to 1.0
     * @return The mapped power safe for VEX 393 CR Servos
     */
    public static double map393(double power) {
        return map(power, -1, 1, Constants.VEX_393_LOWER_BOUND, Constants.VEX_393_UPPER_BOUND);
    }
}
