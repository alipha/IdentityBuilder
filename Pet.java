import java.util.Date;


public class Pet {

	private String name;
	private Date birthDate;
	private int weight;


	public Pet(String name, Date birthDate, int weight) {
		this.name = name;
		this.birthDate = birthDate;
		this.weight = weight;
	}
	

	public String getName() { return this.name; }

	public Date getBirthDate() { return this.birthDate; }


	public int getWeight() { return this.weight; }

	public void setWeight() { this.weight = weight; }


	@Override
	public int hashCode() {
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;

		if(right == null || this.getClass() != obj.getClass())
			return false;

		Pet rightPet = (Pet)right;

		if(this.name != obj.name) {
			if(this.name == null || obj.name == null)
				return false;
			if(!this.name.equals(obj.name))
				return false;
		}

		if(this.birthDate != obj.birthDate) {
			if(this.birthDate == null || obj.birthDate == null)
				return false;
			if(!this.birthDate.equals(obj.birthDate))
				return false;
		}

		return true;
	}

	@Override
	public String toString() {
	}


	private static void collectMembers(IdentityBuilder<Pet> builder) {
		builder
			.add("name", pet -> pet.name)
			.add("birthDate", pet -> pet.birthDate);
	}
}
