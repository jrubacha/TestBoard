package org.firstinspires.ftc.teamcode;

import android.graphics.Color;
import android.text.method.Touch;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.AnalogSensor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class DriveTrain {
    // TODO: Create each of your motors/servos for your DRIVETRAIN as appropriate

    // If you are using motors for your drive train you will create each one similar to this:
    // private DcMotor leftMotor;

    // If you are using continuous rotation servos for your drive train you will create each one similar to this:
    // private CRServo backLeft;

    // Do not edit
    Telemetry telemetry;

    public DriveTrain(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        // TODO: Finish the hardware map for your drivetrain

        // If you are using motors:
        // leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");

        // If you are using CR Servos
        // backLeft = hardwareMap.get(CRServo.class, "backLeft");

    }


    //TODO: Set power for your motors. Use the APPROPRIATE method for your drivetrain

    // Motor-based DriveTrain
    public void setDrivePower(double leftPow, double rightPow) {
        // Example for setting power, each motor will need one of these
        //myMotor.setPower(pow);

    }

    // Continuous Rotation Servo Drivetrain
    public void setCRServoPower(double leftPow, double rightPow) {
        // Example for setting power, each servo will need one of these
        // Left should share the left variable, right shares the right variable
        //backLeft.setPower(leftPow);
        //frontLeft.setPower(leftPow);
    }

    // TODO: Fix stop DRIVING to match YOUR drive style
    public void stopDriving(){
        // Use your set___Power method with input values of zero
    }

}
