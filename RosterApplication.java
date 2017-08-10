
import javax.swing.JFrame;

public class RosterApplication {
	public static void main(String[] args) {
		// create a JFrame
		JFrame myFrame = new JFrame("Professor Nada's Classes List!");

		// create an instance of the controller
		RosterController program = new RosterController();
		// add the controller to the frame
		myFrame.add(program);

		// set the frame's size
		myFrame.setSize(700, 800);
		// exit on close
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set it to be visible
		myFrame.setVisible(true);

	}

}
