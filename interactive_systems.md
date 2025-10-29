# Interactive systems

- Model-view-controller pattern

## Model-view-controller pattern

Interactive system architecture that separates model (core processing), view
(output) and controller (input).

```mermaid
classDiagram
  direction LR
  class Model {
    -observers : Observer[]
    +register(Observer)
    +unregister(Observer)
    +service()
    +getData()
    +notify()
  }
  class Observer {
    -model : Model
    +update()
  }
  Model -- Observer

  class View {
    -controller : Controller
    +display()
    +update()
    +initialize(Model, Controller)
  }
  class Controller {
    -view : View
    +handleInput()
    +update()
    +initialize(View, Model)
  }
  Observer <|-- View
  Observer <|-- Controller
  View -- Controller
```

The same information is represented differently in different UIs.

```mermaid
classDiagram
  direction LR
  class ConcreteModel {
    -data : Data
    +service()
    +getData()
  }
  class Model {
    -observers : Observer[]
    +register(Observer)
    +unregister(Observer)
    +notify()
  }
  Model <|-- ConcreteModel
  Model -- Observer

  class View {
    -controller : Controller
    +update()
    +initialize()
  }
  class View1 {
    +display()
    +update()
  }
  class View2 {
    +display()
    +update()
  }
  View <|-- View1
  View <|-- View2

  class Controller {
    -view : View
    +handleInput()
    +update()
  }
  class Controller1 {
    +handleInput()
    +update()
  }
  class Controller2 {
    +handleInput()
    +update()
  }
  Controller <|-- Controller1
  Controller <|-- Controller2

  class Observer {
    -model : Model
    +update()
  }
  Observer <|-- View
  Observer <|-- Controller
  View -- Controller
```
