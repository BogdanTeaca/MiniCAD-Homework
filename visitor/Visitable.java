package visitor;
/**
 * Interfata Visitable pentru Visitor Design Pattern.
 *
 * @author TEACA BOGDAN
 */
public interface Visitable {
    /**
     * Metoda accept a interfetei Visitor ce accepta interactiunea cu DrawVisitor ce se ocupa
     * cu desenarea conturului figurilor.
     */
    void accept(DrawVisitor v);
}
