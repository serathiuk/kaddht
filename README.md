# Serathiuk's Kademlia DHT
A simple Java Kademlia DHT Implementation, based in the paper ["Kademlia: A Scalable Peer-to-peer Lookup Service for Internet Applications"](Kademlia.pdf) of Ion Stoica, Robert Morris, David Karger, M. Frans Kaashoek, Hari Balakrishnan. 

## Usage

To execute the program, run the following command:

```bash
./mvnw exec:java
```

After the program is running, you can use the following commands:

### 1 - Start Kademlia 

Starts the Kademlia DHT local server. The server is necessary to communicate with other nodes. All nodes 
are client and server in same time.

You will be asked to provide the following information:

- **Local host**: the localhost address. Defaults to `localhost`.
- **Local port**: the port where the server will be listening. Defaults to `8000`.
- **Remote host**: the remote host address of a valid Kademlia node. Leave it blank if you want to start a new Kademlia ring.
- **Remote port**: the remote port address of a valid Kademlia node. Leave it as `0` if you want to start a new Kademlia ring.

### 2 - Stop  Kademlia

Stop the local Kademlia server and leave the network.

### 3 - Put a Key

Add a key to the Kademlia DHT. You will be asked to provide the following information:

- **Key**: the key to be added.
- **Value**: the value to be associated with the key.

### 4 - Get a Key

Get a key from the Kademlia DHT. You will be asked to provide the following information:

- **Key**: the key to be retrieved.

### 5 - Show node info

Show the node info. It will display the following information:

- **Node ID**: the node ID.

### 9 - Exit

Exit the program.


