package PrototypePattern;

public abstract class Shape implements Cloneable {

	public String id;

	public String type;

	public abstract void draw();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object clone() {
		Object clone = null;
		try {
			clone = (Object) super.clone();
		} catch (CloneNotSupportedException c) {
			c.printStackTrace();
		}

		return clone;
	}

}
