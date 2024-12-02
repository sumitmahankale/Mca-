class Task {
    constructor(name, priority, duration) {
        this.name = name;
        this.priority = priority;
        this.duration = duration;
        this.next = this.prev = null;
    }
}

class TaskScheduler {
    constructor() {
        this.head = this.tail = null;
    }

    addTask(name, priority, duration) {
        const newTask = new Task(name, priority, duration);
        let current = this.head;

        if (!this.head) {
            this.head = this.tail = newTask;
            return;
        }

        while (current && current.priority >= priority) current = current.next;

        if (!current) {
            this.tail.next = newTask;
            newTask.prev = this.tail;
            this.tail = newTask;
        } else if (current === this.head) {
            newTask.next = this.head;
            this.head.prev = newTask;
            this.head = newTask;
        } else {
            newTask.prev = current.prev;
            newTask.next = current;
            current.prev.next = newTask;
            current.prev = newTask;
        }
    }

   
    executeTask() {
        if (!this.head) return console.log("No tasks.");
        const task = this.head;
        console.log(`Executing ${task.name} for ${task.duration}s`);
        if (this.head === this.tail) this.head = this.tail = null;
        else this.head = this.head.next;
        if (this.head) this.head.prev = null;
        setTimeout(() => console.log(`${task.name} completed.`), task.duration * 1000);
    }


    displayTasks() {
        let current = this.head, tasks = [];
        while (current) {
            tasks.push(`${current.name} (Priority: ${current.priority})`);
            current = current.next;
        }
        console.log(tasks.join(" | "));
    }
}


const scheduler = new TaskScheduler();
scheduler.addTask("Task 1", 3, 5);
scheduler.addTask("Task 2", 1, 2);
scheduler.addTask("Task 3", 5, 4);
scheduler.addTask("Task 4", 2, 3);

scheduler.displayTasks();  
scheduler.executeTask();   
setTimeout(() => scheduler.executeTask(), 6000);  
