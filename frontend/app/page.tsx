import Network from "./components/Network";
import NavBar from "./NavBar";
import SearchFilter from "./components/SearchFilter";
import ConnectionInfoDisplay from "./components/ConnectionInfoDisplay";

export default function Home() {
  return (
    // TODO check if using fragment best practice
    // TODO how to properly lay out each section
    <div>
      {/* TODO left section */}
      <SearchFilter />

      {/* TODO mid section */}
      <NavBar />
      <Network />

      {/* TODO right section */}
      <ConnectionInfoDisplay />
    </div>
  );
}
