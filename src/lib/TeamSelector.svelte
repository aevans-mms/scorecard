<script>
	import { onMount } from 'svelte';
	import { getContext } from 'svelte';

	
	let teams = getContext('teams');
	export let forCounter;
	let value;

	
	function setTeam(value) {
		console.log("setTeam()", value);
	}

</script>


<div class="team-selector">

	<select name="team-selector" on:change={setTeam} bind:value>
		<option value="" disabled selected>Choose Team</option>
		{#each $teams as team }
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