package shapes;
import utils.Point;
import visitor.DrawVisitor;
import visitor.Visitable;

/**
 * Clasa pentru figura geometrica de tip triunghi ce mosteneste clasa abstracta Shape.
 * Implementeaza metoda accept() pentru Visitor Design Pattern.
 *
 * @author TEACA BOGDAN
 */
public class Triangle extends Shape implements Visitable {
    private static final int NR_POINTS = 3;
    private Point point1, point2, point3;

    /**
     * Constructor ce initializeaza varfurile triunghiului.
     */
    public Triangle(final Point point1, final Point point2, final Point point3,
                    final int colorMargin, final int colorInterior) {
        super(colorMargin, colorInterior);

        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(final DrawVisitor v) {
        v.visit(this);
    }

    /**
     * Getter pentru varfurile triunghiului.
     */
    public Point[] getPoints() {
        return new Point[] {point1, point2, point3};
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Point getGravityCenter() {
        int xGravity = (point1.getX() + point2.getX() + point3.getX()) / NR_POINTS;
        int yGravity = (point1.getY() + point2.getY() + point3.getY()) / NR_POINTS;

        return new Point(xGravity, yGravity);
    }
}
