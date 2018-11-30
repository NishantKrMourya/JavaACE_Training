package pack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Application {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
			Employee employee = new Employee(1, "abc");
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.ser"));
			oos.writeObject(employee);
			oos.close();
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file.ser"));
			Object obj = ois.readObject();
			ois.close();
			Employee emp = (Employee)obj;
			System.out.println(emp);
	}

}
