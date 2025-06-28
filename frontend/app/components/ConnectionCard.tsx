import React from "react";
// TODO import relevant assets

const ConnectionCard = () => {
  return (
    // TODO remove tmp's and properly add var
    <div>
      {/* top section of card */}
      {/* TODO check div or section mos aproppriate tag */}
      <section>
        <h3>
          NameTMP
          {/* Name var here */}
        </h3>
        {/* TODO may remove Edit icon potentially */}
        <button>
          <img src="" alt="TMP edit icon" />
        </button>
      </section>

      {/* Mid Section */}
      <section>
        <span>Company TMP</span>
        <span>Job Tittle TMP</span>
      </section>

      {/* Bottom Section */}
      <section>
        {/* Tag list */}
        <ul>{/* TODO add call to tag icon creation */}</ul>

        {/* TODO expand or indicate if more tags then space on card to be displayed ...?*/}
        <button>
          <img src="" alt="TMP expand tag icon" />
        </button>
      </section>
    </div>
  );
};

export default ConnectionCard;
