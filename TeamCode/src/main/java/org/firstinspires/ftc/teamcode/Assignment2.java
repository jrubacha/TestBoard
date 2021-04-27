// TODO: Read the following instructions

//////////////////////////////////////////////////////////////////////////////////////////
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
//////////////////////////////////////////////////////////////////////////////////////////
@Autonomous(name= "Assignment 2", group="Assignments")
@Disabled
//////////////////////////////////////////////////////////////////////////////////////////
public class Assignment2 extends LinearOpMode {
    BotUtilities util;
    TestBoard testboard;
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        util = new BotUtilities(telemetry);
        testboard = new TestBoard(hardwareMap, telemetry);

        telemetry.addLine("Test board initialized and ready");
        telemetry.update();

        // TODO: Add code to make the servo go to position -1

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Motion has started
        runtime.reset();

        // TODO: Add code to make first motor spin forward at a power of 1

        // TODO: Add code to make the servo go to position 1

        // TODO: Run a method to make both motors spin forward at a power of 1. (When you run this code, the single motor code above should be commented out. This method will be written in testboard

        updateTelemetry();
    }
//////////////////////////////////////////////////////////////////////////////////////////
    private void runEverything(){
        int roundedRunTime = (int) runtime.seconds();
        if (roundedRunTime % 5 == 0 || roundedRunTime % 4 == 0) {
            testboard.setServoPosition(-1);
            testboard.setMotorPower(-1);
        } else {
            testboard.setServoPosition(1);
            testboard.setMotorPower(1);
        }
    }

    private void updateTelemetry() {
        // Show the elapsed game time
        telemetry.addData("Run Time: ", runtime.toString());

        // Display Values of all the attached sensors
        telemetry.addLine("\n=== Sensors ===");
        telemetry.addData("Limit switch status", testboard.limitSwitchState());
        telemetry.addData("Bump switch status", testboard.bumpSwitchState());
        telemetry.addData("Rev Touch status", testboard.revTouchState());
        telemetry.addData("Potentiometer Value", testboard.getPotValue());
        telemetry.addData("Encoder Value", testboard.getMotorEncoder());
        telemetry.update();
    }
}
