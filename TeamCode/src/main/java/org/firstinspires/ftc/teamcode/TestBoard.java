package org.firstinspires.ftc.teamcode;

import android.graphics.Color;
import android.text.method.Touch;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.AnalogSensor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class TestBoard {
    private Servo myServo;
    private CRServo myCRServo;
    private DcMotor myMotor;
    private TouchSensor myRevTouch, vexPushButton, limitSwitch;
    private LED flashlight;
    private AnalogInput pot;
    private ColorSensor color;
    Telemetry telemetry;
    BotUtilities utilities = new BotUtilities(telemetry);

    public TestBoard(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        myServo = hardwareMap.get(Servo.class, "vexServo");
        myRevTouch = hardwareMap.get(TouchSensor.class, "revTouchButton");
        //flashlight = hardwareMap.get(LED.class, "flashlight");
        //vexPushButton = hardwareMap.get(TouchSensor.class, "vexPushButton");
        pot = hardwareMap.get(AnalogInput.class, "potentiometer");
        limitSwitch = hardwareMap.get(TouchSensor.class, "limitSwitch");
        myCRServo = hardwareMap.get(CRServo.class, "vexCRServo");
        myMotor = hardwareMap.get(DcMotor.class, "testBoardMotor");
        color = hardwareMap.get(ColorSensor.class, "colorV3");
    }

    public void turnFlashlightOn(){
        //flashlight.enable(true);
        flashlight.enableLight(true);
    }
    public void turnFlashlightOff(){
        flashlight.enable(false);
    }

    // Motor
    public void setMotorPower(double pow) {
        myMotor.setPower(pow);
    }
    public double getMotorEncoder(){
        return utilities.getEncoderValue(myMotor);
    }
    //public void

    // Servos
    public void setServoPosition(double pos) {
        myServo.setPosition(pos);
    }

    // Sensors
    public boolean revTouchState(){
        return myRevTouch.isPressed();
    }
//    public boolean bumpSwitchState(){
//        return vexPushButton.isPressed();
//    }
    public boolean limitSwitchState() {
        return limitSwitch.isPressed();
    }
    public double getPotValue(){
        return pot.getVoltage();
    }


    // Color Sensor
    public void printColorSensorValues() {
        telemetry.addData("Red", color.red());
        telemetry.addData("Blue", color.blue());
        telemetry.addData("Green", color.green());
        telemetry.update();
    }

    public void setCRServoPower(double power) {
        myCRServo.setPower(power);
    }
}
