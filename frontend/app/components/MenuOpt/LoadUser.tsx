"use client";

import { useState } from "react";
import { Connection } from "@/app/types/Connection";
import ConnectionCard from "@/app/components/Network/ConnectionCard";

export default function NetworkList() {
  const [connections, setConnections] = useState<Connection[]>([]);
  const [loading, setLoading] = useState(false);

  const loadConnections = async () => {
    setLoading(true);
    try {
      const res = await fetch("http://localhost:8080/api/connections");
      const data = await res.json();
      setConnections(data);
    } catch (err) {
      console.error("Fetch error:", err);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div>
      <button
        className="btn btn-primary mb-4"
        onClick={loadConnections}
        disabled={loading}
      >
        {loading ? "Loading..." : "Load Connections"}
      </button>

      <ul className="flex flex-col gap-4 max-h-[70vh] overflow-y-auto">
        {connections.map((conn) => (
          <li /* TODO might need to add id to my connections for easier loading
           key={conn.id}*/
          >
            <ConnectionCard {...conn} />
          </li>
        ))}
      </ul>
    </div>
  );
}
