import java.util.Date;


public class PetBuilder {

	private String name;
	private Date birthDate;
	private int weight;


	public PetBuilder(String name, Date birthDate, int weight) {
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
		return IdentityBuilder.create(PetBuilder.class, PetBuilder::collectMembers).computeHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return IdentityBuilder.create(PetBuilder.class, PetBuilder::collectMembers).computeEquals(this, obj);
	}

	@Override
	public String toString() {
		return IdentityBuilder.create(PetBuilder.class, PetBuilder::collectMembers).computeToString(this);
	}


	private static void collectMembers(IdentityBuilder<PetBuilder> builder) {
		builder
			.add("name", pet -> pet.name)
			.add("birthDate", pet -> pet.birthDate);
	}
}
