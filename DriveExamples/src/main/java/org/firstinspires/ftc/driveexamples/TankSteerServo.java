package org.firstinspires.ftc.driveexamples;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.FORWARD;
import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;

/**
 * Tank Drive with Steering using CR Servos for propulsion.
 * Left and right wheels are each driven by a CR servo.
 * A separate CR servo controls a front steering mechanism for turning left/right.
 * Left joystick Y controls forward/backward, right joystick X controls steering.
 */
public class TankSteerServo {
    // CR servos for propulsion (left and right)
    private CRServo leftServo;
    private CRServo rightServo;

    // CR servo for the front steering mechanism
    private CRServo steeringServo;

    Telemetry telemetry;

    /**
     * Constructor - sets up hardware from the hardware map.
     * The names here must match what is configured on the robot's phone/hub.
     */
    public TankSteerServo(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;

        // Get the drive servos from the hardware map
        leftServo = hardwareMap.get(CRServo.class, "leftServo");
        rightServo = hardwareMap.get(CRServo.class, "rightServo");

        // Get the steering servo from the hardware map
        steeringServo = hardwareMap.get(CRServo.class, "steeringServo");

        // Left side goes forward, right side is reversed so both sides
        // move the same direction when given positive power
        leftServo.setDirection(FORWARD);
        rightServo.setDirection(REVERSE);
    }

    /**
     * Sets the drive power for both CR servos (forward/backward).
     * All CR servo values are run through the map command for safe output.
     *
     * @param power Power for both drive servos (-1.0 to 1.0)
     */
    public void setDrivePower(double power) {
        // Map joystick value to safe CR servo range
        double mappedPower = Utilities.map393(power);
        leftServo.setPower(mappedPower);
        rightServo.setPower(mappedPower);

        telemetry.addData("Drive Power", mappedPower);
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
     * Stops the drive servos and the steering servo.
     */
    public void stop() {
        setDrivePower(0);
        setSteeringPower(0);
    }
}
