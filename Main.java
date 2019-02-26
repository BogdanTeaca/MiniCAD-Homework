import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

import shapes.Canvas;
import shapes.Shape;
import utils.ShapeFactory;
import visitor.DrawVisitor;

/**
 * Clasa Main a programului. Aici se citesc datele din fisierul de intrare si se foloseste
 * shapeFactory ce implementeaza Factory Design Pattern care creaza diversele figuri
 * geometrice.
 *
 * @author TEACA BOGDAN
 */
public abstract class Main {
    public static void main(final String[] args) {
        try {
            BufferedReader f = new BufferedReader(new FileReader(args[0]));

            String line = f.readLine();
            int n = Integer.parseInt(line);

            ShapeFactory shapeFactory = new ShapeFactory();
            DrawVisitor drawVisitor = new DrawVisitor();

            for (int i = 0; i < n; i++) {
                line = f.readLine();
                String[] s = line.split(" ");

                Shape shape = shapeFactory.getShape(s);
                shape.accept(drawVisitor);
                shape.fillShape();
            }

            ImageIO.write(Canvas.getImage(), "PNG", new File("drawing.png"));

            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
