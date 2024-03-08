<script lang="ts">
	import { onMount } from 'svelte';
	import { session, sessionKey } from './session';
	import { getCookie } from 'typescript-cookie';
	import type { ActionData } from './$types';

	export let data: ActionData;
	let hostname: string = '';
	let logo: string = data.api + '/image/logo.png';

	console.log('Header Adresse url = ' + logo);

	onMount(() => {
		hostname = window.location.origin;
		if (getCookie('session')) {
			session.set(true);
			sessionKey.set(getCookie('session') || '');
		} else {
			session.set(false);
			sessionKey.set('');
		}
	});
</script>

<header>
	<div class="header">
		<div>
			<a href={hostname}>
				<img src={logo} alt="" />
			</a>
		</div>
		<nav class="nav">
			<ul>
				<li><a href="/"><i class="fa fa-home"></i> Home</a></li>
				<li><a href="/drive"><i class="fa fa-clipboard-check"></i> Choice file</a></li>
				{#if $session}
					<li>
						<a href="/create_drive"><i class="fa fa-edit"></i> Create Drive</a>
					</li>
				{/if}
				{#if !$session}
					<li><a href="/register"><i class="far fa-id-card"></i> Register</a></li>
					<li><a href="/login"><i class="fa fa-user-alt"></i> Login</a></li>
				{/if}
				{#if $session}
					<li>
						<a href="/logout"><i class="fa fa-user-alt-slash"></i> Logout</a>
					</li>
				{/if}
			</ul>
		</nav>
	</div>
</header>

<style lang="scss">
	// $mobil-max: 748px;
	// header {
	// 	margin: 10px 20px;
	// 	@media screen and (max-width: $mobil-max) {
	// 		margin: 5px;
	// 		margin-bottom: 15px;
	// 	}
	// 	.header {
	// 		display: flex;
	// 		max-width: 800px;
	// 		justify-content: space-between;
	// 		flex-wrap: nowrap;
	// 		flex-direction: row;
	// 		border: 5.5px solid #73778c;
	// 		border-radius: 15px;
	// 		padding: 15px;
	// 		margin: 0 auto;
	// 		@media screen and (max-width: $mobil-max) {
	// 			padding: 5px;
	// 		}
	// 		.logo {
	// 			display: flex;
	// 			align-items: center;
	// 			margin: auto 10px;
	// 			@media screen and (max-width: $mobil-max) {
	// 				margin: auto 80px;
	// 			}
	// 			img {
	// 				width: 100%;
	// 				min-width: 100px;
	// 				max-width: 400px;
	// 			}
	// 		}
	// 	}
	// }
	// .nav ul {
	// 	margin: 0;
	// }
</style>
