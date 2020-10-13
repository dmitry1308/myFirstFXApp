package dshepin.myFirstFxApp.logic.reader;

public interface Reader<V,T> {
	V read(T fileName);
}
