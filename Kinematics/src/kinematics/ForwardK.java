package kinematics;

import static java.lang.Math.*;


/**
 *
 *            +Z  -Y
 *             |  /
 *             | /
 *             |/
 *    -X ------/------- +X
 *            /|
 *           / |
 *          /  |
 *        +Y  -Z
 *
 * Orientacion
 *
 * Q[0]   -> base
 * Q[1]   -> antebrazo
 * Q[2]   -> brazo
 *
 */

public class ForwardK {
    private double Q[];
    private double L[];

    /**
     * Constructor de cinematica directa
     * Recibe las dimensiones del brazo
     * @param l
     */
    public ForwardK(double[] l) {
        L = l;
    }

    /**
     * Recibe de entrada un vector q de 3 posiciones con angulos en radianes
     * lo convierte valores x,y,z usando formulas de cinematica directa
     *
     * @param q
     * @return
     */
    public double[] getCartesian(double[] q,boolean isRadian) {
        Q = q;

        if (q.length < 3) return null;

        if(!isRadian){
            Q[0] = Math.toRadians(Q[0]);
            Q[1] = Math.toRadians(Q[1]);
            Q[2] = Math.toRadians(Q[2]);
        }

        double x = ( L[2] * cos(Q[1] + Q[2]) + L[1] * cos(Q[1]) ) * sin(Q[0]);//ok

        double y = ( L[2] * cos(Q[1] + Q[2]) + L[1] * cos(Q[1]) ) * cos(Q[0]);//ok

        double z =   L[2] * sin(Q[1] + Q[2]) + L[1] * sin(Q[1])  + L[0];//ok

        double cartesian[] = new double[3];
        cartesian[0] = x;
        cartesian[1] = y;
        cartesian[2] = z;

        return cartesian;
    }
}