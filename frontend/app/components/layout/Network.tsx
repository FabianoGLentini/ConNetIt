import React from "react";
import ConnectionCard from "../Network/ConnectionCard";
import { Connection } from "@/app/types/Connection";
// import Connection from "@/app/types/Connection";
import { UsersTMP } from "@/app/types/UsersTMP";

const Network = (userstmp: User[]) => {
  return (
    // TODO card display, so call opon car method and lay it out vertically in fix sizing?

    // TODO replace current conection info with connection card component

    <section className="h-full overflow-y-scroll max-h-screen scrollbar-custom">
      <ul className="list p-2  ">
        {/* TODO tmp example method set up List */}
        {userstmp.map((user: User) => (
          <li key={user.id}> {user.name}</li>
        ))}
        <li>
          <ConnectionCard />
        </li>

        <li>
          <ConnectionCard />
        </li>

        {/* Padding buffer */}
        <li className="invisible h-18"></li>
      </ul>
    </section>
  );
};

export default Network;
