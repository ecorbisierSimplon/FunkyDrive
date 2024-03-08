<script lang="ts">
	import { onMount } from 'svelte';
	import { getCookie } from 'typescript-cookie';
	let name: string = '';
	onMount(() => {
		name = getCookie('firstname') as string;
		name = name === undefined ? '' : ' ' + name;
	});
</script>

<svelte:head>
	<title>Home</title>
	<meta name="description" content="Drive" />
</svelte:head>

<section>
	<h2>Hello{name},</h2>
</section>

<style>
</style>
