package org.firstinspires.ftc.crane;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Turret {
    /**
     * The turret uses 1 Bag motor on a ? : 1 reduction versaplanetary
     * This motor really should have encoder control and/or limit switches at the outer bounds
     */

    private DcMotor turretMotor;
    private TouchSensor limitSwitch;
    Constants constants;
    Telemetry telemetry;

    public enum turretPosition {
        LEFT,
        RIGHT,
        ROVING
    }

    public Turret(HardwareMap hardwareMap, Telemetry telemetry){
        this.telemetry = telemetry;
        turretMotor = hardwareMap.get(DcMotor.class, "turret");
        limitSwitch = hardwareMap.get(TouchSensor.class, "turretLimit");
        turretMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void snapToLeft(){
        if(!limitSwitch.isPressed()) {
            setTurretPower(constants.AUTON_TURRET_SPEED);
        }
    }
    public void snapToRight(){
        turretMotor.setTargetPosition(constants.RIGHT_LIMIT);
        turretMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    private void setMotorToEncoderMode(){
        turretMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        turretMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }



    public void setTurretPower(double power){
        turretMotor.setPower(power);
    }




}
