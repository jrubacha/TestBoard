// TODO: Read the following instructions
/**
 * Fill out the controller sections of this code for how you want the human to control the robot
 */
//////////////////////////////////////////////////////////////////////////////////////////
package org.firstinspires.ftc.crane;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;


//////////////////////////////////////////////////////////////////////////////////////////
@TeleOp(name="TeleOpMode", group="actuators")
//@Disabled        // Comment/Uncomment this line as needed to show/hide this opmode
//////////////////////////////////////////////////////////////////////////////////////////

public class TeleOpMode extends OpMode {
    private ElapsedTime runtime = new ElapsedTime();
    DriveTrain drivetrain;
    Agitator agitator;
    Elevator elevator;
    Intake intake;
    Shooter shooter;
    Turret turret;
    Utilities utilities;
    Constants constants;

//////////////////////////////////////////////////////////////////////////////////////////

    /* Code to run ONCE when the driver hits INIT */
    @Override
    public void init() {
        drivetrain = new DriveTrain(hardwareMap, telemetry);
        agitator = new Agitator(hardwareMap, telemetry);
        elevator = new Elevator(hardwareMap, telemetry);
        intake = new Intake(hardwareMap, telemetry);
        shooter = new Shooter(hardwareMap, telemetry);
        turret = new Turret(hardwareMap, telemetry);
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
        drivetrain.arcadeDrive(-gamepad1.left_stick_y, gamepad1.right_stick_x);
    }


    public void checkOperatorController() {
        // Elevator Control + agitator?
        if(gamepad2.dpad_up) {
            elevator.raiseElevator();
        } else if (gamepad2.dpad_down) {
            elevator.lowerElevator();
        } else {
            elevator.stopElevator();
        }

        // Shooter Control
        if(gamepad2.triangle) {
            shooter.shoot();
        } else if (gamepad2.cross) {
            shooter.spit();
        } else if (gamepad2.dpad_left) {
            shooter.retractBall();
        } else {
            shooter.stopShooter();
        }


        // Turret Control
        if (Math.abs(gamepad2.right_stick_x) > 0.1) {
            turret.fullManualSpinTurret(gamepad2.right_stick_x);
        } else {
            turret.fullManualSpinTurret(0);
        }


        // Intake Deployment Control
        if (gamepad2.left_bumper) {
            intake.manualDeployment(constants.RAISE);
        } else if (gamepad2.right_bumper){
            intake.manualDeployment(constants.LOWER);
        } else {
            intake.manualDeployment(0);
        }

        // Intake Intaking Control
        if(gamepad2.circle){
            intake.intake();
        } else if(gamepad2.square){
            intake.outtake();
        } else {
            intake.stopIntaking();
        }


    }

}

