// app/page.tsx or wherever Home is
import Network from "./components/layout/Network";
import NavBar from "./components/layout/NavBar";
import SearchFilterSideBar from "./components/layout/SearchFilterSideBar";
import ConnectionInfoDisplay from "./components/layout/ConnectionInfoDisplay";

interface User {
  id: number;
  name: string;
  email: string;
  username: string;
  phone: string;
  website: string;
  // Add more fields if needed
}

export default async function Home() {
  const res = await fetch("https://jsonplaceholder.typicode.com/users");
  const users: User[] = await res.json();

  return (
    <div data-theme="connetit" className="grid grid-cols-5 max-h-screen">
      <SearchFilterSideBar />
      <section className="col-span-4">
        <NavBar />
        <section className="grid grid-cols-6">
          <div className="col-span-4">
            {/* TODO tmp testing practice jsonplaceholder */}
            <Network users={users} />
          </div>
          <div className="col-span-2">
            <ConnectionInfoDisplay />
          </div>
        </section>
      </section>
    </div>
  );
}
