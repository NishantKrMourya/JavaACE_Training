package pack;

import java.io.IOException;
import java.io.ObjectOutputStream.PutField;
import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = -2384598235975584268L;
	private int id;
	private String name;

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	public Object readResolve() {
		System.out.println("readResolve called");
		return this;
	}

	public Object writeReplace() {
		System.out.println("writeReplace called");
		return this;
	}

	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		System.out.println("writeObject");
		// controlling fields value here start.
		/*PutField putFields = out.putFields();
		putFields.put("name", "name changed");
		out.writeFields();*/
		// controlling fields value here end.
		out.defaultWriteObject();
	}

	private void readObject(java.io.ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		System.out.println("readObject");
		in.defaultReadObject();
	}

}
