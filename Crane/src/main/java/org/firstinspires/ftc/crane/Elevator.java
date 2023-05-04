package org.firstinspires.ftc.crane;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Elevator {
    /**
     * The elevator uses 2 bag motors, each on a ? : 1 reduction versaplanetary
     * These motors are electrically tied together and run on a single motor controller
     */
    private CRServo elevatorMotors;
    Constants constants;
    Telemetry telemetry;
    Utilities utilities;

    public Elevator(HardwareMap hardwareMap, Telemetry telemetry) {
        elevatorMotors = hardwareMap.get(CRServo.class, "elevatorMotors");
        this.telemetry = telemetry;
        elevatorMotors.setDirection(REVERSE);
    }

    private void setElevatorPower(double power){
        power = Utilities.mapVictorSPX(power);
        elevatorMotors.setPower(power);
    }
    public void stopElevator(){
        setElevatorPower(0);
    }

    public void raiseElevator(){
        setElevatorPower(constants.RAISE_ELEVATOR);
    }
    public void lowerElevator(){
        setElevatorPower(constants.LOWER_ELEVATOR);
    }
}
