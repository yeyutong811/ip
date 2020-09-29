# User Guide

Duke is a task scheduler that allows you to manage 3 types of tasks: todos, deadlines or events. 

## Quick Start
1. Ensure you have Java 11 or above installed on your computer.  
2. Download the latest `.jar` file.  
3. Copy the file to your desired home folder.  
4. In command prompt, use `cd` to navigate to the home folder.  
5. Run the `.jar` file in command prompt by entering `java -jar duke.jar` 
6. Enter `help` to view available user commands.
7. Refer to the guide below for details of each command. 

## Features 

### 1. Help Feature
This feature shows the available user commands.

### Usage

### `help` - View list of user commands

Show the list of available user commands.

Example of usage: 

`help`

Expected outcome:

```
    ____________________________________________________________    
    Here's the list of available commands:  
    1.help - View list of available user commands  
    2.list - View list of tasks  
    3.todo - Add todo  
    4.deadline - Add deadline  
    5.event - Add event  
    6.delete - Delete task  
    7.done - Mark the task as done  
    8.find - Find tasks using keyword  
    9.bye - Exit program    
    ____________________________________________________________
```    

### 2. List Feature
This feature shows the user the list of existing tasks.

### Usage

### `list` - View list of tasks

Show the list of existing tasks.

Example of usage: 

`list`

Expected outcome:
```
    ____________________________________________________________ 
    1.[T][X] borrow book   
    2.[D][X] return book (by: 3rd Aug)   
    3.[E][X] read book (at: 9am)   
    ____________________________________________________________    
```

### 3. Add Task Feature 
This feature allows the user to add 3 different types of tasks to the list.

### Usage

### `todo` - Add todo task

Add a todo task in the task list.

Example of usage: 

`todo borrow book`

Expected outcome:
```
    ____________________________________________________________   
    Got it. I've added this task:  
    [T][X] borrow book  
    Now you have 2 tasks in the list.  
    ____________________________________________________________
```

### `deadline` - Add deadline task

Add a deadline task in the task list.

Example of usage: 

`deadline return book /by 3rd Aug`

Expected outcome:

```
    ____________________________________________________________   
    Got it. I've added this task:  
    [D][X] return book (by: 3rd Aug)  
    Now you have 2 tasks in the list.  
    ____________________________________________________________
```

### `event` - Add event task

Add an event task in the task list.

Example of usage: 

`event read book /at 9am`

Expected outcome:

```
    ____________________________________________________________   
    Got it. I've added this task:  
    [E][X] read book (at: 9am)  
    Now you have 3 tasks in the list.  
    ____________________________________________________________
```

### 4. Delete Task Feature 
This feature allows the user to delete a task from the task list.

### Usage

### `delete` - Delete task

Delete a task in the task list based on the index of the task.

Example of usage: 

`delete 3`

Expected outcome:
```
    ____________________________________________________________   
    If the task with the index exists:  
    Noted. I'll removed this task:   
    [E][X] read book (at: 9am)  
    Task removed successfully!  
    Now you have 2 tasks in the list.  
    ____________________________________________________________   
```

### 5. Complete Task Feature 
This feature allows the user to mark a task in the task list as done.

### Usage

### `done` - Mark the task as done

Mark a task in the task list as done based on the index of the task.

Example of usage: 

`done 1`

Expected outcome:
```
    ____________________________________________________________   
    Nice! I've marked this task as done:  
    [T][V] borrow book  
    ____________________________________________________________   
```

### 6. Find Task Feature 
This feature allows the user find tasks using a keyword.

### Usage

### `find` - Find tasks by keyword

Find a list of tasks in the task list that contains the given keyword.

Example of usage: 

`find borrow`

Expected outcome:
```
    ____________________________________________________________    
    Here are the matching tasks in your list:  
    1.[T][V] borrow book  
    ____________________________________________________________    
```

### 7. Exit Feature 
This feature allows the user find tasks using a keyword.

### Usage

### `bye` - Exit the program

Print exit message and end the program.

Example of usage: 

`bye`

Expected outcome:
```
    ____________________________________________________________    
    Ok cool. Hope to see you again soon... QAQ  
    ____________________________________________________________    
```

## Command Summary

Command | Function | Format
------------ | ------------- | -------------
help | View list of commands | `help`
list | View list of tasks | `list`
todo | Add todo task | `todo` **Task Name**
deadline | Add deadline task | `deadline` **Task Name /by Task Time**
event | Add event task | `event` **Task Name /at Task Time**
delete | Delete task | `delete` **Task Index**
done | Mark task as done | `done` **Task Index**
find | Find tasks by keyword |  `find` **Keyword**
bye | Exit program | `bye`