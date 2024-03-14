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
						First name
						<input type="text" name="firstName" class="form-control" />
						{#if form?.firstNameError != undefined}
							<span class="error">{form?.firstNameError}</span>
						{/if}
					</label>
				</div>
				<div class="mb-1">
					<label class="form-label">
						Last name
						<input type="text" name="lastName" class="form-control" />
						{#if form?.lastNameError != undefined}
							<span class="error">{form?.lastNameError}</span>
						{/if}
					</label>
				</div>
			</div>
			<div>
				<div class="mb-1">
					<label class="form-label">
						Email
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
						Password
						<input type="password" name="password" class="form-control" />
						{#if form?.passwordError != undefined}
							<span class="error">{form?.passwordError}</span>
						{/if}
					</label>
				</div>
				<div class="mb-1">
					<label class="form-label">
						Confirm password
						<input type="password" name="passwordValidation" class="form-control" />
						{#if form?.passwordValidationError != undefined}
							<span class="error">{form?.passwordValidationError}</span>
						{/if}
					</label>
				</div>
			</div>
			{#if data.count == true}
				<div class="flex">
					<div class="mb-1">
						<label class="form-label">
							Password first connexion
							<input type="password" name="pass" class="form-control" />
							{#if form?.passError != undefined}
								<span class="error">{form?.passError}</span>
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
			<button class="submit f--right"><i class="fas fa-user-alt"></i> Register</button>
		</form>
	</section>
{/if}

<style lang="scss">
	section {
		display: flex;
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
