package Operator;

import java.awt.Point;

import State.State;

public class Operator {
	// 0 : up 
	// 1 : down ;
	// 2 : left ;
	// 3 : right 
	
	public int i ;
	
	public Operator(int i) {
		this.i = i ;
	}
	
	
	public State move(State s ) {
		
		switch (this.i) {
		case 0:
			return this.Up(s);
			
		case 1:
			return this.Down(s);
		case 2:
			return this.Left(s);
		case 3:
			return this.Right(s);
					
		default:
			return null;
		}
		
		
	}


	private State Right(State s) {
		System.out.println("trai");
		MyPoint zero =  Pzero(s);
		if( zero.j==0) return s ;
		State s1 = new State(s.d);
		s1.d[zero.i][zero.j]= s.d[zero.i][zero.j-1];  
		s1.d[zero.i][zero.j-1] = 0;
		return s1;
	}


	private State Left(State s) {
		System.out.println("phai");
		MyPoint zero =  Pzero(s);
		if( zero.j==2) return s;
		State s1 = new State(s.d);
		s1.d[zero.i][zero.j]= s.d[zero.i][zero.j+1];  
		s1.d[zero.i][zero.j+1] = 0;
		return s1;
	}


	private State Down(State s) {
		System.out.println("len");
		MyPoint zero =  Pzero(s);
		if( zero.i==0) return s ;
		State s1 = new State(s.d);
		s1.d[zero.i][zero.j]= s.d[zero.i-1][zero.j];  
		s1.d[zero.i-1][zero.j] = 0;
		return s1;
	}


	private State Up(State s) {
		System.out.println("xuong ");
		MyPoint zero =  Pzero(s);
		if( zero.i==2) return s ;
		State s1 = new State(s.d);
		s1.d[zero.i][zero.j]= s.d[zero.i+1][zero.j];  
		s1.d[zero.i+1][zero.j] = 0;
		return s1;
	
	}


	private MyPoint Pzero(State s) {
		
		for(int i=0 ;i< 3 ; i++) {
			for(int j=0 ;j< 3; j++) {
				if(s.d[i][j] == 0 ) return new MyPoint(i,j);
			}
		}
		return null;
	}
	
	

	
}
class MyPoint {
	public int i;
	public int j ;
	public MyPoint(int i, int j ) {
		this.i = i ;
		this.j = j ;
	}
}





