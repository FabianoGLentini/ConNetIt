import React from "react";
import Image from "next/image";

const NavBar = () => {
  return (
    <div>
      <div>
        <h2>Account Name</h2>
        <h4>Network</h4>
      </div>
      <span>Add Connection +</span>
      <button className="">
        <Image
          src="/images/main/icons/burger-icon.svg"
          alt="menu"
          width={24}
          height={24}
        />
      </button>
    </div>
  );
};

export default NavBar;
