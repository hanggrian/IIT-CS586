# Architectural patterns

- Proxy pattern
- De-coupling pattern
- Model-view-controller pattern
- Client-server pattern

## Proxy pattern

The proxy and the real subject share the same interface.

```mermaid
classDiagram
  direction LR
  class Image {
    +display() void
  }
  class RealImage {
    -filename : String
    +display() void
    +loadFromDisk(filename : String) void
  }
  class ProxyImage {
    -realImage : RealImage
    -filename : String
    +display() void
  }
  class Client {
    +main() void
  }
  Image <|-- RealImage
  Image <|-- ProxyImage
  Client --> ProxyImage
```

## De-coupling pattern

Introduce an intermediary to weaken coupling between modules.

```mermaid
classDiagram
  direction LR
  C1 -- Intermediate
  Intermediate -- C2
```

## Model-view-controller pattern

The same information is represented differently in different UIs.

```mermaid
classDiagram
  direction LR
  class Model {
    -state
    +update() void
    +query() integer
  }
  class View {
    +update() void
  }
  class Controller {
    +execute() void
  }
  View "1..*" -- "1..*" Controller
  View "*" -- "1" Model
  Controller "*" -- "1" Model
```

## Client-server pattern

- Client-dispatcher-server
- Client-broker-server

### Client-dispatcher-server

Clients locate server address and get service from the server. The client
communicates directly with the server.

```mermaid
classDiagram
  direction LR
  class Client {
    -dispatcher
    +process
  }
  class Dispatcher {
    -servers : Server[]
    +register(s : Server, signature : String) void
    +unregister(s : Server) void
    +locateServer(signature : String) Server
  }
  class Server {
  }
  class Service1 {
    +add(x : integer, y : integer) integer
    +add(x : integer, y : integer) float
    +multiply(x : string, y : string) float
  }
  class Service2 {
    +multiply(x : integer, y : integer) integer
    +add(x : integer, y : integer, z : integer) integer
    +add(x : integer, y : integer) integer
    +multiply(x : float, y : float) float
  }
  Server <|-- Service1
  Server <|-- Service2
  Dispatcher "1" o-- "*" Server
  Client -- Dispatcher
```

### Client-broker-server

The client communicates with the server via a broker.

1.  Client requests service
1.  Broker forwards the service request to the server
1.  Server replies to the broker
1.  Broker forwards the reply to client

```mermaid
graph LR
  Client -- 1 --> Broker
  Broker -- 4 --> Client

  Server1 -- register --> Broker
  Server2 -- register --> Broker

  Broker -- 2 --> Server2
  Server2 -- 3 --> Broker
```
