<script>
	import { onMount } from 'svelte';

	import Heading from './lib/Heading.svelte'
	import TeamSelector from './lib/TeamSelector.svelte'

	onMount(fetchTeams);

	async function fetchTeams() {
		console.log("App.fetchTeams()");
		
		let teams_endpoint = "http://localhost:5173/api/teams.json";
		const response = await fetch(teams_endpoint);
		let teamlist = await response.json();
		console.log("teamlist", teamlist);
	}
		
</script>

<main>
	<Heading/>

	<div class="card">
		<h4>Team 1</h4>
		<TeamSelector/>
	</div>

	<div class="card">
		<h4>Team 2</h4>
		<TeamSelector/>
	</div>
</main>

<style>
	h4 { text-align: left;
		margin: 0; 
		padding:0.25rem;
		font-weight: 700;
	}
	.card {
		padding: 0.5rem;
		margin: 1rem;
		margin-bottom: 2rem;
		border: 1px dotted gray; 
		border-radius: 0.5rem;
	}
</style>
