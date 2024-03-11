// since there's no dynamic data here, we can prerender
import type { PageServerLoad } from './$types';
import { getWritable } from '$lib/packages/getWritable';
import { API_CLIENT_URL } from '$lib/server/variables';

// it so that it gets served as a static asset in production

export const load: PageServerLoad = () => {
	return { api: getWritable(API_CLIENT_URL) };
};
