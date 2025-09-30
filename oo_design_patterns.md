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
    +files: File[]
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
  class BookSubject {
    -users : UserType[]
    +register(o : Observer) void
    +unregister(o : Observer) void
    +notify() void
  }
  class UserType {
    +update()
  }
  BookSystem <|-- BookSubject
  BookSubject -- "*" UserType
```

### State pattern

Declare state objects to represent different states of a class.

```mermaid
classDiagram
  direction LR
  Content o-- "*" State : states
  StateA --|> State
  StateB --|> State
  StateC --|> State
```

### Adapter pattern

Introduce a wrapper that allows the interface of an existing class to be used as
another interface.

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

### Association-based

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

### Strategy pattern

Encapsulate each algorithm or requirement in a separate class.

```mermaid
classDiagram
  direction LR
  class Strategy {
    +algo()
  }
  class StrategyA {
    +algo()
  }
  class StrategyB {
    +algo()
  }
  class StrategyC {
    +algo()
  }
  Client -- Strategy
  Strategy <-- StrategyA
  Strategy <-- StrategyB
  Strategy <-- StrategyC
```

### Abstract factory pattern

Provides an interface (or abstract class) for creating families of related or
dependent objects without specifying their concrete classes.

```mermaid
classDiagram
  direction LR
  `<small>&laquo;abstract&raquo;</small> ProductA1` -- `<small>&laquo;abstract&raquo;</small> ConcreteFactory1`
  `<small>&laquo;abstract&raquo;</small> ProductA2` -- `<small>&laquo;abstract&raquo;</small> ConcreteFactory2`

  `<small>&laquo;abstract&raquo;</small> ProductB1` -- `<small>&laquo;abstract&raquo;</small> ConcreteFactory1`
  `<small>&laquo;abstract&raquo;</small> ProductB2` -- `<small>&laquo;abstract&raquo;</small> ConcreteFactory2`

  `<small>&laquo;abstract&raquo;</small> AbstractFactory` <|-- `<small>&laquo;abstract&raquo;</small> ConcreteFactory1`
  `<small>&laquo;abstract&raquo;</small> AbstractFactory` <|-- `<small>&laquo;abstract&raquo;</small> ConcreteFactory2`

  `<small>&laquo;abstract&raquo;</small> AbstractProductA` <|-- `<small>&laquo;abstract&raquo;</small> ProductA1`
  `<small>&laquo;abstract&raquo;</small> AbstractProductA` <|-- `<small>&laquo;abstract&raquo;</small> ProductA2`

  Application -- `<small>&laquo;abstract&raquo;</small> AbstractProductA`
  Application -- `<small>&laquo;abstract&raquo;</small> AbstractProductB`
  Application -- `<small>&laquo;abstract&raquo;</small> AbstractFactory`

  `<small>&laquo;abstract&raquo;</small> AbstractProductB` <|-- `<small>&laquo;abstract&raquo;</small> ProductB1`
  `<small>&laquo;abstract&raquo;</small> AbstractProductB` <|-- `<small>&laquo;abstract&raquo;</small> ProductB2`
```
