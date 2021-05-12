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
@Autonomous(name= "Autonomous", group="Auto")
@Disabled
//////////////////////////////////////////////////////////////////////////////////////////
public class AutonomousMode extends LinearOpMode {
    DriveTrain drivetrain;
    Mechanisms mechanisms;
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        mechanisms = new Mechanisms(hardwareMap, telemetry);
        drivetrain = new DriveTrain(hardwareMap, telemetry);

        telemetry.addLine("Robot initialized and ready");
        telemetry.update();

//////////////////////////////////////////////////////////////////////////////////////////

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

//////////////////////////////////////////////////////////////////////////////////////////
        runtime.reset();
        while (opModeIsActive()) {
            // TODO: Write your autonomous code in this section here


            callTelemetry();
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////

    private void callTelemetry() {
        telemetry.addData("Run Time: ", runtime.toString());
        telemetry.update();
    }
}
