package org.firstinspires.ftc.driveexamples;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Tank Drive with Steering using DC Motors for propulsion.
 * Left and right wheels are each driven by a DC motor.
 * A separate CR servo controls a front steering mechanism for turning left/right.
 * Left joystick Y controls forward/backward, right joystick X controls steering.
 */
public class TankSteerMotor {
    // DC motors for propulsion (left and right)
    private DcMotor leftMotor;
    private DcMotor rightMotor;

    // CR servo for the front steering mechanism
    private CRServo steeringServo;

    Telemetry telemetry;

    /**
     * Constructor - sets up hardware from the hardware map.
     * The names here must match what is configured on the robot's phone/hub.
     */
    public TankSteerMotor(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;

        // Get the drive motors from the hardware map
        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");

        // Get the steering servo from the hardware map
        steeringServo = hardwareMap.get(CRServo.class, "steeringServo");

        // Left side goes forward, right side is reversed so both sides
        // move the same direction when given positive power
        leftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        rightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        // Brake when power is zero so the robot stops quickly
        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    /**
     * Sets the drive power for both motors (forward/backward).
     * DC motors accept values from -1.0 to 1.0 directly (no mapping needed).
     *
     * @param power Power for both drive motors (-1.0 to 1.0)
     */
    public void setDrivePower(double power) {
        leftMotor.setPower(power);
        rightMotor.setPower(power);

        telemetry.addData("Drive Power", power);
    }

    /**
     * Sets the steering servo power (left/right).
     * CR servo values are run through the map command for safe output.
     *
     * @param power Steering power (-1.0 to 1.0). Positive = right, negative = left.
     */
    public void setSteeringPower(double power) {
        // Map the value to safe CR servo range
        power = Utilities.map393(power);
        steeringServo.setPower(power);

        telemetry.addData("Steering Power", power);
    }

    /**
     * Stops the drive motors and the steering servo.
     */
    public void stop() {
        setDrivePower(0);
        setSteeringPower(0);
    }
}
