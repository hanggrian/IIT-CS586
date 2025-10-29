# [Exam 2](https://github.com/hanggrian/IIT-CS586/blob/assets/assignments/exam2_1.pdf)

> Notice that none of the class diagrams shown in the problem statement should
  be modified. Provide a class diagram and briefly describe the responsibility
  of each class and the functionality of each operation using pseudo-code. You
  do not have to provide any description for classes/operations of the above
  class diagram (only new classes/operations should be described). In your
  design, all components should be decoupled as much as possible.

## Problem 1

> There exist two servers **S1** and **S2.** Both servers support the following
  services:
>
> Services supported by **server-S1:**
>
> - `void service1(string, integer, integer)`
> - `void service2(string, integer, integer)`
> - `integer service3(string)`
> - `float service4(string)`
>
> Services supported by **server-S2:**
>
> - `void service1(string, integer)`
> - `void service2(string, integer)`
> - `integer service3(string)`
> - `float service4(string)`
>
> There exist two client processes *processA()* and *processB(),* and they
  request the following services:
>
> **Client1:**
>
> - `void service1(string, integer, integer)`
> - `void service2(string, integer)`
> - `integer service3(string)`
> - `float service4(string)`
>
> **Client2:**
>
> - `void service1(string, integer)`
> - `void service2(string, integer, integer)`
> - `integer service3(string)`
> - `float service4(string)`
>
> The client processes do not know the location (pointer) to servers that may
  provide these services. Devise a software architecture using a
  **Client-Dispatcher-Server** architecture for this problem. In this design,
  the client processes are not aware of the location of the servers providing
  these services.
>
> - Provide a class diagram for this architecture.
> - Describe each component (class) of your design and operations supported by
    each class using the **pseudo-code.** However, you do not have to specify
    operations of **Server-1,Server-2** and **Client1.** For Client2 only
    operation *processB()* must be specified using pseudo-code showing how
    *processB()* gets `int service3(string)` service. In your design all
    components should be **decoupled** as much as possible.
> - Provide a sequence diagram to show how *processB()* of Client2 gets
    `int service3(string)` service.

### Class diagram

```mermaid
classDiagram
  direction TB
  class ClientA {
    -dispatcher : Dispatcher
    -server : Server
    +processA()
  }
  class ClientB {
    -dispatcher : Dispatcher
    -server : Server
    +processB()
  }
  class Dispatcher {
    -servers: Map~string, Server~
    +register(server : Server, signature : string) void
    +unregister(server : Server) void
    +locateServer(operation : string) Server
  }
  ClientA "*" -- "1" Dispatcher : finding server
  ClientB "*" -- "1" Dispatcher : finding server

  class Server {
    -dispatcher : Dispatcher
  }
  ClientA -- Server : requests
  ClientB -- Server : requests
  Dispatcher "1" -- "*" Server : finds

  class Server1 {
    +service1(param1 : string, param2 : integer, param3 : integer) void
    +service2(param1 : string, param2 : integer, param3 : integer) void
    +service3(param1 : string) integer
    +service4(param1 : string) float
  }
  class Server2 {
    +service1(param1 : string, param2 : integer) void
    +service2(param1 : string, param2 : integer) void
    +service3(param1 : string) integer
    +service4(param1 : string) float
  }
  Server <|-- Server1
  Server <|-- Server2
```

### Pseudo-code

```vb
class ClientB {
  Dispatcher dispatcher
  Server server

  void processB() {
    server <- dispatcher.locateServer("int service3(string)")
    integer result <- server.service3("abc")
  }
}

class Dispatcher {
  Map<string, Server> servers

  void register(Server server, string operation) {
    servers.put(operation, server)
  }

  void unregister(Server server) {
    FOR operation IN servers DO
      ServerProxy p <- servers.get(operation)
      IF p == proxy THEN
        servers.remove(operation)
      END IF
    END FOR
  }

  Server locateServer(string operation) {
    ServerProxy proxy <- proxies.get(operation)
    return proxy
  }
}
```

### Sequence diagram

