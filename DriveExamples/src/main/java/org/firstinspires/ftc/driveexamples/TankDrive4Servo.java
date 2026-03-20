package org.firstinspires.ftc.driveexamples;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.FORWARD;
import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;

/**
 * Tank Drive using 4 Continuous Rotation Servos.
 * Two servos on the left side (front and back), two on the right side (front and back).
 * Left joystick Y controls the left side, right joystick Y controls the right side.
 */
public class TankDrive4Servo {
    // Left side CR servos
    private CRServo frontLeft;
    private CRServo backLeft;

    // Right side CR servos
    private CRServo frontRight;
    private CRServo backRight;

    Telemetry telemetry;

    /**
     * Constructor - sets up hardware from the hardware map.
     * The names here must match what is configured on the robot's phone/hub.
     */
    public TankDrive4Servo(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;

        // Get each servo from the hardware map
        frontLeft = hardwareMap.get(CRServo.class, "frontLeft");
        backLeft = hardwareMap.get(CRServo.class, "backLeft");
        frontRight = hardwareMap.get(CRServo.class, "frontRight");
        backRight = hardwareMap.get(CRServo.class, "backRight");

        // Left side goes forward, right side is reversed so both sides
        // move the same direction when given positive power
        frontLeft.setDirection(FORWARD);
        backLeft.setDirection(FORWARD);
        frontRight.setDirection(REVERSE);
        backRight.setDirection(REVERSE);
    }

    /**
     * Sets power to both sides of the drivetrain.
     * All CR servo values are run through the map command for safe output.
     *
     * @param leftPower  Power for the left side (-1.0 to 1.0)
     * @param rightPower Power for the right side (-1.0 to 1.0)
     */
    public void setPower(double leftPower, double rightPower) {
        // Map joystick values to safe CR servo range
        leftPower = Utilities.map393(leftPower);
        rightPower = Utilities.map393(rightPower);

        // Apply the mapped power to each servo
        frontLeft.setPower(leftPower);
        backLeft.setPower(leftPower);
        frontRight.setPower(rightPower);
        backRight.setPower(rightPower);

        telemetry.addData("Left Power", leftPower);
        telemetry.addData("Right Power", rightPower);
    }

    /**
     * Stops all drivetrain servos.
     */
    public void stop() {
        setPower(0, 0);
    }
}
