package shapes;
import utils.Point;
import visitor.DrawVisitor;
import visitor.Visitable;

/**
 * Clasa pentru figura geometrica de tip cerc ce mosteneste clasa abstracta Shape.
 * Implementeaza metoda accept() pentru Visitor Design Pattern.
 *
 * @author TEACA BOGDAN
 */
public class Circle extends Shape implements Visitable {
    private Point pointCenter;
    private int radius;

    /**
     * Constructor ce initializeaza centrul si raza cercului.
     */
    public Circle(final Point pointCenter, final int radius,
                  final int colorMargin, final int colorInterior) {
        super(colorMargin, colorInterior);

        this.pointCenter = pointCenter;
        this.radius = radius;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(final DrawVisitor v) {
        v.visit(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Point getGravityCenter() {
        return pointCenter;
    }

    /**
     * Getter pentru raza cercului.
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Getter pentru centrul cercului.
     */
    public Point getPointCenter() {
        return pointCenter;
    }
}
