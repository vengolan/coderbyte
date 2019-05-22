## Problem Statement
*I own a multi-storey parking lot that can hold up to 'n' cars at any given point in
time. Each slot is given a number starting at 1 increasing with increasing distance
from the entry point in steps of one. I want to create an automated ticketing
system that allows my customers to use my parking lot without human
intervention.*

*When a car enters my parking lot, I want to have a ticket issued to the driver. The
ticket issuing process includes us documenting the registration number (number
plate) and the colour of the car and allocating an available parking slot to the car
before actually handing over a ticket to the driver (we assume that our customers
are nice enough to always park in the slots allocated to them). The customer
should be allocated a parking slot which is nearest to the entry. At the exit the
customer returns the ticket which then marks the slot they were using as being
available.*

*The system should provide me with the ability to find Out:*
- *Registration numbers of all cars of a particular colour.*
- *Slot number in which a car with a given registration number is parked.*
- *Slot numbers of all slots where a car of a particular colour is parked.*

*We interact with the system via a simple set of commands which produce a
specific output. Please take a look at the example below, which includes all the
commands you need to support - they're self explanatory. The system should
allow input in two ways. Just to clarify, the same codebase should support both
modes of input - we don't want two distinct submissions.*
- *It should provide us with an interactive command prompt based shell
where commands can be typed in*
- *It should accept a filename as a parameter at the command prompt and
read the commands from that file*


## How to Build and Execute  ##

```
    ./parking_lot.sh ./parkinglot.txt
```
Above script 
* runs the test script 
* builds the project into a .jar under /target folder 
* and executes commands provided in the parameter file one by one and shows output.

If no parameters are passed, it shows up the console where user could type in the commands
```
    ./parking_lot.sh
```



## Unit Test Cases 

The unit test cases can be found in 
```/src/test/java/com/coderbyte/parkinglot/ParkingLotTestCases.java```



## Some Core objects explained

#### ```Application.java```

Collects the command from console or the parameter file and passes it on to ```CommandExecutor.java```

#### ```CommandExecutor.java```

Gets the command passed on by ```Application.java``` and calls the appropriate *Command* object after basic validations. 

#### ```Command.java``` 

All command Objects implement the below three methods of the ```Command``` Interface. 
* ```execute```
* ```validateParams```
* ```usage```

#### ```command.properties```

This file is found under /src/resources folder. This has the mapping between the acutal commands typed in by the user and the corresponding *Command* object that implements them. Below are the contents 

```
park=com.coderbyte.parkinglot.commands.ParkCommand
leave=com.coderbyte.parkinglot.commands.LeaveCommand
slot_numbers_for_cars_with_colour=com.coderbyte.parkinglot.commands.GetSlotsByColor
registration_numbers_for_cars_with_colour=com.coderbyte.parkinglot.commands.GetRegnosByColor
slot_number_for_registration_number=com.coderbyte.parkinglot.commands.GetSlotByRegno
status=com.coderbyte.parkinglot.commands.StatusCommand
create_parking_lot=com.coderbyte.parkinglot.commands.CreateParkingLot
```

For more detailed Information Refer to ```/doc/``` folder
