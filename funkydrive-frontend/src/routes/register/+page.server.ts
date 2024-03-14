import { fail } from '@sveltejs/kit';
import { ValidateForm } from '$lib/packages/Pattern';
import type { PageServerLoad, Actions } from './$types';
import { API_URL } from '$lib/server/variables';
import { getWritable } from '$lib/packages/getWritable';

export const load: PageServerLoad = async ({ cookies }) => {
	const api = getWritable(API_URL);
	const tempResponse = await fetch(`${api}/user/count`, {
		method: 'GET'
	});
	const responses = await tempResponse.json();
	return { firstName: cookies.get('userName'), count: responses.count };
};
export const actions = {
	register: async ({ request, cookies }) => {
		const data = await request.formData();
		const formData = await Object.fromEntries(data);
		const firstName = formData.firstName;
		const surName = formData.surName;
		const email = formData.email;
		const password = formData.password;
		const passwordValidation = formData.passwordValidation;
		const pass = formData.pass;
		const api = getWritable(API_URL);
		const countResponse = await fetch(`${api}/users/count`, {
			method: 'GET'
		});
		const count = await countResponse.json();
		console
		let codes: number = 201;
		let messagesError = {};
		let testInput: string | null = null;

		testInput = ValidateForm.validateField(firstName.toString(), 'firstname');
		if (testInput) {
			codes = 400;
			messagesError = { ...messagesError, nameError: testInput };
		}

		testInput = ValidateForm.validateField(surName.toString(), 'lastname');
		if (testInput) {
			codes = 400;
			messagesError = { ...messagesError, surnameError: testInput };
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
			if (testInput && count.count === true) {
				codes = 400;
				messagesError = {
					...messagesError,
					passwordFirstError: testInput
				};
			}
		} catch (error) {}

		if (codes === 400) {
			return fail(codes, messagesError);
		}
		const tempResponse = await fetch(`${api}/users/register`, {
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
