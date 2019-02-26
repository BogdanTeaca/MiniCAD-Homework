package visitor;
import shapes.Canvas;
import shapes.Circle;
import shapes.Diamond;
import shapes.Line;
import shapes.Polygon;
import shapes.Rectangle;
import shapes.Square;
import shapes.Triangle;

/**
 * Interfata Visitor pentru Visitor Design Pattern.
 *
 * @author TEACA BOGDAN
 */
public interface Visitor {
    void visit(Line line);
    void visit(Square square);
    void visit(Rectangle rectangle);
    void visit(Diamond diamond);
    void visit(Triangle triangle);
    void visit(Polygon polygon);
    void visit(Circle circle);
    void visit(Canvas canvas);
}
