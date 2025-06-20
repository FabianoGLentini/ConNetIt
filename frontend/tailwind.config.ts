import type { Config } from "tailwindcss";

const config: Config = {
  content: [
    "./app/**/*.{ts,tsx}",
    "./pages/**/*.{ts,tsx}",
    "./components/**/*.{ts,tsx}",
  ],

  theme: {
    extend: {
      colors: {
        backround: "var(--backround)",
        forground: "var(--forground)",
        primary: "var(--primary)",

      },
    },
  },
  plugins: [],
};

export default config;
