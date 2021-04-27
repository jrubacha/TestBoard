/*
17012
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

//////////////////////////////////////////////////////////////////////////////////////////
/*
Assignment #1 OpMode

Follow along with the assignment on Canvas to use this OpMode

You will be running the program and making small changes to the values used in the
 program. You will not need to write any new code for this assignment.

Except where specified, do NOT make any changes to the program
*/
//////////////////////////////////////////////////////////////////////////////////////////
@TeleOp(name="Assignment 1", group="TestBoard")
// TODO: For question #?, change the text inside the quotes above to something other than Assignment 1
//@Disabled        // Comment/Uncomment this line as needed to show/hide this opmode
//////////////////////////////////////////////////////////////////////////////////////////

public class Assignment1 extends OpMode {
    private ElapsedTime runtime = new ElapsedTime();
    BotUtilities utilities;
    TestBoard testboard;

//////////////////////////////////////////////////////////////////////////////////////////

    /* Code to run ONCE when the driver hits INIT */
    @Override
    public void init() {
        // Create our two objects needed for this assignment
        utilities = new BotUtilities(this.telemetry);
        testboard = new TestBoard(this.hardwareMap, this.telemetry);

        // Tell the user that initialization is complete.
        // TODO: Uncomment line 43 when instructed
        //telemetry.addLine("Hello World!");
        telemetry.addLine("Testboard is now ready to be used.");
        telemetry.update();
    }

//////////////////////////////////////////////////////////////////////////////////////////

    /* Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY */
    @Override
    public void init_loop() {
    }

//////////////////////////////////////////////////////////////////////////////////////////

    /* Code to run ONCE when the driver hits PLAY */
    @Override
    public void start() {
        runtime.reset();
        getTelemetry();
    }

//////////////////////////////////////////////////////////////////////////////////////////

    /* Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP */
    @Override
    public void loop() {
        // Run actions for this sample opmode
        runEverything();

        // Call Telemetry
        getTelemetry();

    }

//////////////////////////////////////////////////////////////////////////////////////////

    /* Code to run ONCE after the driver hits STOP */
    @Override
    public void stop() {
        telemetry.addData("Final runtime: ", runtime.toString());
        telemetry.update();
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
    private void getTelemetry() {
        // Show the elapsed game time
        telemetry.addData("Run Time: ", runtime.toString());

        // Display Values of all the attached sensors
        // TODO: For question #? remove the '\n' in the following code. What happens?
        telemetry.addLine("\n=== Sensors ===");
        telemetry.addData("Limit switch status", testboard.limitSwitchState());
        telemetry.addData("Bump switch status", testboard.bumpSwitchState());
        telemetry.addData("Rev Touch status", testboard.revTouchState());
        telemetry.addData("Potentiometer Value", testboard.getPotValue());
        telemetry.addData("Encoder Value", testboard.getMotorEncoder());
        telemetry.update();
    }  // getTelemetry

}

