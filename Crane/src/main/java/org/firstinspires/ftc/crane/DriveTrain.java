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
import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;

public class DriveTrain {
    // TODO: Create motors for the drive train.
    //  Note: Only create a motor here for every motor controller used on the drivetrain
    //  Motor controllers are considered CRServos, as they need the raw pwm signal

    // Example:
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

    // TODO: setup actual driving methods (arcade, tank, curvature, whatever)



    // TODO: Create stop driving method
    /** Stopping is important.
     *  This is done by setting power to the motors/servos to zero.
     *  You will call the method you created above when you write the stopDriving method
     */
    public void stopDriving(){
        // Use your set___Power method with input values of zero

    }

}
