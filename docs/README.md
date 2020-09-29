# User Guide

## Features 
`list` - View list of tasks  
`todo` - Add todo  
`deadline` - Add deadline  
`event` - Add event  
`delete` - Delete task  
`done` - Mark the task as done  
`find` - Find tasks using keyword  
`bye` - Exit program

### Help Feature
This feature shows the available user commands.

## Usage

### `help` - View list of user commands

Show the list of available user commands.

Example of usage: 

`help`

Expected outcome:

`    ____________________________________________________________`    
`    Here's the list of available commands:`  
`    1.help - View list of available user commands`  
`    2.list - View list of tasks`  
`    3.todo - Add todo`  
`    4.deadline - Add deadline`  
`    5.event - Add event`  
`    6.delete - Delete task`  
`    7.done - Mark the task as done`  
`    8.find - Find tasks using keyword`  
`    9.bye - Exit program`    
`    ____________________________________________________________`    

### List Feature
This feature shows the user the list of existing tasks.

## Usage

### `list` - View list of tasks

Show the list of existing tasks.

Example of usage: 

`list`

Expected outcome:

`    ____________________________________________________________`    
`    1.[T][X] borrow book`  
`    2.[D][X] return book (by: 3rd Aug)`  
`    3.[E][X] read book (at: 9am)`    
`    ____________________________________________________________`    

### Add Task Feature 
This feature allows the user to add 3 different types of tasks to the list.

## Usage

### `todo` - Add todo

Add a todo task in the task list.

Example of usage: 

`todo borrow book`

Expected outcome:

`    ____________________________________________________________`   
`    Got it. I've added this task:`  
`    [T][X] borrow book`  
`    Now you have 2 tasks in the list.`  
`    ____________________________________________________________`

### `deadline` - Add deadline

Add a deadline task in the task list.

Example of usage: 

`deadline return book /by 3rd Aug`

Expected outcome:

`    ____________________________________________________________`   
`    Got it. I've added this task:`  
`    [D][X] return book (by: 3rd Aug)`  
`    Now you have 2 tasks in the list.`  
`    ____________________________________________________________`

### `event` - Add event

Add an event task in the task list.

Example of usage: 

`event read book /at 9am`

Expected outcome:

`    ____________________________________________________________`   
`    Got it. I've added this task:`  
`    [E][X] read book (at: 9am)`  
`    Now you have 3 tasks in the list.`  
`    ____________________________________________________________`

### Delete Task Feature 
This feature allows the user to delete a task from the task list.

## Usage

### `delete` - Delete task

Delete a task in the task list based on the index of the task.

Example of usage: 

`delete 3`

Expected outcome:
`    ____________________________________________________________`   
`    If the task with the index exists:`  
`    Noted. I'll removed this task:`   
`    [E][X] read book (at: 9am)`  
`    Task removed successfully!`  
`    Now you have 2 tasks in the list.`  
`    ____________________________________________________________`   

### Complete Task Feature 
This feature allows the user to mark a task in the task list as done.

## Usage

### `done` - Mark the task as done

Mark a task in the task list as done based on the index of the task.

Example of usage: 

`done 1`

Expected outcome:
`    ____________________________________________________________`   
`    Nice! I've marked this task as done:`  
`    [T][V] borrow book`  
`    ____________________________________________________________`   

### Find Task Feature 
This feature allows the user find tasks using a keyword.

## Usage

### `find` - Find tasks by keyword

Find a list of tasks in the task list that contains the given keyword.

Example of usage: 

`find borrow`

Expected outcome:
`    ____________________________________________________________`    
`    Here are the matching tasks in your list:`  
`    1.[T][V] borrow book`  
`    ____________________________________________________________`    

### Exit Feature 
This feature allows the user find tasks using a keyword.

## Usage

### `bye` - Exit the program

Print exit message and end the program.

Example of usage: 

`bye`

Expected outcome:
`    ____________________________________________________________`    
`    Ok cool. Hope to see you again soon... QAQ`  
`    ____________________________________________________________`    

