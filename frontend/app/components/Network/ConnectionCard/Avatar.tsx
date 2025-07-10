import React from "react";

interface Sizing {
  width: string;
}

export const Avatar = ({ width = "w-20" }: Sizing) => {
  return (
    <div className="avatar">
      <div className={`${width} rounded-full border-2  bg-gray-200`}>
        <svg
          viewBox="0 0 176 176"
          fill="none"
          xmlns="http://www.w3.org/2000/svg"
        >
          <path
            d="M32.4922 156.289C37.2544 132.853 60.2947 115.077 88 115.077C115.705 115.077 138.746 132.853 143.508 156.289C128.365 168.612 109.045 176 88 176C66.9547 176 47.6348 168.612 32.4922 156.289Z"
            fill="#8E9EB8"
          />
          <path
            d="M115.077 76.1538C115.077 91.4196 102.702 103.795 87.4359 103.795C72.1702 103.795 59.7949 91.4196 59.7949 76.1538C59.7949 60.8881 72.1702 48.5128 87.4359 48.5128C102.702 48.5128 115.077 60.8881 115.077 76.1538Z"
            fill="#8E9EB8"
          />
        </svg>
      </div>
    </div>
  );
};
