package org.firstinspires.ftc.tacobot.Subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.tacobot.Constants;
import org.firstinspires.ftc.tacobot.Utilities;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.FORWARD;
import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;

public class DriveTrain {
    private DcMotor backLeft, backRight, frontLeft, frontRight;
    Utilities utilities;

    Telemetry telemetry;

    public DriveTrain(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;

        backLeft = hardwareMap.get(DcMotor.class, "DTBL");
        frontLeft = hardwareMap.get(DcMotor.class, "DTFL");
        backRight = hardwareMap.get(DcMotor.class, "DTBR");
        frontRight = hardwareMap.get(DcMotor.class, "DTFR");

        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


    }

    public void stopDriving() {
        setMotorPower(0,0,0,0);
    }

    public void setMotorPower(double FL, double BL, double FR, double BR) {
        frontLeft.setPower(FL);
        backLeft.setPower(BL);
        frontRight.setPower(FR);
        backRight.setPower(BR);
    }

    private double[] normalize(double[] wheelSpeeds) {
        double maxMagnitude = Math.abs(wheelSpeeds[0]);

        for (int i = 1; i < wheelSpeeds.length; i++){
            double magnitude = Math.abs(wheelSpeeds[i]);
            if (magnitude > maxMagnitude){
                maxMagnitude = magnitude;
            }
        }

        if (maxMagnitude > 1.0) {
            for (int i = 0; i < wheelSpeeds.length; i++){
                wheelSpeeds[i] /= maxMagnitude;
            }
        }


        return wheelSpeeds;
    }   //normalize

    public double deadband(double x) {
        if (x > 0.1) {
            return x;
        } else if (x < -0.1) {
            return x;
        } else {
            return 0;
        }
    }   // deadband

//    public void mecanumFieldOrientated(double x, double y, double rotation) {
//        final double PI = Math.PI;
//        double gyroHeading = imu.getHeadingInRad(); // TODO: Create IMU class and this method
//        double temp = y * Math.cos(gyroHeading) + x * Math.sin(gyroHeading);
//        x = -y * Math.sin(gyroHeading) + x * Math.cos(gyroHeading);
//        y = temp;
//
//        double wheelSpeeds[] = new double[4];
//
//        mecanumDrive_Cartesian(x, y, rotation);
//    }

    public void mecanumDrive_Cartesian(double x, double y, double rotation) {
        double wheelSpeeds[] = new double[4];

        // Slow it down
        x *= Constants.DriveConstants.DRIVE_SPEED_MODIFIER;
        y *= Constants.DriveConstants.DRIVE_SPEED_MODIFIER;
        rotation *= Constants.DriveConstants.DRIVE_SPEED_MODIFIER;


        // Deadband prevents controller movement for very small motions to prevent unintentional movements
        x = deadband(x);
        y = deadband(y);
        rotation = deadband(rotation);

        //Cubic funtion for controls
        x = x * x * x;
        y = y * y * y;
        rotation = rotation * rotation * rotation;

        //Mecanum Math
        wheelSpeeds[0] = x - y + rotation;
        wheelSpeeds[1] = x + y - rotation;
        wheelSpeeds[2] = x + y + rotation;
        wheelSpeeds[3] = x - y - rotation;

        // Remaping wheel speeds to be 0 to 1.
        wheelSpeeds = normalize(wheelSpeeds);



        //Set power to motors. Vroom vroom.
        setMotorPower(wheelSpeeds[0], wheelSpeeds[1], wheelSpeeds[2], wheelSpeeds[3]);

    }   //mecanumDrive_Cartesian


}
