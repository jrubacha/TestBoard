package org.firstinspires.ftc.crane;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Agitator {
    /**
     * The agitator uses 2 bag motors, each on a ? : 1 reduction versaplanetary
     * These motors are electrically tied together and run on a single motor controller
     */
    private CRServo agitatorMotors;
    Constants constants;
    Telemetry telemetry;
    Utilities utilities;

    public Agitator(HardwareMap hardwareMap, Telemetry telemetry){
        agitatorMotors = hardwareMap.get(CRServo.class, "agitatorMotors");
        this.telemetry = telemetry;
    }

    private void setAgitatorMotorPower(double power){
        power = utilities.mapVictorSPX(power);
        agitatorMotors.setPower(power);
    }
    public void agitatorIn(){
        agitatorMotors.setPower(constants.AGITATOR_IN);
    }
    public void agitatorOut(){
        agitatorMotors.setPower(constants.AGITATOR_OUT);
    }
}
