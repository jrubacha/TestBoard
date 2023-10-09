package org.firstinspires.ftc.teamcode;

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
import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;

public class DriveTrain {
    // TODO: Create each of your motors/servos in your DRIVETRAIN as appropriate
    // It is good practice to give every device a meaningful name. For example: leftMotor, frontRightMotor, etc.

    // For every drivetrain motor:
    // private DcMotor motorName;

    // For every drivetrain Continuous Rotation Servo:
    // private CRServo servoName;
    //

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

        // Motor Example:
        // motorName = hardwareMap.get(DcMotor.class, "motorName");

        // CR Servo Example:
        // servoName = hardwareMap.get(CRServo.class, "servoName");

        // TODO: Set motor/servo directions. They will default to FORWARD, use this to change items to REVERSE as needed
        // motorName.setDirection(REVERSE);

        // TODO: Choose your Zero Power Behavior. They will default to COAST, use this to change items to BRAKE as needed
        // Brake: Motor/servo will use current to stop the momentum quickly
        // Coast: Motor/servo will stop providing current, but allow momentum to continue
        // Example:
        // motorName.setZeroPowerBehavior(BRAKE);
    }


    //TODO: Set power for your drivetrain. Choose the appropriate section.
    // Nothing in this section should reference a gamepad. This code will work for ALL driving, auto and human controlled.

    // Motor-based DriveTrain
    public void setDrivePower(double leftPow, double rightPow) {
        // TODO: For each drive MOTOR, utilize the following command in a manner fitting your setup
        // Example: leftMotor.setPower(leftPow);
    }

    // Continuous Rotation Servo Drivetrain
    public void setCRServoPower(double leftPow, double rightPow) {
        leftPow = Utilities.map393(leftPow);
        rightPow = Utilities.map393(rightPow);
        // TODO: For each drive CR servo, utilize the following command in a manner fitting your setup
        // All servos on the left should share the left variable, all on the right share the right variable
        // Example: backLeft.setPower(leftPow);
    }

    // TODO: Create stop DRIVING to match YOUR drive style
    /** Stopping is important.
     *  This is done by setting power to the motors/servos to zero.
     *  You will call the method you created above when you write the stopDriving method
     */
    public void stopDriving(){
        // Use your set___Power method with input values of zero

    }

}
