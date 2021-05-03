package model;


public enum Category {

	AresTb("ARES TB"), AresThs("ARES THS"), CronosOld("Cronos Old"), CronosL("Cronos L"), CronosNg("Cronos NG");

	final private String name;

	Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}