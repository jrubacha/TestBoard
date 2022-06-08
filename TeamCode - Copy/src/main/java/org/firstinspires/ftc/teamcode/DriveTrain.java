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

    // For every Motor:
    // private DcMotor leftMotor;

    // For every Continuous Rotation Servo:
    // private CRServo backLeft;


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
        // leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");

        // CR Servo Example:
        // backLeft = hardwareMap.get(CRServo.class, "backLeft");

        // TODO: Set motor/servo directions. They will default to FORWARD, use this to change items to REVERSE as needed
        // armMotor.setDirection(REVERSE);

        // TODO: Choose your Zero Power Behavior. They will default to COAST, use this to change items to BRAKE as needed
        // Brake: Motor/servo will use current to stop the momentum quickly
        // Coast: Motor/servo will stop providing current, but allow momentum to continue
        // Example:
        // leftMotor.setZeroPowerBehavior(BRAKE);
    }


    //TODO: Set power for your motors. Use the APPROPRIATE method for your drivetrain
    /** Regardless of the drive type, you will need to add code inside one of the following methods
     *  You will use the variables leftPow and rightPow within to control the actuators
     *  Follow the examples provided
     */

    // Motor-based DriveTrain
    public void setDrivePower(double leftPow, double rightPow) {
        // Example for setting power, each motor will need one of these, referencing the appropriate input
        // myMotor.setPower(leftPow);
    }

    // Continuous Rotation Servo Drivetrain
    public void setCRServoPower(double leftPow, double rightPow) {
        // Example for setting power, each servo will need one of these
        // Left should share the left variable, right shares the right variable
        // backLeft.setPower(leftPow);
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
