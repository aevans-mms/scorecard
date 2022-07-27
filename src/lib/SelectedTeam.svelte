<script>
    export let selected_team;

    function changeTeam() {
        selected_team = "changed"
    }
</script>


<div class="SelectedTeam">
    Selected Team: <span id="selected_team">{selected_team}</span>
</div>

<button on:click={changeTeam}>Change Team</button>
	
