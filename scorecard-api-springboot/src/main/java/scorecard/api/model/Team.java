package scorecard.api.model;

import scorecard.api.controller.TeamsController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Team
{
	private @Id	@GeneratedValue Long id;
	private String name;
	private String league;

	public static Team create(String teamName, String leagueName)
	{
		Team instance = Team.create(teamName);
		instance.setLeague(leagueName);
		return instance;
	}

	public static Team create(String teamName)
	{
		Team instance = new Team();
		instance.setId(TeamsController.nextTeamId());
		instance.setName(teamName);
		return instance;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getLeague()
	{
		return league;
	}

	public void setLeague(String league)
	{
		this.league = league;
	}

}

