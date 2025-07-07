import Network from "./components/layout/Network";
import NavBar from "./components/layout/NavBar";
import SearchFilterSideBar from "./components/layout/SearchFilterSideBar";
import ConnectionInfoDisplay from "./components/layout/ConnectionInfoDisplay";

export default function Home() {
  return (
    // TODO check if using fragment best practice
    // TODO how to properly lay out each section
    <div data-theme="connetit" className="grid grid-cols-5 max-h-screen">
      {/* TODO left section */}
      <SearchFilterSideBar />
      <section className="col-span-4">
        {/* TODO mid section */}

        <NavBar />

        <section className="grid grid-cols-5">
          <div className="col-span-3">
            <Network />
          </div>
          <div className="col-span-2">
            <ConnectionInfoDisplay />
          </div>
        </section>
      </section>
    </div>
  );
}
