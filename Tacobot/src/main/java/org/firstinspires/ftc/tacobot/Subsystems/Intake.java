package org.firstinspires.ftc.tacobot.Subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Const;
import org.firstinspires.ftc.tacobot.Constants;
import org.firstinspires.ftc.tacobot.Utilities;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake {
    private CRServo intakeServoLeft, intakeServoRight;
    private DcMotor intakePivotMotor;
    Utilities utilities;
    Telemetry telemetry;

    public Intake(HardwareMap hardwareMap, Telemetry telemetry) {
        intakePivotMotor = hardwareMap.get(DcMotor.class, "intakePivot");
        intakeServoLeft = hardwareMap.get(CRServo.class, "intakeLeft");
        intakeServoRight = hardwareMap.get(CRServo.class, "intakeRight");

        this.telemetry = telemetry;

        intakePivotMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intakePivotMotor.setDirection(DcMotorSimple.Direction.REVERSE);


        intakeServoRight.setDirection(DcMotorSimple.Direction.FORWARD);
        intakeServoLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    private void setPivotPower(double power){
        intakePivotMotor.setPower(power);
    }
    public void deployIntake(){
        setPivotPower(Constants.IntakeContants.INTAKE_PIVOT_SPEED);
    }
    public void retractIntake(){
        setPivotPower(-1 * Constants.IntakeContants.INTAKE_PIVOT_SPEED);
    }
    public void stopIntakePivot(){
        setPivotPower(0);
    }

    private void setIntakePower(double power){
        intakeServoRight.setPower(power);
        intakeServoLeft.setPower(power);
    }
    public void intake(){
        setIntakePower(Constants.IntakeContants.INTAKING_SPEED);
    }
    public void outtake(){
        setIntakePower(Constants.IntakeContants.OUTTAKING_SPEED);
    }
    public void stopIntaking(){
        setIntakePower(0);
    }
}
