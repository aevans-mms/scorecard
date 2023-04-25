select * from team;

select team.name as team, league.name as league
    from team, league
    where team.league_id = league.id
    order by league.name, team.name;

select
    league.name as league,
    count(team.name) as teams
from team, league
where
    league.id = team.league_id
group by league_id;