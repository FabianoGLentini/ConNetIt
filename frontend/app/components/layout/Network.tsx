import React from "react";
import ConnectionCard from "../Network/ConnectionCard";

const Network = () => {
  return (
    // TODO card display, so call opon car method and lay it out vertically in fix sizing?

    // TODO replace current conection info with connection card component

    <section className="h-full overflow-y-scroll max-h-screen scrollbar-custom">
      <ul className="list p-2  ">
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
