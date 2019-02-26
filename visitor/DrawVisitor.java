package visitor;
import shapes.Canvas;
import shapes.Circle;
import shapes.Diamond;
import shapes.Line;
import shapes.Polygon;
import shapes.Rectangle;
import shapes.Square;
import shapes.Triangle;
import utils.Point;

/**
 * Clasa ce implementeaza interfata Visitor. Clasa se ocupa cu desenarea contururilor figurilor
 * de diverse tipuri. Deoarece figurile au forme diferite, desenarea contururilor acestor forme
 * va diferi de la un tip de figura la alta.
 *
 * @author TEACA BOGDAN
 */
public class DrawVisitor implements Visitor {
    private static final int BRESENHAM_CONSTANT_3 = 3;
    private static final int BRESENHAM_CONSTANT_4 = 4;
    private static final int BRESENHAM_CONSTANT_6 = 6;
    private static final int BRESENHAM_CONSTANT_10 = 10;

    /**
     * Metoda visit pentru Visitor Design Pattern ce primeste o linie ca parametru si ii deseneaza
     * conturul folosind Algoritmul lui Bresenham de desenare a liniilor.
     */
    @Override
    public void visit(final Line line) {
        // Algoritmul lui Bresenham de desenare a liniilor

        int x = line.getPointStart().getX();
        int y = line.getPointStart().getY();

        int deltaX = Math.abs(line.getPointEnd().getX() - line.getPointStart().getX());
        int deltaY = Math.abs(line.getPointEnd().getY() - line.getPointStart().getY());

        int signX = Integer.signum(line.getPointEnd().getX() - line.getPointStart().getX());
        int signY = Integer.signum(line.getPointEnd().getY() - line.getPointStart().getY());

        Boolean interchanged = false;

        if (deltaY > deltaX) {
            int temp = deltaX;
            deltaX = deltaY;
            deltaY = temp;

            interchanged = true;
        }

        int error = 2 * deltaY - deltaX;

        for (int i = 0; i <= deltaX; i++) {
            Point.drawPoint(x, y, line.getColor());

            while (error > 0) {
                if (interchanged) {
                    x += signX;
                } else {
                    y += signY;
                }

                error -= 2 * deltaX;
            }

            if (interchanged) {
                y += signY;
            } else {
                x += signX;
            }

            error += 2 * deltaY;
        }
    }

    /**
     * Metoda visit pentru Visitor Design Pattern ce primeste un patrat ca parametru si ii
     * deseneaza conturul prin desenarea celor 4 laturi.
     */
    @Override
    public void visit(final Square square) {
        Point pointUpLeft = square.getPointUpLeft();
        Point pointUpRight = square.getPointUpRight();
        Point pointDownRight = square.getPointDownRight();
        Point pointDownLeft = square.getPointDownLeft();

        visit(new Line(pointUpLeft, pointUpRight, square.getColorMargin()));
        visit(new Line(pointUpRight, pointDownRight, square.getColorMargin()));
        visit(new Line(pointDownRight, pointDownLeft, square.getColorMargin()));
        visit(new Line(pointDownLeft, pointUpLeft, square.getColorMargin()));
    }

    /**
     * Metoda visit pentru Visitor Design Pattern ce primeste un dreptunghi ca parametru si ii
     * deseneaza conturul prin desenarea celor 4 laturi.
     */
    @Override
    public void visit(final Rectangle rectangle) {
        Point pointUpLeft = rectangle.getPointUpLeft();
        Point pointUpRight = rectangle.getPointUpRight();
        Point pointDownRight = rectangle.getPointDownRight();
        Point pointDownLeft = rectangle.getPointDownLeft();

        visit(new Line(pointUpLeft, pointUpRight, rectangle.getColorMargin()));
        visit(new Line(pointUpRight, pointDownRight, rectangle.getColorMargin()));
        visit(new Line(pointDownRight, pointDownLeft, rectangle.getColorMargin()));
        visit(new Line(pointDownLeft, pointUpLeft, rectangle.getColorMargin()));
    }

