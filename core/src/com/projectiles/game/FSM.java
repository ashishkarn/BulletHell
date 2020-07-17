package com.projectiles.game;

import com.badlogic.gdx.utils.Array;
import com.projectiles.game.States.State;

public class FSM {
    private State currentState;
    private Array<State> states;
    private int input;
    private int[][] function; //[currentState][input]

    public FSM(){
        states=new Array<State>();
        currentState=new State();
    }

    public void addState(State state){
        states.add(state);
        if(state.stateNumber==0){
            currentState=state;
        }
    }

    public void setFunction(int[][] function){

    }

    public void changeState(int input){

    }

    public void executeCurrentState(){
        //currentState.update();
    }
}
