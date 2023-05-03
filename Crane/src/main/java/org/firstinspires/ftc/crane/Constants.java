package org.firstinspires.ftc.crane;

public class Constants {
    // Vex 393 Limits
    public final static double VEX_393_LOWER_BOUND = -0.8;
    public final static double VEX_393_UPPER_BOUND = 0.8;

    // Victor SPX Max/Min output
    public final double VICTOR_SPX_LOWER_BOUND = -0.85;
    public final double VICTOR_SPX_UPPER_BOUND = 0.85;

    // GoBilda Linear Servo Limits
    public final double LINEAR_SERVO_LOWER_BOUND = 0.1;
    public final double LINEAR_SERVO_UPPER_BOUND = 0.9;

    // Driving Constants
    public final double TURN_SPEED = 0.75;
    public final double DRIVE_SPEED = 0.9;

    // Intake Constants
    public final double INTAKE = 0.8;
    public final double OUTTAKE = -0.8;
    public final double RAISE = 0.9;
    public final double LOWER = -0.9;

    // Elevator constants
    public final double RAISE_ELEVATOR = 0.75;
    public final double LOWER_ELEVATOR = 0.75;

    // Agitator Constants
    public final double AGITATOR_IN = 0.75;
    public final double AGITATOR_OUT = 0.75;

    // Shooter Constants
    public final double RETRACT = 0.3;
    public final double SPIT_SHOT = 0.65;
    public final double FULL_POWER_SHOT = 0.95;

    // Turret Constants
    public final int LEFT_LIMIT = 0;
    public final int RIGHT_LIMIT = 30000; // number pulled out of booty
    public final double AUTON_TURRET_SPEED = 0.8;
    public final double HUMAN_TURRET_SPEED = 0.5;
    public final static double TURRET_SCALAR = 0.375;
}
