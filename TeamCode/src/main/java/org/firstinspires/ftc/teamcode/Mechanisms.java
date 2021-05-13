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

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;

public class Mechanisms {
    // TODO: Create each of your motors/servos for your things NOT in your drivetrain as appropriate
    /** Below, there are examples of how to initialize each actuator type
     *  Each needs a unique name, that should also relate to what it does/is
     */

    // For dc motors:
    // private DcMotor armMotor;

    // For continuous rotation servos:
    // private CRServo armServo;

    // For standard servos:
    // private Servo clawServo;

    // Do not edit
    Telemetry telemetry;

    public Mechanisms(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        // TODO: Finish the hardware map for your mechanisms
        /** Finishing the hardware map:
         *  The first word should be the same as the name you used above
         *  The word in quotes should be the same as the name you used in configure robot setting on the phone
         */
        // If you are using motors:
        // leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");

        // If you are using CR Servos:
        // backLeft = hardwareMap.get(CRServo.class, "backLeft");

        // If you are using standard servos:
        // clawServo = hardwareMap.get(Servo.class, "clawServo");

        // Set motor/servo directions
        // armMotor.setDirection(REVERSE);

    }


    //TODO: Create methods to do the things you need.

    /** The number of methods down here will depend on the number of extra motors/servos you used on your robot
     *  Each method should follow the same form, if you have a question, ASK!!!
     *  There are many different ways this section will need to be done depending on what YOU are doing with YOUR robot
     */

    // Sample - Arm Motor Power
//    public void setArmMotorPower(double power) {
//        armMotor.setPower(power);
//    }

    // Sample - Continuous Rotation Servo Power
//    public void setArmServoPower(double power) {
//        // Example for setting power, each servo will need one of these
//        armServo.setPower(power);
//    }

    // Sample - Standard Servo Position
//    public void setClawServoPosition(double position) {
//        clawServo.setPosition(position);
//    }
}
