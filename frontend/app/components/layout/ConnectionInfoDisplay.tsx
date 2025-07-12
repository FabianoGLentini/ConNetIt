import React from "react";
import { Avatar } from "../Network/ConnectionCard/Avatar";
import { ConnectionLvl } from "../assets/ConnectionLvl";
// import { FaStar, FaRegStar } from "react-icons/fa";
// import { FiEdit2, FiPlus } from "react-icons/fi";

const hobbies = ["Hobby 01", "Hobby 01", "Hobby 01", "Hobby 01", "Hobby 01"];
// const stars = [true, true, true, false, false];

const ConnectionDisplayBar = () => {
  return (
    <div className="w-full min-h-screen border-l-4 p-4 shadow-sm border-base-300 bg-base-100 space-y-4">
      {/* Edit icon */}
      <div className="flex justify-end">
        {/* TODO edit option refine */}
        <svg
          width="31"
          height="31"
          viewBox="0 0 31 31"
          fill="none"
          xmlns="http://www.w3.org/2000/svg"
        >
          <path
            fill-rule="evenodd"
            clip-rule="evenodd"
            d="M19.7922 1.35037C21.5927 -0.450121 24.5118 -0.450125 26.3123 1.35037L29.6496 4.68768C31.4501 6.48817 31.4501 9.40735 29.6496 11.2078L17.9917 22.8658C17.7035 23.154 17.3126 23.3159 16.905 23.3159H9.2209C8.37214 23.3159 7.68408 22.6279 7.68408 21.7791V14.095C7.68408 13.6874 7.84599 13.2965 8.1342 13.0083L19.7922 1.35037ZM24.1389 3.52375C23.5388 2.92359 22.5657 2.92359 21.9655 3.52376L20.6152 4.87412L26.1259 10.3848L27.4762 9.03445C28.0764 8.43428 28.0764 7.46123 27.4762 6.86107L24.1389 3.52375ZM23.9525 12.5582L18.4418 7.04751L10.7577 14.7316V20.2423H16.2684L23.9525 12.5582ZM7.68408 3.33731C5.1378 3.33731 3.07363 5.40148 3.07363 7.94776V23.3159C3.07363 25.8622 5.1378 27.9264 7.68408 27.9264H23.0522C25.5985 27.9264 27.6627 25.8622 27.6627 23.3159V18.7055C27.6627 17.8567 28.3507 17.1687 29.1995 17.1687C30.0483 17.1687 30.7363 17.8567 30.7363 18.7055V23.3159C30.7363 27.5597 27.296 31 23.0522 31H7.68408C3.44028 31 0 27.5597 0 23.3159V7.94776C0 3.70396 3.44028 0.263675 7.68408 0.263675H12.2945C13.1433 0.263675 13.8313 0.951732 13.8313 1.80049C13.8313 2.64925 13.1433 3.33731 12.2945 3.33731H7.68408Z"
            fill="#6A9BE4"
          />
        </svg>
      </div>

      <div className="flex justify-center">
        <Avatar width="w-40" />
      </div>

      {/* Name + Rating */}
      <div className="text-center flex flex-col items-center">
        <h2 className="font-bold text-lg">Generic Name</h2>
        <ConnectionLvl />
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
          {/* TODO edit option refine */}
          <svg
            width="26"
            height="26"
            viewBox="0 0 26 26"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              fill-rule="evenodd"
              clip-rule="evenodd"
              d="M5.6047 5.6047C6.14266 2.6999 8.68942 0.5 11.75 0.5H19.25C22.7018 0.5 25.5 3.29822 25.5 6.75V14.25C25.5 17.3106 23.3001 19.8573 20.3953 20.3953C19.8573 23.3001 17.3106 25.5 14.25 25.5H6.75C3.29822 25.5 0.5 22.7018 0.5 19.25V11.75C0.5 8.68942 2.6999 6.14266 5.6047 5.6047ZM8.21338 5.5H14.25C17.7018 5.5 20.5 8.29822 20.5 11.75V17.7866C21.9565 17.2718 23 15.8828 23 14.25V6.75C23 4.67893 21.3211 3 19.25 3H11.75C10.1172 3 8.72818 4.04351 8.21338 5.5ZM6.75 8C4.67893 8 3 9.67893 3 11.75V19.25C3 21.3211 4.67893 23 6.75 23H14.25C16.3211 23 18 21.3211 18 19.25V11.75C18 9.67893 16.3211 8 14.25 8H6.75ZM10.5 10.5C11.1904 10.5 11.75 11.0596 11.75 11.75V14.25H14.25C14.9404 14.25 15.5 14.8096 15.5 15.5C15.5 16.1904 14.9404 16.75 14.25 16.75H11.75V19.25C11.75 19.9404 11.1904 20.5 10.5 20.5C9.80964 20.5 9.25 19.9404 9.25 19.25V16.75H6.75C6.05964 16.75 5.5 16.1904 5.5 15.5C5.5 14.8096 6.05964 14.25 6.75 14.25H9.25V11.75C9.25 11.0596 9.80964 10.5 10.5 10.5Z"
              fill="#6A9BE4"
            />
          </svg>
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
