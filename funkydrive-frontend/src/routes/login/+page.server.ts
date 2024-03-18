import { fail } from '@sveltejs/kit';
import type { Actions, PageServerLoad } from './$types';
import { session } from '../session';
import { getCookie } from 'typescript-cookie';
import { ValidateForm } from '$lib/packages/Pattern';

const API_URL = process.env.API_URL;

export const load: PageServerLoad = async ({ cookies }) => {
	const userString = cookies.get('user');
	const sessionid = cookies.get('sessionid');
	if (userString) {
		const users: { first_name: string; sur_name: string } = JSON.parse(userString).user;
		if (users && users.first_name) {
			const firstName: string = users.first_name as string;
			const surName: string = users.sur_name as string;
			const remember: string = JSON.parse(userString).remember;
			console.log(JSON.parse(userString));
			return { firstName, surName, login: true, sessionid, remember };
		} else {
			// Gérez le cas où la propriété `last_name` n'est pas définie ou si l'objet `users` est null/undefined
			console.error("Erreur: Impossible d'obtenir le nom de l'utilisateur.");
			return { user: null, login: false }; // ou un autre traitement approprié
		}
	} else {
		// Gérez le cas où userString est undefined
		console.error("Erreur: La chaîne d'utilisateur est undefined.");
		return { user: null, login: false }; // ou un autre traitement approprié
	}
}

export const actions = {
	login: async ({ cookies, request }) => {
		const data = await request.formData();
		const formData = await Object.fromEntries(data);
		const email: string = formData.email as string;
		const password: string = formData.password as string;
		const remember: string = formData.remember as string;


		let codes: number = 201;
		let messagesError = formData;
		let testInput: string | null = null;

		testInput = ValidateForm.validateEmail(email.toString());
		if (testInput) {
			codes = 400;
			messagesError = { ...messagesError, emailError: testInput };
		}

		testInput = ValidateForm.validatePassword(password.toString());
		if (testInput) {
			codes = 400;
			messagesError = { ...messagesError, passwordError: testInput };
		}

		if (codes === 400) {
			return fail(codes, messagesError);
		}

		const tempResponse = await fetch(`${API_URL}/users/email/${email}`);
		const responses = await tempResponse.json();
		try {
			const response: string = responses.user.email;
			if (response === undefined) {
				return fail(400, {
					email,
					missing: true,
					errorEmail: 'Password and/or email is invalid !'
				});
			}
		} catch (error) {
			return fail(400, { email, missing: true, errorEmail: 'Password and/or email is invalid !' });
		}

		const user = (await fetch(`${API_URL}/user/email/${email}`)).json();
		const userRemember = { ...(await user), remember };
		const userString = JSON.stringify(await userRemember);
		cookies.set('user', userString, { path: '/' });



		try {
			// Faites une requête d'authentification au backend (par exemple, avec fetch ou axios)
			const response = await fetch(`${API_URL}/auth/login`, {
				method: 'POST',
				headers: { 'Content-Type': 'application/json' },
				body: JSON.stringify({ email, password })
			});
			const token = await response.json();
			console.log(token);
			if (token.access_token) {
				cookies.set('sessionid', token.access_token, { path: '/' });
				// cookies.set('remember')
				session.set(false);
				const userString = JSON.stringify(await userRemember);
				cookies.set('user', userString, { path: '/' });
				return { success: true };
			}

			return null;
		} catch (error) {
			console.error('Error during login:', error);
			return null;
		}
	}
} satisfies Actions;

export function _getToken(): string | null {
	getCookie('user');
	return localStorage.getItem('token');
}
