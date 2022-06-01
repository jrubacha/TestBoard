// TODO: Read the following instructions
/**
 * The purpose of this assignment is to introduce you to using input in order to control functions.
 *
 * You will learn about logic statements and the gamepad.
 *
 * Except where prompted, do not make changes to the program.
 */
//////////////////////////////////////////////////////////////////////////////////////////
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

//////////////////////////////////////////////////////////////////////////////////////////
@TeleOp(name="Assignment 3", group="actuators")
@Disabled        // Comment/Uncomment this line as needed to show/hide this opmode
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

        // Set up our telemetry dashboard
        updateTelemetry(telemetry);

        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized    :)");
    }

//////////////////////////////////////////////////////////////////////////////////////////

    /* Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY */
    @Override
    public void init_loop() {
    }

//////////////////////////////////////////////////////////////////////////////////////////

    /* Code to run ONCE when the driver hits PLAY */
    @Override
    public void start() {
        runtime.reset();
        updateTelemetry(telemetry);
    }

//////////////////////////////////////////////////////////////////////////////////////////

    /* Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP */
    @Override
    public void loop() {
        checkDriverController();
        // Call Telemetry
        telemetry.update();
    }

//////////////////////////////////////////////////////////////////////////////////////////

    /* Code to run ONCE after the driver hits STOP */
    @Override
    public void stop() {
        telemetry.addData("Robot Stopped. ", "Have a nice day.");
        telemetry.addData("Final runtime: ", runtime.toString());
        telemetry.update();
    }

//////////////////////////////////////////////////////////////////////////////////////////

    public void checkDriverController() {
        // Example if statement that adds a telemetry message if the square is pushed
        if (gamepad1.square) {
            telemetry.addLine("Square pushed");
        }

        // TODO: Use an if statement to add telemetry statement for the gamepad to show when the triangle is pushed


        // TODO: Complete the if-elseif-else statement below to control the servo position using the triangle and cross buttons. You will need to uncomment the code first
        // You can quickly comment/uncomment code by highlighting all of it and press CTRL+/ on your keyboard
//        if (gamepad1.) {
//            actuators.setServoPosition(.5);
//        } else if () {
//
//        }



        // TODO: Set power to the motor based on the left_stick_y value
        // Start typing actuators. (like above) to find motor methods




    }

}

