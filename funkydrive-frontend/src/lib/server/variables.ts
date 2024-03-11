import { writable } from 'svelte/store';
export const secureCookie: boolean = false;

export const API_URL = writable<string>(process.env.API_DOCKER_URL);
export const API_CLIENT_URL = writable<string>(process.env.API_CLIENT_URL);
