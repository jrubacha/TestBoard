package org.firstinspires.ftc.teamcode;


import android.graphics.Color;
import android.text.method.Touch;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.AnalogSensor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Const;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Actuators {
    private Servo myServo;
    private CRServo myCRServo;
    private DcMotor myMotor;
    Constants constants;
    Telemetry telemetry;
    Utilities util;

    public Actuators(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        constants = new Constants();
        util = new Utilities();
        myServo = hardwareMap.get(Servo.class, "myServo");
        myCRServo = hardwareMap.get(CRServo.class, "myCRServo");
        myMotor = hardwareMap.get(DcMotor.class, "testBoardMotor");
        myMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }


    // Motor
    public void setMotorPower(double pow) {
        myMotor.setPower(pow);
    }
    public double getMotorEncoder(){
        return myMotor.getCurrentPosition();
    }
    public void printMotorEncoderValue(){
        telemetry.addData("Encoder", getMotorEncoder());
    }


    // Standard Servo
    public void setServoPosition(double pos) {
        myServo.setPosition(pos);
    }



    // Continuous Rotation Servo
    public void setCRServoPower(double power) {
        myCRServo.setPower(mapVexServo(power));
    }
    private double mapVexServo(double power){
        return util.map(power, -1.0, 1.0, constants.VEX_393_LOWER_BOUND, constants.VEX_393_UPPER_BOUND);
    }


    // Actuator Telemetry
    public void printActuatorTelemetry(){
        telemetry.addLine("=== Actuators ===");
        printMotorEncoderValue();
    }
}
