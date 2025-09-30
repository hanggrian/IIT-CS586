# [Cohesion](https://bestsoftwareengineer.medium.com/the-7-types-of-cohesion-you-need-to-know-to-be-the-best-software-engineer-with-pythonic-code-e224e2fa36ce)

Cohesion in Software Engineering refers to level of relatedness in functionality
of a software module, where a module from an Object Oriented Programming (OOP)
is a class (Hooshyar & Izadkhah, 2017).

## Types of Cohesion

- Coincidental cohesion (worst)
- Functional cohesion (best)

### Coincidental cohesion

The below class is coincidentally cohesive because none of the functionality of
the methods are related.

```mermaid
block-beta
  block
    calculate_price_based_on_discount
    read_file
    display
  end
```

```python
class Utilities:
  @classmethod
  def calculate_price_based_on_discount(cls, price: float, discount: float):
    return price - price * discount

  @classmethod
  def read_file(cls, file_name):
    file_contents = ''
    with open(file_name) as file_handle:
      file_contents = file_handle.read()

    return file_contents

  @classmethod
  def display(cls, message):
    print(message)
```

### Functional cohesion

Functional cohesion is the highest and most desirable level of cohesion because
all the elements of the module contribute to perform one well-defined task
(Ingeno, 2018).

```mermaid
graph LR
  Reader -->|implements| FileReader
```

```python
from abc import ABC, abstractmethod
import os

class Reader(ABC):
  @abstractmethod
  def read(self):
    pass

class FileReader(Reader):
  def __init__(self, file_name:str):
    self._file_name = file_name

  def read(self):
    file_contents = ''
    with open(self._file_name) as file_handle:
      file_contents = file_handle.read()

    return file_contents

def main():
  reader: Reader = FileReader('data.in')
  print(reader.read())

main()
```
