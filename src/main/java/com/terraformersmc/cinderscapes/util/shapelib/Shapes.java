package com.terraformersmc.cinderscapes.util.shapelib;

import net.minecraft.util.math.BlockPos;
import java.lang.Math;
import java.util.List;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

// TODO: Write a proper shapes library
public class Shapes {

    public static Shape line(float x1, float y1, float z1, float x2, float y2, float z2) {
        Shape shape = new Shape();
        float dx = x2 - x1;
        float dy = y2 - y1;
        float dz = z2 - z1;
        float dt = MathHelper.max(Math.abs(dx), Math.abs(dy), Math.abs(dz));
        float dxdt = (float)dx/(float)dt;
        float dydt = (float)dy/(float)dt;
        float dzdt = (float)dz/(float)dt;
        for (int t = 0; t <= dt; t++) {
            shape.add(new BlockPos(Math.round(x1 + (dxdt * t)), Math.round(y1 + (dydt * t)), Math.round(z1 + (dzdt * t)) ));
        }
        return shape;
    }

    /**
     * Returns a list of block positions drawing a line between two points
     * @param start The starting block position of the line
     * @param end   The ending block position of the line
     * @return A list of block positions drawing a line between the start and end points
     */
    public static Shape line(BlockPos start, BlockPos end) {
        return line(start.getX(), start.getY(), start.getZ(), end.getX(), end.getY(), end.getZ());
    }

    public static Shape line(BlockPos end) {
        return line(BlockPos.ORIGIN, end);
    }

    /**
     * Returns a line given a point a distance and a 3d rotation value
     * @param origin The starting point of the line
     * @param distance The distance of the line
     * @param rotation The quaternion by which to rotate the line in 3d space
     * @return A shape representing a line of the given specifications
     */
    public static Shape line(BlockPos origin, float distance, Quaternion rotation) {
        return line(origin, origin.add(Quaternion.of(new BlockPos(distance, 0, 0)).rotateBy(rotation).toBlockPos()));
    }

    public static Shape line(float distance, Quaternion rotation) {
        return line(BlockPos.ORIGIN, distance, rotation);
    }





    /// I'm happy up until this point






    public static Shape ellipseShell(float width, float height, Quaternion q) {
        Shape shape = new Shape();
        float a = width/2;
        float b = height/2;
        float r = Math.max(a, b);
        float thetaStep = 1/r;
        for (float theta = 0; theta <= 2 * Math.PI; theta+=thetaStep) {
            shape.add(new BlockPos(
                    Math.round(a * cos(theta) * ( (q.getW() * q.getW()) + (q.getI() * q.getI()) - (q.getJ() * q.getJ()) - (q.getK() * q.getK()) ) + b * sin(theta) * ((2 * q.getW() * q.getJ()) + (2 * q.getK() * q.getI()))),
                    Math.round(a * cos(theta) * ((2 * q.getI() * q.getJ()) + (2 * q.getW() * q.getK())) + b * sin(theta) * ((2 * q.getJ() * q.getK()) - (2 * q.getI() * q.getW()))),
                    Math.round(b * sin(theta) * ( (q.getW() * q.getW()) - (q.getI() * q.getI()) - (q.getJ() * q.getJ()) + (q.getK() * q.getK()) ) + a * cos(theta) * ((2 * q.getI() * q.getK()) - (2 * q.getJ() * q.getW())))
            ));
        }
        return shape;
    }

    public static Shape ellipseSolid(float width, float height, Quaternion q) {
        Shape shape = new Shape();
        float rstep = Math.max(width, height);
        for (int i = 0; i < rstep; i++) {
            shape.join(ellipseShell(MathHelper.map(Math.min(i, rstep), 0, rstep, width, 0), MathHelper.map(Math.min(i, rstep), 0, rstep, height, 0), q));
        }
        return shape;
    }











    /////////////////////
    // One Dimensional //
    /////////////////////




    /////////////////////
    // Two Dimensional //
    /////////////////////

    /**
     * Creates a hollow rectangular shell of a given width and height
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     * @return A shape representing a hollow rectangle of the given specifications
     */
    public static Shape rectShell(int width, int height) {
        Shape shape = new Shape();
        for (int x = -(width/2); x < (width/2); x++) {
            shape.add(new BlockPos(x, 0, height/2));
            shape.add(new BlockPos(x, 0, -(height/2)));
        }
        for (int z = -(width/2); z < (width/2); z++) {
            shape.add(new BlockPos(width/2, 0, z));
            shape.add(new BlockPos(-(width/2), 0, z));
        }
        return shape;
    }

    /**
     * Creates a hollow square shell of a given size
     * @param size The width and height of the square
     * @return A shape representing a hollow square of the given specifications
     */
    public static Shape squareShell(int size) {
        return rectShell(size, size);
    }

    /**
     * Creates a solid rectangle of a given width and height
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     * @return A shape representing a solid rectangle of the given specifications
     */
    public static Shape rectSolid(int width, int height) {
        Shape shape = new Shape();
        for (int x = -(width/2); x < width/2; x++) {
            for (int z = -(width/2); z < width/2; z++) {
                shape.add(new BlockPos(x, 0, z));
            }
        }
        return shape;
    }

    /**
     * Creates a solid square of a given size
     * @param size The width and height of the square
     * @return A shape representing a solid square of the given specifications
     */
    public static Shape squareSolid(int size) {
        return rectSolid(size, size);
    }

