package com.terraformersmc.cinderscapes.util.shapelib;

import net.minecraft.util.math.BlockPos;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

/**
 * A better quaternion class because Mojang's is not awesome
 *
 * As a note, the w value is basically irrelevant,
 * the i value represents the x value, the j value
 * represents the y value, and the k value represents
 * the z value
 *
 * @author <Wtoll> Will Toll on 2020-05-15
 * @project Cinderscapes
 */
public class Quaternion {

    public static final Quaternion NONE = new Quaternion(1, 0, 0, 0);

    private float w;
    private float i;
    private float j;
    private float k;

    public Quaternion(float w, float i, float j, float k) {
        this.w = w;
        this.i = i;
        this.j = j;
        this.k = k;
    }

    public Quaternion(net.minecraft.util.math.Quaternion q) {
        this(q.getW(), q.getX(), q.getY(), q.getZ());
    }

    public Quaternion(Quaternion q) {
        this(q.getW(), q.getI(), q.getJ(), q.getK());
    }

    public Quaternion(BlockPos pos) {
        this(0f, pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f);
    }

    // TODO: Take another look at this
    public Quaternion(float xrot, float yrot, float zrot, boolean degrees) {
        if (degrees) {
            xrot *= Math.PI / 180;
            yrot *= Math.PI / 180;
            zrot *= Math.PI / 180;
        }

        float f = (float) Math.sin((double) 0.5F * xrot);
        float g = (float) Math.cos((double) 0.5F * xrot);
        float h = (float) Math.sin((double) 0.5F * yrot);
        float a = (float) Math.cos((double) 0.5F * yrot);
        float b = (float) Math.sin((double) 0.5F * zrot);
        float c = (float) Math.cos((double) 0.5F * zrot);
        this.i = f * a * c + g * h * b;
        this.j = g * h * c - f * a * b;
        this.k = f * h * c + g * a * b;
        this.w = g * a * c - f * h * b;
    }

    public static Quaternion of(float w, float i, float j, float k) {
        return new Quaternion(w, i, j, k);
    }
    
    public static Quaternion of(net.minecraft.util.math.Quaternion q) {
        return new Quaternion(q);
    }

    public static Quaternion of(BlockPos pos) {
        return new Quaternion(pos);
    }

    public Quaternion copy() {
        return new Quaternion(this);
    }

    public BlockPos toBlockPos() {
        return new BlockPos(Math.round(this.i), Math.round(this.j), Math.round(this.k));
    }

    /**
     * Get the coefficient of the real component of the quaternion
     * @return
     */
    public float getW() {
        return this.w;
    }

    /**
     * Get the coefficient of the first imaginary term of the quaternion
     * @return
     */
    public float getI() {
        return this.i;
    }

    /**
     * Get the coefficient of the second imaginary term of the quaternion
     * @return
     */
    public float getJ() {
        return this.j;
    }

    /**
     * Get the coefficient of the third imaginary term of the quaternion
     * @return
     */
    public float getK() {
        return this.k;
    }

    /**
     * Sets the terms of the existing quaternion to the sums of itself and the addend
     * @param addend The complex quaternion value to be added to the already existing quaternion value
     */
    public Quaternion add(Quaternion addend) {
        this.w += addend.w;
        this.i += addend.i;
        this.j += addend.j;
        this.k += addend.k;
        return this;
    }

    /**
     * Add two complex quaternion values together
     * @param q1 The first quaternion addend
     * @param q2 The second quaternion addend
     * @return The addition of the two complex quaternion values
     */
    public static Quaternion add(Quaternion q1, Quaternion q2) {
        return new Quaternion(q1.w + q2.w, q1.i + q2.i, q1.j + q2.j, q1.k + q2.k);
    }

    /**
     * Sets the terms of the existing quaternion (minuend) to the difference of itself and the subtrahend
     * @param subtrahend The complex quaternion value to be subtracted from the already existing quaternion value
     */
    public Quaternion sub(Quaternion subtrahend) {
        this.w -= subtrahend.w;
        this.i -= subtrahend.i;
        this.j -= subtrahend.j;
        this.k -= subtrahend.k;
        return this;
    }

    /**
     * Subtract two complex quaternion values from one another
     * @param minuend The minuend quaternion value
     * @param subtrahend The subtrahend quaternion value
     * @return The difference of the two complex quaternion values
     */
    public static Quaternion sub(Quaternion minuend, Quaternion subtrahend) {
        return new Quaternion(minuend.w - subtrahend.w, minuend.i - subtrahend.i, minuend.j - subtrahend.j, minuend.k - subtrahend.k);
    }

    /**
     * Sets the terms of the existing quaternion (multiplicand) to the product of itself and the multiplier
     * @param multiplier The complex quaternion value by which to multiply the already existing quaternion value
     */
    public Quaternion mul(Quaternion multiplier) {
        float w = (this.w * multiplier.w) - (this.i * multiplier.i) - (this.j * multiplier.j) - (this.k * multiplier.k);
        float i = (this.w * multiplier.i) + (this.i * multiplier.w) + (this.j * multiplier.k) - (this.k * multiplier.j);
        float j = (this.w * multiplier.j) - (this.i * multiplier.k) + (this.j * multiplier.w) + (this.k * multiplier.i);
        float k = (this.w * multiplier.k) + (this.i * multiplier.j) - (this.j * multiplier.i) + (this.k * multiplier.w);
        this.w = w;
        this.i = i;
        this.j = j;
        this.k = k;
        return this;
    }

