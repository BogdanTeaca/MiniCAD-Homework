package utils;
import shapes.Canvas;

/**
 * Clasa ce stocheaza coordonatele unui punct si ce contine metode specifice punctului.
 *
 * @author TEACA BOGDAN
 */
public class Point {
    private int x;
    private int y;

    /**
     * Constructor pentru un punct de coordonate X si Y.
     *
     * @param x = Coordonata X a punctului
     * @param y = Coordonata Y a punctului
     */
    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return = Coordonata X a punctului
     */
    public int getX() {
        return x;
    }

    /**
     * @return = Coordonata Y a punctului
     */
    public int getY() {
        return y;
    }

    /**
     * Metoda ce verifica daca punctul se afla in interiorul Canvas-ului sau in exteriorul lui si
     * returneaza locatia relativa a punctului fata de Canvas. Metoda este folosita pentru
     * algoritmul de Flood-Fill: daca centrul de greutate a figurii este in exteriorul Canvas-ului
     * atunci trebuie cunoscuta locatia relativa a punctului fata de Canvas astfel incat
     * algoritmul sa se deplaseze inspre Canvas in caz ca exista puncte din figura ce trebuie
     * colorate.
     *
     * @return Locatia relativa a punctului fata de Canvas
     */
    public RelativePointPosition getRelativePointPosition() {
        if (x < 0) {
            return RelativePointPosition.LEFT_OF_CANVAS;
        } else if (x >= Canvas.getWidth()) {
            return RelativePointPosition.RIGHT_OF_CANVAS;
        } else if (y < 0) {
            return RelativePointPosition.ABOVE_CANVAS;
        } else if (y >= Canvas.getHeight()) {
            return RelativePointPosition.BELOW_CANVAS;
        } else {
            return RelativePointPosition.INSIDE_CANVAS;
        }
    }

    /**
     * Metoda statica ce coloreaza un punct in imagine la locatia (x,y) dupa ce face verificarea
     * daca punctul se afla in interiorul Canvas-ului.
     */
    public static void drawPoint(final int x, final int y, final int color) {
        if (x >= 0 && y >= 0 && x < Canvas.getWidth() && y < Canvas.getHeight()) {
            Canvas.getImage().setRGB(x, y, color);
        }
    }
}
