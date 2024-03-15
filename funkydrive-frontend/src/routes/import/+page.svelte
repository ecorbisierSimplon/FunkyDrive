<script lang="ts">

    let files: any = [];

    function handleSubmit(event: any) {
        files.push(...event.target.files) // les 3 points (opérateur de décomposition) sont appelés pour décomposer les éléments d'un tableau
        console.log(files.length);
    }

    function listFiles() {
        const fileList = document.getElementById('container') as HTMLElement; // The <div> where we will display the file names

        // Clear the file list
        fileList.innerHTML = '';

        // Loop through the files and add each one to the file list
        for (let i = 0; i < files.length; i++) {
            const file = files[i];

            // Create a new <p> element for the file name
            const fileElement = document.createElement('p');
            fileElement.textContent = file.name;

            // Add the <p> element to the file list
            fileList.appendChild(fileElement);
        }
    }



</script>

<div id="upload">
    <label for="file">File</label>
    <input on:change={handleSubmit} id="file" name="avatar" type="file" accept="*/*" multiple/>
    <button on:click={listFiles}>upload</button>
</div>



<div id="container">

</div>


<style>

    #upload{
        width: 50%;
        margin: auto;
    }





</style>