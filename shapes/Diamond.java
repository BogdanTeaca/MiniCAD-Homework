package shapes;
import utils.Point;
import visitor.DrawVisitor;
import visitor.Visitable;

/**
 * Clasa pentru figura geometrica de tip romb ce mosteneste clasa abstracta Shape.
 * Implementeaza metoda accept() pentru Visitor Design Pattern.
 *
 * @author TEACA BOGDAN
 */
public class Diamond extends Shape implements Visitable {
    private Point pointUp;
    private Point pointDown;
    private Point pointLeft;
    private Point pointRight;
    private Point pointCenter;

    /**
     * Constructor ce initializeaza varfurile rombului.
     */
    public Diamond(final Point pointCenter, final int diagH, final int diagV,
                   final int colorMargin, final int colorInterior) {
        super(colorMargin, colorInterior);

        this.pointUp = new Point(pointCenter.getX(), pointCenter.getY() - diagV / 2);
        this.pointDown = new Point(pointCenter.getX(), pointCenter.getY() + diagV / 2);
        this.pointLeft = new Point(pointCenter.getX() - diagH / 2, pointCenter.getY());
        this.pointRight = new Point(pointCenter.getX() + diagH / 2, pointCenter.getY());
        this.pointCenter = pointCenter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(final DrawVisitor v) {
        v.visit(this);
    }

    /**
     * @return = Punctul de sus al rombului
     */
    public Point getPointUp() {
        return pointUp;
    }

    /**
     * @return = Punctul de jos al rombului
     */
    public Point getPointDown() {
        return pointDown;
    }

    /**
     * @return = Punctul din stanga al rombului
     */
    public Point getPointLeft() {
        return pointLeft;
    }

    /**
     * @return = Punctul din dreapta al rombului
     */
    public Point getPointRight() {
        return pointRight;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Point getGravityCenter() {
        return pointCenter;
    }
}
