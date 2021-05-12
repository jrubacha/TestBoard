// TODO: Write program to control the robot during the 30 second autonomous period.

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
            /** Use the methods found in drivetrain and mechanisms to control your robot
             * Time delay can be achieved by:
             *      delay(1000);
             * The number is measured in MILLISECONDS
             *
             * Example code below will drive the robot forward for one second
             */
//            drivetrain.setDrivePower(1, 1);
//            delay(1000);
//            drivetrain.stopDriving();



            callTelemetry();
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////

    private void callTelemetry() {
        telemetry.addData("Run Time: ", runtime.toString());
        telemetry.update();
    }

    // Delays robot actions, measured in milliseconds
    private void delay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // no-op
        }
    }
}
