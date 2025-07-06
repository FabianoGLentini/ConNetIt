import React from "react";
type Props = {
  src?: string;

  //   size?: string;
};
export const Avatar = ({
  src = "/public/default-avatar.svg",
  //   size = "w-18",
}) => {
  return (
    <div className="avatar">
      <div className="w-18 rounded-full border border-2 ">
        <img src="public/default-avatar.svg" />
      </div>
    </div>
  );
};
