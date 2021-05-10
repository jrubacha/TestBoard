/** TODO: Read the following instructions
 *
 * Follow along with the assignment on Canvas to use this OpMode
 *
 * Except where specified, do NOT make any changes to the program.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

//////////////////////////////////////////////////////////////////////////////////////////
@TeleOp(name="Assignment 2", group="actuators")

@Disabled        // Comment/Uncomment this line as needed to show/hide this opmode
//////////////////////////////////////////////////////////////////////////////////////////

public class Assignment2 extends OpMode {
    private ElapsedTime runtime = new ElapsedTime();
    Sensors sensors;
    Actuators actuators;

//////////////////////////////////////////////////////////////////////////////////////////

    /* Code to run ONCE when the driver hits INIT */
    @Override
    public void init() {
        // Create our two objects needed for this assignment
        sensors = new Sensors(hardwareMap, telemetry);
        actuators = new Actuators(hardwareMap, telemetry);


        // Tell the user that initialization is complete.
        telemetry.addLine("actuators is now ready to be used.");
        telemetry.update();
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
        getTelemetry();
    }

//////////////////////////////////////////////////////////////////////////////////////////

    /* Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP */
    @Override
    public void loop() {
        // Run actions for this sample opmode
        runEverything();

        // Call Telemetry
        getTelemetry();

    }

//////////////////////////////////////////////////////////////////////////////////////////

    /* Code to run ONCE after the driver hits STOP */
    @Override
    public void stop() {
        telemetry.addData("Final runtime: ", runtime.toString());
        telemetry.update();
    }

//////////////////////////////////////////////////////////////////////////////////////////

    private void runEverything(){
        double motorPower = 0.75;
        // TODO: #2 Create a variable named restingServoPosition and set it equal to 0.5

        // TODO: #3 Create a variable named targetServoPosition and set it equal to -0.25


        actuators.setMotorPower(motorPower);

        // TODO: #4 Utilize an if-else statement to control the servo using the pushbutton

    }


    private void getTelemetry() {
        // Show the elapsed game time
        telemetry.addData("Run Time: ", runtime.toString());

        // Use sensor data to add / remove a message
        // TODO: #1 Create an if-else statement to display a custom message when the limit switch is pushed


        // Display Values of all the attached sensors
        sensors.printSensorTelemetry();
        telemetry.update();
    }  // getTelemetry



}

