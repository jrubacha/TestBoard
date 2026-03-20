package org.firstinspires.ftc.driveexamples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * TeleOp example for tank drive with steering, using DC motors for propulsion.
 * Left joystick Y  = forward/backward power (both wheels together)
 * Right joystick X = steering (CR servo moves steering mechanism left/right)
 */
@TeleOp(name = "Tank Steer - Motor", group = "Drive Examples")
@Disabled
public class TankSteerMotorTeleOp extends OpMode {
    private ElapsedTime runtime = new ElapsedTime();
    TankSteerMotor drivetrain;

    @Override
    public void init() {
        // Create the drivetrain object using the hardware map
        drivetrain = new TankSteerMotor(hardwareMap, telemetry);

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
        // Left stick Y controls forward/backward (negated because forward is negative on stick)
        double drivePower = -gamepad1.left_stick_y;

        // Right stick X controls steering (positive = right)
        double steeringPower = gamepad1.right_stick_x;

        drivetrain.setDrivePower(drivePower);
        drivetrain.setSteeringPower(steeringPower);

        telemetry.addData("Runtime", runtime.toString());
        telemetry.update();
    }

    @Override
    public void stop() {
        drivetrain.stop();
    }
}
