import React from "react";
import Image from "next/image";
//  TODO create package import for nav bar maybe???

const NavBar = () => {
  return (
    // TODO revise div look into using that<></> maybe?
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
