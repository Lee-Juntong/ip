# User Guide
Duke is __a desktop app for managing tasks,
optimized for use via a Command Line Interface__ (CLI). 
This application aims to help the user store tasks and trace the status of tasks.

### [Quick Start](#quick-start)
### [Features](#features) 
* [Adding Todo: `todo`](#adding-todo-todo)
* [Adding Event: `event`](#adding-event-event)
* [Adding Deadline: `deadline`](#adding-deadline-deadline)
* [Listing Tasks: `list`](#listing-tasks-list)
* [Finding Tasks: `find`](#finding-tasks-find)
* [Deleting Task: `delete`](#deleting-task-delete)
* [Done Task: `done`](#done-task-done)
* [Exit the Application: `bye`](#exit-the-application-bye)
* [Find Tasks on Date: `date`](#find-tasks-on-date-date)
### [FAQ](#faq)
### [Command Summary](#command-summary)

---
### Quick Start

1. Ensure you have Java `11` or above installed in your Computer.
1. Download the latest `DUKE.jar` from [here](https://github.com/Lee-Juntong/ip/releases/tag/v0.2).
1. Copy the file to the folder you want to use as the home folder for your *Duke*.
1. Open the terminal in this folder. Type `java -jar Duke.jar` and press enter, to start this application.
1. Type the command in the terminal and press Enter to execute it. <p>
    Some example commands you can try: <p>
    * `todo finish homework` : Adds a Todo "finish homework" to the task list.
    * `list` : Lists all tasks.
    * `find homework` : Prints all tasks having the keyword in the description
    * `bye` : Exits the application.
1. Refer to the [Features](#features) below for details of each command.    
---
### Features
###### Notes about the command format:

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<p>
e.g. in todo `DESCRIPTION`, `DESCRIPTION` is a parameter which can be used as `todo do something`.

#### Adding Todo: `todo`
Adds a Todo to the task list.<p>
**Format**: `todo DESCRIPTION`<p>
Examples:<p>
* `todo finish homework`

#### Adding Event: `event`
Adds an Event to the task list.<p>
**Format**: `event DESCRIPTION /at TIME`<p>
Note the format for `TIME` should be `yyyy-MM-dd HH:mm`<p>
For example, `2000-01-01 00:00`<p>
Example:<p>
* `event meeting /at 2020-10-01 13:00`

#### Adding Deadline: `deadline`
Adds a deadline to the task list.<p>
**Format**: `deadline DESCRIPTION /by TIME`<p>
Note the format for `TIME` should be `yyyy-MM-dd HH:mm`<p>
For example, `2000-01-01 00:00`<p>
Example:<p>
* `deadline submitting homework /by 2020-10-01 23:59`

#### Listing Tasks: `list`
Prints all tasks in the list.<p>
**Format**:`list`

#### Finding Tasks: `find`
Prints all tasks in the list that contains the keyword that the user want.<p>
**Format**:`find KEYWORD`<p>
Example:<p>
* `find book`

#### Deleting Task: `delete`
Deletes the task with the given index.<p>
**Format**:`delete INDEX`<p>
Example:<p>
* `delete 1`

#### Done Task: `done`
Marks the task with the given index as done.<p>
**Format**:`done INDEX`<p>
Example:<p>
* `done 1`

#### Find Tasks on Date: `date`
Prints all tasks in the list that happens on a certain date.<p>
**Format**:`date DATE`<p>
Example:<p>
* `date 2020-10-01`

#### Exit the Application: `bye`
Exits the application.<p>
**Format**:`bye`
---
### FAQ
**Q**: How do I transfer my data to another Computer?<p>
**A**: Install the app in the other computer and overwrite the data\tasks.txt file it creates with the file that contains your previous data.
---
### Command Summary
ACTION | FORMAT & EXAMPLE
------------ | -------------
Add Todo | `todo DESCRIPTION`<p> e.g.`todo do something`
Add Event| `event DESCRIPTION /at TIME`<p> e.g.`event meeting /at 2020-10-01 13:00`
Add Deadline| `deadline DESCRIPTION /by TIME`<p> e.g.`deadline submitting homework /by 2020-10-01 23:59`
List Tasks|`list`
Find Task|`find KEYWORD`<p> e.g.`find book`
Delete Task|`delete INDEX`<p> e.g.`delete 1`
Done Task|`done INDEX`<p> e.g.`done 1`
Find Task on Date|`date DATE`<p> e.g.`date 2020-10-01`
Exit|`bye`
