# Object-oriented design patterns

Reuse of design solutions.

## Types of design patterns

- Item description pattern
- Whole-part pattern
- Observer pattern
- State pattern
- Adapter pattern
- Strategy pattern
- Abstract factory pattern
- Proxy pattern
- De-coupling pattern

### Item description pattern

Create a new class with description.

```mermaid
classDiagram
  direction LR
  class Item {
    +description : Description
  }
  class Description {
    +name : string
    +age : integer
  }
  Item o-- Description : has
```

### Whole-part pattern

An object consists of parts of different types.

```mermaid
classDiagram
  direction LR
  class Directory {
    +files : File[]
  }
  Directory o-- "*" File : contains
  Directory --|> File
  Text --|> File
  Exec --|> File
```

### Observer pattern

Publisher-subscriber model.

```mermaid
classDiagram
  direction LR
  class Subject {
    -observers : Observer[]
    +notify()
    +register(Observer)
    +unregister(Observer)
  }
  Subject <|-- ConcreteSubject

  class Observer {
    -subject : Subject
    +update()
  }
  class ObserverA {
    +update()
  }
  class ObserverB {
    +update()
  }
  Subject -- Observer : observes
  Observer <|-- ObserverA
  Observer <|-- ObserverB
```

### State pattern

Declare state objects to represent different states of a class.

#### Centralized

```mermaid
classDiagram
  direction LR
  class Data {
    +min : integer
    +max : integer
  }
  class Stack {
    -currentState : State
    -states : State[]
    -data : Data
    +push()
    +pop()
  }
  Data "1" -- Stack

  class State {
    -data : Data
    -id : integer
    +push()
    +pop()
    +getId() integer
  }
  class EmptyState {
    -id : integer = 0
    +push()
  }
  class PartialState {
    -id : integer = 1
    +push()
    +pop()
  }
  class FullState {
    -id : integer = 2
    +pop()
  }
  Data "1" -- State
  Stack -- "*" State
  State <|-- EmptyState
  State <|-- PartialState
  State <|-- FullState
```

#### Decentralized

```mermaid
classDiagram
  direction LR
  class Data {
    +min : integer
    +max : integer
  }
  class Stack {
    -currentState : State
    -states : State[]
    -data : Data
    +push()
    +pop()
    +changeState(State)
  }

  class State {
    -data : Data
    -stack : Stack
    +push()
    +pop()
  }
  class EmptyState {
    +push()
  }
  class PartialState {
    +push()
    +pop()
  }
  class FullState {
    +pop()
  }
  Data "1" -- State
  Stack -- "*" State
  State <|-- EmptyState
  State <|-- PartialState
  State <|-- FullState
```

### Adapter pattern

Introduce a wrapper that allows the interface of an existing class to be used as
another interface.

#### Association-based

The adapter communicates from one server to another with association.

```mermaid
classDiagram
  direction LR
  class Client {
    -server
    +process()
  }
  class ServerA {
    +m1()
    +m2()
  }
  class ServerB {
    +p1()
    +p2()
  }
  class ServiceA {
    +m1()
    +m2()
  }
  class ServiceB {
    +m1()
    +m2()
  }
  class ServiceC {
    +p1()
    +p2()
  }
  class ServiceD {
    +p1()
    +p2()
  }
  ServerA <|-- ServiceA
  ServerA <|-- ServiceB
  ServerB <|-- ServiceC
  ServerB <|-- ServiceD

  ServerA <|-- Adapter
  ServerB -- Adapter

  Client -- ServerA
```

#### Inheritance-based

The servers share a common interface.

```mermaid
classDiagram
  direction LR
  class Client {
    -server
    +process()
  }
  class ServerA {
    +m1()
    +m2()
  }
  class ServerB {
    +p1()
    +p2()
  }
  class ServiceA {
    +m1()
    +m2()
  }
  class ServiceB {
    +m1()
    +m2()
  }
  class Adapter {
    -serviceC
    +m1()
    +m2()
  }
  ServerA <|-- ServiceA
  ServerA <|-- ServiceB
  ServerA <|-- Adapter
  ServerB <|-- Adapter

  Client -- ServerA
```

### Strategy pattern

Encapsulate each algorithm or requirement in a separate class.

```mermaid
classDiagram
  direction LR
  class CalcTax {
    +calculate()
  }
  class EU {
    +calculate()
  }
  class US {
    +calculate()
  }
  class Canada {
    +calculate()
  }
  class SalesOrder {
    -calc : CalcTax
    +calculate()
  }
  Application -- SalesOrder
  SalesOrder -- CalcTax
  CalcTax <|-- EU
  CalcTax <|-- US
  CalcTax <|-- Canada
```

### Abstract factory pattern

Application needs to be de-coupled from the problem of creating the objects.

```mermaid
classDiagram
  direction LR
  class AbstractProductA {
    <<abstract>>
  }
  class AbstractProductB {
    <<abstract>>
  }
  class AbstractFactory {
    <<abstract>>
  }

  class ProductA1 {
    <<abstract>>
  }
  class ProductA2 {
    <<abstract>>
  }
  class ProductB1 {
    <<abstract>>
  }
  class ProductB2 {
    <<abstract>>
  }

  class ConcreteFactory1 {
    <<abstract>>
  }
  class ConcreteFactory2 {
    <<abstract>>
  }

  ProductA1 -- ConcreteFactory1
  ProductA2 -- ConcreteFactory2

  ProductB1 -- ConcreteFactory1
  ProductB2 -- ConcreteFactory2

  AbstractFactory <|-- ConcreteFactory1
  AbstractFactory <|-- ConcreteFactory2

  AbstractProductA <|-- ProductA1
  AbstractProductA <|-- ProductA2

  Application -- AbstractProductA
  Application -- AbstractProductB
  Application -- AbstractFactory

  AbstractProductB -- ProductB1
  AbstractProductB -- ProductB2
```

## Proxy pattern

Coordinate interactions between a client and servers.

```mermaid
classDiagram
  direction LR
  Client -- Proxy
  Proxy -- S1
  Proxy -- S2
  Proxy -- S100
  note for S1 "Busy"
  note for S2 "Busy"
  note for S100 "Idle"
```

### Protection proxy

To protect server from unauthorized access.

```mermaid
classDiagram
  direction LR
  Client -- Proxy
  Proxy -- Server
```

### Remote proxy

Search for a location of a server that can provide the service.

```mermaid
classDiagram
  direction LR
  Client -- Proxy
  Proxy -- Server

  class Server {
    +service1()
    +service2()
  }
  class A {
    +service1()
    +service2()
  }
  class B {
    +service1()
    +service2()
  }
  Server <|-- A
  Server <|-- B
```

## De-coupling pattern

Introduce an intermediary to weaken coupling between modules.

```mermaid
classDiagram
  direction LR
  C1 -- Intermediate
  Intermediate -- C2
```
