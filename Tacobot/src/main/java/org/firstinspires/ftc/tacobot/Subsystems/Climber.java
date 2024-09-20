package org.firstinspires.ftc.tacobot.Subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.tacobot.Constants;

public class Climber {
    private CRServo climbServoLeft, climbServoRight;
    private DcMotor climbMotor;
    Telemetry telemetry;

    public Climber(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;

        climbMotor = hardwareMap.get(DcMotor.class, "climbMotor");
        climbServoLeft = hardwareMap.get(CRServo.class, "climbServoLeft");
        climbServoRight = hardwareMap.get(CRServo.class, "climbServoRight");

        climbMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        climbServoRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    private void setServoPowers(double power){
        climbServoRight.setPower(power);
        climbServoLeft.setPower(power);
    }

    public void deployClimbServos(){
        setServoPowers(Constants.ClimbConstants.CLIMB_SERVO_MOVE_SPEED);
    }
    public void retractClimbServos(){
        setServoPowers(-1 * Constants.ClimbConstants.CLIMB_SERVO_MOVE_SPEED);
    }
    public void stopClimbServos(){
        setServoPowers(0);
    }

    private void setClimbMotorPower(double power){
        climbMotor.setPower(power);
    }

    public void ascend(){
        setClimbMotorPower(Constants.ClimbConstants.ASCENT_SPEED);
    }
    public void descend(){
        setClimbMotorPower(-1 * Constants.ClimbConstants.ASCENT_SPEED);
    }
    public void stopClimber(){
        setClimbMotorPower(0);
    }
}
