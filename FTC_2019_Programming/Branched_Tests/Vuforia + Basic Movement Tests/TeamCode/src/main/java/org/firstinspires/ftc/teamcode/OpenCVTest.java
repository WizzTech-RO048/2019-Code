package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.opencv.core.Mat;

@Autonomous(name = "OpenCVTest", group = "Testing")
public class OpenCVTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        Initialisation init = new Initialisation(hardwareMap);  //Initializarea
        init.initVuforia();    //Initializare la vuforia
        init.init();       //Initializare robot --- momentan gol

        telemetry.addData(">", "Press Play to start");
        telemetry.update();

        waitForStart();

        init.activate();    //Activeaza Vuforia Navigation---aici incepe vuforia sa primeasca date de la camera

        while (opModeIsActive()) {
            float x = 0, y = 0, z = 0, roll = 0, pitch = 0, heading = 0;
            VuforiaArray vArray = init.locationVuforia();       //Array ce contine locatia
            telemetry.addData(">", "x %f,y %f,z %f,r %f,p %f,h %f", vArray.getX(), vArray.getY(), vArray.getZ(), vArray.getRoll(), vArray.getPitch(), vArray.getHeading());
            telemetry.update();

            Mat mat = new Mat();
            //mat.eye(20,);
        }
    }
}
