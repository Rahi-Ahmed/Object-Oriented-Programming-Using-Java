 import java.util.ArrayList;
import java.util.Random;

public class BurgerAndFries {
	public static int cheeseLeft; // initial amount of cheese
	public static int cheeseLost = 0; //stores the lost amount of cheese
	public static int secondCount = 0; //check and stores current second
	public static ArrayList<Integer> MouseID = new ArrayList<Integer>(); //this is for mouses
	public static ArrayList<Integer> TrapID = new ArrayList<Integer>(); //this is for empty trap
	public static ArrayList<Integer> TrapFilled = new ArrayList<Integer>(); //this is for filled traps
	
	public static int X, Y , caughtMouse = 0; //mouse number, trap number and caught mouse respectively

	public static int cheeseStatus = 0; //it will check whether the machine add cheese or not
	public static int ownerStatus = 0; //it will set after each 5 seconds

	public void cheeseAdding() {
		synchronized (this) {
			while (caughtMouse < X) { //checking the breaking condition
				while (cheeseStatus == 0 && caughtMouse < X) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (caughtMouse < X) {
					System.out.println("[Action] cheese machine add 10 grams of cheese"); //if all conditions satisfied, cheese machine will add 10gms of cheese
					cheeseLeft += 10; //cheeseLeft will be increased also
					System.out.println("[Status] cheese left: "+cheeseLeft); //showing status
					System.out.println("");
					try{
						Thread.sleep(1000);
					}
					catch(InterruptedException e){
						e.printStackTrace();
					}
					cheeseStatus = 0; //cheeseStatus is set to 0
					notifyAll();
				}
			}

		}
	}

	
	//this method will check what the mouses are doing
	public void mouseDoing() {
		synchronized (this) {

			while (caughtMouse < X) {
				if (secondCount != 0 && secondCount % 2 == 0) { //if a cheese adding condition satisfied, current thread will be resumed
					cheeseStatus = 1;
					notifyAll();
					try {
						wait();

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (secondCount != 0 && secondCount % 5 == 0) { //if a mouse removing condition satisfied, current thread will be resumed
					ownerStatus = 1;
					notifyAll();
					try {
						wait();

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Random rand = new Random(); //creating random object to randomly generate states
				int state = rand.nextInt(2);
				if (state == 0 && MouseID.size() > 0 && TrapID.size() > 0) { //if it is a zero state means mouse will be caught
					int mouse = rand.nextInt(MouseID.size());
					int trap = rand.nextInt(TrapID.size());

					int trapNumber = TrapID.get(trap);

					TrapFilled.add(trapNumber);
					TrapID.remove(trap);

					System.out.println("[Action] mouse-" + MouseID.get(mouse)
							+ " get caught by trap");
					System.out.println("");

					MouseID.remove(mouse);

				}

				else if (state == 1 && MouseID.size() > 0) {
					int mouse = rand.nextInt(MouseID.size());
					if (cheeseLeft > 0) { // if the amount of cheese in the
											// container is greater than 0gm
											// then proceed
						int cheeseTaken = rand.nextInt(3) + 1; // randomly
																// generates the
																// amount of
																// cheese to be
																// consumed

						if (cheeseTaken <= cheeseLeft) {
							cheeseLeft = cheeseLeft - cheeseTaken;

							cheeseLost = cheeseLost + cheeseTaken;

							System.out.println("[Action] mouse-"
									+ MouseID.get(mouse) + " ate "
									+ cheeseTaken + " grams of cheese");
							System.out.println("[Status] cheese left: "
									+ cheeseLeft);
							System.out.println("");
						} else {

							System.out.println("[Action] mouse-"
									+ MouseID.get(mouse) + " ate " + cheeseLeft
									+ " grams of cheese");
							System.out.println("[Status] cheese left: 0");
							System.out.println("");

							cheeseLost = cheeseLost + cheeseLeft;

							cheeseLeft = 0;
						}
					} else { // no cheese in the container
						System.out
								.println("[Action] mouse-" + MouseID.get(mouse)
										+ " is waiting for cheese");
					}
				}

				secondCount++;
				try{
					Thread.sleep(1000);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}

			}
		}
	}

	public void trapOwner() { //this method is for trap owner to remove mouses from filled traps

		synchronized (this) {
			while (caughtMouse < X) {
				while (ownerStatus == 0 && caughtMouse < X) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("=========================================================================");
				for (int i = 0; i < TrapFilled.size(); i++) {
					System.out.println("Owner Removed Mouse From Trap-"+ TrapFilled.get(i));
					TrapID.add(TrapFilled.get(i));
					try{
						Thread.sleep(1000);
					}
					catch(InterruptedException e){
						e.printStackTrace();
					}
					caughtMouse++;
				}
				System.out.println("=========================================================================");
				TrapFilled.clear();
				
				ownerStatus = 0;
				notifyAll();
			}

		}
	}

	public static void main(String[] args) throws NullPointerException {

		X = 5; //initializing number of mouses
		Y = 3; //initializing number of traps
		cheeseLeft = 20;
		
		
		System.out.println("[Status] cheese left: "+cheeseLeft);
		System.out.println("");
		
		
		for (int i = 1; i <= X; i++) {
			MouseID.add(i); //initializing ArrayList
		}
		for (int i = 1; i <= Y; i++) {
			TrapID.add(i);
		}

		final BurgerAndFries t = new BurgerAndFries(); //creating object of the class

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				t.cheeseAdding(); //thread for cheeseAdding
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				t.mouseDoing(); //thread for mouse's actions
			}
		});

		Thread t3 = new Thread(new Runnable() {
			public void run() {
				t.trapOwner(); //thread for trapOwner
			}
		});

		//starting threads
		t1.start();
		t2.start();
		t3.start();
		try {
			//joining threads
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException exc) {
			exc.printStackTrace();
		}
		
		
		System.out.println("[Status] Total cheese lost = "+cheeseLost);
		

	}

}
