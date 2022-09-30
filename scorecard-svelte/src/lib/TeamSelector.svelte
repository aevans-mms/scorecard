<script>
	import { onMount } from 'svelte';
	import { compute_slots } from 'svelte/internal';
    import ScoreButton from './ScoreButton.svelte';
	// import { getContext } from 'svelte';

	export let forCounter;
	let value;
	
	function setTeam(value) {
		console.log("setTeam()", value);
	}

	let teams = [ { name: "teams not loaded yet"} ];
	let randomLoadTime = Math.floor(Math.random() * 3);
	function fetchTeams() {
		console.log(`fetchTeams() takes ${randomLoadTime} seconds`)
		teams = [
			{"name": "Argentina", "league": "west"},
			{"name": "Canada", "league": "west"},
			{"name": "India", "league": "east"},
			{"name": "England", "league": "east"},
			{"name": "Mexico", "league": "west"},
			{"name": "South Africa", "league": "east"},
			{"name": "USA", "league": "west", }
		]
		console.log("teams loaded", teams);
	}

	setTimeout(fetchTeams, 3000)
</script>


<div class="team-selector">

	<select name="team-selector" on:change={setTeam} bind:value>
		<option value="" disabled selected>Choose Team</option>
		{#each teams as team }
		<option value="{team.name}">{team.name}</option>
		{/each}
	</select>
	
	{#if value}
		<!-- <span> (team: {value})  </span> -->
		<ScoreButton team="{value}"/>
	
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