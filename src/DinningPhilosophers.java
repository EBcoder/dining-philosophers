import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.FlatteningPathIterator;
import java.io.IOException;
import java.util.concurrent.Semaphore;

import javax.swing.ImageIcon;

public class DinningPhilosophers {

			// Number of philosophers
			final static int n = 5;			
			final static Philosopher[] philosophers = new Philosopher[n];
		    //final static Forks[] forks = new Forks[n];
			final static Semaphore mutex = new Semaphore(1);
			
			static Display des;

         	private static String phil1="";
        	private static String phil2="";
        	private static String phil3 ="";
        	private static String phil4 ="";
        	private static String phil5 = "";
        	
        	Button starB;
        	Button stopB;
        	
         static boolean wait = true;
			
	  public static void main(String[] args) throws IOException {
		 
					
					
					
					   des = new Display();
					   
			 //while(Display.onClick1==true){
						  
					   
			// }
					
				    // Initialize threads
				    philosophers[0] = new Philosopher(0);
				    for (int i = 1; i < n; i++) {
				      philosophers[i] = new Philosopher(i);
				    };
			
				    // Start the threads
				    for (Thread t : philosophers) {
				      t.start();
				    } 
				
	    
	  }

	  
	  public static class Philosopher extends Thread{
	        
			    enum State {THINKING, HUNGRY, EATING};
			    
			    private final int id;
			    private State state;
			    private final Semaphore self;
			    
			    Philosopher(int id) {
				      this.id = id;
				      self = new Semaphore(0);
				      state = State.THINKING;
			    }
			    
			    private Philosopher left() {
			         return philosophers[id == 0 ? n - 1 : id - 1];
			    }
		
			    private Philosopher right() {
			         return philosophers[(id + 1) % n];
			    }
			    
	  public void run() {
			      try {
			        while (true) {
				          printState();
				          
				          switch(state) {
				          case THINKING: 
				            thinkOrEat();//slows down program
				            mutex.acquire(); //"table" gets forks
				            state = State.HUNGRY; //new state is hungry
				            break;
				          case HUNGRY:
				            // only eat if no neighbor is eating, otherwise wait
				            test(this);
				            mutex.release();//"table" releases forks
				            
				            self.acquire();//this philosopher gets forks
				            //MOVE FORKS HERE
				            state = State.EATING;//new state is eating
				            break;
				          case EATING:
				            thinkOrEat();//slows down program 
				            mutex.acquire();//philosopher releases forks          
				            state = State.THINKING;
				            // if a hungry neighbor can now eat, nudge the neighbor.
				            test(left());  
				            test(right());
				            mutex.release();//"table" releases forks
				            break;          
			          }
			        }
			      } catch(InterruptedException e) {}
			    }
	  static private void test(Philosopher p) {
						      if (p.left().state != State.EATING && p.state == State.HUNGRY &&
						          p.right().state != State.EATING) {
						        p.state = State.EATING;
						        p.self.release();
						      }
			    }
	 private void thinkOrEat() {//slow down 
						      try {
						        Thread.sleep((long) Math.round(Math.random() * 13000));
						      } catch (InterruptedException e) {}
			    }
		
