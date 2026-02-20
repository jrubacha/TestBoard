/** TODO: Read the following instructions
 *
 * Make changes as directed to by the Canvas guide.
 */
//////////////////////////////////////////////////////////////////////////////////////////
package org.firstinspires.ftc.poeblack4;

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

        telemetry.addLine("Test board initialized and ready");

        // TODO #1: Uncomment the line below
        //telemetry.addLine("Hello World!");

        // TODO #2: Add a new telemetry line below with a custom message of your choosing
        // It must come before telemetry.update();


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
        // TODO #3: Change the CR Servo power and observe the effect
        // Valid range: -1.0 to 1.0
        actuators.setCRServoPower(0.5);

        // TODO #4: Change the Motor power and observe the effect
        // Valid range: -1.0 to 1.0
        actuators.setMotorPower(0.5);

        // TODO #5: Change the Servo position and observe the effect
        // Valid range: 0.0 to 1.0
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
