import java.util.Date;


public class Test {

	public static void main(String[] args) {
		Pet pet1 = new Pet("Wiggles", new Date(109, 4, 1), 12);
		Pet pet2 = new Pet("Gabby", new Date(109, 7, 1), 8);
		Pet pet3 = new Pet("Wiggles", new Date(109, 4, 1), 12);
		Pet pet4 = new Pet("Wiggles", new Date(109, 4, 2), 12);
		Pet pet6 = new Pet(null, null, 12);
		Pet pet7 = new Pet(null, null, 12);
		Pet pet5 = pet1;

		System.out.println(pet1.equals(pet1) + " " + pet1.hashCode() + " " + pet1);
		System.out.println(pet1.equals(pet2) + " " + pet2.hashCode() + " " + pet2);
		System.out.println(pet1.equals(pet3) + " " + pet3.hashCode() + " " + pet3);
		System.out.println(pet1.equals(pet4) + " " + pet4.hashCode() + " " + pet4);
		System.out.println(pet1.equals(pet5) + " " + pet5.hashCode() + " " + pet5);
		System.out.println(pet1.equals(pet6) + " " + pet6.hashCode() + " " + pet6);
		System.out.println(pet6.equals(pet1) + " " + pet6.equals(pet7) + " " + pet6.equals(null));
		System.out.println(pet1.equals("foo"));
	}
}
