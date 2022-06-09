package org.firstinspires.ftc.crane;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake {
    /**
     * The intaking motor is 1 bag motor, with a ? : 1 reduction VP
     * The deploying motors are 2 bosch seat motors, electrically tied together
     * This deploying motors really should have encoder control and/or limit switches at the outer bounds
     */
    CRServo deploymentMotor, intakeMotor;
    TouchSensor upLimitSwitch, downLimitSwitch;
    Telemetry telemetry;
    Constants constants;

    public Intake(HardwareMap hardwareMap, Telemetry telemetry) {
        deploymentMotor = hardwareMap.get(CRServo.class, "deploymentMotor");
        intakeMotor = hardwareMap.get(CRServo.class, "intakeMotor");
        upLimitSwitch = hardwareMap.get(TouchSensor.class, "intakeUpSwitch");
        downLimitSwitch = hardwareMap.get(TouchSensor.class, "intakeDownSwitch");
        this.telemetry = telemetry;
        constants = new Constants();
    }


}
