import { fileURLToPath } from 'url'; // Required for resolving absolute paths
import { defineNuxtConfig } from 'nuxt/config';
import path from 'path';

export default defineNuxtConfig({
  compatibilityDate: '2025-07-15',
  devtools: { enabled: true },

  devServer: {
    port: 8000,
  },

  routeRules: {
    '/**': {
      headers: {
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Methods': 'GET,HEAD,PUT,PATCH,POST,DELETE,OPTIONS',
        'Access-Control-Allow-Headers': 'Content-Type, Authorization', 
      },
    },
  },

  modules: ['@nuxtjs/tailwindcss', '@nuxt/test-utils'],

  telemetry: false,

  runtimeConfig: {
    dbFile : './lotto.sqlite.db',
    public : {

    }
  },

  alias : {
    '#server': fileURLToPath(new URL('./server', import.meta.url)),
    '@styles': path.resolve(__dirname, './app/assets/styles'),
  },
  nitro: {
    alias: {
      '#server': fileURLToPath(new URL('./server', import.meta.url)),
    },
    typescript: {
      tsConfig: {
        compilerOptions: {
          paths: {
            '#server': [
              fileURLToPath(new URL('./server', import.meta.url)),
            ],
            '#server/*': [
              fileURLToPath(new URL('./server', import.meta.url)) + '/*',
            ],
          },
        },
      },
    },
  },
  vite: {
    css: {
      preprocessorOptions: {
        scss: {
          //additionalData: `@import "~/assets/scss/global-variables.scss";`,
        },
      },
    },
  },
})