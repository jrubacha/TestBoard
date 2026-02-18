package org.firstinspires.ftc.poeblack2;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

public class IMU {
    // The universal IMU sensor object (works with both BNO055 and BHI260AP)
    com.qualcomm.robotcore.hardware.IMU imu;

    Telemetry telemetry;

    public IMU(HardwareMap hardwareMap, Telemetry telemetry){
        this.telemetry = telemetry;

        // Retrieve the IMU from the hardware map using the universal IMU interface.
        // This works with both the older BNO055 and the newer BHI260AP found in
        // newer REV Control Hubs.
        imu = hardwareMap.get(com.qualcomm.robotcore.hardware.IMU.class, "imu");

        // Define how the control hub is mounted on the robot.
        // Adjust LogoFacingDirection and UsbFacingDirection to match your robot's mounting.
        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
        );

        imu.initialize(new com.qualcomm.robotcore.hardware.IMU.Parameters(orientationOnRobot));
    }

    public double getHeading(){
        YawPitchRollAngles angles = imu.getRobotYawPitchRollAngles();
        return angles.getYaw(AngleUnit.DEGREES);
    }

    public double getRoll(){
        YawPitchRollAngles angles = imu.getRobotYawPitchRollAngles();
        return angles.getRoll(AngleUnit.DEGREES);
    }

    public double getPitch(){
        YawPitchRollAngles angles = imu.getRobotYawPitchRollAngles();
        return angles.getPitch(AngleUnit.DEGREES);
    }

    public void resetYaw(){
        imu.resetYaw();
    }

    // Telemetry
    public void printIMUTelemetry(){
        YawPitchRollAngles angles = imu.getRobotYawPitchRollAngles();
        telemetry.addData("  Heading", "%.1f", angles.getYaw(AngleUnit.DEGREES));
        telemetry.addData("  Roll", "%.1f", angles.getRoll(AngleUnit.DEGREES));
        telemetry.addData("  Pitch", "%.1f", angles.getPitch(AngleUnit.DEGREES));
    }
}
