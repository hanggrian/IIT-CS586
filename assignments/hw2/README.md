<!-- KaTeX -->
<script
  type="text/javascript"
  src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML">
</script>
<script
  type="text/x-mathjax-config">
  MathJax.Hub.Config({tex2jax: {inlineMath: [['$','$'], ['\\(','\\)']]}});
</script>

# [Homework 2](https://github.com/hanggrian/IIT-CS586/blob/assets/assignments/hw2_1.pdf)

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
> There exist two client processes, and they request the following services:
>
> **Client-A:**
>
> - `void service1(string, integer, integer)`
> - `void service2(string, integer)`
> - `integer service3(string)`
> - `float service4(string)`
>
> **Client-B:**
>
> - `void service1(string, integer)`
> - `void service2(string, integer, integer)`
> - `integer service3(string)`
> - `float service4(string)`
>
> The client processes do not know the location (pointer) to servers that may
  provide these services. Devise a software architecture using a
  **Client-Broker-Server** architecture for this problem. In this design, the
  client processes are not aware of the location of the servers providing these
  services.
>
> - Provide a class diagram for the proposed architecture. In your design, all
    components should be **decoupled** as much as possible.
> - Provide the **pseudo-code** for all operations of the following
    components/classes:
>   - Broker
>   - Client Proxy of *Client-A*
>   - Server Proxy of *Server-2*
> - Provide a sequence diagram to show how *Client-A* gets
    `void service2(string, integer)`.

### Class diagram

<img
  width="100%"
  alt="Diagram 1.1"
  src="https://github.com/hanggrian/IIT-CS586/raw/assets/assignments/hw2/diagram1_1.svg"/>

### Pseudo-code

```vb
class Broker {
  ServerProxy currentProxy
  Map<string, ServerProxy> proxies

  void registerServer(ServerProxy proxy, string operation) {
    proxies.put(operation, proxy)
  }

  void unregisterServer(ServerProxy proxy) {
    FOR operation IN proxies DO
      ServerProxy p <- proxies.get(operation)
      IF p == proxy THEN
        proxies.remove(operation)
      END IF
    END FOR
  }

  void forwardServer(Request request) {
    ServerProxy proxy <- proxies.get(request.operation)
    IF proxy != NULL THEN
      proxy.callServer(request)
    END IF
  }
}

class ClientAProxy {
  Broker broker

  void service1(string s, integer i1, integer i2) {
    Request request
    request.operation <- "void service1(string, int, int)"
    request.s <- s
    request.i1 <- i1
    request.i2 <- i2
    broker.forwardServer(request)
  }

  void service2(string s, integer i) {
    Request request
    request.operation <- "void service2(string, int)"
    request.s <- s
    request.i1 <- i
    broker.forwardServer(request)
  }

  integer service3(string s) {
    Request request
    request.operation <- "int service3(string)"
    request.s <- s
    broker.forwardServer(request)
    RETURN request.result1
  }

  float service4(string s) {
    Request request
    request.operation <- "float service4(string)"
    request.s <- s
    broker.forwardServer(request)
    RETURN request.result2
  }
}

class Server2Proxy {
  Server2 server2

  void callServer(Request request) {
    IF request.operation == "void service1(string, int)" THEN
      server2.service1(request.s, request.i1)
    ELSE IF request.operation == "void service2(string, int)" THEN
      server2.service2(request.s, request.i1)
    ELSE IF request.operation == "int service3(string)" THEN
      request.result1 <- server2.service3(request.s)
    ELSE IF request.operation == "float service4(string)" THEN
      request.result2 <- server2.service4(request.s)
    END IF
  }
}
```

### Sequence diagram

<img
  width="100%"
  alt="Diagram 1.2"
  src="https://github.com/hanggrian/IIT-CS586/raw/assets/assignments/hw2/diagram1_2.svg"/>

## Problem 2

> ```mermaid
> classDiagram
>   direction TB
>   class S1 {
>     +service1()
>   }
>   class S1_1 {
>     +service1()
>   }
>   class S1_2 {
>     +service1()
>   }
>   S1 <|-- S1_1
>   S1 <|-- S1_2
>   ClientA -- S1
>
>   class S2 {
>     +service2()
>   }
>   class S2_1 {
>     +service2()
>   }
>   class S2_2 {
>     +service2()
>   }
>   S2 <|-- S2_1
>   S2 <|-- S2_2
>   ClientB -- S2
>
>   class S3 {
>     +service3()
>   }
>   class S3_1 {
>     +service3()
>   }
>   class S3_2 {
>     +service3()
>   }
>   S3 <|-- S3_1
>   S3 <|-- S3_2
>   ClientC -- S3
> ```
>
> A design of a system is shown above. In this system, *Client_A* uses objects
  of classes *S1_1* and *S1_2,* *Client_B* uses objects of classes *S2_1* and
  *S2_2,* and *Client_C* uses objects of classes *S3_1* and *S3_2*.
