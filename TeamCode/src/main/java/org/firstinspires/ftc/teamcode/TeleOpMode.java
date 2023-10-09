// TODO: Read the following instructions
/**
 * Fill out the controller sections of this code for how you want the human to control the robot
 */
//////////////////////////////////////////////////////////////////////////////////////////
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

//////////////////////////////////////////////////////////////////////////////////////////
@TeleOp(name="TeleOpMode", group="actuators")
// TODO: Enable the program.
@Disabled
//////////////////////////////////////////////////////////////////////////////////////////

public class TeleOpMode extends OpMode {
    private ElapsedTime runtime = new ElapsedTime();
    DriveTrain drivetrain;
    Mechanisms mechanisms;

//////////////////////////////////////////////////////////////////////////////////////////

    /* Code to run ONCE when the driver hits INIT */
    @Override
    public void init() {
        drivetrain = new DriveTrain(hardwareMap, telemetry);
        mechanisms = new Mechanisms(hardwareMap, telemetry);

        // Set up our telemetry dashboard
        telemetry.update();

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
        checkOperatorController();

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
        // TODO: Fill out this section with how you want the controller to respond to human actions
        // Use Assignment 3 as a reference
        // Ask questions as needed!!!
        // These sections will largely be custom to YOUR team, so there aren't easy examples

    }

    public void checkOperatorController() {
        // TODO: Fill out this section if you need a SECOND controller
    }
}

