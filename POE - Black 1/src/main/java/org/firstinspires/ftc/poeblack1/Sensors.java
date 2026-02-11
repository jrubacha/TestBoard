package org.firstinspires.ftc.poeblack1;

import android.graphics.Color;

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
    IMU imu;
    Telemetry telemetry;

    // Constructor
    public Sensors(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        pushButton = hardwareMap.get(TouchSensor.class, "pushButton");
        pot = hardwareMap.get(AnalogInput.class, "potentiometer");
        limitSwitch = hardwareMap.get(TouchSensor.class, "limitSwitch");
        color = hardwareMap.get(ColorSensor.class, "colorV3");
        imu = new IMU(hardwareMap, telemetry);
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
        telemetry.addData("Potentiometer (raw)", getRawPotReading());
        telemetry.addData("Potentiometer (mapped)", getPotReading());
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
    public float[] getHSV(){
        float[] hsv = new float[3];
        Color.RGBToHSV(color.red(), color.green(), color.blue(), hsv);
        return hsv;
    }
    public void printColorSensorValues() {
        float[] hsv = getHSV();
        telemetry.addData("  Red", color.red());
        telemetry.addData("  Green", color.green());
        telemetry.addData("  Blue", color.blue());
        telemetry.addData("  Alpha", color.alpha());
        telemetry.addData("  Hue", "%.1f", hsv[0]);
        telemetry.addData("  Saturation", "%.3f", hsv[1]);
        telemetry.addData("  Value", "%.3f", hsv[2]);
    }

    // Sensor Telemetry
    public void printSensorTelemetry(){
        telemetry.addLine("\n=== Sensors ===");
        telemetry.addLine("--- Digital ---");
        printPushButtonState();
        printLimitSwitchState();
        telemetry.addLine("--- Analog ---");
        printPotReading();
        telemetry.addLine("--- Color Sensor ---");
        printColorSensorValues();
        telemetry.addLine("--- IMU ---");
        imu.printIMUTelemetry();
    }
}
