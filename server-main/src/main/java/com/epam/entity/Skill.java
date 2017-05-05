package com.epam.entity;

import java.util.Objects;

public class Skill {

	private String language;
	private int level;

	public Skill() {}

	public Skill(String language, int level) {
		this.language = language;
		this.level = level;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Skill skill = (Skill) o;
		return level == skill.level &&
				Objects.equals(language, skill.language);
	}

	@Override
	public int hashCode() {
		return Objects.hash(language, level);
	}

	@Override
	public String toString() {
		return "Skill{" +
				"language='" + language + '\'' +
				", level=" + level +
				'}';
	}

	public String getLanguage()	{
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
