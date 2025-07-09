"use client";
import React from "react";
import DropDownFilter from "../SearchFilterSideBar/DropDown";
// import { FilterOption } from "@/app/types/filters";

export default function SearchFilterSideBar() {
  return (
    <aside className="border-r-4 bg-base-200 border-base-300 p-4 flex flex-col items-center">
      {/* TODO adjust html for logo for better simantic img */}
      <h1 className="text-3xl font-bold text-primary mb-6 w-fit">ConNetIt</h1>

      <input
        type="text"
        placeholder="Search"
        className="input input-bordered w-full rounded-full bg-base-100 mb-6"
      />

      <div className="flex flex-col w-full gap-2 p-1">
        {/* Filters */}
        <h2 className="font-bold w-fill mb-2">Filters:</h2>

        <DropDownFilter
          title="Company"
          options={
            // TODO use propper backend fn for getting arr

            Array.from({ length: 9 }).map((_, i) => ({
              label: `Fill tmp 0${i}`,
              value: "tmp val",
              onClick: () => console.log("tmp"),
            }))
          }
        />
        <DropDownFilter
          title="Job Title"
          options={
            // TODO use propper backend fn for getting arr

            Array.from({ length: 6 }).map((_, i) => ({
              label: `Fill tmp 0${i}`,
              value: "tmp val",
              onClick: () => console.log("tmp"),
            }))
          }
        />

        <DropDownFilter
          title="Hobbies"
          options={
            // TODO use propper backend fn for getting arr

            Array.from({ length: 20 }).map((_, i) => ({
              label: `Fill tmp 0${i}`,
              value: "tmp val",
              onClick: () => console.log("tmp"),
            }))
          }
        />
      </div>
    </aside>
  );
}
