<script lang="ts">
    import { name, showFolder } from "./store";
    import { fileTab } from "./store";

    let fileName = '';

    export function addFile() {
        $showFolder = true;
        fileName += $name;
        $fileTab.push($name)
        console.log($name);
    }

    

    
</script>


<h1>Create a folder</h1>

<div id="folder">
    <input bind:value={$name} class="name" type="text" placeholder="folder name"/>
    <br>
    <input on:click={() => addFile()} type="button" value="save"/>
</div>


<style>
    h1{
        text-align: center;
    }

    #folder{
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        position: relative;
        top: 100px;

    }

    #folder > *{
        width: 200px;
    }

</style>