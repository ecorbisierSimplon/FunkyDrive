<script lang="ts">
	import { goto } from '$app/navigation';
	import type { PageData, ActionData } from './$types';
	export let data: PageData;
	export let form: ActionData;
	const password_first: boolean = false;
</script>

<h2>Register</h2>
{#if form?.success}
	<div class="modals">
		<div class="">
			<h3>Yous is registered !</h3>
			<p>Welcome back, {data.first_name}.</p>
			<p>You have created Successfully your account, please log in!</p>
			<button class="plus" on:click={() => goto('/login')}>Ok</button>
		</div>
	</div>
{:else}
	<section>
		<form method="POST" action="?/register">
			<div class="flex">
				<div class="mb-1">
					<label class="form-label">
						First name:
						<input type="text" name="first_name" class="form-control" />
						{#if form?.nameError != undefined}
							<span class="error">{form?.nameError}</span>
						{/if}
					</label>
				</div>
				<div class="mb-1">
					<label class="form-label">
						Last name:
						<input type="text" name="sur_name" class="form-control" />
						{#if form?.surnameError != undefined}
							<span class="error">{form?.surnameError}</span>
						{/if}
					</label>
				</div>
			</div>
			<div>
				<div class="mb-1">
					<label class="form-label">
						Email:
						<input type="email" name="email" class="form-control" />
						{#if form?.errorEmail != undefined}
							<span class="error">{form?.errorEmail}</span>
						{/if}
					</label>
				</div>
			</div>
			<div class="flex">
				<div class="mb-1">
					<label class="form-label">
						Password:
						<input type="password" name="password" class="form-control" />
						{#if form?.passwordError != undefined}
							<span class="error">{form?.passwordError}</span>
						{/if}
					</label>
				</div>
				<div class="mb-1">
					<label class="form-label">
						Confirm password:
						<input type="password" name="password_validation" class="form-control" />
						{#if form?.password_validationError != undefined}
							<span class="error">{form?.password_validationError}</span>
						{/if}
					</label>
				</div>
			</div>
			{#if data.count == 0}
				<div class="flex">
					<div class="mb-1">
						<label class="form-label">
							Password first connexion:
							<input type="password" name="password_first" class="form-control" />
							{#if form?.passwordFirstError != undefined}
								<span class="error">{form?.passwordFirstError}</span>
							{/if}
						</label>
					</div>
					<div></div>
				</div>
			{/if}
			<div class="mb-1">
				{#if form?.messageError != undefined}
					<span class="error">{form?.messageError}</span>
				{/if}
			</div>
			<button>Register</button>
		</form>
	</section>
{/if}

<style lang="scss">
	section {
		display: flex;
	}
	form {
		width: 500px;
		position: relative;
		margin: auto;
		padding: 30px;
		border-radius: 20px;
		background-color: hsl(204, 100%, 95%);
		box-shadow:
			0px 0px 5px 0px hsl(204, 100%, 95%),
			4px 4px 8px hsl(208 25% 43% / 1);
	}
	.error {
		color: red;
		font-size: 0.8rem;
	}
	label {
		width: 100%;
	}
	form {
		& > div {
			& > div {
				margin-right: 10px;
				min-width: 300px;
			}
		}
	}
	.flex {
		display: flex;
		flex-direction: row;
		flex-wrap: wrap;
		justify-content: space-between;
		& > div {
			flex: 1;
		}
	}
</style>
