import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Function;


public class IdentityBuilder<T> {

	private static HashMap<Class<?>, IdentityBuilder<?>> builders = new HashMap<Class<?>, IdentityBuilder<?>>();

	private ArrayList<String> memberNames;
	private ArrayList<Function<T, Object>> members;


	public static <U> IdentityBuilder<U> create(Class<U> type, Consumer<IdentityBuilder<U>> collectMembers) {
		IdentityBuilder<U> builder = (IdentityBuilder<U>)builders.get(type);
		
		if(builder == null) {
			builder = new IdentityBuilder<U>(collectMembers);
			builders.put(type, builder);
		}

		return builder;
	}


	public IdentityBuilder(Consumer<IdentityBuilder<T>> collectMembers) {
		memberNames = new ArrayList<String>();
		members = new ArrayList<Function<T, Object>>();
		collectMembers.accept(this);
	}


	public IdentityBuilder<T> add(String memberName, Function<T, Object> getMember) {
		memberNames.add(memberName);
		members.add(getMember);
		return this;
	}


	public int computeHashCode(T obj) {
		final int prime = 31;
		int result = 1;

		for(Function<T, Object> getMember : members) {
			Object member = getMember.apply(obj);
			result = prime * result + (member == null ? 0 : member.hashCode());
		}

		return result;
	}


	public boolean computeEquals(T left, Object right) {
		if (left == right)
			return true;

		if (left == null || right == null)
			return false;

		if (left.getClass() != right.getClass())
			return false;
		
		T rightT = (T)right;

		for(Function<T, Object> getMember : members) {
			Object leftMember = getMember.apply(left);
			Object rightMember = getMember.apply(rightT);

			if(leftMember == rightMember)
				continue;
			if(leftMember == null || rightMember == null)
				return false;

			if(!leftMember.equals(rightMember))
				return false;
		}

		return true;
	}


	public String computeToString(T obj) {
		StringBuilder sb = new StringBuilder();
		sb.append(obj.getClass().getSimpleName());
		sb.append(" {");

		for(int i = 0; i < members.size(); i++) {
			sb.append(memberNames.get(i));
			sb.append("='");
			sb.append(members.get(i).apply(obj));
			sb.append(i < members.size() - 1 ? "', " : "'");
		}

		sb.append("}");
		return sb.toString();
	}
}
