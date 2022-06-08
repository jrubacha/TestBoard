package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Sensors {
    private TouchSensor pushButton, limitSwitch;
    private AnalogInput pot;
    private ColorSensor color;
    Telemetry telemetry;

    // Constructor
    public Sensors(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        pushButton = hardwareMap.get(TouchSensor.class, "pushButton");
        pot = hardwareMap.get(AnalogInput.class, "potentiometer");
        limitSwitch = hardwareMap.get(TouchSensor.class, "limitSwitch");
        color = hardwareMap.get(ColorSensor.class, "colorV3");
    }

    // pushButton
    public boolean getPushButtonState(){
        return pushButton.isPressed();
    }
    public void printPushButtonState(){
        telemetry.addData("Push Button", getPushButtonState());
    }

    // Limit Switch
    public boolean getLimitSwitchState(){
        return limitSwitch.isPressed();
    }
    public void printLimitSwitchState(){
        telemetry.addData("Limit Switch", getLimitSwitchState());
    }

    // Potentiometer
    public double getPotReading(){
        return mapPotReading();
    }

    public void printPotReading(){
        telemetry.addData("Potentiometer", getPotReading());
    }
    public double mapPotReading(){
        return getRawPotReading() / 3.321;
    }
    public double getRawPotReading(){
        return pot.getVoltage();
    }

    // Color Sensor
    public int[] getColorArray(){
        int[] rgb = {color.red(), color.green(), color.blue()};
        return rgb;
    }
    public void printColorSensorValues() {
        telemetry.addData("Red", color.red());
        telemetry.addData("Green", color.green());
        telemetry.addData("Blue", color.blue());
    }

    // Sensor Telemetry
    public void printSensorTelemetry(){
        telemetry.addLine("\n=== Sensors ===");
        printPushButtonState();
        printLimitSwitchState();
        printPotReading();
        printColorSensorValues();
    }
}
