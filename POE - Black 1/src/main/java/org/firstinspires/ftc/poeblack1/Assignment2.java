/** TODO: Read the following instructions
 *
 * Make changes as directed by your assignment guide.
 */
//////////////////////////////////////////////////////////////////////////////////////////
package org.firstinspires.ftc.poeblack1;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

//////////////////////////////////////////////////////////////////////////////////////////
@Autonomous(name= "Assignment 2", group="Assignments")
// TODO #1: Enable the program
@Disabled
//////////////////////////////////////////////////////////////////////////////////////////
public class Assignment2 extends LinearOpMode {
    BotUtilities util;
    Actuators actuators;
    Sensors sensors;
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        util = new BotUtilities(telemetry);
        actuators = new Actuators(hardwareMap, telemetry);
        sensors = new Sensors(hardwareMap, telemetry);

        telemetry.addLine("Test board initialized and ready");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Motion has started
        runtime.reset();
        while (opModeIsActive()) {
            runEverything();
            callTelemetry();
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////

    private void runEverything() {
        // TODO #2: Use the potentiometer reading to control the servo position

        // TODO #3: Use the potentiometer reading to control the CR servo power

        // TODO #4: Use an if / else-if / else structure to control the motor
        //          using the push button, with speed from the potentiometer

    }

    private void callTelemetry() {
        // Show the elapsed game time
        telemetry.addData("Run Time: ", runtime.toString());

        // TODO #5: Use an if-else statement to display a telemetry message
        //          based on the limit switch state

        // Display Values of all the attached sensors
        sensors.printSensorTelemetry();
        actuators.printActuatorTelemetry();
        telemetry.update();
    }
}
