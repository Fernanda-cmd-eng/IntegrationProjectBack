package main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "meters")
public class Meters {
	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "line")
	private String line;

	@Column(name = "category")
	String category;

	@Column(name = "model")
	String model;

	public Meters() {
	}

	public Meters(String id, String line, String category, String model) {
		this.id = id;
		this.line = line;
		this.category = category;
		this.model = model;
	}

	public Meters(String line, String category, String model) {
		this.line = line;
		this.category = category;
		this.model = model;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Meters: " + this.id + ", " + this.line + ", " + this.category + ", " + this.model;
	}

}