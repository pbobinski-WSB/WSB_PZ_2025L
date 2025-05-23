package wsb.merito.pz.cw13.wp.singleton;

// Lazy Initialization
public class SingletonClassDemo {

	// Static attribute.
	private static SingletonClassDemo instance = null;

	// Private constructor.
	private SingletonClassDemo() {

	}

	// Static function.
	public static SingletonClassDemo getInstance() {
		// If there is no instance available, create new one (i.e. lazy initialization).
		if (instance == null) {
			instance = new SingletonClassDemo();
		}
		return instance;
	}

	@Override
	public String toString() {
		return "SingletonClassDemo{} "+super.toString();
	}
}