>
> *Client_A* would like to use objects, operations *service2(),* of classes
  *S2_1* and *S2_2* by invoking operation *service1().* *Client_C* would like to
  use objects, operation *service1(),* of classes *S1_1* and *S1_2* by invoking
  operation *service3().* In addition, *Client_B* would like to use objects,
  operation *service3(),* of classes *S3_1* and *S3_2* by invoking operation
  *service2().*
>
> Provide a design with minimal modifications to the existing system using the
  Adapter design pattern in which (1) *Client_A* can use objects of classes
  *S2_1* and *S2_2* by invoking operations *service1(),* (2) *Client_B* can use
  objects of classes *S3_1,* and *S3_2* by invoking operations *service2(),* and
  (3) *Client_C* can use objects of classes *S1_1,* and *S1_2* by invoking
  operations *service3().* Notice that none of the classes shown in the above
  class diagram should be modified. Provide two solutions that are based on:
>
> 1.  An association-based version of the Adapter pattern
> 1.  An inheritance-based version of the Adapter pattern
>
> Provide a class diagram for each solution. You do not have to provide any
  description for classes/operations of the above class diagram (only new
  classes/operations should be described using pseudo-code).

### Association-based version

#### Class diagram

```mermaid
classDiagram
  direction TB
  class S1 {
    +service1()
  }
  class S1_1 {
    +service1()
  }
  class S1_2 {
    +service1()
  }
  S1 <|-- S1_1
  S1 <|-- S1_2
  ClientA -- S1 : calls

  class S2 {
    +service2()
  }
  class S2_1 {
    +service2()
  }
  class S2_2 {
    +service2()
  }
  S2 <|-- S2_1
  S2 <|-- S2_2
  ClientB -- S2 : calls

  class S3 {
    +service3()
  }
  class S3_1 {
    +service3()
  }
  class S3_2 {
    +service3()
  }
  S3 <|-- S3_1
  S3 <|-- S3_2
  ClientC -- S3 : calls

  class AdapterS1toS2 {
    +service1()
    -adaptee : S2
  }
  class AdapterS2toS3 {
    +service2()
    -adaptee : S3
  }
  class AdapterS3toS1 {
    +service3()
    -adaptee : S1
  }
  S1 <|-- AdapterS1toS2
  S2 <|-- AdapterS2toS3
  S3 <|-- AdapterS3toS1
  S2 -- AdapterS1toS2 : adapts
  S3 -- AdapterS2toS3 : adapts
  S1 -- AdapterS3toS1 : adapts
```

#### Pseudo-code

```vb
class AdapterS1toS2 implements S1 {
  S2 adaptee

  void service1() {
    adaptee.service2()
  }
}

class AdapterS2toS3 implements S2 {
  S3 adaptee

  void service2() {
    adaptee.service3()
  }
}

class AdapterS3toS1 implements S3 {
  S1 adaptee

  void service3() {
    adaptee.service1()
  }
}
```

### Inheritance-based version

#### Class diagram

```mermaid
classDiagram
  direction TB
  class S1 {
    +service1()
  }
  class S1_1 {
    +service1()
  }
  class S1_2 {
    +service1()
  }
  S1 <|-- S1_1
  S1 <|-- S1_2
  ClientA -- S1 : calls

  class S2 {
    +service2()
  }
  class S2_1 {
    +service2()
  }
  class S2_2 {
    +service2()
  }
  S2 <|-- S2_1
  S2 <|-- S2_2
  ClientB -- S2 : calls

  class S3 {
    +service3()
  }
  class S3_1 {
    +service3()
  }
  class S3_2 {
    +service3()
  }
  S3 <|-- S3_1
  S3 <|-- S3_2
  ClientC -- S3 : calls

  class AdapterS1toS2_1 {
    +service1()
  }
  class AdapterS1toS2_2 {
    +service1()
  }
  class AdapterS2toS3_1 {
    +service2()
  }
  class AdapterS2toS3_2 {
    +service2()
  }
  class AdapterS3toS1_1 {
    +service3()
  }
  class AdapterS3toS1_2 {
    +service3()
  }
  S2_1 <|-- AdapterS1toS2_1
  S1 <|-- AdapterS1toS2_1
  S2_2 <|-- AdapterS1toS2_2
  S1 <|-- AdapterS1toS2_2
  S3_1 <|-- AdapterS2toS3_1
  S2 <|-- AdapterS2toS3_1
  S3_2 <|-- AdapterS2toS3_2
  S2 <|-- AdapterS2toS3_2
  S1_1 <|-- AdapterS3toS1_1
  S3 <|-- AdapterS3toS1_1
  S1_2 <|-- AdapterS3toS1_2
  S3 <|-- AdapterS3toS1_2
```

#### Pseudo-code

