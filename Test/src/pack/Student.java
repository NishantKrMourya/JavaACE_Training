package pack;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Student implements Externalizable {

	private int rollNo;
	private String name;

	public Student() {
		super();
	}

	public Student(int rollNo, String name) {
		super();
		this.rollNo = rollNo;
		this.name = name;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("writeExternal called");
		out.writeInt(rollNo);
		out.writeObject(name);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		System.out.println("readExternal called");
		rollNo = in.readInt();
		name = (String) in.readObject();
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + "]";
	}

	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		Student student = new Student(1, "abc");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				"stdfile.ser"));
		oos.writeObject(student);
		oos.close();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				"stdfile.ser"));
		Object obj = ois.readObject();
		ois.close();
		Student std = (Student) obj;
		System.out.println(std);
	}
}
