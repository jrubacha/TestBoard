package org.firstinspires.ftc.crane;

import android.graphics.Color;
import android.text.method.Touch;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.AnalogSensor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import static com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.BRAKE;
import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.FORWARD;
import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;

public class DriveTrain {
    private CRServo backLeft, backRight, frontLeft, frontRight;
    Utilities utilities;


    Telemetry telemetry; // Do not edit

    public DriveTrain(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;

        backLeft = hardwareMap.get(CRServo.class, "backLeft");
        frontLeft = hardwareMap.get(CRServo.class, "frontLeft");
        backRight = hardwareMap.get(CRServo.class, "backRight");
        frontRight = hardwareMap.get(CRServo.class, "frontRight");

        frontLeft.setDirection(FORWARD);
        backLeft.setDirection(FORWARD);

        frontRight.setDirection(REVERSE);
        backRight.setDirection(REVERSE);

    }

    public void setPower(double leftSpeed, double rightSpeed) {
        frontLeft.setPower(leftSpeed);
        backLeft.setPower(leftSpeed);
        frontRight.setPower(rightSpeed);
        backRight.setPower(rightSpeed);
        telemetry.addData("setLeft", leftSpeed);
        telemetry.addData("setRight", rightSpeed);
    }

    public void setPower(double[] powers){
        telemetry.addData("DT Val", powers[0]);
        try {
            powers[0] = utilities.mapVictorSPX(powers[0]);
            powers[1] = utilities.mapVictorSPX(powers[1]);
            telemetry.addData("pow 0", powers[0]);
            telemetry.addData("pow 1", powers[1]);
            setPower(powers[0], powers[1]);
        }catch(NullPointerException e){
            telemetry.addLine("Actually, I break here.");
        }

    }

    public double deadband(double x) {
        double deadBand = 0.1;
        if (Math.abs(x) < deadBand) {
            x = 0.0;
        }
        return x;
    }   // deadband

    /**
     * Tank drive method for differential drive platform.
     *
     * @param left The robot's power on the left drive pod. Forward is positive.
     * @param right The robot's power on the right drive pod. Forward is positive.
     */
    public void tankDrive(double left, double right) {
        setPower(deadband(left), deadband(right));
    }

    /**
     * Note: Code outline and comments borrow from WPILIB Documentation
     * Arcade drive method for differential drive platform.
     *
     * @param throttle The robot's power along the X axis [-1.0..1.0]. Forward is positive.
     * @param rotation The robot's rotation rate around the Z axis [-1.0..1.0]. Clockwise is
     *     positive.
     */
    public double[] arcadeDrive(double throttle, double rotation) {

        double leftMotorOutput, rightMotorOutput;

        throttle = deadband(throttle);
        rotation = deadband(rotation);

        throttle = Math.pow(throttle, 3)/2;
        rotation = Math.pow(rotation, 3)/2;

        leftMotorOutput = throttle + rotation;
        rightMotorOutput = throttle - rotation;

        throttle *= Constants.DRIVE_SPEED;
        rotation *= Constants.TURN_SPEED;

        telemetry.addData("ArcadeLeft", leftMotorOutput);
        telemetry.addData( "ArcadeRight", rightMotorOutput);
        double[] motorPowers = {leftMotorOutput, rightMotorOutput};

        setPower(motorPowers);
        return motorPowers;
    }   // arcadeDrive

    public double[] normalizePowers(double left, double right){
        double maxMagnitude = Math.max(Math.abs(left), Math.abs(right));
        if (maxMagnitude > 1.0) {
            left /= maxMagnitude;
            right /= maxMagnitude;
        }
        double[] powers = {left, right};
        return powers;
    }

    public double clampDriveVal(double val, double min, double max){
        //Clamps a value between a min and max
        //Take a value and return it if it's between max and min
        //If not between, return what's closest.
        if (val < min){
            return min;
        }else if(val > max){
            return max;
        }else{
            return val;
        }
    }


    public void stopDriving(){
        // Use your set___Power method with input values of zero
        setPower(0,0);
    }

}
