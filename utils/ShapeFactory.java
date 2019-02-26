package utils;
import shapes.Canvas;
import shapes.Circle;
import shapes.Diamond;
import shapes.Line;
import shapes.Polygon;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Square;
import shapes.Triangle;

/**
 * Clasa ce implementeaza Factory Design Pattern si se ocupa cu crearea unei figuri geometrice
 * in functie de parametrii dati.
 *
 * @author TEACA BOGDAN
 */
public class ShapeFactory {
    private static final int PARAM_3 = 3;
    private static final int PARAM_4 = 4;
    private static final int PARAM_5 = 5;
    private static final int PARAM_6 = 6;
    private static final int PARAM_7 = 7;
    private static final int PARAM_8 = 8;
    private static final int PARAM_9 = 9;
    private static final int PARAM_10 = 10;

    public ShapeFactory() { };

    /**
     * Metoda primeste un sir de parametri, instantiaza figura geometrica corespunzatoare
     * si o intoarce.
     */
    public Shape getShape(final String[] s) {
        Point pointUpLeft, pointCenter;
        int colorMargin, colorInterior, width, height;

        switch (s[0]) {
        case "CANVAS":
            height = Integer.parseInt(s[1]);
            width = Integer.parseInt(s[2]);
            colorInterior = ColorUtils.convertHexToRgb(s[PARAM_3], Integer.parseInt(s[PARAM_4]));

            return Canvas.getCanvas(height, width, colorInterior);
        case "LINE":
            Point pointStart = new Point(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            Point pointEnd = new Point(Integer.parseInt(s[PARAM_3]), Integer.parseInt(s[PARAM_4]));
            colorMargin = ColorUtils.convertHexToRgb(s[PARAM_5], Integer.parseInt(s[PARAM_6]));

            return new Line(pointStart, pointEnd, colorMargin);
        case "SQUARE":
            pointUpLeft = new Point(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            width = Integer.parseInt(s[PARAM_3]);
            colorMargin = ColorUtils.convertHexToRgb(s[PARAM_4], Integer.parseInt(s[PARAM_5]));
            colorInterior = ColorUtils.convertHexToRgb(s[PARAM_6], Integer.parseInt(s[PARAM_7]));

            return new Square(pointUpLeft, width, colorMargin, colorInterior);
        case "RECTANGLE":
            pointUpLeft = new Point(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            height = Integer.parseInt(s[PARAM_3]);
            width = Integer.parseInt(s[PARAM_4]);
            colorMargin = ColorUtils.convertHexToRgb(s[PARAM_5], Integer.parseInt(s[PARAM_6]));
            colorInterior = ColorUtils.convertHexToRgb(s[PARAM_7], Integer.parseInt(s[PARAM_8]));

            return new Rectangle(pointUpLeft, height, width, colorMargin, colorInterior);
        case "CIRCLE":
            pointCenter = new Point(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            int radius = Integer.parseInt(s[PARAM_3]);
            colorMargin = ColorUtils.convertHexToRgb(s[PARAM_4], Integer.parseInt(s[PARAM_5]));
            colorInterior = ColorUtils.convertHexToRgb(s[PARAM_6], Integer.parseInt(s[PARAM_7]));

            return new Circle(pointCenter, radius, colorMargin, colorInterior);
        case "TRIANGLE":
            Point point1 = new Point(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            Point point2 = new Point(Integer.parseInt(s[PARAM_3]), Integer.parseInt(s[PARAM_4]));
            Point point3 = new Point(Integer.parseInt(s[PARAM_5]), Integer.parseInt(s[PARAM_6]));
            colorMargin = ColorUtils.convertHexToRgb(s[PARAM_7], Integer.parseInt(s[PARAM_8]));
            colorInterior = ColorUtils.convertHexToRgb(s[PARAM_9], Integer.parseInt(s[PARAM_10]));

            return new Triangle(point1, point2, point3, colorMargin, colorInterior);
        case "DIAMOND":
            pointCenter = new Point(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            int diagH = Integer.parseInt(s[PARAM_3]);
            int diagV = Integer.parseInt(s[PARAM_4]);
            colorMargin = ColorUtils.convertHexToRgb(s[PARAM_5], Integer.parseInt(s[PARAM_6]));
            colorInterior = ColorUtils.convertHexToRgb(s[PARAM_7], Integer.parseInt(s[PARAM_8]));

            return new Diamond(pointCenter, diagH, diagV, colorMargin, colorInterior);
        case "POLYGON":
            int nrPoints = Integer.parseInt(s[1]);

            Point[] points = new Point[nrPoints];

            int diffBetweenParams = 2;

            // Cream pe rand punctele ce reprezinta varfurile poligonului
            for (int j = 0; j < 2 * nrPoints; j += 2) {
                int xPoint = Integer.parseInt(s[j + diffBetweenParams]);
                int yPoint = Integer.parseInt(s[j + diffBetweenParams + 1]);

                points[j / 2] = new Point(xPoint, yPoint);
            }

            int lastParamsIndex = 2 * nrPoints + diffBetweenParams + 1;

            colorMargin = ColorUtils.convertHexToRgb(s[lastParamsIndex - 1],
                    Integer.parseInt(s[lastParamsIndex]));
            colorInterior = ColorUtils.convertHexToRgb(s[lastParamsIndex + 1],
                    Integer.parseInt(s[lastParamsIndex + 2]));

            return new Polygon(points, colorMargin, colorInterior);
        default:
            break;
        }

        return null;
    }
}
