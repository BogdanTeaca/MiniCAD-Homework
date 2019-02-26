package shapes;
import utils.Point;

/**
 * Clasa pentru figura geometrica de tip patrat ce mosteneste clasa Rectangle.
 * Implementeaza metoda accept() pentru Visitor Design Pattern.
 *
 * @author TEACA BOGDAN
 */
public class Square extends Rectangle {
    /**
     * Deoarece patratul este un caz particular de dreptunghi cu toate laturile egale atunci pur
     * si simplu in constructorul patratului apelam constructorul dreptunghiului cu width = height
     * pentru a evita scrierea de cod aproape identic cu cel al dreptunghiului.
     */
    public Square(final Point pointUpLeft, final int width,
                  final int colorMargin, final int colorInterior) {
        super(pointUpLeft, width, width, colorMargin, colorInterior);
    }
}
