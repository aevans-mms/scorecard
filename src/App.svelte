<script>
	import { onMount } from 'svelte';
	import { writable } from 'svelte/store';
	import { setContext } from 'svelte';

	import Heading from './lib/Heading.svelte';
	
	// import TeamList from './lib/TeamList.svelte';

	import TeamSelector from './lib/TeamSelector.svelte';

	import Counter from './lib/Counter.svelte';

	export let team1 = "India";
	export let team2 = "England";
	
	const default_teams = [
		{"name": "India"},
		{"name": "England"}
	]

	const teams = writable([]);
	setContext('teams', teams);

	onMount(() => {
		teams.set([{name: 'teams not loaded yet'}])
		let randomLoadTime = Math.floor(Math.random() * 5000);
		console.log(`loading teams will take ${randomLoadTime} milliseconds`)
		setTimeout(fetchTeams, randomLoadTime)
	})
	
	async function fetchTeams() {
		let teams_endpoint = "http://localhost:5173/api/teams.json";
		const response = await fetch(teams_endpoint);
		let teamlist = await response.json();
		console.log("teams loaded", teamlist);
		teams.set(teamlist);
	}


</script>

<main>

	<Heading/>

	<!-- <TeamList></TeamList> -->


	<div class="card">
		<TeamSelector forCounter="team1"/>
		<Counter team="{team1}" id="team1"/>

	</div>

	
	<div class="card">
		<TeamSelector forCounter="team2"/>
		<Counter team="{team2}" id="team2"/>
	</div>

</main>

<style>

.card {
	padding: 0.5rem;
	margin: 1rem;
	border-radius: 0.5rem;
}

</style>
