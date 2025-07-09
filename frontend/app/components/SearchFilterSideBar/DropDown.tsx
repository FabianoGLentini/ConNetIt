import React, { useState } from "react";

const DropDown = () => {
  const [accordionOpen, setAccordionOpen] = useState(false);
  return (
    <div>
      <button
        onClick={() => setAccordionOpen(!accordionOpen)}
        className="flex justify-between w-ful h-fit cursor-pointer"
      >
        <span>Filter Section TMP</span>
        {accordionOpen ? <span>tmp -</span> : <span>tmp +</span>}
      </button>

      <ul
        className={`grid overflow-hidden transition-all duration-300 ease-in-out ${
          accordionOpen ? "visible" : "collapse max-height h-0"
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
