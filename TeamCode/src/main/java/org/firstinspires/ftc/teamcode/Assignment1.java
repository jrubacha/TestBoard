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
@Autonomous(name= "Assignment 1", group="Assignments")
//@Disabled
//////////////////////////////////////////////////////////////////////////////////////////
public class Assignment1 extends LinearOpMode {
    BotUtilities util;
    TestBoard testboard;
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        util = new BotUtilities(telemetry);
        testboard = new TestBoard(hardwareMap, telemetry);

        telemetry.addLine("Test board initialized and ready");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Motion has started
        runtime.reset();
        while (opModeIsActive()) {
            //runEverything();
            callTelemetry();
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

    private void callTelemetry() {
        // Show the elapsed game time
        telemetry.addData("Run Time: ", runtime.toString());

        // Display Values of all the attached sensors
        telemetry.addLine("\n=== Sensors ===");
        telemetry.addData("Limit switch status", testboard.limitSwitchState());
        //telemetry.addData("Bump switch status", testboard.bumpSwitchState());
        telemetry.addData("Rev Touch status", testboard.revTouchState());
        telemetry.addData("Potentiometer Value", testboard.getPotValue());
        telemetry.addData("Encoder Value", testboard.getMotorEncoder());
        testboard.printColorSensorValues();
        telemetry.update();
    }
}
