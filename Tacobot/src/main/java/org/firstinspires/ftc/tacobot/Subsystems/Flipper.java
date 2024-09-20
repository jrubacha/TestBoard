package org.firstinspires.ftc.tacobot.Subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.tacobot.Constants;

public class Flipper {
    private CRServo flipperLeft, flipperRight;

    Telemetry telemetry;

    public Flipper(HardwareMap hardwareMap, Telemetry telemetry){
        this.telemetry = telemetry;

        flipperLeft = hardwareMap.get(CRServo.class, "flipperLeft");
        flipperRight = hardwareMap.get(CRServo.class, "flipperRight");

        flipperLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        flipperRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    private void setFlipperServoPowers(double power){
        flipperLeft.setPower(power);
        flipperRight.setPower(power);
    }

    public void flipperExtend(){
        setFlipperServoPowers(Constants.FlipperConstants.FLIPPER_MOVE_SPEED);
    }
    public void flipperRetract(){
        setFlipperServoPowers(-1 * Constants.FlipperConstants.FLIPPER_MOVE_SPEED);
    }
    public void stopFlipperMovement(){
        setFlipperServoPowers(0);
    }
}
