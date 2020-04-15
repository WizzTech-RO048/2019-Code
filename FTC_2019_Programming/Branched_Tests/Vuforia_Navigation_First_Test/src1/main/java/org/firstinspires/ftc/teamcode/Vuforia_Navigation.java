package org.firstinspires.ftc.teamcode;

/**
 * This 2018-2019 OpMode illustrates the basics of using the Vuforia localizer to determine
 * positioning and orientation of robot on the FTC field.
 * The code is structured as a LinearOpMode
 * <p>
 * Vuforia uses the phone's camera to inspect it's surroundings, and attempt to locate target images.
 * <p>
 * When images are located, Vuforia is able to determine the position and orientation of the
 * image relative to the camera.  This sample code than combines that information with a
 * knowledge of where the target images are on the field, to determine the location of the camera.
 * <p>
 * This example assumes a "square" field configuration where the red and blue alliance stations
 * are on opposite walls of each other.
 * <p>
 * From the Audience perspective, the Red Alliance station is on the right and the
 * Blue Alliance Station is on the left.
 * <p>
 * The four vision targets are located in the center of each of the perimeter walls with
 * the images facing inwards towards the robots:
 * - BlueRover is the Mars Rover image target on the wall closest to the blue alliance
 * - RedFootprint is the Lunar Footprint target on the wall closest to the red alliance
 * - FrontCraters is the Lunar Craters image target on the wall closest to the audience
 * - BackSpace is the Deep Space image target on the wall farthest from the audience
 * <p>
 * A final calculation then uses the location of the camera on the robot to determine the
 * robot's location and orientation on the field.
 *
 * @see VuforiaLocalizer
 * @see VuforiaTrackableDefaultListener
 * see  ftc_app/doc/tutorial/FTC_FieldCoordinateSystemDefinition.pdf
 * <p>
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list.
 * <p>
 * IMPORTANT: In order to use this OpMode, you need to obtain your own Vuforia license key as
 * is explained below.
 */

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

import java.util.ArrayList;
import java.util.List;

import static org.firstinspires.ftc.robotcore.external.navigation.AngleUnit.DEGREES;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesOrder.XYZ;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesOrder.YZX;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesReference.EXTRINSIC;
import static org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection.FRONT;

@TeleOp(name = "Adapted Concept: Vuforia Rover Nav", group = "Testing")
public class Vuforia_Navigation extends LinearOpMode {

    Initialisation init = new Initialisation(hardwareMap);  //Initializarea

    @Override
    public void runOpMode() {
        init.initVuforia();    //Initializare la vuforia
        init.init();       //Initializare robot --- momentan gol

        telemetry.addData(">", "Press Play to start");
        telemetry.update();

        waitForStart();

        init.activate();    //Activeaza Vuforia

        while (opModeIsActive()) {
            float x=0,y=0,z=0,roll = 0,pitch=0,heading=0;
            init.locationVuforia(x,y,z,roll,pitch,heading);
            telemetry.addData(">","x %f,y %f,z %f,r %f,p %f,h %f",x,y,z,roll,pitch,heading);
            telemetry.update();
        }
    }

}
