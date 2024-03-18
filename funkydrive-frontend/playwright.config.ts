import type { PlaywrightTestConfig } from '@playwright/test';

const config: PlaywrightTestConfig = {
	// webServer: {
	// 	command: 'npm run build && npm run preview',
	// 	port: 4173
	// },
	use: {
		baseURL: 'http://localhost:8000/',
	  },
	testDir: 'tests',
	testMatch: /(.+\.)?(test|spec)\.[jt]s/,
	timeout: ((0 * 60 ) + (25)) * 1000,
};

export default config;
