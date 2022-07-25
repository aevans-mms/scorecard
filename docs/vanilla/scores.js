let settings = {
    app: 
    {
        name: "Scores"
    }
}

class FW
{
    // framework code

    constructor(settings)
    {
        self = this
        self.cfg = settings
        self.log("in constructor for app ", self.cfg.app.name)
    }   

    log(...message) 
    {
        console.log("[FW:log]", ...message)
    }

    init(event) 
    {
        self.log("init()")
    }
    
    element(selector)
    {
        const element =  document.querySelector(selector)
        self.log("element", element)
        return element
    }

    elements(selector)
    {
        const elements = document.querySelectorAll(selector)
        self.log("elements", element)
        return elements
    }



    // application code 

    choose_team(event) {
        self.log("choose_team()");
        const element = event.target
        self.log(event.type, element.type, element)
    
        // check if we got a <select> element
        if (! element.type.includes("select"))
        {
            self.log("[ERROR] was expected `select` but got", element.type);
            throw new Error("unepected element type: " + element)
        }
        
        const select = element
        self.log("select.value", select.value);
    }
}



let team1_locator = document.querySelector("#team1");
let team1_selector = team1_locator.querySelector("select");
let team1_button = team1_locator.querySelector("button.counter")

let team2_locator = document.querySelector("#team2");
let team2_selector = team2_locator.querySelector("select");
let team2_button = team2_locator.querySelector("button.counter")

const fw = new FW(settings)

window.addEventListener("load", fw.init);

team1_selector.addEventListener('change', fw.choose_team);


team2_selector.addEventListener('change', function(event) {
    var team = event.target.name;
    console.log("team: " + team);
    set_team(team);
});


function set_team(team_id)
{
    console.log(`fname(team_id=${team_id})`)
    
    var teamElement = document.getElementById(team_id)
    console.log("teamElement", teamElement)

    var teamSelect = teamElement.querySelector("select")
    console.log(teamSelect)

    var teamButton = teamElement.querySelector("button.counter")
    console.log(teamButton)
    
    var teamReset = teamElement.querySelector("button.reset")
    console.log(teamReset)

    var teamName = teamSelect.value
    console.log("teamName", teamName)

    console.log("...todo set team")
}


class Team 
{
    _id = undefined
    _name = undefined
    _score = 0
    
    constructor(name) {
        this._name = name
    }

    set name(name) {
        this._name = name
    }

    get name() {
        return this._name
    }

    set score(score) {
        this._score = score
   }

    get score() {
        return this._score
    }

    increment() {
        this._score += 1
    }

    decrement() {
        this._score -= 1
    }

    team_locator(team_id) {
        return document.getElementById(team_id)
    }
}


class TeamComponent {
    
    _locator = undefined

    constructor(locator) {
        this._locator = locator;
    }

    element() {
        var element = document.querySelector(this._locator)
        return element
    }

    selector() {
        var select =  this.element().querySelector("select")
        return select
    }

    counter() {
        var counter = this.element().querySelector("button.counter")
        return counter
    }

    label() { 
        var label = this.counter().querySelector(".team_label")
        return label
    }

    score() {
        var score = this.counter().querySelector(".team_score")
    }



    team_label_element()
    updateScore(team_id) {   
        var teamElement = document.getElementById(team_id)
        console.log("teamElement", teamElement)

        var teamSelect = teamElement.querySelector("select")
        console.log(teamSelect)

        var teamButton = teamElement.querySelector("button.counter")
        console.log(teamButton)

        var teamLabel = teamElement.querySelector(".team_label")
        console.log(teamLabel)

        var teamScore = teamElement.querySelector(".team_score")

        teamSelect.value = this.score
    }
}
const ScoresApp = {
    team1 : undefined,
    team2 : undefined,
    
    init : function init() {
        var name1 = window.team1.name
        var score1 = window.team1.score

        var name2 = window.team2.name
        var score2 = window.team2.score

        this.team1 = new Team(name1, score1)
        this.team2 = new Team(name2, score2)

        console.log("ScoresApp team1", this.team1)
        console.log("ScoresApp team2", this.team2)
    }
}




window.addEventListener("load", ScoresApp.init)

function fname() { return arguments.callee.name }