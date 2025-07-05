import Network from "./components/layout/Network";
import NavBar from "./components/layout/NavBar";
// import SearchFilter from "./components/layout/SearchFilter";
import ConnectionInfoDisplay from "./components/layout/ConnectionInfoDisplay";

export default function Home() {
  return (
    // TODO check if using fragment best practice
    // TODO how to properly lay out each section
    <div data-theme="connetit">
      {/* TODO left section */}
      {/* <SearchFilter /> */}
      {/* TODO mid section */}

      <NavBar />
      <section className="grid grid-cols-1 md:grid-cols-4">
        <div className="md:col-span-3">
          <Network />
        </div>
        <ConnectionInfoDisplay />
      </section>
    </div>
  );
}