    /**
     * Metoda visit pentru Visitor Design Pattern ce primeste un cerc ca parametru si ii
     * deseneaza conturul folosind Algoritmul lui Bresenham de desenare a cercurilor.
     */
    @Override
    public void visit(final Circle circle) {
        // Algoritmul lui Bresenham de desenare a cercurilor

        int x = circle.getPointCenter().getX();
        int y = circle.getPointCenter().getY();
        int p = 0;
        int q = circle.getRadius();
        int d = BRESENHAM_CONSTANT_3 - 2 * q;

        while (p < q) {
            drawCirclePoints(x, y, p, q, circle.getColorMargin());

            p++;

            if (d < 0) {
                d += BRESENHAM_CONSTANT_4 * p + BRESENHAM_CONSTANT_6;
            } else {
                q--;
                d += BRESENHAM_CONSTANT_4 * (p - q) + BRESENHAM_CONSTANT_10;
            }
        }

        drawCirclePoints(x, y, p, q, circle.getColorMargin());
    }

    /**
     * Metoda auxiliara a Algoritmului lui Bresenham de desenare a cercurilor.
     */
    private void drawCirclePoints(final int x, final int y, final int p, final int q,
                                  final int color) {
        Point.drawPoint(x + p, y + q, color);
        Point.drawPoint(x - p, y + q, color);
        Point.drawPoint(x + p, y - q, color);
        Point.drawPoint(x - p, y - q, color);
        Point.drawPoint(x + q, y + p, color);
        Point.drawPoint(x - q, y + p, color);
        Point.drawPoint(x + q, y - p, color);
        Point.drawPoint(x - q, y - p, color);
    }

    /**
     * Metoda visit pentru Visitor Design Pattern ce primeste un triunghi ca parametru si ii
     * deseneaza conturul prin desenarea celor 3 laturi.
     */
    @Override
    public void visit(final Triangle triangle) {
        Point[] points = triangle.getPoints();

        visit(new Line(points[0], points[1], triangle.getColorMargin()));
        visit(new Line(points[1], points[2], triangle.getColorMargin()));
        visit(new Line(points[2], points[0], triangle.getColorMargin()));
    }

    /**
     * Metoda visit pentru Visitor Design Pattern ce primeste un romb ca parametru si ii
     * deseneaza conturul prin desenarea celor 4 laturi.
     */
    @Override
    public void visit(final Diamond diamond) {
        Point pointUp = diamond.getPointUp();
        Point pointDown = diamond.getPointDown();
        Point pointRight = diamond.getPointRight();
        Point pointLeft = diamond.getPointLeft();

        visit(new Line(pointUp, pointLeft, diamond.getColorMargin()));
        visit(new Line(pointLeft, pointDown, diamond.getColorMargin()));
        visit(new Line(pointDown, pointRight, diamond.getColorMargin()));
        visit(new Line(pointRight, pointUp, diamond.getColorMargin()));
    }

    /**
     * Metoda visit pentru Visitor Design Pattern ce primeste un poligon ca parametru si ii
     * deseneaza conturul prin desenarea celor N laturi.
     */
    @Override
    public void visit(final Polygon polygon) {
        Point[] points = polygon.getPoints();
        int n = points.length;

        for (int i = 0; i < n - 1; i++) {
            visit(new Line(points[i], points[i + 1], polygon.getColorMargin()));
        }

        visit(new Line(points[n - 1], points[0], polygon.getColorMargin()));
    }

    /**
     * Metoda visit pentru Visitor Design Pattern ce primeste un canvas (deoarece si Canvas-ul
     * este o forma conform enuntului), insa Canvas-ul nu are un contur, ci numai culoare de
     * fundal, asa ca metoda visit a acesteia nu va face nimic deoarece singurul scop al
     * DrawVisitor-ului este sa deseneze contururi.
     */
    @Override
    public void visit(final Canvas canvas) { }
}
