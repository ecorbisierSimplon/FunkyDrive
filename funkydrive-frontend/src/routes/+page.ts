// since there's no dynamic data here, we can prerender

import { getWritable } from '$lib/packages/getWritable';
import { API_URL } from '$lib/packages/variables';

// it so that it gets served as a static asset in production
export const prerender = true;

export async function load() {
	// console.log('Adresse url = ' + getWritable(API_URL));
	return { api: getWritable(API_URL) };
}
