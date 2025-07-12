import React from "react";
import { BurgerIcon } from "./NavBar/BurgerIcon";
// import Image from "next/image";
//  TODO create package import for nav bar maybe???

const NavBar = () => {
  return (
    <nav className="navbar border-b-4 bg-base-100 border-base-300 col-span-6">
      <div className="flex-2">
        {/* TODO remove button styling...? */}
        <h1 className="text-xl">Account Name</h1>
        <h2 className="text-lg">Network</h2>
      </div>

      {/* TODO adjus properly maybe set to be part of the list section instead */}
      {/* <span>Add Connection +</span> */}

      <div className="flex-none">
        {/* TODO remove arrow and style burger menu properly */}
        <ul className="menu menu-horizontal px-1">
          <li>
            {/* TODO fix up menu burger set up */}
            <details>
              <summary>
                <BurgerIcon />
              </summary>
              <ul className="bg-base-100 rounded-t-none p-2">
                <li>
                  {/* TODO check if I should edit anchor tag to link tag for less loading */}
                  {/* TODO add appropriate drop down menu */}
                  <a>Link 1</a>
                </li>
                <li>
                  <a>Link 2</a>
                </li>
              </ul>
            </details>
          </li>
        </ul>
      </div>
    </nav>
  );
};

export default NavBar;
