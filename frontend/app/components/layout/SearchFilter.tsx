import React from "react";
// TODO import additional assets

const SearchFilter = () => {
  return (
    // TODO implement should all be wrap in a div ?
    // TODO replace tmp's
    <div className="flex h-screen flex-col justify-between border-e">
      <div className="px-4 py-6">
        <span>ConNetIt</span>
        {/* May search name or tag and dynamically...? filters list. Through inputed text */}
        <div className="place-content-center">
          <span>Search TMP</span>
          <h3>Filters & Search TMP</h3>
          <ul>
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
          </ul>
        </div>
        <section>{/* TODO Conection lvl selection by range...?*/}</section>
      </div>
    </div>
  );
};

export default SearchFilter;
