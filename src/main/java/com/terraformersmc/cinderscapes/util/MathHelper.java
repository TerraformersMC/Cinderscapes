package com.terraformersmc.cinderscapes.util;

public class MathHelper {
    public static float map(float val, float instart, float inend, float outstart, float outend) {
        return ((val - instart) / (inend - instart)) * (outend - outstart) + outstart;
    }

    public static float max(float ...vals) {
        float max = vals[0];
        for (int i = 1; i < vals.length; i++) {
            max = Math.max(max, vals[i]);
        }
        return max;
    }
}
