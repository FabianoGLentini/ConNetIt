import React from "react";
import { Avatar } from "./ConnectionCard/Avatar";
// TODO add props var
export default function ConnectionCard() {
  return (
    <div className="--border rounded-box border-[#C4CBDC]/60 bg-white shadow-sm px-6 py-4">
      {/* top row ─────────────────────────────────────────────── */}
      <div className="flex items-start gap-4">
        <Avatar />

        <ul className="justify-center items-center">
          <h3 className="font-semibold text-lg leading-tight">Generic Name</h3>

          <li>
            <span className="text-sm ">Company: Name</span>
          </li>
          <li>
            <span className="text-sm">Job-Title: Name</span>
          </li>
        </ul>

        {/* external-link icon */}
        <button
          aria-label="Open profile"
          className="text-[#6A9BE4] hover:text-[#3C79D5]"
        >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            className="h-5 w-5"
            fill="none"
            viewBox="0 0 24 24"
            stroke="currentColor"
            strokeWidth="2"
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              d="M14 3h7v7m0-7L10 14m-1 7h-7v-7"
            />
          </svg>
        </button>
      </div>

      {/* rating row ──────────────────────────────────────────── */}
      <div className="mt-2 flex gap-1">
        {[1, 2, 3, 4, 5].map((n) => (
          <Star key={n} filled={n <= 3} />
        ))}
      </div>

      {/* tags row ───────────────────────────────────────────── */}

      <div className="relative max-w-full overflow-hidden">
        <div className="mt-3 overflow-hidden whitespace-nowrap flex gap-2 w-full">
          {["Hobby 01", "Hobby 01", "Hobby 01", "Hobby", "H", "H", "H"].map(
            (tag) => (
              <span
                key={tag + Math.random()}
                className="bg-primary text-primary-content px-2 py-1 rounded-full inline-block"
              >
                {tag}
              </span>
            )
          )}
        </div>
        <div className="absolute right-0 top-0 h-full w-8 bg-gradient-to-l from-white to-transparent pointer-events-none" />
      </div>
    </div>
  );
}

/* helper star component */
function Star({ filled }: { filled: boolean }) {
  return (
    <svg
      xmlns="http://www.w3.org/2000/svg"
      className="h-5 w-5"
      viewBox="0 0 20 20"
      fill={filled ? "#3C79D5" : "none"}
      stroke={filled ? "#3C79D5" : "#C4CBDC"}
    >
      <path
        strokeLinecap="round"
        strokeLinejoin="round"
        strokeWidth="1.5"
        d="M10 2.5l2.47 5.01 5.53.8-4 3.9.94 5.49L10 15.1l-4.94 2.6.94-5.49-4-3.9 5.53-.8L10 2.5z"
      />
    </svg>
  );
}
