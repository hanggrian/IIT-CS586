# Client-server architecture

- Client-dispatcher-server
- Client-broker-server

## Client-dispatcher-server

The client communicates directly with the server.

```mermaid
classDiagram
  direction LR
  class Client {
    -dispatcher : Dispatcher
    +process
  }
  class Dispatcher {
    -servers : Server[]
    +register(s : Server, signature : String) void
    +unregister(s : Server) void
    +locateServer(signature : String) Server
  }
  class Server {
    -dispatcher : Dispatcher
    +service1(integer, integer) integer
    +service2(integer, integer) integer
    +service3(float, float) float
  }
  Dispatcher "1" -- "*" Server
  Client "*" -- "1" Dispatcher
  Client -- Server
```

## Client-broker-server

The client communicates with the server via a broker.

```mermaid
classDiagram
  direction LR
  class Client {
    -proxy : ClientProxy
    +process()
  }
  class ClientProxy {
    -broker : Broker
    +service1(integer, integer) integer
    +service2(integer, integer) integer
    +service3(float, float) float
  }
  Client -- ClientProxy

  class Server {
    +service1(integer, integer) integer
    +service2(integer, integer) integer
    +service3(float, float) float
  }
  class ServerProxy {
    -broker : Broker
    +callService()
  }
  Server -- ServerProxy

  class Broker {
    -proxies : ServerProxy[]
    +register()
    +unregister()
    +forwardService()
    +findServer()
  }
  ClientProxy -- Broker
  ServerProxy -- Broker

  class Request {
    +spec : string
  }
  class Request1 {
    +i1 : integer
    +i2 : integer
    +result1 : integer
  }
  class Request2 {
    +f1 : float
    +f2 : float
    +result2 : float
  }
  Request <|-- Request1
  Request <|-- Request2
  Broker -- Request
  ClientProxy -- Request
  ServerProxy -- Request
```