```vb
class AdapterS1toS2_1 implements S1, S2_1 {
  void service1() {
    service2()
  }
}

class AdapterS1toS2_2 implements S1, S2_2 {
  void service1() {
    service2()
  }
}

class AdapterS2toS3_1 implements S2, S3_1 {
  void service2() {
    service3()
  }
}

class AdapterS2toS3_2 implements S2, S3_2 {
  void service2() {
    service3()
  }
}

class AdapterS3toS1_1 implements S3, S1_1 {
  void service3() {
    service1()
  }
}

class AdapterS3toS1_2 implements S3, S1_2 {
  void service3() {
    service1()
  }
}
```

## Problem 3

> ```mermaid
> classDiagram
>   direction LR
>   class ClientA {
>     -server : Server
>     +process()
>   }
>   class ClientB {
>     -server : Server
>     +process()
>   }
>   class Server {
>     -s1: Server1
>     -s2: Server2
>     +sort()
>     +search()
>   }
>   ClientA -- Server
>   ClientB -- Server
>   note for Server "sort() {<br>&emsp;s1.sort()<br>}<br><br>search() {<br>&emsp;s2.search()<br>}"
>
>   class Server1 {
>     +sort()
>   }
>   class Server2 {
>     +search()
>   }
>   Server -- Server1
>   Server -- Server2
>
>   class HeapSort {
>     +sort()
>   }
>   class MergeSort {
>     +sort()
>   }
>   Server1 <|-- HeapSort
>   Server1 <|-- MergeSort
>
>   class BinarySearch {
>     +search()
>   }
>   class LinearSearch {
>     +search()
>   }
>   Server2 <|-- BinarySearch
>   Server2 <|-- LinearSearch
> ```
>
> *Client A* and *Client B* get services, `sort()` and `search()`, directly from
  the *Server.* However, the *Server* gets the appropriate services from
  *HeapSort* or *MergeSort* servers for `sort()` service. In addition, the
  *Server* gets the appropriate services from *BinarySearch* or *LinearSearch*
  servers for `search()` service.
>
> In this design, clients do not have control where the services are coming
  from. However, *Client A*, by invoking `sort()` and `search()` on the
  *Server,* would like to get `sort()` service from *HeapSort* server and
  `search()` service from *BinarySearch* server. On the other hand, *Client B*,
  by invoking `sort()` and `search()` on the *Server,* would like to get `sort()`
  from *MergeSort* server and `search()` from *LinearSearch* server. Notice that
  the current design does not support this option.
>
> Use the **abstract factory** design pattern to solve this problem. In your
  solution, the *Client* classes should be completely **decoupled** from the
  issue of invoking services by the *Server* for appropriate versions of
  `sort()` and `search()`. Notice that none of the classes (and operations)
  shown in the above class diagram should be modified. However, new
  operations/classes can be introduced.
>
> - Provide the class diagram and briefly describe the responsibility of each
    class and the functionality of each operation using **pseudo-code.** In your
    design, all components should be **decoupled** as much as possible. You do
    not have to provide any description for classes/operations of the above
    class diagram (only new classes/operations should be described).
> - Provide a sequence diagram to show how *ClientB* gets `sort()` service from
    *MergeSort* server and `search()` service from *LinearSearch* server by
    invoking `sort()` and `search()` on the *Server*.

### Class diagram

<img
  width="100%"
  alt="Diagram 2.1"
  src="https://github.com/hanggrian/IIT-CS586/raw/assets/assignments/hw2/diagram2_1.svg"/>

### Pseudo-code

```vb
class ClientA {
  Server server
  AbstractFactory factory

  void process() {
    AbstractFactory1 f
    server.initialize(f)
    'Do sort and search'
  }
}

class ClientB {
  Server server
  AbstractFactory factory

  void process() {
    AbstractFactory2 f
    server.initialize(f)
    'Do sort and search'
  }
}

class Server {
  Sort sort
  Search search

  void initialize(AbstractFactory factory) {
    sort <- factory.getSort()
    search <- factory.getSearch()
  }

  Object[] sort(Object[] items) {
    Object[] result <- sort.sort(items)
    RETURN result
  }

  Object search(Object[] items) {
    Object result <- search.search(items)
    RETURN result
  }
}

interface AbstractFactory {
  Sort getSort()

  Search getSearch()
}

class AbstractFactoryA implements AbstractFactory {
  Sort getSort() {
    HeapSort sort
    RETURN sort
  }

  Search getSearch() {
    BinarySearch search
    RETURN search
  }
}

class AbstractFactoryB implements AbstractFactory {
  Sort getSort() {
    MergeSort sort
    RETURN sort
  }

  Search getSearch() {
    LinearSearch search
    RETURN search
  }
}
```

### Sequence diagram

<img
  width="100%"
  alt="Diagram 2.2"
  src="https://github.com/hanggrian/IIT-CS586/raw/assets/assignments/hw2/diagram2_2.svg"/>
