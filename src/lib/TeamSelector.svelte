<script>
	import { onMount } from 'svelte';
import { compute_slots } from 'svelte/internal';
	// import { getContext } from 'svelte';

	export let forCounter;
	let value;
	
	function setTeam(value) {
		console.log("setTeam()", value);
	}

	let teams = [ { name: "teams not loaded yet"} ];
	let randomLoadTime = Math.floor(Math.random() * 5000);
	function fetchTeams() {
		console.log(`fetchTeams() takes ${randomLoadTime} seconds`)
		teams = [
			{"name": "Argentina"},
			{"name": "England"},
			{"name": "India"},
			{"name": "South Africa"},
			{"name": "USA"}
		]
		console.log("teams loaded", teams);
	}

	setTimeout(fetchTeams, randomLoadTime)
</script>


<div class="team-selector">

	<select name="team-selector" on:change={setTeam} bind:value>
		<option value="" disabled selected>Choose Team</option>
		{#each teams as team }
		<option value="{team.name}">{team.name}</option>
		{/each}
	</select>
	
	{#if value}
	(team: {value}) 
	{/if}

</div>



<style>

	.team-selector select {
		width: 100%;
		padding: 0.25rem;
		margin: 0.25rem;
		border-radius: 0.5rem;
	}

</style>