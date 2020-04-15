package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "BasicTeleopTest", group = "Testing")
public class BasicTeleOpTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        int i;
        Initialisation init = new Initialisation(hardwareMap);
        init.init();
        waitForStart();
        while (opModeIsActive()) {
            i = (int)getRuntime();
            telemetry.addData("Timp activ", "%d", i);
            telemetry.update();
            init.MotorDreapta.setPower(0.5f);
            init.MotorStanga.setPower(-0.2f);
            init.Servo1.setPosition(0.2f);

        }
    }
}