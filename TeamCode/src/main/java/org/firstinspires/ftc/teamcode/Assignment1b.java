/** TODO: Read the following instructions
 *
 * Make changes as directed to by the Canvas guide.
 */

//////////////////////////////////////////////////////////////////////////////////////////
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//////////////////////////////////////////////////////////////////////////////////////////
@Autonomous(name= "Assignment 1b", group="Assignments")
//@Disabled
//////////////////////////////////////////////////////////////////////////////////////////
public class Assignment1b extends LinearOpMode {
    BotUtilities util;
    Actuators actuators;
    Sensors sensors;
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        util = new BotUtilities(telemetry);
        actuators = new Actuators(hardwareMap, telemetry);
        sensors = new Sensors(hardwareMap, telemetry);

        actuators.setServoPosition(0);

        telemetry.addLine("Test board initialized and ready");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Motion has started
        runtime.reset();
        actuators.setServoPosition(-.5);
        while (opModeIsActive()) {
            runEverything();
            callTelemetry();
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////
    private void runEverything(){
        actuators.setCRServoPower(-.5);
        actuators.setMotorPower(-.5);
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
