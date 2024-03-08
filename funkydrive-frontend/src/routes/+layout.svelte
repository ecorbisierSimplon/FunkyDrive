<script lang="ts">
	import '../css/styles.min.css';
	import type { ActionData } from './$types';
	import Header from './Header.svelte';

	export let data: ActionData;
</script>

<div class="app">
	<Header {data} />
	<main>
		<slot />
	</main>

	<footer></footer>
</div>

<style>
	* {
		color: #d6d6d6;
	}
</style>
