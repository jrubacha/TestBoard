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
    // TODO: Create motors for the drive train.
    //  Note: Only create a motor here for every motor controller used on the drivetrain
    //  Motor controllers are considered CRServos, as they need the raw pwm signal

    // Example:
    private CRServo backLeft, backRight, frontLeft, frontRight;
    Utilities utilities;


    Telemetry telemetry; // Do not edit

    public DriveTrain(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        // TODO: Finish the hardware map for your drivetrain
        /** Setting up the hardware map.
         *  - Remember that every item typed in the quotes, be it a motor/servo, must match EXACTLY what you type in on the phone while configuring the robot
         *  - This does not have to match the variable used here
         *  - The name, in either location, should be clear and descriptive
         *  - You will need one line of hardwareMap for attached actuator
         */


        // CR Servo Example:
        backLeft = hardwareMap.get(CRServo.class, "backLeft");
        frontLeft = hardwareMap.get(CRServo.class, "frontLeft");
        backRight = hardwareMap.get(CRServo.class, "backRight");
        frontRight = hardwareMap.get(CRServo.class, "frontRight");

        // TODO: Set motor/servo directions. They will default to FORWARD, use this to change items to REVERSE as needed
        frontLeft.setDirection(REVERSE);
        backLeft.setDirection(FORWARD);

        frontRight.setDirection(FORWARD);
        backRight.setDirection(REVERSE);

        // TODO: Choose your Zero Power Behavior. They will default to COAST, use this to change items to BRAKE as needed
        // Brake: Motor/servo will use current to stop the momentum quickly
        // Coast: Motor/servo will stop providing current, but allow momentum to continue
        // Example:
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
