package shapes;
import utils.Point;
import visitor.DrawVisitor;
import visitor.Visitable;

/**
 * Clasa pentru figura geometrica de tip dreptunghi ce mosteneste clasa abstracta Shape.
 * Implementeaza metoda accept() pentru Visitor Design Pattern.
 *
 * @author TEACA BOGDAN
 */
public class Rectangle extends Shape implements Visitable {
    protected Point pointUpLeft;
    protected Point pointUpRight;
    protected Point pointDownLeft;
    protected Point pointDownRight;

    private int height;
    private int width;

    /**
     * Constructor ce initializeaza varfurile dreptunghiului si dimensiunile acestuia.
     */
    public Rectangle(final Point pointUpLeft, final int height, final int width,
                     final int colorMargin, final int colorInterior) {
        super(colorMargin, colorInterior);

        int xUpLeft = pointUpLeft.getX();
        int yUpLeft = pointUpLeft.getY();

        this.pointUpLeft = pointUpLeft;
        this.pointUpRight = new Point(xUpLeft + width - 1, yUpLeft);
        this.pointDownLeft = new Point(xUpLeft, yUpLeft + height - 1);
        this.pointDownRight = new Point(xUpLeft + width - 1, yUpLeft + height - 1);

        this.height = height;
        this.width = width;
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
        return new Point(pointUpLeft.getX() + width / 2, pointUpLeft.getY() + height / 2);
    }

    /**
     * Getter pentru varful din stanga-sus al dreptunghiului.
     */
    public Point getPointUpLeft() {
        return pointUpLeft;
    }

    /**
     * Getter pentru varful din dreapta-sus al dreptunghiului.
     */
    public Point getPointUpRight() {
        return pointUpRight;
    }

    /**
     * Getter pentru varful din stanga-jos al dreptunghiului.
     */
    public Point getPointDownLeft() {
        return pointDownLeft;
    }

    /**
     * Getter pentru varful din dreapta-jos al dreptunghiului.
     */
    public Point getPointDownRight() {
        return pointDownRight;
    }
}
