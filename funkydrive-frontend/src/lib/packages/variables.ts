import { writable } from 'svelte/store';
import { getWritable } from './getWritable';
export const secureCookie: boolean = false;

export const API_URL = writable<string>(process.env.API_URL);
console.log(getWritable(API_URL));
