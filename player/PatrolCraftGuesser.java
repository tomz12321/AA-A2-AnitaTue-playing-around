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

class PatrolCraftGuesser {
	public Cell[][] board;
    public boolean isSunk;
    private int calNumRow;//playerWorld.numRow;
    private int calNumColumn;//playerWorld.numColumn;

    private LinkedList<Cell> prob4;
    private LinkedList<Cell> prob3;
    private LinkedList<Cell> prob2;

	PatrolCraftGuesser(){
		this.calNumRow = 10;
        this.calNumColumn = 10;
        this.board = new Cell[calNumRow][calNumColumn];
        this.isSunk = false;
        
        this.prob4 = new LinkedList<>();
        this.prob3 = new LinkedList<>();
        this.prob2 = new LinkedList<>();
	}

    //initialised guesser map
    public void initialGuesserMap(World world){
        //implement me
        this.calNumRow = world.numRow;
        this.calNumColumn = world.numColumn;
        this.board = new Cell[calNumRow][calNumColumn];
        this.isSunk = false;

        //initialize board
        for(int i = 0; i < calNumRow; i++) {
            for(int j = 0; j < calNumColumn; j++) {
                board[i][j] = new Cell(i, j);
            }
        }

        //prob4 elements
        for(int i = 1; i <= 8; i++)
            for(int j = 1; j <= 8; j++)  
                setCellValue(i, j, 4);

        //prob3 elements
        for(int i = 1; i <= 8; i++)
            setCellValue(i, 0, 3);

        for(int i = 1; i <= 8; i++)
            setCellValue(0, i, 3);

        for(int i = 1; i <= 8; i++)
            setCellValue(9, i, 3);

        for(int i = 1; i <= 8; i++)
            setCellValue(i, 9, 3);

        //prob2 elements
        setCellValue(0, 0, 2);
        setCellValue(0, 9, 2);
        setCellValue(9, 0, 2);
        setCellValue(9, 9, 2);
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