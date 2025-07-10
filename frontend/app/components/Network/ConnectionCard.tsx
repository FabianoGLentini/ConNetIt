import React from "react";
import { Avatar } from "./ConnectionCard/Avatar";
import { ConnectionLvl } from "../assets/ConnectionLvl";
// TODO add props var
export default function ConnectionCard() {
  return (
    // TODO add hoever effect but maybe on ul instead?
    <div className="list-row  shadow-md">
      <div className="flex flex-col">
        {/* Main row ─────────────────────────────────────────────── */}
        <div className="flex justify-between h-fill w-fill">
          {/* Left col */}
          <div className="flex flex-row gap-4 mb-6">
            <Avatar width="w-20" />
            <ul>
              <h3 className="font-semibold text-lg leading-tight">
                Generic Name
              </h3>
              <li>
                <span className="text-sm ">Company: Name</span>
              </li>
              <li>
                <span className="text-sm">Job-Title: Name</span>
              </li>
            </ul>
          </div>
          {/* Right col  */}
          <div className="flex flex-col gap h-full justify-between">
            <button
              aria-label="Open profile"
              className="text-[#6A9BE4] hover:text-[#3C79D5] w-fit h-fit place-self-end"
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
            {/* rating row ──────────────────────────────────────────── */}
            {/* TODO rework rating system this is tmp visual */}
            <ConnectionLvl />
          </div>
        </div>
        {/* tags row ───────────────────────────────────────────── */}
        <div className="relative max-w-full overflow-hidden">
          <div className="overflow-hidden whitespace-nowrap flex gap-2 w-full">
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
          {/* TODO refine fade out tag fx */}
          {/* tags fade out fx */}
          <div className="absolute right-0 top-0 h-full w-8 bg-gradient-to-l from-white to-transparent pointer-events-none" />
        </div>
      </div>
    </div>
  );
}
