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

    public Actuators(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        constants = new Constants();
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



    // Motor Modes
    public void setMotorToEncoderMode(){
        myMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void setMotorToBlankMode(){
        myMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    // must be called AFTER setting a target position
    public void setMotorToPositionMode(){
        myMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void setMotorTarget(int target){
        myMotor.setTargetPosition(target);
    }
    public void resetEncoders(){
        myMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void printCurrentMotorMode(){
        telemetry.addData("Motor Mode", myMotor.getMode());
    }
    public boolean isMotorBusy(){
        return myMotor.isBusy();
    }

    public void driveToDistance (double inches){
        myMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        int target = (int)(inches / .046);
        myMotor.setTargetPosition (target); //This converts inches back into pulses. 1 pulse covers about .046 inches of distance.
        setMotorPower(.35);
        myMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (myMotor.isBusy())
        {
            telemetry.addData("Current Encoder Position", myMotor.getCurrentPosition() );
            telemetry.addData("Target is", target);
            telemetry.update();
        }
        setMotorPower(0);
    }

    // Standard Servo
    public void setServoPosition(double pos) {
        myServo.setPosition(pos);
    }



    // Continuous Rotation Servo
    public void setCRServoPower(double power) {
        myCRServo.setPower(power);
    }


    // Actuator Telemetry
    public void printActuatorTelemetry(){
        telemetry.addLine("=== Actuators ===");
        printMotorEncoderValue();
    }
}
