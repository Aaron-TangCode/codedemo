package com.hailintang.demo.designpattern.statepattern;

public class MarioStateMachine {
    private int score;
    private State currentState;

    public MarioStateMachine() {
        this.score = 0;
        this.currentState = State.SMALL;
    }

    public void obtainMushRoom() { //TODO
    }

    public void obtainCape() { //TODO
    }

    public void obtainFireFlower() { //TODO
    }

    public void meetMonster() { //TODO
    }

    public int getScore() {
        return this.score;
    }

    public State getCurrentState() {
        return this.currentState;
    }
}

