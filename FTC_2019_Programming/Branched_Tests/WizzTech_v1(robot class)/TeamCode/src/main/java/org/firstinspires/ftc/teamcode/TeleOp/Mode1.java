package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.Robot;

@TeleOp(name = "Tele Op V1", group = "Official")
public class Mode1 extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

        boolean frana = false;

        Robot.getInstance().init(hardwareMap);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            if (gamepad1.x || gamepad1.dpad_left) {
                Robot.getInstance().getLeftMotorUp().getMotor().setPower(-0.1);
                Robot.getInstance().getRightMotorUp().getMotor().setPower(0.1);
                Robot.getInstance().getLeftMotorDown().getMotor().setPower(0.1);
                Robot.getInstance().getRightMotorDown().getMotor().setPower(-0.1);
                frana = true;
            } else {
                frana = false;
            }

            if (!frana) {
                if (gamepad1.left_bumper && gamepad1.right_bumper) {
                    Robot.getInstance().getLeftMotorUp().getMotor().setPower(Range.clip(-gamepad1.left_stick_x + gamepad1.left_stick_y - gamepad1.right_stick_x, -1, 1) / 6);
                    Robot.getInstance().getRightMotorUp().getMotor().setPower(Range.clip(-gamepad1.left_stick_x - gamepad1.left_stick_y - gamepad1.right_stick_x, -1, 1) / 6);
                    Robot.getInstance().getLeftMotorDown().getMotor().setPower(Range.clip(gamepad1.left_stick_x + gamepad1.left_stick_y - gamepad1.right_stick_x, -1, 1) / 6);
                    Robot.getInstance().getRightMotorDown().getMotor().setPower(Range.clip(gamepad1.left_stick_x - gamepad1.left_stick_y - gamepad1.right_stick_x, -1, 1) / 6);
                } else if (gamepad1.left_bumper) {
                    Robot.getInstance().getLeftMotorUp().getMotor().setPower(Range.clip(-gamepad1.left_stick_x + gamepad1.left_stick_y - gamepad1.right_stick_x, -1, 1) / 4);
                    Robot.getInstance().getRightMotorUp().getMotor().setPower(Range.clip(-gamepad1.left_stick_x - gamepad1.left_stick_y - gamepad1.right_stick_x, -1, 1) / 4);
                    Robot.getInstance().getLeftMotorDown().getMotor().setPower(Range.clip(gamepad1.left_stick_x + gamepad1.left_stick_y - gamepad1.right_stick_x, -1, 1) / 4);
                    Robot.getInstance().getRightMotorDown().getMotor().setPower(Range.clip(gamepad1.left_stick_x - gamepad1.left_stick_y - gamepad1.right_stick_x, -1, 1) / 4);
                } else if (gamepad1.right_bumper) {
                    Robot.getInstance().getLeftMotorUp().getMotor().setPower(Range.clip(-gamepad1.left_stick_x + gamepad1.left_stick_y - gamepad1.right_stick_x, -1, 1));
                    Robot.getInstance().getRightMotorUp().getMotor().setPower(Range.clip(-gamepad1.left_stick_x - gamepad1.left_stick_y - gamepad1.right_stick_x, -1, 1));
                    Robot.getInstance().getLeftMotorDown().getMotor().setPower(Range.clip(gamepad1.left_stick_x + gamepad1.left_stick_y - gamepad1.right_stick_x, -1, 1));
                    Robot.getInstance().getRightMotorDown().getMotor().setPower(Range.clip(gamepad1.left_stick_x - gamepad1.left_stick_y - gamepad1.right_stick_x, -1, 1));
                } else {
                    Robot.getInstance().getLeftMotorUp().getMotor().setPower(Range.clip(-gamepad1.left_stick_x + gamepad1.left_stick_y - gamepad1.right_stick_x, -1, 1) / 2);
                    Robot.getInstance().getRightMotorUp().getMotor().setPower(Range.clip(-gamepad1.left_stick_x - gamepad1.left_stick_y - gamepad1.right_stick_x, -1, 1) / 2);
                    Robot.getInstance().getLeftMotorDown().getMotor().setPower(Range.clip(gamepad1.left_stick_x + gamepad1.left_stick_y - gamepad1.right_stick_x, -1, 1) / 2);
                    Robot.getInstance().getRightMotorDown().getMotor().setPower(Range.clip(gamepad1.left_stick_x - gamepad1.left_stick_y - gamepad1.right_stick_x, -1, 1) / 2);
                }
            }
            telemetry.addData("Timp trecut", runtime.seconds());
            telemetry.update();
        }
    }
}
