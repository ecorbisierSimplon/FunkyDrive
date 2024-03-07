<div id="search">
	<input id="searchBar" type="search" placeholder="Search a file" />
	<input id="button" type="button" value="search" />
</div>

<div id="Your_files">
	<h1>Your files</h1>
	<li class="caroussel-files"></li>
</div>

<div id="recently_open">
	<h1>Recently open</h1>
	<li class="caroussel-files"></li>
</div>

<style>
	#Your_files {
		position: relative;
		left: 100px;
		top: 50px;
	}

	#recently_open {
		position: relative;
		top: 250px;
		left: 100px;
	}

	#searchBar {
		width: 300px;
	}

	#search {
		display: flex;
		justify-content: center;
		align-items: center;
	}

	#search > * {
		margin: 5px;
	}
</style>
