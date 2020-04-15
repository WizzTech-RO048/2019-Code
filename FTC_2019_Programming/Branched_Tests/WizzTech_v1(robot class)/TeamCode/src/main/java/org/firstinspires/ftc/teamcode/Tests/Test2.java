package org.firstinspires.ftc.teamcode.Tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.opencv.android.OpenCVLoader;
import org.opencv.core.Mat;


@Autonomous(name = "Test 2 - OpenCV", group = "tests")
public class Test2 extends LinearOpMode {

    static {
        try {
            System.loadLibrary("opencv_java3");
        } catch (UnsatisfiedLinkError e) {
            OpenCVLoader.loadOpenCV();
            // pass
        }
    }

    @Override
    public void runOpMode() throws InterruptedException {
        Mat mat = new Mat();
        sleep(10000);
    }
}
