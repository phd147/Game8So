package App;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Operator.Operator;
import State.State;

public class App {
	public static void main(String[] args) {
		State start = new State();
		State goal = new State();
		
		State O = null;
		
		
		List<State> open = new ArrayList<State>();
		List<State> close = new ArrayList<State>();
		
		
	
		Random rd = new Random();
		
		State success = new State();
		
		for(int i=0 ;i<100; i++) {
			Operator op = new Operator(rd.nextInt(4));
			success = op.move(success);
			
		}
		
		System.out.println(rd.nextInt(4));
		
		goal.print();
		
		System.out.println("------------------------");
		
		
		
		//1. cho đỉnh xuất phát vào open 
		
		open.add(start);
		
		//2 - 6 ;
		while(open.size() != 0) {
			//3 
			O = open.remove(0);
			
			close.add(O);
			
			// 4 
			if(isEqual(O, goal)) break ;
			
			for(int i= 0; i<4; i++) {
				Operator op = new Operator(i);
				State child = op.move(O);
				if(child == null) continue ;
				if(contains(open, child)) continue ;
				if(contains(close, child)) continue ;
				
				open.add(child);
				
			}
			
		}
		
		if(isEqual(O, goal)) System.out.println("tim kiem thanh cong ");
		O.print();
		
		
			
	}
	
	public static boolean isEqual(State o , State goal) {
		for(int i=0 ;i< 3; i++) {
			for(int j =0; j <3;j++) {
				if(o.d[i][j] != goal.d[i][j]) {
					return false ;
				}
			}
		}
		return true ;
	}
	
	public static boolean contains(List<State> opens, State child) {
		
		for(State open : opens) {
			if(!isEqual(child, open)) {
				return false ;
			}
		}
		
		
		
		return true;
		
	}
	
	
	
	
	
}
