<script>
  import svelteLogo from '../assets/svelte.svg'
</script>

<div id="heading">
  <heading>

    <div id="top">
        <img src={svelteLogo} class="logo scores" alt="ScoresApp Logo" />
        
        <h1>
          ScoresApp 
        </h1>
    </div>
  
  </heading>
</div>


<style>

  #top {
    display: flex;
    align-items: center;

    /* border: 1px dotted gray;  */
  }

  h1 {
    /* border: 1px dotted gray;  */
  }

  img {
    height: 2rem;
    padding-right: 1rem;

    /* border: 1px dotted gray;  */
  }

</style>