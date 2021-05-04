/** TODO: Read the following instructions
 *
 * There are no changes to be made within this code.
 *
 * Assignment 1 is observational only.
 *
 * Please do not make any changes to this program.
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

        actuators.setServoPosition(1);

        telemetry.addLine("Test board initialized and ready");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Motion has started
        runtime.reset();
        actuators.setServoPosition(-1);
        while (opModeIsActive()) {
            runEverything();
            callTelemetry();
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////
    private void runEverything(){
        actuators.setCRServoPower(-1);
        actuators.setMotorPower(-1);
    }

    private void callTelemetry() {
        // Show the elapsed game time
        telemetry.addData("Run Time: ", runtime.toString());

        // Display Values of all the attached sensors
        sensors.printSensorTelemetry();
        actuators.printMotorEncoderValue();
        telemetry.update();
    }
}
