package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.ArrayList;

public class Robot {

    private static Robot instance = null;
    private HardwareMap hardwareMap;
    private WizzTechDcMotor leftMotorUp, rightMotorUp, leftMotorDown, rightMotorDown, extendCollectorMotorArm;
    private ServoFromDcMotor collectorMotor;
    private CRServo collectorServo;

    private Robot() {
    }

    public static Robot getInstance() {
        if (instance == null) instance = new Robot();
        return instance;
    }

    public static void disable() {
        instance = null;
    }

    public void init(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;
        System.out.println("Initializare");
        //Init of the chassis motor
        leftMotorUp = new WizzTechDcMotor("m1", hardwareMap.dcMotor.get("m1"));
        rightMotorUp = new WizzTechDcMotor("m2", hardwareMap.dcMotor.get("m2"));
        leftMotorDown = new WizzTechDcMotor("m3", hardwareMap.dcMotor.get("m3"));
        rightMotorDown = new WizzTechDcMotor("m4", hardwareMap.dcMotor.get("m4"));

//        init of the ArmCollector
//        extendCollectorMotorArm = hardwareMap.dcMotor.get("m5");
//        collectorMotor = new ServoFromDcMotor("m6", hardwareMap.dcMotor.get("m6")) {
//            @Override
//            public ArrayList<Integer> setPositions() {
//                ArrayList<Integer> pos = new ArrayList<>();
//                pos.add(50);
//                pos.add(40);
//                return pos;
//            }
//        };
        collectorServo = hardwareMap.crservo.get("cs1");
    }

    public void initVuforia() {
        // TODO: 12/1/2018 vuforia init
    }

    public WizzTechDcMotor getLeftMotorUp() {
        return leftMotorUp;
    }
    public WizzTechDcMotor getRightMotorUp() {
        return rightMotorUp;
    }
    public WizzTechDcMotor getLeftMotorDown() {
        return leftMotorDown;
    }
    public WizzTechDcMotor getRightMotorDown() {
        return rightMotorDown;
    }
    public WizzTechDcMotor getExtendCollectorMotorArm() {
        return extendCollectorMotorArm;
    }
    public WizzTechDcMotor getCollectorMotor() {
        return collectorMotor;
    }
    public CRServo getCollectorServo() {
        return collectorServo;
    }
}
