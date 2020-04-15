package org.firstinspires.ftc.teamcode.OpenCV;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

import org.opencv.BuildConfig;
import org.opencv.android.JavaCameraView;
import org.opencv.android.Utils;
import org.opencv.core.Mat;

/**
 * Processes the frame from the camera and creates the canvas with it that will appear in the layout
 */

public class CustomCameraView extends JavaCameraView {
    private static final String TAG = "CustomCameraView";

    public CustomCameraView(Context context, int cameraId) {
        super(context, cameraId);
    }

    @Override
    protected void deliverAndDrawFrame(CvCameraViewFrame frame) {
        Mat editedFrame;
        boolean validFrame = true;
        int phoneOrientation = getContext().getResources().getConfiguration().orientation;

        if (mListener != null) {
            editedFrame = mListener.onCameraFrame(frame);
        } else {
            editedFrame = frame.rgba();
        }

        if (editedFrame != null) {
            try {
                if (mCacheBitmap.getWidth() != editedFrame.cols() || mCacheBitmap.getHeight() != editedFrame.rows()) {
                    mCacheBitmap = Bitmap.createBitmap(editedFrame.cols(), editedFrame.rows(), Bitmap.Config.ARGB_8888);        //Check the size of the edited frame
                }
                Utils.matToBitmap(editedFrame, mCacheBitmap);
            } catch (Exception e) {
                Log.e(TAG, "EditedFrame size: " + editedFrame.cols() + "*" + editedFrame.rows());
                Log.e(TAG, "Frame size: " + mCacheBitmap.getWidth() + "*" + mCacheBitmap.getHeight());
                Log.e(TAG, "Utils.matToBitmap() throws an exception: " + e.getMessage());
                validFrame = false;
            }
        }

        if (validFrame && mCacheBitmap != null) {
            Canvas canvas = getHolder().lockCanvas();
            if (canvas != null) {
                canvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);        //Draw a white background in the canvas

                //Corrects the size of the camera in the canvas
                int ratio = mCacheBitmap.getHeight() / mCacheBitmap.getWidth();
                if (mCacheBitmap.getHeight() > mCacheBitmap.getWidth()) {
                    mCacheBitmap = Bitmap.createScaledBitmap(mCacheBitmap, canvas.getHeight(), canvas.getHeight() / ratio, true);
                }
                else{
                    mCacheBitmap = Bitmap.createScaledBitmap(mCacheBitmap, canvas.getWidth()*ratio, canvas.getWidth(), true);
                }
                //End

                if (mScale != 0) {
                    //Draws the image in the canvas in a new rectangle
                    canvas.drawBitmap(mCacheBitmap, new Rect(0, 0, mCacheBitmap.getWidth(), mCacheBitmap.getHeight()),
                            new Rect((int) ((canvas.getWidth() - mScale * mCacheBitmap.getWidth()) / 2),
                                    (int) ((canvas.getHeight() - mScale * mCacheBitmap.getHeight()) / 2),
                                    (int) ((canvas.getWidth() - mScale * mCacheBitmap.getWidth()) / 2 + mScale * mCacheBitmap.getWidth()),
                                    (int) ((canvas.getHeight() - mScale * mCacheBitmap.getHeight()) / 2 + mScale * mCacheBitmap.getHeight())), null);
                } else {
                    canvas.drawBitmap(mCacheBitmap, new Rect(0, 0, mCacheBitmap.getWidth(), mCacheBitmap.getHeight()),
                            new Rect((canvas.getWidth() - mCacheBitmap.getWidth()) / 2,
                                    (canvas.getHeight() - mCacheBitmap.getHeight()) / 2,
                                    (canvas.getWidth() - mCacheBitmap.getWidth()) / 2 + mCacheBitmap.getWidth(),
                                    (canvas.getHeight() - mCacheBitmap.getHeight()) / 2 + mCacheBitmap.getHeight()), null);
                }

                // Draw FPS meter on the canvas
                if (phoneOrientation == Configuration.ORIENTATION_PORTRAIT) {
                    canvas.save();

                    canvas.rotate(-90, getWidth() / 2, getHeight() / 2);

                    if (mFpsMeter != null) {
                        mFpsMeter.measure();
                        mFpsMeter.draw(canvas, 20, 30);
                    }
                    canvas.restore();
                }
                getHolder().unlockCanvasAndPost(canvas);
            }
        }
    }
}