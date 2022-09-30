<script>
  export let team;
  let id;
  let score = 0
  
  const increment = () => {
    score += 1
    console.log("increment", team, id, score)
  }

  const reset = () => {
    score = 0
    console.log("reset", team, id, score)
  }

</script>


<div class="score-button">
  <button on:click={increment}>
    {team} : {score}
  </button>

  <button class="smaller" on:click={reset}>
    reset
  </button>

</div>




<style>

  .score-button {
    display: flex;
    align-items: center;
  }
  
  button {
    margin: 0.25rem;
  }
  
  .smaller {
    font-size: 75%;
    opacity: 75%;
  } 
  
  </style>