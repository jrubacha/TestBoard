package org.firstinspires.ftc.tacobot;

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

    private CRServo turretMotor;
    private TouchSensor limitSwitch;
    private turretPosition currentPosition;
    Constants constants;
    Telemetry telemetry;
    Utilities utilities;

    public enum turretPosition {
        LEFT,
        RIGHT,
        ROVING
    }

    public void setTurretState(turretPosition newState){
        currentPosition = newState;
        switch (currentPosition) {
            case LEFT:
                snapToLeft();
                break;
            case RIGHT:
                //snapToRight();
                break;
            case ROVING:
                // TODO: create roving method and call it here
                break;
        }
    }

    public Turret(HardwareMap hardwareMap, Telemetry telemetry){
        this.telemetry = telemetry;
        turretMotor = hardwareMap.get(CRServo.class, "turret");
        limitSwitch = hardwareMap.get(TouchSensor.class, "turretLimit");
//        turretMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void snapToLeft(){
        if(!limitSwitch.isPressed()) {
            setTurretMotorPower(constants.AUTON_TURRET_SPEED);
        }
    }
//    public void snapToRight(){
//        turretMotor.setTargetPosition(constants.RIGHT_LIMIT);
//        turretMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//    }
//    private void setMotorToEncoderMode(){
//        turretMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        turretMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//    }

    private void setTurretMotorPower(double power){
        power = Utilities.mapVictorSPX(power);
        turretMotor.setPower(power);
    }

    public void manualTurretLeft(){
        setTurretMotorPower(-constants.HUMAN_TURRET_SPEED);
    }
    public void manualTurretRight(){
        setTurretMotorPower(constants.HUMAN_TURRET_SPEED);
    }
    public void manualTurretStop(){
        setTurretMotorPower(0);
    }
    public void fullManualSpinTurret(double power){
        setTurretMotorPower(power * constants.TURRET_SCALAR);
    }



}