```mermaid
sequenceDiagram
  actor User
  participant ClientB
  participant Dispatcher
  participant Server1

  Server1 ->> Dispatcher : register(self, "int service3(string)")
  activate Server1
  deactivate Server1

  activate Dispatcher
  note over Dispatcher : servers = { "int service3(string)": Server1 }
  User ->> ClientB : processB()
  activate ClientB
  ClientB ->> Dispatcher : locateServer("int service3(string)")
  Dispatcher -->> ClientB : Server1
  deactivate Dispatcher

  ClientB ->> Server1 : service3("abc")
  activate Server1
  Server1 -->> ClientB : an integer
  deactivate Server1
  deactivate ClientB
```

## Problem 2

> There exist two clients (*Client1* and *Client2*) and a *Server.* The server
  provides two services: *service1()* and *service2().* There exist two versions
  of *service1()*: *service1_1()* and *service1_2().* In addition, there exist
  two versions of *service2()*: *service2_1()* and *service2_2(),* where:
>
> - *Client1* invokes *service1_1()* and *service2_1()*
> - *Client2* invokes *service1_2()* and *service2_2()*
>
> The current design is shown below:
>
> ```mermaid
> classDiagram
>   direction LR
>   class Server {
>     +service1_1()
>     +service1_2()
>     +service2_1()
>     +service2_2()
>   }
>   Client1 -- Server
>   Client2 -- Server
> ```
>
> In a better design, clients should be shielded from different versions of
  *service1()* and *service2().* In the new design shown below:
>
> - *Client1* should invoke *service1()* and *service2()* to execute
    *service1_1()* and *service2_1().*
> - Similarly, *Client2* should invoke *service1()* and *service2()* to execute
    *service1_2()* and *service2_2().*
>
> ```mermaid
> classDiagram
>   direction LR
>   class Server {
>     +service1()
>     +service2()
>   }
>   Client1 -- Server
>   Client2 -- Server
> ```
>
> Use the **strategy pattern** and the **abstract factory** design pattern to
  solve this problem. In your solution the *Client* classes should be completely
  de-coupled from the issue of invoking appropriate versions of *service1()* and
  *service2().*
>
> - Provide the class diagram and describe the responsibility of each class and
    the functionality of each operation using pseudo-code. You do not have to
    provide any description for classes/operations of the above class diagram
    (only new classes/operations should be described).
> - Provide a sequence diagram showing how *Client1* gets *service1_1()* by
    invoking *service1()* and then *service2_1()* by invoking *service2()* on
    the Server.

### Class diagram

```mermaid
classDiagram
  direction TB
  class Client1 {
    -server : Server
    -factory : AbstractFactory
  }
  class Client2 {
    -server : Server
    -factory : AbstractFactory
  }
  class Server {
    -service1 : Service1
    -service2 : Service2
  }
  Client1 -- Server : requests
  Client2 -- Server : requests

  class Service1 {
    +service1()
  }
  class Service1_1 {
    +service1()
  }
  class Service1_2 {
    +service1()
  }
  class Service2 {
    +service2()
  }
  class Service2_1 {
    +service2()
  }
  class Service2_2 {
    +service2()
  }
  Service1 <|-- Service1_1
  Service1 <|-- Service1_2
  Service2 <|-- Service2_1
  Service2 <|-- Service2_2
  Server -- Service1 : responds
  Server -- Service2 : responds

  class AbstractFactory {
    <<interface>>
    +getService1() Service1
    +getService2() Service2
  }
  class AbstractFactory1 {
    +getService1() Service1
    +getService2() Service2
  }
  class AbstractFactory2 {
    +getService1() Service1
    +getService2() Service2
  }
  AbstractFactory <|-- AbstractFactory1
  AbstractFactory <|-- AbstractFactory2
  AbstractFactory -- Client1 : uses
  AbstractFactory -- Client2 : uses
  AbstractFactory -- Server : initialized by
  AbstractFactory1 -- Service1_1 : service 1
  AbstractFactory1 -- Service2_1 : service 1
  AbstractFactory2 -- Service1_2 : service 2
  AbstractFactory2 -- Service2_2 : service 2
```

### Pseudo-code

