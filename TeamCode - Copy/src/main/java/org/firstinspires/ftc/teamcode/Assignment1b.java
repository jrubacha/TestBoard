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
    Actuators actuators;
    Sensors sensors;
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        actuators = new Actuators(hardwareMap, telemetry);
        sensors = new Sensors(hardwareMap, telemetry);

        actuators.setServoPosition(0);

        // TODO: #1 Uncomment the line below when instructed
        //telemetry.addLine("Hello World!");

        // TODO: #2 Add a telemetry statement below this line with a custom message of your own
        telemetry.addLine("Test board initialized and ready");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Motion has started
        runtime.reset();

        while (opModeIsActive()) {
            runEverything();
            callTelemetry();
        }

    }
    //////////////////////////////////////////////////////////////////////////////////////////
    private void runEverything(){
        // TODO: #3. Change the numerical values below as prompted
        // value ranges -1 - 1
        actuators.setCRServoPower(0.5);
        actuators.setMotorPower(0.5);

        // value ranges 0 - 1
        actuators.setServoPosition(-1);
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
