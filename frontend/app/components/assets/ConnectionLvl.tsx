import React from "react";

export const ConnectionLvl = () => {
  return (
    <div className=" flex gap-1 w-fit h-fit mb-1.5">
      {[1, 2, 3, 4, 5].map((n) => (
        <Star key={n} filled={n <= 3} />
      ))}
    </div>
  );
};

// TODO add sizing adjustments based on container size or set sizing..?
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
