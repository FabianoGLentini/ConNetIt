import React from "react";

export default function FilterSidebar() {
  return (
    <aside className="w-64 min-h-screen bg-base-200 border-r border-base-300 p-4 flex flex-col justify-between">
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

      {/* Connection Level Rating */}
      <div className="text-center mb-2">
        <h3 className="font-bold mb-2">Connection LVL</h3>
        <div className="flex justify-center gap-1">
          {Array.from({ length: 5 }).map((_, i) => (
            <svg
              key={i}
              xmlns="http://www.w3.org/2000/svg"
              fill="none"
              viewBox="0 0 24 24"
              stroke="currentColor"
              className="w-5 h-5 text-base-300"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth={2}
                d="M11.049 2.927c.3-.921 1.603-.921 1.902 0l1.518 4.674a1 1 0 00.95.69h4.915c.969 0 1.371 1.24.588 1.81l-3.978 2.89a1 1 0 00-.364 1.118l1.518 4.674c.3.921-.755 1.688-1.538 1.118l-3.978-2.89a1 1 0 00-1.175 0l-3.978 2.89c-.783.57-1.838-.197-1.538-1.118l1.518-4.674a1 1 0 00-.364-1.118L2.67 10.1c-.783-.57-.38-1.81.588-1.81h4.915a1 1 0 00.95-.69l1.518-4.674z"
              />
            </svg>
          ))}
        </div>
      </div>
    </aside>
  );
}
