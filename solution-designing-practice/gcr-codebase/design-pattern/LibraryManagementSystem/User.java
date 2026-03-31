package LibraryManagementSystem;

abstract class User implements LibraryObserver {
	protected String name;

	public User(String name) {
		this.name = name;
	}

	public abstract void showRole();

	@Override
	public void update(String message) {
		System.out.println(name + " notified: " + message);
	}

	@Override
	public String toString() {
		return name + " (" + getClass().getSimpleName() + ")";
	}
}