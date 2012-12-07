package com.dferreras.project;

public class ProduceItem {

	private String name, season, freshness, nutrition, storage, varieties;

	public ProduceItem() {
		this.name = "temp";
		this.freshness = "temp";
		this.nutrition = "temp";
		this.storage = "temp";
		this.varieties = "";
	}
	
	public ProduceItem(String name, String freshness, String nutrition, String storage) {
		this.name = name;
		this.freshness = freshness;
		this.nutrition = nutrition;
		this.storage = storage;
		this.varieties = "";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getFreshness() {
		return freshness;
	}

	public void setFreshness(String freshness) {
		this.freshness = freshness;
	}

	public String getNutrition() {
		return nutrition;
	}

	public void setNutrition(String nutrition) {
		this.nutrition = nutrition;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getVarieties() {
		return varieties;
	}

	public void setVarieties(String varieties) {
		this.varieties = varieties;
	}
	
}
