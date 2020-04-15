package org.firstinspires.ftc.teamcode.OpenCV;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;


/**
 * This class implements replacing the current view of the FTC application with a modified one.
 * It uses the context of the App Activity and a view we send as a parameter.
* */

public class CameraViewDisplay implements ViewDisplay {
    private static CameraViewDisplay instance;

    private View view;

    private CameraViewDisplay() {
    }

    public static CameraViewDisplay getInstance() {
        if (instance == null)
            instance = new CameraViewDisplay();
        return instance;
    }

    public void setCurrentView(Context context, View newView) {
        // ResourceID represents the id of the resource used from the FTC application (this way this can exist outside of the Teamcode sandbox
        final int resourceID = context.getResources().getIdentifier("RelativeLayout", "id", context.getPackageName());
        final Activity activity = (Activity) context;       //Get the parameter activity context
        final View queuedView = newView;
        activity.runOnUiThread(new Runnable() {         //Run on the Activity UI Thread
            @Override
            public void run() {
                ViewGroup cameraView = (ViewGroup) activity.findViewById(resourceID); //R.id.RelativeLayout) aka current view
                if (view != null) {
                    cameraView.removeView(view);        //Delete current view
                }
                cameraView.addView(queuedView);     //Add the modified view to the screen
                view = queuedView;                  //Update current view
            }
        });
    }

    public void removeCurrentView(Context context) {
        final int resourceID = context.getResources().getIdentifier("RelativeLayout", "id", context.getPackageName());
        final Activity activity = (Activity) context;
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //cameraMonitorViewId
                ViewGroup cameraView = (ViewGroup) activity.findViewById(resourceID); // .id.RelativeLayout);
                if (view != null) {
                    cameraView.removeView(view);
                }
                view = null;
            }
        });
    }
}