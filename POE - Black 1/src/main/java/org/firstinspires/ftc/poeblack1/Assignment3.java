/** TODO: Read the following instructions
 *
 * The purpose of this assignment is to introduce you to using input
 * in order to control functions.
 *
 * You will learn about logic statements and the gamepad.
 *
 * Except where prompted, do not make changes to the program.
 */
//////////////////////////////////////////////////////////////////////////////////////////
package org.firstinspires.ftc.poeblack1;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

//////////////////////////////////////////////////////////////////////////////////////////
@TeleOp(name="Assignment 3", group="Assignments")
// TODO #1: Enable the program
@Disabled
//////////////////////////////////////////////////////////////////////////////////////////

public class Assignment3 extends OpMode {
    private ElapsedTime runtime = new ElapsedTime();
    Sensors sensors;
    Actuators actuators;

//////////////////////////////////////////////////////////////////////////////////////////

    /* Code to run ONCE when the driver hits INIT */
    @Override
    public void init() {
        sensors = new Sensors(hardwareMap, telemetry);
        actuators = new Actuators(hardwareMap, telemetry);

        telemetry.addData("Status", "Initialized");
    }

//////////////////////////////////////////////////////////////////////////////////////////

    /* Code to run ONCE when the driver hits PLAY */
    @Override
    public void start() {
        runtime.reset();
    }

//////////////////////////////////////////////////////////////////////////////////////////

    /* Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP */
    @Override
    public void loop() {
        checkDriverController();
        telemetry.update();
    }

//////////////////////////////////////////////////////////////////////////////////////////

    /* Code to run ONCE after the driver hits STOP */
    @Override
    public void stop() {
        telemetry.addData("Final runtime", runtime.toString());
        telemetry.update();
    }

//////////////////////////////////////////////////////////////////////////////////////////

    public void checkDriverController() {
        // Example: Display a telemetry message when the square button is pressed
        if (gamepad1.square) {
            telemetry.addLine("Square pushed");
        }

        // TODO #2: Use an if statement to display a telemetry message
        //          when a gamepad button is pressed

        // TODO #3: Use gamepad buttons to control the servo position
        //          Consider the difference between analog and digital inputs
//        if (gamepad1.) {
//            actuators.setServoPosition(.5);
//        } else if () {
//
//        }

        // TODO #4: Use a joystick to control the motor power

    }

}
