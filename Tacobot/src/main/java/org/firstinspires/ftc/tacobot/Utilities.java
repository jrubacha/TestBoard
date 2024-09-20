package org.firstinspires.ftc.tacobot;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Utilities {
    static Constants constants;
    Telemetry telemetry;

    public Utilities(Telemetry telemetry){
        constants = new Constants();
        this.telemetry = telemetry;
    }

    /**
     * Many PWM output components do not accept the raw -1-1 values from the Control Hub unless they fall within the Rev product families.
     * Method takes in a value, the range that value exists in and spits out the value in an acceptable form for the chosen device
     * @param value    - the value to be remapped
     * @param in_min   - the min value of the range that the value is in
     * @param in_max   - the max value of the range that the value is in
     * @param out_min  - the min value of the range you want the value to be in
     * @param out_max  - the max value of the range you want the value to be in
     * @return
     */
    private static double map(double value, double in_min, double in_max, double out_min, double out_max) {
        return (value - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }

    /**
     * Cleaner version of map for use in other classes. Specific to use with Victor SPX motor controller
     * @param value - the value to be mapped
     * @return
     */



    /**
     * Time delay. Mostly for use with autonomous modes
     * @param time - delay time in milliseconds
     */
    public void delay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // no-op
        }
    }
}
