import { fail } from '@sveltejs/kit';
import { ValidateForm } from '$lib/packages/Pattern';
import type { PageServerLoad, Actions } from './$types';
import { API_URL } from '$lib/server/variables';
import { getWritable } from '$lib/packages/getWritable';

export const load: PageServerLoad = async ({ cookies }) => {
	const api = getWritable(API_URL);
	const tempResponse = await fetch(`${api}/users/count`, {
		method: 'GET'
	});
	const responses = await tempResponse.json();
	console.log(responses);
	return { firstName: cookies.get('userName'), count: responses };
};
export const actions = {
	register: async ({ request, cookies }) => {
		const data = await request.formData();
		const formData = await Object.fromEntries(data);
		const firstName = formData.firstName;
		const lastName = formData.lastName;
		const email = formData.email;
		const password = formData.password;
		const passwordValidation = formData.passwordValidation;
		const pass = formData.pass;
		const api = getWritable(API_URL);
		const countResponse = await fetch(`${api}/users/count`, {
			method: 'GET'
		});
		const count = await countResponse.json();
		console.log(count);
		let codes: number = 201;
		let messagesError = formData;
		let testInput: string | null = null;

		testInput = ValidateForm.validateField(firstName.toString(), 'first name');
		if (testInput) {
			codes = 400;
			messagesError = { ...messagesError, firstNameError: testInput };
		}

		testInput = ValidateForm.validateField(lastName.toString(), 'last name');
		if (testInput) {
			codes = 400;
			messagesError = { ...messagesError, lastNameError: testInput };
		}

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

		if (password.toString() != passwordValidation.toString()) {
			codes = 400;
			messagesError = {
				...messagesError,
				passwordValidationError: "The passwords isn't identical!"
			};
		}
		try {
			testInput = ValidateForm.validatePassword(pass.toString());
			if (testInput && count === true) {
				codes = 400;
				messagesError = {
					...messagesError,
					passError: testInput
				};
			}
		} catch (error) {
			return fail(codes, messagesError);
		}

		if (codes === 400) {
			return fail(codes, messagesError);
		}
		const tempResponse = await fetch(`${api}/users`, {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(formData)
		});

		const responses = await tempResponse.json();
		try {
			if (responses.statusCode != 201) {
				return fail(400, { missing: true, messageError: responses.message });
			}
		} catch (error) {
			return fail(400, { missing: true, messageError: 'A field does not completed !' });
		}
		cookies.set('userName', firstName as string, { path: '/' });
		return { success: true };
	}
} satisfies Actions;
