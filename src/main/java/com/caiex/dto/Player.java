package com.caiex.dto;

import java.io.IOException;
import java.util.Date;

import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

public class Player {
	
	private String name;
	
	private Date birthday;
	
	private String league;

	private String team;
	
	private String position;
	
	public Player() {
	}
	
	public Player(String name, Date birthday, String league, String team,
			String position) {
		this.name = name;
		this.birthday = birthday;
		this.league = league;
		this.team = team;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", birthday=" + birthday + ", league="
				+ league + ", team=" + team + ", position=" + position + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((league == null) ? 0 : league.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((team == null) ? 0 : team.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (league == null) {
			if (other.league != null)
				return false;
		} else if (!league.equals(other.league))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		return true;
	}
	
	public XContentBuilder toJSON() throws IOException {
		XContentBuilder builder = XContentFactory.jsonBuilder();
		builder.startObject()
				.field("name", this.name)
				.field("birthday", this.birthday)
				.field("league", this.league)
				.field("team", this.team)
				.field("position", this.position)
				.endObject();
		return builder;
	}

}
