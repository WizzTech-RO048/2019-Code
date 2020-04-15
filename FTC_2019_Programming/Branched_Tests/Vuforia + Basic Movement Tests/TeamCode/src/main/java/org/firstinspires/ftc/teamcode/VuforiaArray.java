package org.firstinspires.ftc.teamcode;


class VuforiaArray {
    private float x, y, z, roll, pitch, heading;

    VuforiaArray(float x, float y, float z, float roll, float pitch, float heading) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.roll = roll;
        this.pitch = pitch;
        this.heading = heading;
    }

    float getHeading() {
        return heading;
    }

    float getPitch() {
        return pitch;
    }

    float getRoll() {
        return roll;
    }

    float getY() {
        return y;
    }

    float getZ() {
        return z;
    }

    float getX() {
        return x;
    }
}
