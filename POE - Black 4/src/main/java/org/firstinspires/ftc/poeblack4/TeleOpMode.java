//// TODO: Read the following instructions
///**
// * Fill out the controller sections of this code for how you want the human to control the robot
// */
////////////////////////////////////////////////////////////////////////////////////////////
//package org.firstinspires.ftc.poeblack4;
//
//import static com.qualcomm.robotcore.hardware.configuration.ConfigurationType.DeviceFlavor.I2C;
//
//import android.graphics.Color;
//
//import com.qualcomm.hardware.rev.RevColorSensorV3;
//import com.qualcomm.robotcore.eventloop.opmode.Disabled;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.ColorRangeSensor;
//import com.qualcomm.robotcore.hardware.ColorSensor;
//import com.qualcomm.robotcore.hardware.NormalizedRGBA;
//import com.qualcomm.robotcore.util.ElapsedTime;
//
////////////////////////////////////////////////////////////////////////////////////////////
//@TeleOp(name="TeleOpMode", group="actuators")
//// TODO: Enable the program.
////@Disabled
////////////////////////////////////////////////////////////////////////////////////////////
//
//public class TeleOpMode extends OpMode {
//    private ElapsedTime runtime = new ElapsedTime();
//    ColorSensor colorSensor;
//    NormalizedRGBA cS;
////    DriveTrain drivetrain;
////    Mechanisms mechanisms;
//
//
////////////////////////////////////////////////////////////////////////////////////////////
//
//    /* Code to run ONCE when the driver hits INIT */
//    @Override
//    public void init() {
//        cS = hardwareMap.get(NormalizedRGBA.class, "colorSensor");
//        colorSensor = hardwareMap.get(ColorSensor.class, "colorSensor");
//        final float[] hsvValues = new float[3];
//
//        //drivetrain = new DriveTrain(hardwareMap, telemetry);
//        //mechanisms = new Mechanisms(hardwareMap, telemetry);
//
//        // Set up our telemetry dashboard
//        telemetry.update();
//
//        // Tell the driver that initialization is complete.
//        telemetry.addData("Status", "Initialized    :)");
//    }
//
////////////////////////////////////////////////////////////////////////////////////////////
//
//    /* Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY */
//    @Override
//    public void init_loop() {
//        int blue = colorSensor.blue();
//        int red = colorSensor.red();
//        int green = colorSensor.green();
//
//
//        telemetry.addData("red", red);
//        telemetry.addData("green", green);
//        telemetry.addData("blue", blue);
//
//        NormalizedRGBA colors = colorSensor.getNormalizedColors();
//
//        /* Use telemetry to display feedback on the driver station. We show the red, green, and blue
//         * normalized values from the sensor (in the range of 0 to 1), as well as the equivalent
//         * HSV (hue, saturation and value) values. See http://web.archive.org/web/20190311170843/https://infohost.nmt.edu/tcc/help/pubs/colortheory/web/hsv.html
//         * for an explanation of HSV color. */
//
//
//        // Update the hsvValues array by passing it to Color.colorToHSV()
//        Color.colorToHSV(colors.toColor(), hsvValues);
//
//        telemetry.addLine()
//                .addData("Red", "%.3f", colors.red)
//                .addData("Green", "%.3f", colors.green)
//                .addData("Blue", "%.3f", colors.blue);
//        telemetry.addLine()
//                .addData("Hue", "%.3f", hsvValues[0])
//                .addData("Saturation", "%.3f", hsvValues[1])
//                .addData("Value", "%.3f", hsvValues[2]);
//        telemetry.addData("Alpha", "%.3f", colors.alpha);
//
//
//
//        telemetry.update();
//    }
//
////////////////////////////////////////////////////////////////////////////////////////////
//
//    /* Code to run ONCE when the driver hits PLAY */
//    @Override
//    public void start() {
//        runtime.reset();
//        updateTelemetry(telemetry);
//    }
//
////////////////////////////////////////////////////////////////////////////////////////////
//
//    /* Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP */
//    @Override
//    public void loop() {
//        checkDriverController();
//        checkOperatorController();
//
//        // Call Telemetry
//        telemetry.update();
//    }
//
////////////////////////////////////////////////////////////////////////////////////////////
//
//    /* Code to run ONCE after the driver hits STOP */
//    @Override
//    public void stop() {
//        telemetry.addData("Robot Stopped. ", "Have a nice day.");
//        telemetry.addData("Final runtime: ", runtime.toString());
//        telemetry.update();
//    }
//
////////////////////////////////////////////////////////////////////////////////////////////
//// TODO: Write human controls in this section ONLY. See notes below
//
//    public void checkDriverController() {
//        // TODO: Fill out this section with how you want the controller to respond to human actions
//        // Use Assignment 3 as a reference
//        // Ask questions as needed!!!
//        // These sections will largely be custom to YOUR team, so there aren't easy examples
//
//    }
//
//    public void checkOperatorController() {
//        // TODO: Fill out this section if you need a SECOND controller
//    }
//}
//
