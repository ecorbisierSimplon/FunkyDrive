import { devices, PlaywrightTestConfig } from '@playwright/test';

const config: PlaywrightTestConfig = {

	projects: [
		{ name: 'chronium', use: { ...devices['desktop Chrome'] } },
		// { name: 'firefox', use: { ...devices['desktop Firefox'] } },
		// { name: 'webkit', use: { ...devices['desktop Safari'] } },
	],
	retries: 2,
	use: {
		baseURL: 'http://localhost:8000/',
		trace: 'on-first-retry',
	},
	testDir: 'tests',
	testMatch: /(.+\.)?(test|spec)\.[jt]s/,
	timeout: (0 * 60 + 25) * 1000
};

export default config;
