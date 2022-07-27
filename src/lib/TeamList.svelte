<script>
	import { onMount } from 'svelte';
	import SelectedTeam from './SelectedTeam.svelte';

    let teams = [ "Red", "Blue", "Green", "Yellow" ]
    let selected_team = teams[0]

    function select_team(event) {
        const team = event.target.value
        console.log("select_team", team)
        selected_team = team
    }
</script>

<div class="TeamList">
    <h3> Team List</h3>
    <ul id="team_list">
        {#each teams as team}
        <li> <input name="team-select" value="{team}" type="radio" on:click="{select_team}"> <label for="team-{team}">{team}</label> </li>
        {/each}
    </ul>
    <SelectedTeam bind:selected_team></SelectedTeam>
</div>

<style>
    .TeamList {
        border: 1px dashed gray;
        padding: 1rem;
    }

    h3 { 
        margin: 0;
        padding: 0;
    }

    ul { 
        list-style-type: none;
        
    }

    li {
        display: flex;
        flex-direction: row;
        justify-content: flex-start;
    }

    input[type=radio] {
        margin-right: 2ch;
    }
</style>