package player;

import java.util.Scanner;
import world.World;
import java.lang.Math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import ship.Ship;
import world.World;
import world.World.Coordinate;
import world.World.ShipLocation;

class SubmarineGuesser{
	public Cell[][] board;
	public boolean isSunk;

	SubmarineGuesser(){
		World playerWorld = new World(); 
        int calNumRow = playerWorld.numRow;
        int calNumColumn = playerWorld.numColumn;
        Cell[][] board = new Cell[calNumRow][calNumColumn];
        isSunk = false;
	}

    //initialised guesser map
    public void initialGuesserMap(){
        //implement me
    }

	class Cell{
    	int row, colunm;
    	LinkedList<Cell> adjC;
    	Guess guess;
    	Coordinate coor;
    	boolean isHit;
    	public int probValue;
    	
    	public Cell(int row, int column) {
    		this.row = row;
    		this.colunm = column;
    		this.adjC = new LinkedList<>();
    		this.guess = new Guess();
    		this.guess.row = row;
    		this.guess.column = colunm;
    		this.coor = new World().new Coordinate();
    		coor.row = row;
    		coor.column = column;
    		isHit = false;
            this.probValue = 0; //initialise as 0, assign it later
    	}
    	
    	public void addAdj(Cell cell) {
    		this.adjC.add(cell);
    	}
    	
    	public LinkedList<Cell> getAdj(){
    		return this.adjC;
    	}
    }

    //getter
    public int getCellValue(int vrow, int vcolumn){
    	return board[vrow][vcolumn].probValue;
    }
    public boolean getIsSunk(){
    	return isSunk;
    }
    //setter
    public void setCellValue(int vrow, int vcolumn, int setProbValue){
    	this.board[vrow][vcolumn].probValue = setProbValue;
    }
    public void setIsSunk(boolean setIsSunk){
    	this.isSunk = setIsSunk;
    }

}