    /**
     * Creates an elliptical shell of the given width and height
     * @param width The width of the ellipse
     * @param height The height of the ellipse
     * @return A shape representing a hollow ellipse of the given dimensions
     */
    public static Shape ellipseShell(float width, float height) {
        Shape shape = new Shape();
        float r = Math.max(width/2, height/2);
        float thetaStep = 1/r;
        for (float theta = 0; theta < 2 * Math.PI; theta+=thetaStep) {
            shape.add(new BlockPos( (width/2) * Math.cos((double) theta), 0, (height/2) * Math.sin((double) theta) ));
        }
        return shape;
    }

    /**
     * Creates a circular shell of the given radius
     * @param radius The radius of the circle
     * @return A shape representing a hollow circle of the given size
     */
    public static Shape circleShell(float radius) {
        return ellipseShell(radius*2, radius*2);
    }

    /**
     * Creates a solid ellipse of the given width and height
     * @param width The width of the ellipse
     * @param height The height of the ellipse
     * @return A shape representing a solid ellipse of the given dimensions
     */
    public static Shape ellipseSolid(float width, float height) {
        Shape shape = new Shape();
        for (int x = (int) -(width/2); x < width/2; x++) {
            for (int z = (int) -(height/2); z < height/2; z++) {
                if ((((x*x)/((width/2)*(width/2)))+((z*z)/((height/2)*(height/2)))) <= 1) {
                    shape.add(new BlockPos(Math.round(x), 0, Math.round(z)));
                }
            }
        }
        return shape;
    }

    /**
     * Creates a solid circle of the given radius
     * @param radius The radius of the circle
     * @return A shape representing a solid circle of the given size
     */
    public static Shape circleSolid(float radius) {
        return ellipseSolid(radius*2, radius*2);
    }

    ///////////////////////
    // THREE DIMENSIONAL //
    ///////////////////////

    public static Shape coneSolid(float baseRadius, int height) {
        Shape shape = new Shape();
        for (int y = 0; y < height; y++) {
            float radius = baseRadius - ((baseRadius/height) * y);
            shape.addAll(Shapes.circleSolid(radius).translateUp(y));
        }
        return shape;
    }



    public static Shape coneSolidRotated(float baseRadius, int height, Quaternion q) {
        Shape shape = new Shape();

        Quaternion endPoint = new Quaternion(0, 0, height, 0);
        endPoint.rotateBy(q);

        float dt = 2 * Math.max(Math.abs(endPoint.getI()), Math.max(Math.abs(endPoint.getJ()), Math.abs(endPoint.getK())));

        float dxdt = endPoint.getI()/dt;
        float dydt = endPoint.getJ()/dt;
        float dzdt = endPoint.getK()/dt;

        for (int t = 0; t <= dt; t++) {
            float x = dxdt * t;
            float y = dydt * t;
            float z = dzdt * t;

            float radius = MathHelper.map(t, 0, dt, baseRadius, 0);

            float radiusStep = 1f/2f;
            for (float iRadius = radius; iRadius > 0; iRadius-=radiusStep) {
                float thetaStep = 1 / (float) Math.max(iRadius, 0.0000001);
                for (float theta = 0; theta < 2 * Math.PI; theta+=thetaStep) {
                    shape.add(new BlockPos(Math.round(x + iRadius * cos(theta) * ( (q.getW() * q.getW()) + (q.getI() * q.getI()) - (q.getJ() * q.getJ()) - (q.getK() * q.getK()) ) + iRadius * sin(theta) * ((2 * q.getW() * q.getJ()) + (2 * q.getK() * q.getI()))),  Math.round(y + iRadius * cos(theta) * ((2 * q.getI() * q.getJ()) + (2 * q.getW() * q.getK())) + iRadius * sin(theta) * ((2 * q.getJ() * q.getK()) - (2 * q.getI() * q.getW()))), Math.round(z + iRadius * sin(theta) * ( (q.getW() * q.getW()) - (q.getI() * q.getI()) - (q.getJ() * q.getJ()) + (q.getK() * q.getK()) ) + iRadius * cos(theta) * ((2 * q.getI() * q.getK()) - (2 * q.getJ() * q.getW())))));
                }
            }

        }

        return shape;
    }

    public static Shape ellipsoidSolidRoatated(float a, float b, float c, Quaternion q) {
        Shape shape = new Shape();

        Quaternion startPoint = new Quaternion(0, 0, -c, 0);
        Quaternion endPoint = new Quaternion(0, 0, c, 0);
        startPoint.rotateBy(q);
        endPoint.rotateBy(q);

        float dx = endPoint.getI() - startPoint.getI();
        float dy = endPoint.getJ() - startPoint.getJ();
        float dz = endPoint.getK() - startPoint.getK();

        float dt = 2 * Math.max(dx, Math.max(dy, dz));

        float dxdt = dx/dt;
        float dydt = dy/dt;
        float dzdt = dz/dt;

        for (float t = 0; t <= dt; t++) {
            float x = dxdt * t;
            float y = dydt * t;
            float z = dzdt * t;

            float centerDist = MathHelper.map(t, 0, dt, -c, c);
            float ta = (float) Math.sqrt( (a * a) - ( (a * a) * (centerDist * centerDist) ) / (c * c) );
            float tb = (float) Math.sqrt( (b * b) - ( (b * b) * (centerDist * centerDist) ) / (c * c) );

            shape.join(ellipseSolid(2*ta, 2*tb, q).translateBy(new BlockPos(x, y, z)));
        }
        return shape;
    }
}
