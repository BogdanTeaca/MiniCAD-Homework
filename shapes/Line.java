package shapes;
import utils.Point;
import visitor.DrawVisitor;
import visitor.Visitable;

/**
 * Clasa pentru figura geometrica de tip linie ce mosteneste clasa abstracta Shape.
 * Implementeaza metoda accept() pentru Visitor Design Pattern.
 *
 * @author TEACA BOGDAN
 */
public class Line extends Shape implements Visitable {
    private Point pointStart;
    private Point pointEnd;
    private int color;

    /**
     * Constructor ce initializeaza capetele si culoarea liniei.
     */
    public Line(final Point pointStart, final Point pointEnd, final int color) {
        this.pointStart = pointStart;
        this.pointEnd = pointEnd;
        this.color = color;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(final DrawVisitor v) {
        v.visit(this);
    }

    /**
     * Getter pentru capatul de start al liniei.
     */
    public Point getPointStart() {
        return pointStart;
    }

    /**
     * Getter pentru capatul de final al liniei.
     */
    public Point getPointEnd() {
        return pointEnd;
    }

    /**
     * Getter pentru culoarea liniei.
     */
    public int getColor() {
        return color;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Point getGravityCenter() {
        int xMidPoint = (pointStart.getX() + pointEnd.getX()) / 2;
        int yMidPoint = (pointStart.getY() + pointEnd.getY()) / 2;

        return new Point(xMidPoint, yMidPoint);
    }

    /**
     * Deoarece linia nu are interior ce trebuie umplut, suprascriem metoda de umplere cu nimic.
     */
    @Override
    public void fillShape() { }
}
