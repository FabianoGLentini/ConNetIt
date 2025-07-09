import React, { useState } from "react";

const DropDown = () => {
  const [accordionOpen, setAccordionOpen] = useState(false);
  return (
    <div>
      <button
        onClick={() => setAccordionOpen(!accordionOpen)}
        className="flex justify-between w-full h-fit cursor-pointer align-baseline"
      >
        <span>Filter Section TMP</span>
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

        {/* {accordionOpen ? (
          <span>tmp -</span>
        ) : (
          <span className="flex justify-center">
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
        )} */}
      </button>

      <ul
        className={`grid overflow-hidden transition-all duration-500 ease-in-out ${
          accordionOpen
            ? "visible opacity-100 h-fit"
            : "invisible max-height h-0 opacity-0"
        }`}
      >
        <li className="overflow-hidden">Inside view</li>
        <li className="overflow-hidden">Inside view</li>
        <li className="overflow-hidden">Inside view</li>
      </ul>
    </div>
  );
};

export default DropDown;
