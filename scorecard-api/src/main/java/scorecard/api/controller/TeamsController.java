package scorecard.api.controller;

import com.google.gson.Gson;
import scorecard.api.model.Team;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class TeamsController
{
	static Long teamId = Long.valueOf(0);

	public static Long nextTeamId()
	{
		return ++teamId;
	}

	private Gson gson = new Gson();

	Map<Long, Team> teams = new HashMap<>(){{
		Team team1 = Team.create("Argentina", "West");
		team1.setId(nextTeamId());
		put(team1.getId(), team1);

		Team team2 = Team.create("Canada", "West");
		team2.setId(nextTeamId());
		put(team2.getId(), team2);

		Team team3 = Team.create("India", "East");
		team3.setId(nextTeamId());
		put(team3.getId(), team3);

		Team team4 = Team.create("England", "East");
		team4.setId(nextTeamId());
		put(team4.getId(), team4);

		Team team5 = Team.create("Mexico", "West");
		team5.setId(nextTeamId());
		put(team5.getId(), team5);

		Team team6 = Team.create("South Africa", "East");
		team6.setId(nextTeamId());
		put(team6.getId(), team6);

		Team team7 = Team.create("USA", "West");
		team7.setId(nextTeamId());
		put(team7.getId(), team7);

//		Team team8 = Team.create("Australia", "East");
//		team8.setId(nextTeamId());
//		put(team8.getId(), team8);
//
//		Team team9 = Team.create("Brazil", "West");
//		team9.setId(nextTeamId());
//		put(team9.getId(), team9);
//
//		Team team10 = Team.create("Japan", "East");
//		team10.setId(11L);
//		put(team10.getId(), team10);

	}};

	@GetMapping("/teams")
	public ResponseEntity<Map<Long, Team>> listTeams(@RequestParam(required = false) String league)
	{
		if (league != null)
		{
			Map<Long, Team> teams = this.teams.entrySet().stream()
					.filter(team -> team.getValue().getLeague().equalsIgnoreCase(league))
					.collect(Collectors.toMap(team -> team.getKey(), team -> team.getValue()));

			if (teams.isEmpty())
			{
				return ResponseEntity.notFound().build();
			}
			else {
				return ResponseEntity.ok(teams);
			}
		}

		return ResponseEntity.ok(teams);
	}

	@GetMapping(value = "/teams/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Team> getTeam(@PathVariable(value="id") String teamId)
	{
		Team team = teams.get(Long.valueOf(teamId));

		if (team == null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.ok(team);
	}

	@PostMapping(value = "/teams", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Team> createTeam(HttpServletRequest request, @RequestBody Team team) throws URISyntaxException
	{
		team.setId(nextTeamId());
		teams.put(team.getId(), team);
		URI uri = new URI(request.getRequestURI() + "/" + team.getId());
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/teams/{id}")
	public ResponseEntity<Team> updateTeam(@RequestBody Team team)
	{
		if (teams.get(team.getId()) == null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		teams.put(team.getId(), team);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/teams/{id}")
	public ResponseEntity<Team> deleteTeam(@RequestBody Team team)
	{
		if (teams.get(team.getId()) == null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		teams.remove(team.getId());

		return ResponseEntity.ok(team);
	}

}
