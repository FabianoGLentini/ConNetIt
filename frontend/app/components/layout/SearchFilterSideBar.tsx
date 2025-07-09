"use client";
import React from "react";
import DropDown from "../SearchFilterSideBar/DropDown";

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
        {/* <span>Company</span> */}
        <DropDown />
        {/* <span>Hobbies</span> */}
        <DropDown />
        {/* Tag Pills */}
        <div className="flex flex-wrap gap-2">
          {Array.from({ length: 9 }).map((_, i) => (
            <div
              key={i}
              className="bg-base-100 px-4 py-1 rounded-full text-sm text-base-content"
            >
              Hobby 01
            </div>
          ))}
        </div>
      </div>
    </aside>
  );
}
