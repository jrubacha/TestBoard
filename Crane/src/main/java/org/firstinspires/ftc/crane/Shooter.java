package org.firstinspires.ftc.crane;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Shooter {
    /**
     * The shooter is run on 2 CIM motors, each with their own motor controller
     */
    private CRServo topShooterMotor, bottomShooterMotor;
    Telemetry telemetry;
    Constants constants;
    Utilities utilities;

    public Shooter(HardwareMap hardwareMap, Telemetry telemetry) {
        topShooterMotor = hardwareMap.get(CRServo.class, "topShooterMotor");
        bottomShooterMotor = hardwareMap.get(CRServo.class, "bottomShooterMotor");

        bottomShooterMotor.setDirection(REVERSE);

        this.telemetry = telemetry;
    }
    public void shoot(){
        setMotorPowers(constants.FULL_POWER_SHOT);
    }
    public void spit(){
        setMotorPowers(constants.SPIT_SHOT);
    }
    public void retractBall(){
        setMotorPowers(constants.RETRACT);
    }
    public void stopShooter(){
        setMotorPowers(0);
    }

    private void setMotorPowers(double power){
        power = Utilities.mapVictorSPX(power);
        topShooterMotor.setPower(power);
        bottomShooterMotor.setPower(power);
    }
}
