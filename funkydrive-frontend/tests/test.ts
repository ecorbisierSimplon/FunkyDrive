import { expect, test } from '@playwright/test';
const mn: number = 60;
const s: number = 30;

test.describe('Home', () => {
	test('about page has expected home title', async ({ page }) => {
		// TEST PAGE HOME
		await page.goto('');
		await expect(page).toHaveTitle(/Home | Funkydrive/);
	});

	test('about page has expected home h1', async ({ page }) => {
		await page.goto('');
		await expect(page.getByRole('heading', { name: 'Hello' })).toBeVisible();
	});
});

test.describe('Login', () => {
	test('Open page login with nav', async ({ page }) => {
		await page.goto('');
		// await page.getByRole('navigation').getByRole('button').click({ force: true, timeout: time_ms(0,5) });
		await page.waitForTimeout(time_ms(0, 2));
		await page.locator('#navicon__bt').click();
		await page.waitForTimeout(time_ms(0, 2));
		await expect(page.getByRole('navigation').locator('div')).toBeVisible();
		await expect(page.getByRole('link', { name: ' Login' })).toBeVisible();
		await page.getByRole('link', { name: ' Login' }).click();
		await page.waitForTimeout(time_ms(0, 2));
		await expect(page.getByRole('heading')).toContainText('Login');
		await page.waitForTimeout(time_ms(0, 2));
	});

	test('about page has expected login title', async ({ page }) => {
		// TEST LOGIN
		await page.goto('login');
		await expect(page).toHaveTitle(/Login | Funkydrive/);
	});

	test('about page has expected login h1', async ({ page }) => {
		await page.goto('login');
		await expect(page.getByRole('heading', { name: 'Login' })).toBeVisible();
	});

	test('about page has expected button login and inputs blanck', async ({ page }) => {
		await page.goto('login');
		const getLogin = page.locator('text=Log in').first();
		await getLogin.click();
		await expect(page.getByText('Please enter a valid email')).toBeVisible();
		await expect(page.getByText('Password must be at least 7')).toBeVisible();
		await page.waitForTimeout(time_ms(0, 2));
	});
});

function time_ms(minut: number, second: number = -1): number {
	return (minut * mn + (second >= 0 ? second : s)) * 1000;
}
