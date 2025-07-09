import React, { useState } from "react";
import { FilterOption } from "@/app/types/filters";

interface DropDownFilterProps {
  title: string;
  options: FilterOption[];
}

const DropDownFilter = ({ title, options }: DropDownFilterProps) => {
  const [accordionOpen, setAccordionOpen] = useState(false);
  return (
    <div>
      <button
        onClick={() => setAccordionOpen(!accordionOpen)}
        className="flex justify-between w-full h-fit cursor-pointer align-baseline"
      >
        <span>{title}</span>
        <span
          className={` transition-all flex justify-center ${accordionOpen ? "rotate-90" : ""}`}
        >
          <svg
            width="8"
            viewBox="0 0 11 19"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              d="M1.85324 16.6636L9.03153 9.48531L1.85324 2.30702"
              stroke="#333333"
              stroke-width="3"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
          </svg>
        </span>
      </button>

      {/* TODO transition max-h- may cause issues as we add more and more companies, might need to set up scroll style if to much? */}
      <ul
        className={`grid overflow-hidden transition-all duration-200  ${
          accordionOpen
            ? "visible opacity-100 max-h-40 ease-in"
            : "invisible max-h-0 opacity-0 ease-out"
        }`}
      >
        {options.map((option, i) => (
          <li key={i}>
            <button>{option.label}</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default DropDownFilter;
