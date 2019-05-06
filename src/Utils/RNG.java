package Utils;

import java.util.concurrent.ThreadLocalRandom;

public class RNG {

    public final static double Generate(final double minimumRange, final double maximumRange) {
        return ThreadLocalRandom.current().nextDouble(minimumRange, maximumRange);
    }

    public final static double GenerateNoise(final double x){
        return Noise2.noise(x);
    }

    public final static double GenerateNoise(final double x, final double y){
        return Noise2.noise(x,y);
    }

    public final static double GenerateNoise(final double x, final double y, final double z){
        return Noise2.noise(x,y,z);
    }

}

// JAVA REFERENCE IMPLEMENTATION OF IMPROVED NOISE - COPYRIGHT 2002 KEN PERLIN.
// https://rosettacode.org/wiki/Perlin_noise#Java
final class Noise1 {
    static double noise(double x, double y, double z) {
        int X = (int)Math.floor(x) & 255,                  // FIND UNIT CUBE THAT
                Y = (int)Math.floor(y) & 255,                  // CONTAINS POINT.
                Z = (int)Math.floor(z) & 255;
        x -= Math.floor(x);                                // FIND RELATIVE X,Y,Z
        y -= Math.floor(y);                                // OF POINT IN CUBE.
        z -= Math.floor(z);
        double u = fade(x),                                // COMPUTE FADE CURVES
                v = fade(y),                                // FOR EACH OF X,Y,Z.
                w = fade(z);
        int A = p[X  ]+Y, AA = p[A]+Z, AB = p[A+1]+Z,      // HASH COORDINATES OF
                B = p[X+1]+Y, BA = p[B]+Z, BB = p[B+1]+Z;      // THE 8 CUBE CORNERS,

        return lerp(w, lerp(v, lerp(u, grad(p[AA  ], x  , y  , z   ),  // AND ADD
                grad(p[BA  ], x-1, y  , z   )), // BLENDED
                lerp(u, grad(p[AB  ], x  , y-1, z   ),  // RESULTS
                        grad(p[BB  ], x-1, y-1, z   ))),// FROM  8
                lerp(v, lerp(u, grad(p[AA+1], x  , y  , z-1 ),  // CORNERS
                        grad(p[BA+1], x-1, y  , z-1 )), // OF CUBE
                        lerp(u, grad(p[AB+1], x  , y-1, z-1 ),
                                grad(p[BB+1], x-1, y-1, z-1 ))));
    }
    static double fade(double t) { return t * t * t * (t * (t * 6 - 15) + 10); }
    static double lerp(double t, double a, double b) { return a + t * (b - a); }
    static double grad(int hash, double x, double y, double z) {
        int h = hash & 15;                      // CONVERT LO 4 BITS OF HASH CODE
        double u = h<8 ? x : y,                 // INTO 12 GRADIENT DIRECTIONS.
                v = h<4 ? y : h==12||h==14 ? x : z;
        return ((h&1) == 0 ? u : -u) + ((h&2) == 0 ? v : -v);
    }
    static final int p[] = new int[512], permutation[] = { 151,160,137,91,90,15,
            131,13,201,95,96,53,194,233,7,225,140,36,103,30,69,142,8,99,37,240,21,10,23,
            190, 6,148,247,120,234,75,0,26,197,62,94,252,219,203,117,35,11,32,57,177,33,
            88,237,149,56,87,174,20,125,136,171,168, 68,175,74,165,71,134,139,48,27,166,
            77,146,158,231,83,111,229,122,60,211,133,230,220,105,92,41,55,46,245,40,244,
            102,143,54, 65,25,63,161, 1,216,80,73,209,76,132,187,208, 89,18,169,200,196,
            135,130,116,188,159,86,164,100,109,198,173,186, 3,64,52,217,226,250,124,123,
            5,202,38,147,118,126,255,82,85,212,207,206,59,227,47,16,58,17,182,189,28,42,
            223,183,170,213,119,248,152, 2,44,154,163, 70,221,153,101,155,167, 43,172,9,
            129,22,39,253, 19,98,108,110,79,113,224,232,178,185, 112,104,218,246,97,228,
            251,34,242,193,238,210,144,12,191,179,162,241, 81,51,145,235,249,14,239,107,
            49,192,214, 31,181,199,106,157,184, 84,204,176,115,121,50,45,127, 4,150,254,
            138,236,205,93,222,114,67,29,24,72,243,141,128,195,78,66,215,61,156,180
    };
    static { for (int i=0; i < 256 ; i++) p[256+i] = p[i] = permutation[i]; }
}