```vb
class Client1 {
  Server server
  AbstractFactory factory

  void process() {
    AbstractFactory1 f
    server.initialize(f)
    server.service1()
    server.service2()
  }
}

class Client2 {
  Server server
  AbstractFactory factory

  void process() {
    AbstractFactory2 f
    server.initialize(f)
    server.service1()
    server.service2()
  }
}

class AbstractFactory1 {
  Service1 getService1() {
    Service1_1 service
    return service
  }

  Service2 getService2() {
    Service2_1 service
    return service
  }
}

class AbstractFactory2 {
  Service1 getService1() {
    Service1_2 service
    return service
  }

  Service2 getService2() {
    Service2_2 service
    return service
  }
}

class Server {
  Service service1
  Service service2

  void initialize(AbstractFactory factory) {
    service1 <- factory.getService1()
    service2 <- factory.getService2()
  }

  void service1() {
    service1.service1()
  }

  void service2() {
    service2.service2()
  }
}
```

### Sequence diagram

```mermaid
sequenceDiagram
  actor User
  participant Client1
  participant Server
  participant AbstractFactory1
  participant Service1_1
  participant Service2_1

  User ->> Client1 : process()
  activate Client1

  Client1 ->> AbstractFactory1 : create factory
  activate AbstractFactory1
  AbstractFactory1 -->> Client1 : factory

  Client1 ->> Server : initialize(factory)
  activate Server
  Server ->> AbstractFactory1 : getService1()
  AbstractFactory1 ->> Service1_1 : create service
  activate Service1_1
  Service1_1 -->> AbstractFactory1 : service
  deactivate Service1_1
  AbstractFactory1 -->> Server :
  Server ->> AbstractFactory1 : getService2()
  AbstractFactory1 ->> Service2_1 : create service
  activate Service2_1
  Service2_1 -->> AbstractFactory1 : service
  deactivate Service2_1
  AbstractFactory1 -->> Server :
  deactivate AbstractFactory1
  note over Server: service1 = Service1_1<br>service2 = Service2_1

  Server -->> Client1 :
  Client1 ->> Server : service1()
  Server ->> Service1_1 : service1 by Service1_1
  activate Service1_1
  Service1_1 -->> Server : result
  deactivate Service1_1

  Server -->> Client1 :
  Client1 ->> Server : service2()
  Server ->> Service2_1 : service2 by Service2_1
  activate Service2_1
  Service2_1 -->> Server : result
  deactivate Service2_1
  Server -->> Client1 :
  deactivate Server
  deactivate Client1
```

## Problem 3

> ```mermaid
> classDiagram
>   direction TB
>     class S1 {
>       +addBook()
>       +deleteBook()
>       +isBook()
>     }
>     class S1_1 {
>       +addBook()
>       +deleteBook()
>       +isBook()
>     }
>     class S1_2 {
>       +addBook()
>       +deleteBook()
>       +isBook()
>     }
>     S1 <|-- S1_1
>     S1 <|-- S1_2
>     ClientA -- S1
>
>     class S2 {
>       +insertBook()
>       +removeBook()
>       +isBook()
>     }
>     class S2_1 {
>       +insertBook()
>       +removeBook()
>       +isBook()
>     }
>     class S2_2 {
>       +insertBook()
>       +removeBook()
>       +isBook()
>     }
>     S2 <|-- S2_1
>     S2 <|-- S2_2
>     ClientB -- S2
> ```
>
> A design of a system is shown above. In this system *ClientA* invokes
  operations of servers *S1_1* and *S1_2* and *ClientB* invokes operations of
  servers *S2_1* and *S2_2.*
>
> *ClientA* would like to invoke operations *insertBook(),* *removeBook()* and
  *isBook()* of servers *S2_1* and *S2_2* by invoking *addBook(),*
  *deleteBook()* and *isBook().* In addition, *ClientB* would like to invoke
  operations *addBook(),* *deleteBook()* and *isBook()* of servers *S1_1* and
  *S1_2* by invoking *insertBook(),* *removeBook()* and *isBook().*
>
> Provide a design with **minimal** modifications to the existing system using:
>
> - **Association-Based Adapter** design pattern for *ClientA.* As a result,
    *ClientA* is able to invoke operations of servers *S2_1* and *S2_2* by
    invoking *addBook(),* *deleteBook()* and *isBook(),* and
> - **Inheritance-Based Adapter** design pattern for *ClientB.* As a result,
    *ClientB* is able to invoke operations of servers *S1_1* and *S1_2* by
    invoking *insertBook(),* *removeBook()* and *isBook()*.

### Association-based version

#### Class diagram

