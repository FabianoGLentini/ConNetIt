import React, { useState } from "react";

const DropDown = () => {
  const [accordionOpen, setAccordionOpen] = useState(false);
  return (
    <div className="py-2">
      <button
        onClick={() => setAccordionOpen(!accordionOpen)}
        className="fex justify-between w-full"
      >
        <span>Filter Section TMP</span>
        {accordionOpen ? <span>tmp +</span> : <span>tmp -</span>}
      </button>

      <div
        className={`grid overflow-hidden transition-all duration-300 ease-in-out ${
          accordionOpen
            ? "grid-rows-[1fr] opacity-100"
            : "grid-row-0fr opacity-0"
        }`}
      >
        <div className="overflow-hidden py-2">Inside view</div>
      </div>
    </div>
  );
};

export default DropDown;
