package org.firstinspires.ftc.driveexamples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * TeleOp example for a 2-motor tank drive.
 * Left joystick Y  = left side power
 * Right joystick Y = right side power
 */
@TeleOp(name = "Tank Drive - 2 Motor", group = "Drive Examples")
@Disabled
public class TankDrive2MotorTeleOp extends OpMode {
    private ElapsedTime runtime = new ElapsedTime();
    TankDrive2Motor drivetrain;

    @Override
    public void init() {
        // Create the drivetrain object using the hardware map
        drivetrain = new TankDrive2Motor(hardwareMap, telemetry);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }

    @Override
    public void init_loop() {
    }

    @Override
    public void start() {
        runtime.reset();
    }

    @Override
    public void loop() {
        // Tank drive: left stick controls left wheels, right stick controls right wheels
        // Joystick Y is negated because pushing the stick forward returns a negative value
        double leftPower = -gamepad1.left_stick_y;
        double rightPower = -gamepad1.right_stick_y;

        drivetrain.setPower(leftPower, rightPower);

        telemetry.addData("Runtime", runtime.toString());
        telemetry.update();
    }

    @Override
    public void stop() {
        drivetrain.stop();
    }
}
