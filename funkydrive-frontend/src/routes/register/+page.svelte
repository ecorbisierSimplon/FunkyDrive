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
			<p>Welcome back, {data.firstName}.</p>
			<p>You have created Successfully your account, please log in!</p>
			<button class="plus" on:click={() => goto('/login')}>Ok</button>
		</div>
	</div>
{:else}
	<section>
		<form method="POST" action="?/register">
			<div class="flex">
				<div class="">
					<label class="form-label">
						First name
						<input
							type="text"
							name="firstName"
							class="form-control {form?.firstNameError != undefined ? 'error' : ''}"
							value={form?.firstName ?? ''}
						/>
						<span class="error">{form?.firstNameError ?? ''}</span>
					</label>
				</div>
				<div class="">
					<label class="form-label">
						Last name
						<input
							type="text"
							name="lastName"
							class="form-control {form?.lastNameError != undefined ? 'error' : ''}"
							value={form?.lastName ?? ''}
						/>
						<span class="error">{form?.lastNameError ?? ''}</span>
					</label>
				</div>
			</div>
			<div>
				<div class="">
					<label class="form-label">
						Email
						<input
							type="email"
							name="email"
							class="form-control {form?.emailError != undefined ? 'error' : ''}"
							value={form?.email ?? ''}
						/>
						<span class="error">{form?.emailError ?? ''}</span>
					</label>
				</div>
			</div>
			<div class="flex">
				<div class="">
					<label class="form-label">
						Password
						<input
							type="password"
							name="password"
							class="form-control {form?.passwordError != undefined ? 'error' : ''}"
							value={form?.password ?? ''}
						/>
						<span class="error">{form?.passwordError ?? ''}</span>
					</label>
				</div>
				<div class="">
					<label class="form-label">
						Confirm password
						<input
							type="password"
							name="passwordValidation"
							class="form-control {form?.passwordValidationError != undefined ||
							form?.passwordError != undefined
								? 'error'
								: ''}"
							value={form?.passwordValidation ?? ''}
						/>
						<span class="error">{form?.passwordValidationError ?? ''}</span>
					</label>
				</div>
			</div>
			{#if data.count == true}
				<div class="flex">
					<div class="">
						<label class="form-label">
							Password first connexion
							<input
								type="password"
								name="pass"
								class="form-control {form?.passError != undefined ? 'error' : ''}"
								value={form?.pass ?? ''}
							/>
							<span class="error">{form?.passError ?? ''}</span>
						</label>
					</div>
					<div></div>
				</div>
			{/if}
			<div class="">
				<span class="error">{form?.messageError ?? ''}</span>
			</div>
			<button class="submit f--right"><i class="fas fa-user-alt"></i> Register</button>
		</form>
	</section>
{/if}

<style lang="scss">
	section {
		display: flex;
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
