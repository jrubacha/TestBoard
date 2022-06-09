package org.firstinspires.ftc.crane;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class BotUtilities {
    Telemetry telemetry;

    public BotUtilities(Telemetry telemetry) {
        this.telemetry = telemetry;
    }


    public void delay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // no-op
        }
    }
}
