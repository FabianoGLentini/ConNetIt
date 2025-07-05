import React from "react";
// TODO import additional assets

const SearchFilter = () => {
  return (
    // TODO implement should all be wrap in a div ?
    // TODO replace tmp's
    <div className="col-span-1">
      <h1>ConNetIt</h1>
      {/* May search name or tag and dynamically...? filters list. Through inputed text */}
      <span>Search TMP</span>

      <h3>Filters & Search TMP</h3>

      {/* TODO figure out appropriate toggle html syntax */}
      <section>
        <span>Tags TMP Toggle</span>
        {/* TODO expand based on tag toggle bool */}
        <ul>
          {/* TODO call tags component to generate created tags you can search */}
        </ul>
      </section>

      <section>
        <span>Sort TMP toggle</span>
        {/* TODO option expand selection & display in span...? */}
        <ul>{/* sort options by default sort by name */}</ul>
      </section>

      <section>{/* TODO Conection lvl selection by range...?*/}</section>
    </div>
  );
};

export default SearchFilter;
