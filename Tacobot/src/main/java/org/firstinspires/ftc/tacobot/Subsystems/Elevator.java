package org.firstinspires.ftc.tacobot.Subsystems;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.tacobot.Constants;
import org.firstinspires.ftc.tacobot.Utilities;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Elevator {
    private DcMotor elevatorLeft, elevatorRight;
    Constants constants;
    Telemetry telemetry;

    public Elevator(HardwareMap hardwareMap, Telemetry telemetry) {
        elevatorLeft = hardwareMap.get(DcMotor.class, "elevatorLeft");
        elevatorRight = hardwareMap.get(DcMotor.class, "elevatorRight");

        this.telemetry = telemetry;

        //elevatorLeft.setDirection(REVERSE);

        elevatorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        elevatorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    private void setElevatorPower(double power){
        elevatorLeft.setPower(power);
        elevatorRight.setPower(power);
    }
    public void stopElevator(){
        setElevatorPower(0);
    }

    public void raiseElevator(){
        setElevatorPower(Constants.ElevatorConstants.ELEVATOR_EXTEND_SPEED);
    }
    public void lowerElevator(){
        setElevatorPower(Constants.ElevatorConstants.ELEVATOR_RETRACT_SPEED);
    }
}
