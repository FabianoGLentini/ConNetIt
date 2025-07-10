import React from "react";
import { Avatar } from "../Network/ConnectionCard/Avatar";
// import { FaStar, FaRegStar } from "react-icons/fa";
// import { FiEdit2, FiPlus } from "react-icons/fi";

const hobbies = ["Hobby 01", "Hobby 01", "Hobby 01", "Hobby 01", "Hobby 01"];
// const stars = [true, true, true, false, false];

const ConnectionDisplayBar = () => {
  return (
    <div className="w-full min-h-screen border-l-4 p-4 shadow-sm border-base-300 bg-base-100 space-y-4">
      {/* Edit icon */}
      <div className="flex justify-end">
        {/* <FiEdit2 className="text-blue-300 text-xl" /> */}
      </div>

      <div className="flex justify-center">
        <Avatar width="w-40" />
      </div>

      {/* Name + Rating */}
      <div className="text-center">
        <h2 className="font-bold text-lg">Generic Name</h2>
        <span>star tmp</span>
      </div>

      {/* Company & Job */}
      <div className="flex justify-center gap-4 text-sm text-gray-600">
        <span>Company Name</span>
        <span>Job Title Name</span>
      </div>

      {/* Hobbies + Add */}
      <div>
        <div className="flex justify-between items-center mb-2">
          <h3 className="font-bold">Hobbies and Tags</h3>
          {/* <FiPlus className="text-blue-300 text-lg" /> */}
        </div>
        <div className="flex flex-wrap gap-2">
          {hobbies.map((hobby, idx) => (
            <span
              key={idx}
              className="bg-blue-100 px-3 py-1 rounded-full text-sm text-gray-700"
            >
              {hobby}
            </span>
          ))}
        </div>
      </div>

      {/* We Met Section */}
      <div>
        <div className="flex justify-between items-center">
          <h4 className="font-bold">We Met:</h4>
          {/* <FiEdit2 className="text-blue-300" /> */}
        </div>
        <p className="bg-blue-100 p-3 mt-1 text-sm rounded-lg text-gray-700">
          It is a long established fact that a reader will be distracted by the
          readable content of a page when looking at its layout. The point of
          using Lorem Ipsum is that it has a more-or-less normal distribution of
          letters...
        </p>
      </div>

      {/* Notes Section */}
      <div>
        <div className="flex justify-between items-center">
          <h4 className="font-bold">Notes:</h4>
          {/* <FiEdit2 className="text-blue-300" /> */}
        </div>
        <div className="bg-blue-100 p-3 mt-1 text-sm rounded-lg text-gray-700 space-y-1">
          <p>It is a long established fact that a reader will be:</p>
          <ul className="list-disc ml-5">
            <li>
              Distracted by the readable content of a page when looking at its
              layout.
            </li>
            <li>
              The point of using Lorem Ipsum is that it has a more-or-less
              normal distribution of letters.
            </li>
          </ul>
        </div>
      </div>
    </div>
  );
};

export default ConnectionDisplayBar;
