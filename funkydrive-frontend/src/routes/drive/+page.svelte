<script lang="ts">
    import { name } from "../create_folder/store";
    import CreateFolder from "../create_folder/createFolder.svelte";


</script>


<div id="search">
    <input id="searchBar" type="search" placeholder="Search a file"/>
    <input id="button" type="button" value="search"/>
    <a href="/import">import</a>
    <a href="/create_folder">create</a>
</div>


<div id="Your_files">
    <h1>Your folder</h1>
    <div id="folder">
        <CreateFolder/>
    </div>


</div>


<div id="recently_open">
    <h1>Recently open</h1>



</div>

<style>
    #Your_files{
        position: relative;
        left: 100px;
        top: 50px;

    }

    #recently_open{
        position: relative;
        top: 50px;
        left: 100px;
    }

    #searchBar{
        width: 300px;
    }

    #search{
        display: flex;
        justify-content: center;
        align-items: center;
    }

    #search > *{
        margin: 5px;

    }



</style>