package shapes;
import java.util.LinkedList;
import java.util.Queue;

import utils.Point;
import utils.RelativePointPosition;
import visitor.Visitable;

/**
 * Clasa abstracta care este mostenita de toate figurile geometrice. Contine metode specifice
 * tuturor formelor geometrice cum sunt metoda de umplere a interiorului figurii care este
 * universala la toate figurile cu interior si metoda abstracta de calculare a centrului de
 * greutate a figurii ce trebuie implementata de fiecare tip de figura in parte.
 *
 * @author TEACA BOGDAN
 */
public abstract class Shape implements Visitable {
    private int colorMargin;
    private int colorInterior;

    public Shape() { }

    /**
     * Constructor ce initializeaza culoarea conturilui si culoarea din interior a figurii.
     *
     * @param colorMargin = Culoarea conturului
     * @param colorInterior = Culoarea din interior
     */
    public Shape(final int colorMargin, final int colorInterior) {
        this.colorMargin = colorMargin;
        this.colorInterior = colorInterior;
    }

    /**
     * Metoda ce implmenteaza algoritmul de Flood-Fill pentru umplerea interiorului figurii
     * geometrice. La inceput se pune intr-o coada centrul de greutate al figurii, se verifica daca
     * punctul se afla in interiorul Canvas-ului, iar daca acesta este in exterior atunci adaugam
     * in coada puncte din ce in ce mai apropiate de Canvas pana ajungem in interiorul acestuia
     * ca sa coloram restul din figura ce se afla in Canvas, moment in care algoritmul flood-fill
     * propriu-zis incepe. Daca punctele se afla in Canvas, atunci se verifica daca trebuie colorat
     * punctul respectiv, iar daca da, atunci se coloreaza si se adauga in coada toti vecinii
     * punctului. Algoritmul se opreste atunci cand nu mai exista puncte in coada, adica atunci cand
     * au fost colorate toate punctele din interiorul figurii.
     */
    public void fillShape() {
        Queue<Point> q = new LinkedList<Point>(); //se initializeaza coada de puncte

        q.add(getGravityCenter()); //adaugam centrul de greutate a figurii ca prim element al cozii

        while (!q.isEmpty()) { //cat timp mai avem puncte de verificat, continuam algoritmul
            Point pointCurrent = q.remove(); //scoatem un punct din coada

            int x = pointCurrent.getX();
            int y = pointCurrent.getY();

            RelativePointPosition pointPositionInCanvas = pointCurrent.getRelativePointPosition();

            //verificam daca punctul se afla in interiorul sau exteriorul Canvas-ului
            switch (pointPositionInCanvas) {
            case INSIDE_CANVAS:
                //daca punctul se afla in interior atunci verificam daca acesta trebuie colorat,
                //iar in caz pozitiv, atunci il coloram si ii adaugam vecinii.
                if (Canvas.getImage().getRGB(x, y) != colorMargin
                        && Canvas.getImage().getRGB(x, y) != colorInterior) {
                    Canvas.getImage().setRGB(x, y, colorInterior);

                    q.add(new Point(x + 1, y));
                    q.add(new Point(x, y + 1));
                    q.add(new Point(x - 1, y));
                    q.add(new Point(x, y - 1));
                }

                break;
            //daca punctul nu se afla in interiorul Canvas-ului atunci ne indreptam spre Canvas
            //in caz ca o parte din figura se afla totusi in Canvas, chiar daca centrul sau de
            //greutate era in exterior.
            case ABOVE_CANVAS:
                q.add(new Point(x, y + 1));

                break;
            case BELOW_CANVAS:
                q.add(new Point(x, y - 1));

                break;
            case LEFT_OF_CANVAS:
                q.add(new Point(x + 1, y));

                break;
            case RIGHT_OF_CANVAS:
                q.add(new Point(x - 1, y));

                break;
            default:
                break;
            }
        }
    }

    /**
     * Metoda abstracta ce calculeaza si returneaza centrul de greutate a figurii. Aceasta metoda
     * este implementata de fiecare figura geometrica in parte pentru ca centrul de greutate a
     * fiecarei figuri se calculeaza intr-un mod diferit
     */
    public abstract Point getGravityCenter();

    /**
     * Getter pentru culoarea conturilui figurii.
     */
    public int getColorMargin() {
        return colorMargin;
    }
}
