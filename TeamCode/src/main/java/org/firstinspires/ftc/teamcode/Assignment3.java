/** TODO: Read the following instructions
 *
 *
 *
 * Except where prompted, do not make changes to the program.
 */

//////////////////////////////////////////////////////////////////////////////////////////
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
//////////////////////////////////////////////////////////////////////////////////////////
@Autonomous(name= "Assignment 3", group="Assignments")
//@Disabled
//////////////////////////////////////////////////////////////////////////////////////////
public class Assignment3 extends LinearOpMode {
    TestBoard testboard;
    Sensors sensors;
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        testboard = new TestBoard(hardwareMap, telemetry);
        sensors = new Sensors(hardwareMap, telemetry);

        telemetry.addLine("Test board initialized and ready");
        telemetry.update();

        // TODO: Add code to make the servo go to position -1

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Motion has started
        runtime.reset();

        while (opModeIsActive()) {
            // TODO: Add code to make first motor spin forward at a power of 1

            // TODO: Add code to make the servo go to position 1

            // TODO: Run a method to make both motors spin forward at a power of 1. (When you run this code, the single motor code above should be commented out. This method will be written in testboard

            updateTelemetry();
        }

    }
//////////////////////////////////////////////////////////////////////////////////////////
    private void runEverything(){
        double motorPower = 0.25, servoPosition = 1;
        int roundedRunTime = (int) runtime.seconds();
        if (roundedRunTime % 5 == 0) {
            motorPower = motorPower * -1;
            servoPosition = servoPosition * -1;
        }
        testboard.setServoPosition(servoPosition);
        testboard.setMotorPower(motorPower);
        testboard.setCRServoPower(motorPower);
    }

    private void updateTelemetry() {
        // Show the elapsed game time
        telemetry.addData("Run Time: ", runtime.toString());

        // Display Values of all the attached sensors
        sensors.printSensorTelemetry();
    }
}
