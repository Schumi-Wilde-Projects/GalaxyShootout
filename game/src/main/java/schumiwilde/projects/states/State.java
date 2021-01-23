package schumiwilde.projects.states;

import schumiwilde.projects.Orchestrator;

public abstract class State {
    protected Orchestrator orchestrator;

    public abstract void handleUserInput();
}