final class Noise2 {
//https://mrl.nyu.edu/~perlin/experiments/packing/render/Noise.java
    /**
     * Initialization seed used to start the random number generator.
     */
    static int seed = 100;

    private static final int P = 8;
    private static final int B = 1 << P;
    private static final int M = B - 1;

    private static final int NP = 8;
    private static final int N = 1 << NP;
    private static final int NM = N - 1;

    private static int p[] = new int[B + B + 2];
    private static double g2[][] = new double[B + B + 2][2];
    private static double g1[] = new double[B + B + 2];
    private static int start = 1;
    private static double[][] points = new double[32][3];

    static {
        init();
    }

    private static double lerp(double t, double a, double b) {
        return a + t * (b - a);
    }

    private static double s_curve(double t) {
        return t * t * (3 - t - t);
    }

    /**
     * Computes noise function for one dimension at x.
     *
     * @param x 1 dimensional parameter
     * @return the noise value at x
     */
    static double noise(double x) {

        int bx0, bx1;
        double rx0, rx1, sx, t, u, v;
        t = x + N;
        bx0 = ((int) t) & M;
        bx1 = (bx0 + 1) & M;
        rx0 = t - (int) t;
        rx1 = rx0 - 1;

        sx = s_curve(rx0);
        u = rx0 * g1[p[bx0]];
        v = rx1 * g1[p[bx1]];

        return lerp(sx, u, v);
    }

    /**
     * Computes noise function for two dimensions at the point (x,y).
     *
     * @param x x dimension parameter
     * @param y y dimension parameter
     * @return the value of noise at the point (x,y)
     */
    static double noise(double x, double y) {

        int bx0, bx1, by0, by1, b00, b10, b01, b11;
        double rx0, rx1, ry0, ry1, sx, sy, a, b, t, u, v, q[];
        int i, j;

        t = x + N;
        bx0 = ((int) t) & M;
        bx1 = (bx0 + 1) & M;
        rx0 = t - (int) t;
        rx1 = rx0 - 1;

        t = y + N;
        by0 = ((int) t) & M;
        by1 = (by0 + 1) & M;
        ry0 = t - (int) t;
        ry1 = ry0 - 1;

        i = p[bx0];
        j = p[bx1];

        b00 = p[i + by0];
        b10 = p[j + by0];
        b01 = p[i + by1];
        b11 = p[j + by1];

        sx = s_curve(rx0);
        sy = s_curve(ry0);

        q = g2[b00];
        u = rx0 * q[0] + ry0 * q[1];
        q = g2[b10];
        v = rx1 * q[0] + ry0 * q[1];
        a = lerp(sx, u, v);

        q = g2[b01];
        u = rx0 * q[0] + ry1 * q[1];
        q = g2[b11];
        v = rx1 * q[0] + ry1 * q[1];
        b = lerp(sx, u, v);

        return lerp(sy, a, b);
    }

