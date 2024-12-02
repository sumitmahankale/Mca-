class Station {
    constructor(name) {
        this.name = name;
        this.next = null;  
    }
}

class TrainRoute {
    constructor() {
        this.head = null;  
        this.tail = null;  
    }

     
    addStation(name) {
        const newStation = new Station(name);
        if (!this.head) {
            this.head = this.tail = newStation;
            newStation.next = this.head; 
        } else {
            this.tail.next = newStation;
            this.tail = newStation;
            this.tail.next = this.head;  
        }
        console.log(`${name} station added.`);
    }

    
    removeStation(name) {
        if (!this.head) return console.log("No stations to remove.");

        let current = this.head;
        let prev = null;

       
        do {
            if (current.name === name) {
                if (prev) {
                    prev.next = current.next;
                    if (current === this.tail) this.tail = prev; 
                                } else {
                   
                    this.tail.next = current.next;
                    this.head = current.next;
                }
                console.log(`${name} station removed.`);
                return;
            }
            prev = current;
            current = current.next;
        } while (current !== this.head); 

        console.log(`${name} station not found.`);
    }

   
    displayRoute() {
        if (!this.head) {
            console.log("No stations in the route.");
            return;
        }

        let current = this.head;
        let stations = [];
        do {
            stations.push(current.name);
            current = current.next;
        } while (current !== this.head); 

        console.log("Train Route:", stations.join(" -> "));
    }


    moveTrain() {
        if (!this.head) return console.log("No stations in the route.");
        console.log(`Train is at ${this.head.name}`);
        this.head = this.head.next; 
    }
}


const trainRoute = new TrainRoute();


trainRoute.addStation("Station A");
trainRoute.addStation("Station B");
trainRoute.addStation("Station C");


trainRoute.displayRoute();


trainRoute.moveTrain();  
trainRoute.moveTrain();  
trainRoute.moveTrain();  

trainRoute.removeStation("Station B");


trainRoute.displayRoute();


trainRoute.moveTrain();  
