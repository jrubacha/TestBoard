// TODO: Read the following instructions
/**
 * Fill out the controller sections of this code for how you want the human to control the robot
 */
//////////////////////////////////////////////////////////////////////////////////////////
package org.firstinspires.ftc.tacobot;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.tacobot.Subsystems.Climber;
import org.firstinspires.ftc.tacobot.Subsystems.DriveTrain;
import org.firstinspires.ftc.tacobot.Subsystems.Elevator;
import org.firstinspires.ftc.tacobot.Subsystems.Flipper;
import org.firstinspires.ftc.tacobot.Subsystems.Intake;


//////////////////////////////////////////////////////////////////////////////////////////
@TeleOp(name="TeleOpMode", group="tacos")
//@Disabled        // Comment/Uncomment this line as needed to show/hide this opmode
//////////////////////////////////////////////////////////////////////////////////////////

public class TeleOpMode extends OpMode {
    private ElapsedTime runtime = new ElapsedTime();
    DriveTrain drivetrain;
    Elevator elevator;
    Intake intake;
    Flipper flipper;
    Climber climber;


    Utilities utilities;
    Constants constants;

//////////////////////////////////////////////////////////////////////////////////////////

    /* Code to run ONCE when the driver hits INIT */
    @Override
    public void init() {
        drivetrain = new DriveTrain(hardwareMap, telemetry);
        elevator = new Elevator(hardwareMap, telemetry);
        intake = new Intake(hardwareMap, telemetry);
        flipper = new Flipper(hardwareMap, telemetry);
        climber = new Climber(hardwareMap, telemetry);

        utilities = new Utilities(telemetry);

        // Set up our telemetry dashboard
        telemetry.update();

        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized    :)");
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
        updateTelemetry(telemetry);
    }

//////////////////////////////////////////////////////////////////////////////////////////

    /* Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP */
    @Override
    public void loop() {
        checkDriverController();
        checkOperatorController();

        // Call Telemetry
        telemetry.update();
    }

//////////////////////////////////////////////////////////////////////////////////////////

    /* Code to run ONCE after the driver hits STOP */
    @Override
    public void stop() {
        telemetry.addData("Robot Stopped. ", "Have a nice day.");
        telemetry.addData("Final runtime: ", runtime.toString());
        telemetry.update();
    }

//////////////////////////////////////////////////////////////////////////////////////////

    public void checkDriverController() {
        Gamepad driver = gamepad1;

        // Drive Controls
        drivetrain.mecanumDrive_Cartesian(driver.left_stick_x, driver.left_stick_y, driver.right_stick_x);

        // Elevator Controls
        if (driver.right_trigger > 0.1) {
            elevator.raiseElevator();
        } else if (driver.left_trigger > 0.1 ) {
            elevator.lowerElevator();
        } else {
            elevator.stopElevator();
        }

        // Intake Controls
        if (driver.triangle) {
            intake.deployIntake();
        } else if (driver.cross) {
            intake.retractIntake();
        } else {
            intake.stopIntakePivot();
        }

        if(driver.right_bumper) {
            intake.intake();
        } else if (driver.left_bumper) {
            intake.outtake();
        } else {
            intake.stopIntaking();
        }

        // Flipper Controls
        if(driver.circle){
            flipper.flipperExtend();
        } else if (driver.square){
            flipper.flipperRetract();
        } else {
            flipper.stopFlipperMovement();
        }

        // Climb Controls
        if(driver.dpad_up) {
            climber.ascend();
        } else if (driver.dpad_down) {
            climber.descend();
        } else {
            climber.stopClimber();
        }

        if(driver.dpad_right) {
            climber.deployClimbServos();
        } else if (driver.dpad_left) {
            climber.retractClimbServos();
        } else {
            climber.stopClimbServos();
        }

    }


    public void checkOperatorController() {


    }

}