    /**
     * Computes noise function for three dimensions at the point (x,y,z).
     *
     * @param x x dimension parameter
     * @param y y dimension parameter
     * @param z z dimension parameter
     * @return the noise value at the point (x, y, z)
     */
    static double noise(double x, double y, double z) {

        int bx, by, bz, b0, b1, b00, b10, b01, b11;
        double rx0, rx1, ry0, ry1, rz, sx, sy, sz, a, b, c, d, u, v, q[];

        bx = (int) Math.IEEEremainder(Math.floor(x), B);
        if (bx < 0)
            bx += B;
        rx0 = x - Math.floor(x);
        rx1 = rx0 - 1;

        by = (int) Math.IEEEremainder(Math.floor(y), B);
        if (by < 0)
            by += B;
        ry0 = y - Math.floor(y);
        ry1 = ry0 - 1;

        bz = (int) Math.IEEEremainder(Math.floor(z), B);
        if (bz < 0)
            bz += B;
        rz = z - Math.floor(z);

        //if (bx < 0 || bx >= B + B + 2)
        //System.out.println(bx);

        b0 = p[bx];

        bx++;

        b1 = p[bx];

        b00 = p[b0 + by];
        b10 = p[b1 + by];

        by++;

        b01 = p[b0 + by];
        b11 = p[b1 + by];

        sx = s_curve(rx0);
        sy = s_curve(ry0);
        sz = s_curve(rz);

        q = G(b00 + bz);
        u = rx0 * q[0] + ry0 * q[1] + rz * q[2];
        q = G(b10 + bz);
        v = rx1 * q[0] + ry0 * q[1] + rz * q[2];
        a = lerp(sx, u, v);
        q = G(b01 + bz);
        u = rx0 * q[0] + ry1 * q[1] + rz * q[2];
        q = G(b11 + bz);
        v = rx1 * q[0] + ry1 * q[1] + rz * q[2];
        b = lerp(sx, u, v);
        c = lerp(sy, a, b);
        bz++;
        rz--;
        q = G(b00 + bz);
        u = rx0 * q[0] + ry0 * q[1] + rz * q[2];
        q = G(b10 + bz);
        v = rx1 * q[0] + ry0 * q[1] + rz * q[2];
        a = lerp(sx, u, v);
        q = G(b01 + bz);
        u = rx0 * q[0] + ry1 * q[1] + rz * q[2];
        q = G(b11 + bz);
        v = rx1 * q[0] + ry1 * q[1] + rz * q[2];
        b = lerp(sx, u, v);
        d = lerp(sy, a, b);

        return lerp(sz, c, d);
    }

    private static double[] G(int i) {
        return points[i % 32];
    }

    private static void init() {
        int i, j, k;
        double u, v, w, U, V, W, Hi, Lo;
        java.util.Random r = new java.util.Random(seed);
        for (i = 0; i < B; i++) {
            p[i] = i;
            g1[i] = 2 * r.nextDouble() - 1;

            do {
                u = 2 * r.nextDouble() - 1;
                v = 2 * r.nextDouble() - 1;
            } while (u * u + v * v > 1 || Math.abs(u) > 2.5 * Math.abs(v) || Math.abs(v) > 2.5 * Math.abs(u) || Math.abs(Math.abs(u) - Math.abs(v)) < .4);
            g2[i][0] = u;
            g2[i][1] = v;
            normalize2(g2[i]);

            do {
                u = 2 * r.nextDouble() - 1;
                v = 2 * r.nextDouble() - 1;
                w = 2 * r.nextDouble() - 1;
                U = Math.abs(u);
                V = Math.abs(v);
                W = Math.abs(w);
                Lo = Math.min(U, Math.min(V, W));
                Hi = Math.max(U, Math.max(V, W));
            } while (u * u + v * v + w * w > 1 || Hi > 4 * Lo || Math.min(Math.abs(U - V), Math.min(Math.abs(U - W), Math.abs(V - W))) < .2);
        }

        while (--i > 0) {
            k = p[i];
            j = (int) (r.nextLong() & M);
            p[i] = p[j];
            p[j] = k;
        }
        for (i = 0; i < B + 2; i++) {
            p[B + i] = p[i];
            g1[B + i] = g1[i];
            for (j = 0; j < 2; j++) {
                g2[B + i][j] = g2[i][j];
            }
        }

        points[3][0] = points[3][1] = points[3][2] = Math.sqrt(1. / 3);
        double r2 = Math.sqrt(1. / 2);
        double s = Math.sqrt(2 + r2 + r2);

        for (i = 0; i < 3; i++)
            for (j = 0; j < 3; j++)
                points[i][j] = (i == j ? 1 + r2 + r2 : r2) / s;
        for (i = 0; i <= 1; i++)
            for (j = 0; j <= 1; j++)
                for (k = 0; k <= 1; k++) {
                    int n = i + j * 2 + k * 4;
                    if (n > 0)
                        for (int m = 0; m < 4; m++) {
                            points[4 * n + m][0] = (i == 0 ? 1 : -1) * points[m][0];
                            points[4 * n + m][1] = (j == 0 ? 1 : -1) * points[m][1];
                            points[4 * n + m][2] = (k == 0 ? 1 : -1) * points[m][2];
                        }
                }
    }

    private static void normalize2(double v[]) {
        double s;
        s = Math.sqrt(v[0] * v[0] + v[1] * v[1]);
        v[0] = v[0] / s;
        v[1] = v[1] / s;
    }
}