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
		<div id="logo" class="logo">
			<a href={hostname}>
				<img src={logo} alt="" />
			</a>
		</div>
		<nav class="nav">
			<input type="checkbox" id="navicon-checkbox" class="navicon__checkbox" />
			<label for="navicon-checkbox" class="navicon__label">
				<span class="navicon__box">
					<span class="navicon__hamburger"></span>
					<span class="navicon__hamburger"></span>
					<span class="navicon__hamburger"></span>
				</span>
			</label>
			<div class="navbar">
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
			</div>
		</nav>
	</div>
</header>

<style lang="scss">
	$mobil-max: 748px;

	header {
		margin: 10px;
		@media screen and (max-width: $mobil-max) {
			margin: 5px;
			margin-bottom: 15px;
		}
		.header {
			// display: flex;
			max-width: 1200px;
			padding: 15px;
			margin: 0 auto;
			@media screen and (max-width: $mobil-max) {
				padding: 5px;
			}
			.logo {
				margin: auto 10px;
				@media screen and (max-width: $mobil-max) {
					margin: auto 20px;
				}
				img {
					width: 100%;
					min-width: 60px;
					max-width: 100px;
					@media screen and (max-width: $mobil-max) {
						width: 80%;
					}
				}
			}
		}
	}
	.nav {
		.navicon {
			&__checkbox {
				opacity: 0;
				position: absolute;
				left: -1000px;
				&:checked {
					& ~ .navicon__label .navicon__box span {
						background-color: hsl(0, 0%, 95%);

						&:first-child,
						&:last-child {
							background-color: hsl(0, 95%, 25%);
							border-bottom: 1px solid hsl(0, 0%, 0%);
							width: 35px;
							left: 1px;
						}

						&:first-child {
							transform: translate3d(6px, 10px, 0) rotate(45deg);
						}

						&:nth-child(2) {
							transform-origin: 0 0;
							transform: translate(-2000px);
							// rotate(-45deg) translate3d(-500px, 100px, 0);
							opacity: 0;
						}

						&:last-child {
							transform: translate3d(5px, -11px, 0) rotate(-45deg);
						}
					}
					& ~ .navbar {
						right: 0px;
						top: 0px;
						box-shadow: 2px 2px 9px 2px hsla(310, 5%, 23%, 0.637);
						width: 260px;
						height: 100vh;
						background-color: hsl(212, 53%, 75%);
						padding: 8px;
					}
				}
			}
			&__label {
				position: absolute;
				box-sizing: content-box;
				right: 15px;
				top: 12px;
				z-index: 999;
				margin: 6px 0 0 0;
				padding: 0 3px 0 2px;
				width: 40px;
				height: 40px;
				border-radius: 5px;
				display: inline-block;
				cursor: pointer;
				transition-property: opacity, filter;
				transition-duration: 0.25s;
				transition-timing-function: linear;
				font: inherit;
				color: inherit;
				text-transform: none;
				background-color: rgba(0, 0, 0, 0);
				border-width: 0 2px 2px 0;
				border-bottom: groove;
				border-right: groove;
				overflow: visible;
				background-color: hsl(212, 72%, 81%);
			}

			&__box {
				span {
					position: relative;
					display: block;
					top: 12px;
					margin-top: -4px;
					width: 30px;
					height: 5px;
					left: 8px;
					border-bottom: 3px solid #000;
					border-radius: 30%;
					position: absolute;
					transition-property: transform;
					transition-duration: 0.25s;
					transition-timing-function: ease;
					&:nth-child(2) {
						content: '';
						top: 22px;
						transition-property: transform, opacity;
						transition-timing-function: ease;
						transition-duration: 2.2s;
					}
					&:last-child {
						content: '';
						top: auto;
						bottom: 6px;
					}
				}
			}
		}
		.navbar {
			position: absolute;
			display: block;
			z-index: 998;
			right: -165px;
			top: 12px;
			overflow: hidden;
			transition: 1.5s all 0s;
			width: 170px;
			height: 50px;
			background-color: #9e0000;
			padding: 0px;
		}
		ul {
			margin: 0;
			list-style: none;
			position: relative;
			top: 90px;
		}
	}
</style>
