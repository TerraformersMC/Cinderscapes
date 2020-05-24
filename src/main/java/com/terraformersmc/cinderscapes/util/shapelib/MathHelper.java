package com.terraformersmc.cinderscapes.util.shapelib;

// TODO: Check
public class MathHelper {
    public static float map(float val, float instart, float inend, float outstart, float outend) {
        return outstart + ((inend-val)/(float)(inend-instart))*(outend - outstart);
    }
}
