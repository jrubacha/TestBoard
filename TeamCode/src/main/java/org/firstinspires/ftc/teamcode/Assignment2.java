/** TODO: Read the following instructions
 *
 * Follow along with the assignment on Canvas to use this OpMode
 *
 * You will be running the program and making small changes to the values used in the program. You will not need to write any new code for this assignment.
 *
 * Except where specified, do NOT make any changes to the program.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

//////////////////////////////////////////////////////////////////////////////////////////
@TeleOp(name="Assignment 2", group="actuators")
// TODO: For question #?, change the text inside the quotes above to something other than Assignment 1
@Disabled        // Comment/Uncomment this line as needed to show/hide this opmode
//////////////////////////////////////////////////////////////////////////////////////////

public class Assignment2 extends OpMode {
    private ElapsedTime runtime = new ElapsedTime();
    Sensors sensors;
    Actuators actuators;

//////////////////////////////////////////////////////////////////////////////////////////

    /* Code to run ONCE when the driver hits INIT */
    @Override
    public void init() {
        // Create our two objects needed for this assignment
        sensors = new Sensors(hardwareMap, telemetry);
        actuators = new Actuators(hardwareMap, telemetry);


        // Tell the user that initialization is complete.
        telemetry.addLine("actuators is now ready to be used.");
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
        double motorPower = 0.25, servoPosition = 1;
        int roundedRunTime = (int) runtime.seconds();
        if (roundedRunTime % 5 == 0) {
            motorPower = motorPower * -1;
            servoPosition = servoPosition * -1;
        }
        actuators.setServoPosition(servoPosition);
        actuators.setMotorPower(motorPower);
        actuators.setCRServoPower(motorPower);
    }
    private void getTelemetry() {
        // Show the elapsed game time
        telemetry.addData("Run Time: ", runtime.toString());

        // Display Values of all the attached sensors
        // TODO: Fix the following TODO
        // TODO: For question #? remove the '\n' in the following code. What happens?
        sensors.printSensorTelemetry();
        telemetry.update();
    }  // getTelemetry


    public void delay(int milli) {
        try {
            Thread.sleep(milli);
        } catch (InterruptedException e) {

        }
    }

}

