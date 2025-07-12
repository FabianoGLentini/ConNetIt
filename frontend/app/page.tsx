import Network from "./components/layout/Network";
import NavBar from "./components/layout/NavBar";
import SearchFilterSideBar from "./components/layout/SearchFilterSideBar";
import ConnectionInfoDisplay from "./components/layout/ConnectionInfoDisplay";
// TODO once I have some basic understanding of using jsonplaceholder I can look into better hookup with my own java backend
// import Connection from "../../backend/src/main/model/Network.java";
import { UsersTMP } from "@/app/types/UsersTMP";

export default async function Home() {
  // TODO confirm that this is appropriate set up for fetch
  const res = await fetch("https://jsonplaceholder.typicode.com/users");
  const users: UsersTMP[] = await res.json();

  return (
    // TODO check if using fragment best practice
    // TODO how to properly lay out each section
    <div data-theme="connetit" className="grid grid-cols-5 max-h-screen ">
      {/* TODO left section */}
      <SearchFilterSideBar />
      <section className="col-span-4">
        {/* TODO mid section */}

        <NavBar />

        <section className="grid grid-cols-6">
          <div className="col-span-4">
            {/* TODO tmp practice set up load list */}
            <ul></ul>
            {/* <Network /> */}
          </div>
          <div className="col-span-2">
            <ConnectionInfoDisplay />
          </div>
        </section>
      </section>
    </div>
  );
}
