//////////////////////////////////////////////////////////////////////////////////////////
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

//////////////////////////////////////////////////////////////////////////////////////////
@Autonomous(name= "Assignment 2", group="Assignments")
// TODO #1: Enable the Program
@Disabled
//////////////////////////////////////////////////////////////////////////////////////////
public class Assignment2a extends LinearOpMode {
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
            callTelemetry();
            runEverything();
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////

    private void runEverything() {
        // TODO #2: Using variables - pot to servo

        // TODO #3: Using variables - pot to CR servo

        // TODO #4: Telemetry by buttons

        // TODO #5: Using variables - pot to Motor & button direction control

    }
    private void callTelemetry() {
        // Show the elapsed game time
        telemetry.addData("Run Time: ", runtime.toString());

        // Display Values of all the attached sensors
        sensors.printSensorTelemetry();
        actuators.printActuatorTelemetry();
        telemetry.update();
    }
}