```mermaid
classDiagram
  direction TB
  class S1 {
    +addBook()
    +deleteBook()
    +isBook()
  }
  class S1_1 {
    +addBook()
    +deleteBook()
    +isBook()
  }
  class S1_2 {
    +addBook()
    +deleteBook()
    +isBook()
  }
  ClientA -- S1 : calls
  S1 <|-- S1_1
  S1 <|-- S1_2

  class S2 {
    +insertBook()
    +removeBook()
    +isBook()
  }
  class S2_1 {
    +insertBook()
    +removeBook()
    +isBook()
  }
  class S2_2 {
    +insertBook()
    +removeBook()
    +isBook()
  }
  ClientB -- S2 : calls
  S2 <|-- S2_1
  S2 <|-- S2_2

  class AdapterS1toS2 {
    -adaptee : S2
    +addBook()
    +deleteBook()
    +isBook()
  }
  S1 <|-- AdapterS1toS2
  S2 -- AdapterS1toS2 : adapts

  class AdapterS2toS1 {
    -adaptee : S1
    +insertBook()
    +removeBook()
    +isBook()
  }
  S2 <|-- AdapterS2toS1
  S1 -- AdapterS2toS1 : adapts
```

#### Pseudo-code

```vb
class AdapterS1toS2 implements S1 {
  S2 adaptee

  void addBook() {
    adaptee.insertBook()
  }

  void deleteBook() {
    adaptee.removeBook()
  }

  boolean isBook() {
    return adaptee.isBook()
  }
}

class AdapterS2toS1 implements S2 {
  S1 adaptee

  void insertBook() {
    adaptee.addBook()
  }

  void removeBook() {
    adaptee.deleteBook()
  }

  boolean isBook() {
    return adaptee.isBook()
  }
}
```

### Inheritance-based version

#### Class diagram

```mermaid
classDiagram
  direction TB
  class S1 {
    +addBook()
    +deleteBook()
    +isBook()
  }
  class S1_1 {
    +addBook()
    +deleteBook()
    +isBook()
  }
  class S1_2 {
    +addBook()
    +deleteBook()
    +isBook()
  }
  ClientA -- S1 : calls
  S1 <|-- S1_1
  S1 <|-- S1_2

  class S2 {
    +insertBook()
    +removeBook()
    +isBook()
  }
  class S2_1 {
    +insertBook()
    +removeBook()
    +isBook()
  }
  class S2_2 {
    +insertBook()
    +removeBook()
    +isBook()
  }
  ClientB -- S2 : calls
  S2 <|-- S2_1
  S2 <|-- S2_2

  class AdapterS1toS2_1 {
    +addBook()
    +deleteBook()
    +isBook()
  }
  class AdapterS1toS2_2 {
    +addBook()
    +deleteBook()
    +isBook()
  }
  S1 <|-- AdapterS1toS2_1
  S2_1 <|-- AdapterS1toS2_1
  S1 <|-- AdapterS1toS2_2
  S2_2 <|-- AdapterS1toS2_2

  class AdapterS2toS1_1 {
    +insertBook()
    +removeBook()
    +isBook()
  }
  class AdapterS2toS1_2 {
    +insertBook()
    +removeBook()
    +isBook()
  }
  S2 <|-- AdapterS2toS1_1
  S1_1 <|-- AdapterS2toS1_1
  S2 <|-- AdapterS2toS1_2
  S1_2 <|-- AdapterS2toS1_2
```

#### Pseudo-code

```vb
class AdapterS1toS2_1 implements S1, S2_1 {
  void addBook() {
    insertBook()
  }

  void deleteBook() {
    removeBook()
  }

  boolean isBook() {
    return isBook()
  }
}

class AdapterS1toS2_2 implements S1, S2_2 {
  void addBook() {
    insertBook()
  }

  void deleteBook() {
    removeBook()
  }

  boolean isBook() {
    return isBook()
  }
}

class AdapterS2toS1_1 implements S2, S1_1 {
  void insertBook() {
    addBook()
  }

  void removeBook() {
    deleteBook()
  }

  boolean isBook() {
    return isBook()
  }
}

class AdapterS2toS1_2 implements S2, S1_2 {
  void insertBook() {
    addBook()
  }

  void removeBook() {
    deleteBook()
  }

  boolean isBook() {
    return isBook()
  }
}
```
