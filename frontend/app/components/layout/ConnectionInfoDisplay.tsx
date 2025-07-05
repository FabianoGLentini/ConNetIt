import React from "react";

const ConnectionInfoDisplay = () => {
  return (
    // TODO implment
    // TODO deside if edit connnection will create new window...?
    <div>
      {/* Top Section */}
      <section>
        <h2>Name TMP</h2>
        <img src="" alt="edit icon tmp" />
      </section>

      <img src="" alt="profile img TMP" />

      {/* Info Seection */}
      <section>
        {/* TODO mayy adjust span for h tags instead...? */}
        <span>
          {" "}
          Company:
          {/* TODO name comapny var */}
        </span>

        <span>
          Job Title:
          {/* TODO job title var */}
        </span>

        <div>
          {/* TODO met up description section plan */}
          <h3>Met:</h3>
          <p>text TMP</p>
        </div>

        <div>
          {/* TODO add descp plan, is it needed ..? */}
          <h3>Additoinal Descritpion:</h3>
          <p>text TMP</p>
        </div>
      </section>

      {/* TODO bottom section */}
      <section>{/* TODO star dissplay lvl */}</section>
    </div>
  );
};

export default ConnectionInfoDisplay;
