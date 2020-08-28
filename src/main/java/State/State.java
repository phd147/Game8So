package State;

public class State {
	public int d[][];
	public State( int d[][]) {
		this.d = d ;
	}
	
	public State() {
		this.d = new int[3][3];
		for(int i=0 ; i<3; i++) {
			for(int j=0; j<3;j++) {
				this.d[i][j] = (i*3+j +1) %9;
			}
		}
	}
	
	public void print() {
		for(int i=0 ; i<3 ; i ++ ) {
			for(int j =0 ; j< 3 ; j++ ) {
				System.out.print(this.d[i][j]);
			}
			System.out.println();
		}
	}
	
}
