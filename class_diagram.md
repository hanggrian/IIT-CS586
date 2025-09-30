# [Class diagram](https://en.wikipedia.org/wiki/Class_diagram)

## Type explicity

```mermaid
classDiagram
  direction LR
  class Hidden {
    -property
    +method(parameter)
  }

  class Explicit {
    +property : type
    +method(parameter : type) type
  }
```

## Member visibility

```mermaid
classDiagram
  direction LR
  class Visibility {
    +public
    -private
    #protected
    ~package
  }
```

## Multiplicity

`0..*` and `1..1` are redundant, so they are usually written as `*` and `1`.

```mermaid
classDiagram
  direction LR
  class One2["One"] {
  }
  Zero "0" -- "1" One2
  ZeroToOne "0..1" -- "1" One2
  One "1" -- "1" One2
  Many "*" -- "1" One2
  OneToMany "1..*" -- "1" One2
```

## Types of relationships

### Dependency

![Weak cohesion](https://img.shields.io/badge/cohesion-weak-success)

When changes in one class may affect another class.

```mermaid
classDiagram
  direction LR
  Server <.. Client : uses
```

### Association/Link

![Weak cohesion](https://img.shields.io/badge/cohesion-weak-success)

When objects of one class are connected to objects of another class.

```mermaid
classDiagram
  direction LR
  class Person {
    +subscriber : Magazine[]
  }
  class Magazine {
    +subscription : Person[]
  }
  Person "*" -- "*" Magazine : subscribes
```

### Aggregation

![Medium cohesion](https://img.shields.io/badge/cohesion-medium-important)

When one class is a part of another class, but can exist independently.

```mermaid
classDiagram
  direction LR
  class Professor {
    +classes : Class[]
  }
  Professor "1" o-- "1..*" Class : teaches
```

### Composition

![Strong cohesion](https://img.shields.io/badge/cohesion-strong-critical)

When one class is a part of another class, and cannot exist independently.

```mermaid
classDiagram
  direction LR
  Car "1" *-- "1" Carburetor : contains
  Pond "1" o-- "1" Duck : contains
```

### Generalization/Inheritance

![Strong cohesion](https://img.shields.io/badge/cohesion-strong-critical)

When a class is a subclass of another class. Overriden properties and methods
must be declared in the subclass.

```mermaid
classDiagram
  direction LR
  class Person {
    +name : string
    +age : integer
  }
  class Student {
    +grades : list
  }
  class Professor {
    +students : list
  }
  Person <|-- Student
  Person <|-- Professor
```

### Realization/Implementation

![Medium cohesion](https://img.shields.io/badge/cohesion-medium-important)

When a class implements an interface. All properties and methods of the
interface must be declared in the implementing class.

```mermaid
classDiagram
  direction LR
  class Animal {
    +makeSound()
  }
  class Dog {
    +makeSound()
  }
  class Cat {
    +makeSound()
  }
  Animal <|.. Dog
  Animal <|.. Cat
```
