package org.firstinspires.ftc.crane;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake {
    /**
     * The intaking motor is 1 bag motor, with a ? : 1 reduction VP and a ? : 1 gear train reduction
     * The deploying motors are 2 bosch seat motors, electrically tied together and run off a single motor controller
     * This deploying motors really should have encoder control and/or limit switches at the outer bounds
     */
    private CRServo deploymentMotor, intakeMotor;
    private TouchSensor upLimitSwitch, downLimitSwitch;
    Telemetry telemetry;
    Constants constants;
    private intakePositionStates currentPosition;
    private intakeStates currentState;
    Utilities utilities;

    public enum intakeStates{
        INTAKING, // collecting balls from ground
        OUTTAKING, // spitting balls out OR feeding in when arm is up
        OFF;
    }
    public enum intakePositionStates{
        UP,
        DOWN,
        OFF; // initial status for when robot is turned on
    }

    public Intake(HardwareMap hardwareMap, Telemetry telemetry) {
        deploymentMotor = hardwareMap.get(CRServo.class, "deploymentMotor");
        intakeMotor = hardwareMap.get(CRServo.class, "intakeMotor");
        upLimitSwitch = hardwareMap.get(TouchSensor.class, "intakeUpSwitch");
        downLimitSwitch = hardwareMap.get(TouchSensor.class, "intakeDownSwitch");
        this.telemetry = telemetry;
        constants = new Constants();
        currentPosition = intakePositionStates.OFF;
        currentState = intakeStates.OFF;
        // TODO: brake mode
    }

    public void setIntakePositionState(intakePositionStates newState){
        currentPosition = newState;
        switch (currentPosition) {
            case OFF:
                setIntakeArmPower(0);
                break;
            case UP:
                retractIntake();
                break;
            case DOWN:
                deployIntake();
                break;
        }
    }

    public void setIntakeState(intakeStates newState){
        currentState = newState;
        switch (currentState) {
            case OFF:
                stopIntaking();
                break;
            case INTAKING:
                intake();
                break;
            case OUTTAKING:
                outtake();
                break;
        }
    }

    public void deployIntake(){
        if(!downLimitSwitch.isPressed()) {
            setIntakeArmPower(constants.LOWER);
        } else {
            setIntakeArmPower(0); // do not run arm when all the way down
        }
    }

    public void retractIntake(){
        if(!upLimitSwitch.isPressed()) {
            setIntakeArmPower(constants.RAISE);
        } else {
            setIntakeArmPower(0);
        }
    }

    public void intake(){
        setIntakingMotorPower(constants.INTAKE);
    }
    public void outtake(){
        setIntakingMotorPower(constants.OUTTAKE);
    }
    public void stopIntaking(){
        setIntakingMotorPower(0);
    }

    private void setIntakingMotorPower(double power){
        power = utilities.mapVictorSPX(power);
        intakeMotor.setPower(power);
    }

    public intakePositionStates getIntakePositionState(){
        return currentPosition;
    }
    public intakeStates getIntakeState(){
        return currentState;
    }
    public void printCurrentStatus(){
        telemetry.addData("Current Position State", getIntakePositionState())
                .addData("Top Limit Switch State", upLimitSwitch.isPressed())
                .addData("Bottom Limit Switch State", downLimitSwitch.isPressed())
                .addData("Current Intaking State", getIntakeState());
    }

    public void setIntakeArmPower(double power) {
        setDeploymentMotorPower(power);
    }

    private void setDeploymentMotorPower(double power){
        power = utilities.mapVictorSPX(power);
        deploymentMotor.setPower(power);
    }

    public void manualDeployment(double power){
        if(upLimitSwitch.isPressed() && power > 0.0){
            power = 0;
        } else if(downLimitSwitch.isPressed() && power < 0.0) {
            power = 0;
        }
        setDeploymentMotorPower(power);
    }
}
