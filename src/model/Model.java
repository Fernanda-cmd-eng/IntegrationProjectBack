package model;

public enum Model {

	ARES7021("ARES 7021"), ARES7031("ARES 7031"), ARES7023("ARES 7023"), ARES802315("ARES 8023 15"),
	ARES8023200("ARES 8023 200"), ARES802325("ARES 8023 2,5"), Cronos6001A("Cronos 6001-A"), Cronos6003("Cronos 6003"),
	Cronos7023("Cronos 7023"), Cronos6021L("Cronos 6021L"), Cronos7023L("Cronos 7023L"), Cronos6001NG("Cronos 6001-NG"),
	Cronos6003NG("Cronos 6003-NG"), Cronos6021NG("Cronos 6021-NG"), Cronos6031NG("Cronos 6031-NG"),
	Cronos7021NG("Cronos 7021-NG"), Cronos7023NG("Cronos 7023-NG");

	final private String name;

	Model(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}