    /**
     * Multiply two complex quaternion values from one another
     * @param multiplicand The multiplicand quaternion value
     * @param multiplier The multiplier quaternion value
     * @return The product of the two complex quaternion values
     */
    public static Quaternion mul(Quaternion multiplicand, Quaternion multiplier) {
        return new Quaternion(
                (multiplicand.w * multiplier.w) - (multiplicand.i * multiplier.i) - (multiplicand.j * multiplier.j) - (multiplicand.k * multiplier.k),
                (multiplicand.w * multiplier.i) + (multiplicand.i * multiplier.w) + (multiplicand.j * multiplier.k) - (multiplicand.k * multiplier.j),
                (multiplicand.w * multiplier.j) - (multiplicand.i * multiplier.k) + (multiplicand.j * multiplier.w) + (multiplicand.k * multiplier.i),
                (multiplicand.w * multiplier.k) + (multiplicand.i * multiplier.j) - (multiplicand.j * multiplier.i) + (multiplicand.k * multiplier.w)
        );
    }

    /**
     * Sets the terms of the existing quaternion (dividend) to the quotient of itself and the divisor
     * @param divisor The complex quaternion value by which to divide the already existing quaternion value
     */
    public Quaternion div(Quaternion divisor) {
        float commonDenominator = (divisor.w * divisor.w) + (divisor.i * divisor.i) + (divisor.j * divisor.j) + (divisor.k * divisor.k);
        float w = ((divisor.w * this.w) + (divisor.i * this.i) + (divisor.j * this.j) + (divisor.k * this.k))/commonDenominator;
        float i = ((divisor.w * this.i) - (divisor.i * this.w) - (divisor.j * this.k) + (divisor.k * this.j))/commonDenominator;
        float j = ((divisor.w * this.j) + (divisor.i * this.k) - (divisor.j * this.w) - (divisor.k * this.i))/commonDenominator;
        float k = ((divisor.w * this.k) - (divisor.i * this.j) + (divisor.j * this.i) - (divisor.k * this.w))/commonDenominator;
        this.w = w;
        this.i = i;
        this.j = j;
        this.k = k;
        return this;
    }

    /**
     * Divide two complex quaternion values from one another
     * @param dividend The dividend quaternion value
     * @param divisor The divisor quaternion value
     * @return
     */
    public static Quaternion div(Quaternion dividend, Quaternion divisor) {
        float commonDenominator = (divisor.w * divisor.w) + (divisor.i * divisor.i) + (divisor.j * divisor.j) + (divisor.k * divisor.k);
        return new Quaternion(
                ((divisor.w * dividend.w) + (divisor.i * dividend.i) + (divisor.j * dividend.j) + (divisor.k * dividend.k))/commonDenominator,
                ((divisor.w * dividend.i) - (divisor.i * dividend.w) - (divisor.j * dividend.k) + (divisor.k * dividend.j))/commonDenominator,
                ((divisor.w * dividend.j) + (divisor.i * dividend.k) - (divisor.j * dividend.w) - (divisor.k * dividend.i))/commonDenominator,
                ((divisor.w * dividend.k) - (divisor.i * dividend.j) + (divisor.j * dividend.i) - (divisor.k * dividend.w))/commonDenominator
        );
    }

    /**
     * Returns the conjugate quaternion for three-dimensional rotations
     * @return The conjugate of the current quaternion value
     */
    public Quaternion conjugate() {
        return new Quaternion(this.w, -this.i, -this.j, -this.k);
    }

    /**
     * Returns the conjugate quaternion for three-dimensional rotations
     * @param q The quaternion to return the conjugate of
     * @return The conjugate of the given quaternion value
     */
    public Quaternion conjugate(Quaternion q) {
        return new Quaternion(q.w, -q.i, -q.j, -q.k);
    }

    /**
     * Answers whether or not the quaternion is a unit quaternion
     * @return true if the quaternion is a unit quaternion
     */
    public boolean isUnit() {
        return (this.w * this.w) + (this.i * this.i) + (this.j * this.j) + (this.k * this.k) == 1;
    }

    /**
     * Answers whether or not the quaternion is pure (only existing in 3 dimensions)
     * @return true if the quaternion is pure
     */
    public boolean isPure() {
        return this.w == 0;
    }

    /**
     * Rotate the already existing quaternion by the given quaternion
     * @param q The quaternion by which to rotate the already existing quaternion
     */
    public Quaternion rotateBy(Quaternion q) {
        Quaternion base = q.copy();
        Quaternion conjugate = base.conjugate();
        base.mul(this);
        base.mul(conjugate);
        set(base);
        return this;
    }

    public Quaternion rotateBy(Quaternion ...q) {
        return rotateBy(Arrays.asList(q));
    }

    public Quaternion rotateBy(List<Quaternion> q) {
        q.forEach(this::rotateBy);
        return this;
    }

    /**
     * Set the quaternion equal to the given quaternion
     * @param q The quaternion to copy the fields from
     */
    private void set(Quaternion q) {
        this.w = q.w;
        this.i = q.i;
        this.j = q.j;
        this.k = q.k;
    }

    public String toString() {
        return String.format("Quaternion{w=%f, i=%f, j=%f, k=%f}", this.w, this.i, this.j, this.k);
    }
}
