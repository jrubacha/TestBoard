package org.firstinspires.ftc.driveexamples;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Tank Drive using 2 DC Motors.
 * One DC motor on the left side, one on the right side.
 * Left joystick Y controls the left side, right joystick Y controls the right side.
 */
public class TankDrive2Motor {
    // One DC motor per side
    private DcMotor leftMotor;
    private DcMotor rightMotor;

    Telemetry telemetry;

    /**
     * Constructor - sets up hardware from the hardware map.
     * The names here must match what is configured on the robot's phone/hub.
     */
    public TankDrive2Motor(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;

        // Get each motor from the hardware map
        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");

        // Left side goes forward, right side is reversed so both sides
        // move the same direction when given positive power
        leftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        rightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        // Brake when power is zero so the robot stops quickly
        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    /**
     * Sets power to both sides of the drivetrain.
     * DC motors accept values from -1.0 to 1.0 directly (no mapping needed).
     *
     * @param leftPower  Power for the left side (-1.0 to 1.0)
     * @param rightPower Power for the right side (-1.0 to 1.0)
     */
    public void setPower(double leftPower, double rightPower) {
        leftMotor.setPower(leftPower);
        rightMotor.setPower(rightPower);

        telemetry.addData("Left Power", leftPower);
        telemetry.addData("Right Power", rightPower);
    }

    /**
     * Stops all drivetrain motors.
     */
    public void stop() {
        setPower(0, 0);
    }
}
