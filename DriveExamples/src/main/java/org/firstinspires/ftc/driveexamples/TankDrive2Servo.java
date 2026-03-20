package org.firstinspires.ftc.driveexamples;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.FORWARD;
import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;

/**
 * Tank Drive using 2 Continuous Rotation Servos.
 * One CR servo on the left side, one on the right side.
 * Left joystick Y controls the left side, right joystick Y controls the right side.
 */
public class TankDrive2Servo {
    // One CR servo per side
    private CRServo leftServo;
    private CRServo rightServo;

    Telemetry telemetry;

    /**
     * Constructor - sets up hardware from the hardware map.
     * The names here must match what is configured on the robot's phone/hub.
     */
    public TankDrive2Servo(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;

        // Get each servo from the hardware map
        leftServo = hardwareMap.get(CRServo.class, "leftServo");
        rightServo = hardwareMap.get(CRServo.class, "rightServo");

        // Left side goes forward, right side is reversed so both sides
        // move the same direction when given positive power
        leftServo.setDirection(FORWARD);
        rightServo.setDirection(REVERSE);
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
        leftServo.setPower(leftPower);
        rightServo.setPower(rightPower);

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
