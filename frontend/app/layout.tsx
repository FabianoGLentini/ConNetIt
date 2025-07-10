import type { Metadata } from "next";
import "./globals.css";
import { Inter } from "next/font/google";
const inter = Inter({ subsets: ["latin"] });

export const metadata: Metadata = {
  title: "ConNetIt",
  description:
    "ConNetIt helps you organize and remember your network with searchable tags, notes, and connection insights, all in a clean, user-friendly interface.",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en" data-theme="connetit">
      <body
        className={`${inter.className} antialiased h-screen overflow-hidden flex flex-col bg-base-100 `}
      >
        <main className="flex-1 overflow-hidden">{children}</main>
      </body>
    </html>
  );
}
