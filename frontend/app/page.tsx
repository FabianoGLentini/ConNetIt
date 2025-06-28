import Network from "./components/Network";
import NavBar from "./components/NavBar";
import SearchFilter from "./components/SearchFilter";

export default function Home() {
  return (
    // TODO check if using fragment best practice
    // TODO how to properly lay out each section
    <div>
      <NavBar />
      <Network />
      <SearchFilter />
    </div>
  );
}
