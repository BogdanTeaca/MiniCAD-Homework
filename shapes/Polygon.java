package shapes;
import utils.Point;
import visitor.DrawVisitor;
import visitor.Visitable;

/**
 * Clasa pentru figura geometrica de tip poligon ce mosteneste clasa abstracta Shape.
 * Implementeaza metoda accept() pentru Visitor Design Pattern.
 *
 * @author TEACA BOGDAN
 */
public class Polygon extends Shape implements Visitable {
    private Point[] points;

    /**
     * Constructor ce initializeaza varfurile poligonului.
     */
    public Polygon(final Point[] points, final int colorMargin, final int colorInterior) {
        super(colorMargin, colorInterior);

        this.points = points;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(final DrawVisitor v) {
        v.visit(this);
    }

    /**
     * Getter pentru varfurile poligonului.
     */
    public Point[] getPoints() {
        return points;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Point getGravityCenter() {
        int n = points.length;

        int xGravity = 0;
        int yGravity = 0;

        for (int i = 0; i < n; i++) {
            xGravity += points[i].getX();
            yGravity += points[i].getY();
        }

        xGravity /= n;
        yGravity /= n;

        return new Point(xGravity, yGravity);
    }
}
