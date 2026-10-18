package patterns.behavioral.visitor;

/** Element: accepts a visitor (this is what enables double dispatch). */
public interface Item {
    <R> R accept(ItemVisitor<R> visitor);
}
