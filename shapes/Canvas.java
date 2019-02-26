package shapes;
import java.awt.image.BufferedImage;

import utils.Point;
import visitor.DrawVisitor;
import visitor.Visitable;

/**
 * Clasa pentru Canvas ce mosteneste clasa abstracta Shape. Implementeaza Singleton Pattern
 * deoarece avem intotdeauna un singur Canvas pentru un desen dat.
 *
 * @author TEACA BOGDAN
 */
public final class Canvas extends Shape implements Visitable {
    private static Canvas canvas = null;
    private static BufferedImage image;
    private static int width;
    private static int height;
    private static int color;

    /**
     * Constructor privat ce initializeaza BufferedImage-ul, dimensiunile si culoarea Canvas-ului.
     * Constructorul este privat pentru a nu permite instantierea unui obiect de tip Canvas
     * folosind direct constructorul. Instantierea unui obiect se face folosind metoda getCanvas()
     * care asigura instantierea unui unic obiect Canvas. Metoda getCanvas() apleaza acest
     * constructor privat numai daca un obiect Canvas nu a mai fost initializat pana atunci.
     */
    private Canvas(final int height, final int width, final int color) {
        Canvas.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Canvas.width = width;
        Canvas.height = height;
        Canvas.color = color;
    }

    /**
     * Metoda ce implementeaza Singleton Pattern pentru Canvas, deoarece avem un singur Canvas
     * pentru un desen. Daca Canvas-ul nu a fost initializat inca, metoda aceasta il initializeaza,
     * iar daca a fost deja initializat atunci intoarce acea instanta de Canvas care a fost
     * deja initializata.
     */
    public static Canvas getCanvas(final int canvasH, final int canvasW, final int canvasColor) {
        if (canvas == null) {
            canvas = new Canvas(canvasH, canvasW, canvasColor);
        }

        return canvas;
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
        return new Point(width / 2, height / 2);
    }

    /**
     * Getter pentru latimea Canvas-ului.
     */
    public static int getWidth() {
        return width;
    }

    /**
     * Getter pentru inaltimea Canvas-ului.
     */
    public static int getHeight() {
        return height;
    }

    /**
     * Getter pentru BufferedImage.
     */
    public static BufferedImage getImage() {
        return image;
    }

    /**
     * Nu este nevoie de algoritmul de Flood-Fill pentru umplerea Canvas-ului deoarece este mai
     * simplu si mai eficient sa coloram direct intregul Canvas.
     */
    @Override
    public void fillShape() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, color);
            }
        }
    }
}
