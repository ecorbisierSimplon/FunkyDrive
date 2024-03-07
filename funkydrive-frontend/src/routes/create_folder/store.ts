import { writable } from "svelte/store";

export const name = writable('');
export const folderImg = writable('/Users/thibault/Desktop/Today/funkydrive/funkydrive-frontend/img/png-transparent-web-development-logo-website-web-design-symmetry-internet.png');
export const showFolder = writable(false);
export const fileTab = writable<string[]>([]);