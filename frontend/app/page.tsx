import Network from "./components/layout/Network";
import NavBar from "./components/layout/NavBar";
import SearchFilter from "./components/layout/SearchFilter";
import ConnectionInfoDisplay from "./components/layout/ConnectionInfoDisplay";

export default function Home() {
  return (
    // TODO check if using fragment best practice
    // TODO how to properly lay out each section
    <div data-theme="connetit" className="grid grid-cols-9 max-h-screen">
      {/* TODO left section */}
      <SearchFilter />
      <section className="col-span-8">
        {/* TODO mid section */}

        <NavBar />

        <section className="grid grid-cols-9">
          <div className="col-span-7">
            <Network />
          </div>
          <ConnectionInfoDisplay />
        </section>
      </section>
    </div>
  );
}
