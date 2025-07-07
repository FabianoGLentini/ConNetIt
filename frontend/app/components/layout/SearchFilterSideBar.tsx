import React from "react";

export default function FilterSidebar() {
  return (
    <aside className="bg-base-200 border-r border-base-300 p-4 flex flex-col justify-between">
      {/* Top Logo + Search */}
      <div>
        <h1 className="text-3xl font-bold text-primary mb-6">ConNetIt</h1>

        <input
          type="text"
          placeholder="Search"
          className="input input-bordered w-full rounded-full bg-base-100 mb-6"
        />

        {/* Filters */}
        <h2 className="font-bold mb-2">Filters:</h2>
        <div className="flex flex-col gap-2 mb-4">
          <div className="flex justify-between items-center cursor-pointer">
            <span>Company</span>
          </div>
          <div className="flex justify-between items-center cursor-pointer">
            <span>Hobbies</span>
          </div>
        </div>

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
