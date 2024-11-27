class EditNode {
    constructor(text, user) {
        this.text = text;  
        this.user = user;  
        this.next = this.prev = null; 
    }
}

class CollaborativeEditor {
    constructor() {
        this.head = this.tail = this.current = null; 
    }

        applyEdit(text, user) {
        const newEdit = new EditNode(text, user);
        if (!this.head) {
            this.head = this.tail = this.current = newEdit;
        } else {
            this.tail.next = newEdit;
            newEdit.prev = this.tail;
            this.tail = newEdit;
            this.current = this.tail; 
        }
        console.log(`${user} edited: "${text}"`);
    }

    
    undo() {
        if (this.current && this.current.prev) {
            this.current = this.current.prev;
            console.log(`Undo: Current text is "${this.current.text}"`);
        } else {
            console.log("No more edits to undo.");
        }
    }

    
    redo() {
        if (this.current && this.current.next) {
            this.current = this.current.next;
            console.log(`Redo: Current text is "${this.current.text}"`);
        } else {
            console.log("No more edits to redo.");
        }
    }

    
    displayCurrentText() {
        if (this.current) {
            console.log(`Current text: "${this.current.text}"`);
        } else {
            console.log("No text available.");
        }
    }

        displayHistory() {
        let current = this.head, history = [];
        while (current) {
            history.push(`${current.user}: ${current.text}`);
            current = current.next;
        }
        console.log("Edit History:");
        console.log(history.join("\n"));
    }
}

const editor = new CollaborativeEditor();


editor.applyEdit("Hello world!", "User1");
editor.applyEdit("Hello world! How are you?", "User2");
editor.applyEdit("Hello world! How are you? I'm fine.", "User1");


editor.displayCurrentText();  


editor.undo();  

editor.redo();  

editor.displayHistory();  
