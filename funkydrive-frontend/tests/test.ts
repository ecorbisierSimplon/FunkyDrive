import { expect, test } from '@playwright/test';

const url = 'http://localhost:8000/';

test('about page has expected h1', async ({ page }) => {

	// TEST PAGE HOME 
	await page.goto(url);
	await expect(page).toHaveTitle(/Home | Funkydrive/);
	await expect(page.getByRole('heading', { name: 'Hello' })).toBeVisible();
	await page.pause();

	// TEST LOGIN
	await page.goto(url + 'login');
	await expect(page).toHaveTitle(/Login | Funkydrive/);
	await expect(page.getByRole('heading', { name: 'Login' })).toBeVisible();
	const getLogin = page.locator('text=Log in').first();
	await getLogin.click();
	await page.pause();



});
