import React from "react";
import ConnectionCard from "../Network/ConnectionCard";
// import { Connection } from "@/app/types/Connection";
// import Connection from "@/app/types/Connection";

// TODO tmp might be better to have it accessible for more then just network section
interface User {
  id: number;
  name: string;
  email: string;
  username: string;
  phone: string;
  website: string;
}

// TODO may be better to have it available to implement in more section maybe?
interface Props {
  users: User[];
}

const Network: React.FC<Props> = ({ users }) => {
  return (
    // TODO card display, so call opon car method and lay it out vertically in fix sizing?

    // TODO replace current conection info with connection card component

    <section className="h-full overflow-y-scroll max-h-screen scrollbar-custom">
      <ul className="list p-2  ">
        {/* TODO tmp example method set up List */}
        {users.map((user) => (
          <li key={user.id}>
            <ConnectionCard
              name={user.name}
              email={user.email}
              phone={user.phone}
            />
          </li>
        ))}

        {/* Padding buffer */}
        <li className="invisible h-18"></li>
      </ul>
    </section>
  );
};

export default Network;

// // components/layout/Network.tsx
// import React from "react";
// import ConnectionCard from "../network/connectioncard/ConnectionCard";

// const Network: React.FC<Props> = ({ users }) => {
//   return (
//     <div className="space-y-2 p-4 overflow-y-scroll max-h-full">
//       {users.map((user) => (
//         <ConnectionCard
//           key={user.id}
//           name={user.name}
//           email={user.email}
//           phone={user.phone}
//         />
//       ))}
//     </div>
//   );
// };

// export default Network;