	  private void printState() {
			        
			        	System.out.println("Philosopher " + id + " is " + state);
			        	
			        	//String st = state.toString();
			        	
			        	
			  
			        	int f =0;
			        	
			        	if(id ==0 ){
			        		phil1 = state.toString();
			        		f=1;
			        		//System.out.println("Phil-0:" + "" +phil1);
			        	}
			        	else if(id ==1){
			        		phil2 = state.toString();
			        		f=2;
			        		//System.out.println("Phil-1:" + "" +phil2);
			        	}
			        	else if(id ==2){
			        		phil3 = state.toString();
			        		f=3;
			        		//System.out.println("Phil-2:" + "" +phil3);
			        	}
			        	else if(id ==3){
			        		phil4 = state.toString();
			        		f=4;
			        		//System.out.println("Phil-3:" + "" +phil4);
			        	}
			        	else if(id ==4){
			        		phil5 =state.toString();
			        		f=5;
			        	//	System.out.println("Phil-4:" + "" +phil5);
			        	}
			        	if(f==1){
			        			if(phil1.equals("EATING") )
			        			{
			        		
						        		if(phil2.equals("HUNGRY") || phil2.equals("THINKING")){
						        			if(phil5.equals("HUNGRY") || phil5.equals("THINKING")){
						        				Display.JL1.setIcon(new ImageIcon("food1.png"));
												Display.fork1.setBounds(240, 5, 60, 100);
												Display.fork5.setBounds(245, 0, 60, 100);
								        			}
								        		}
							   }
							   else if(phil1.equals("HUNGRY"))
							   {
								        		Display.JL1.setIcon(new ImageIcon("hungry.png"));

							        			if(!phil5.equals("EATING")){
							        	
								        		
								        		Display.fork5.setBounds(130, 30, 60, 80);
								        			
							        				}
							        			if(!phil2.equals("EATING")){
										        	
									        		Display.fork1.setBounds(280, 30, 60, 100);
									        	
									        			
								        		}
								        		
						     	}
					        else if(phil1.equals("THINKING") )
					        {
						        		Display.JL1.setIcon(new ImageIcon("phil.png"));
						        		
						        			if(!phil5.equals("EATING")){
						        	
							        		
							        		Display.fork5.setBounds(130, 30, 60, 80);
							        			
						        				}
						        			if(!phil2.equals("EATING")){
									        	
								        		Display.fork1.setBounds(280, 30, 60, 100);
								        	
								        			
							        		}
				    		}
					        		
			        	
			        	}
			        	
			        	 if(f==2){
			        
			        	
				        	 if(phil2.equals("EATING") ){
				        		
				        		if(phil1.equals("HUNGRY") || phil1.equals("THINKING")){
				        			if(phil3.equals("HUNGRY") || phil3.equals("THINKING")){
				        				if(!phil1.equals("EATING") && !phil3.equals("EATING"))
				        					{
						        				Display.JL2.setIcon(new ImageIcon("food1.png"));
						        				Display.fork1.setBounds(360, 80, 60, 100);
						    					Display.fork2.setBounds(365, 80, 60, 100);
				        						}
				        					}
						        		}
						        	}
				        	else if(phil2.equals("HUNGRY") ){
					        		Display.JL2.setIcon(new ImageIcon("hungry.png"));
					        		

				        			if(!phil1.equals("EATING")){
				        	
					        		
				        				Display.fork1.setBounds(280, 30, 60, 100);
					        			
				        				}
				        			if(!phil3.equals("EATING")){
							        	
						        		
				        				Display.fork2.setBounds(360, 130, 60, 100);
						        			
					        		}
					        
					        	
					        		
					        	}
				        	else if(phil2.equals("THINKING") ){
				        		Display.JL2.setIcon(new ImageIcon("phil.png"));
				        		if(!phil1.equals("EATING")){
						        	
					        		
			        				Display.fork1.setBounds(280, 30, 60, 100);
				        			
			        				}
			        			if(!phil3.equals("EATING")){
						        	
					        		
			        				Display.fork2.setBounds(360, 130, 60, 100);
					        			
				        		}
				        		
				        		
				        	}
				        		
			        	
			        	}
			        	 if(f==3){
			        	
			        		 if(phil3.equals("EATING") ){
			        		
			        			 if(!phil4.equals("EATING")){
			        				 if(!phil2.equals("EATING")){
			        				Display.JL3.setIcon(new ImageIcon("food1.png"));
			        				Display.JL3.setBackground(Color.red);
			        				Display.fork2.setBounds(385, 260, 60, 60);
			    					Display.fork3.setBounds(330, 260, 60, 60);
			    					
			        				 }
			        			 }
			        		
			        		 }
			        		 else if ( phil3.equals("HUNGRY") ){
					        		Display.JL3.setIcon(new ImageIcon("hungry.png"));
					        		
					        		if(!phil2.equals("EATING")){
							        	
						        		
					        			Display.fork2.setBounds(360, 130, 60, 100);
					        			
				        				}
				        			if(!phil4.equals("EATING")){
							        	
						        		
				        				Display.fork3.setBounds(210, 260, 60, 80);
						        			
					        		}
					        		
					        		
					        	}
				        	else if(phil3.equals("THINKING") ){
				        		Display.JL3.setIcon(new ImageIcon("phil.png"));
				        		if(!phil2.equals("EATING")){
						        	
					        		
				        			Display.fork2.setBounds(360, 130, 60, 100);
				        			
			        				}
			        			if(!phil4.equals("EATING")){
						        	
					        		
			        				Display.fork3.setBounds(210, 260, 60, 80);
					        			
				        		}
				        	}
			        	
			        	 }
			        	if(f == 4){
			        		if(phil4.equals("EATING") ){
			        		
						        if(!phil5.equals("EATING")){
						        		if(!phil3.equals("EATING")){
						        				Display.JL4.setIcon(new ImageIcon("food1.png"));
						        				Display.JL4.setBackground(Color.red);
						        				Display.fork4.setBounds(46, 270, 60, 60);
						    					Display.fork3.setBounds(90, 270, 60, 60);
						      		}
						        }
			        		}
			        		else if(phil4.equals("HUNGRY")){
			        			Display.JL4.setIcon(new ImageIcon("hungry.png"));
			        			
			        		if(!phil3.equals("EATING")){
						        	
					        		
			        				Display.fork3.setBounds(210, 260, 60, 80);
				        			
			        			}
			        			if(!phil5.equals("EATING")){
						        	
					        		
			        				Display.fork4.setBounds(60, 160, 60, 80);
					        			
				        		}
			        			
			        			
			        		}
							else if(phil4.equals("THINKING")){
								Display.JL4.setIcon(new ImageIcon("phil.png"));
								if(!phil3.equals("EATING")){
						        	
					        		
			        				Display.fork3.setBounds(210, 260, 60, 80);
				        			
			        			}
			        			if(!phil5.equals("EATING")){
						        	
					        		
			        				Display.fork4.setBounds(60, 160, 60, 80);
					        			
				        		}
											        			
											        		
							}
							
			        	}
			        	if(f==5){
			        		if(phil5.equals("EATING") ){
				        		
				        		if(!phil1.equals("EATING")){
				        			if(!phil4.equals("EATING")){
				        				Display.JL5.setIcon(new ImageIcon("food1.png"));
				        				Display.JL5.setBackground(Color.red);
				        				Display.fork4.setBounds(67, 80, 60, 60);
				    					Display.fork5.setBounds(65, 80, 60, 60);
				        			}
				        		}
				        		
				        	}
			        		else if(phil5.equals("HUNGRY") ){
			        			Display.JL5.setIcon(new ImageIcon("hungry.png"));
			        			
			        			if(!phil1.equals("EATING")){
						        	
					        		
			        				Display.fork5.setBounds(130, 20, 60, 80);
				        			
			        			}
			        			if(!phil4.equals("EATING")){
						        	
					        		
			        				Display.fork4.setBounds(60, 160, 60, 80);
					        			
				        		}
			        			
			        		}
							else if(phil5.equals("THINKING") ){
								Display.JL5.setIcon(new ImageIcon("phil.png"));
								if(!phil1.equals("EATING")){
						        	
					        		
			        				Display.fork5.setBounds(130, 20, 60, 80);
				        			
			        			}
			        			if(!phil4.equals("EATING")){
						        	
					        		
			        				Display.fork4.setBounds(60, 160, 60, 80);
					        			
				        		}
			        		}
			        		
			        		
			        	}
			        	
			        	/*else if(phil5.equals("EATING") ){
			        		
			        		if(!phil1.equals("EATING")){
			        			if(!phil4.equals("EATING")){
			        				Display.JL5.setIcon(new ImageIcon("food1.png"));
			        				Display.JL5.setBackground(Color.red);
			        				Display.fork4.setBounds(67, 80, 60, 60);
			    					Display.fork5.setBounds(65, 80, 60, 60);
			        			}
			        		}
			        		
			        	}
			       	*/
			       }
		  }
	}   





