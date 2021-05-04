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
//////////////////////////////////////////////////////////////////////////////////////////
@Autonomous(name= "Assignment 1a", group="Assignments")
//@Disabled
//////////////////////////////////////////////////////////////////////////////////////////
public class Assignment1a extends LinearOpMode {
    BotUtilities util;
    TestBoard testboard;
    Sensors sensors;
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        util = new BotUtilities(telemetry);
        testboard = new TestBoard(hardwareMap, telemetry);
        sensors = new Sensors(hardwareMap, telemetry);

        telemetry.addLine("Test board initialized and ready");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Motion has started
        runtime.reset();
        while (opModeIsActive()) {
            callTelemetry();
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////

    private void callTelemetry() {
        // Show the elapsed game time
        telemetry.addData("Run Time: ", runtime.toString());

        // Display Values of all the attached sensors
        sensors.printSensorTelemetry();
        telemetry.update();
    }
}
