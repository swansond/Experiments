import java.util.TimerTask;


public class IncrementJob extends TimerTask {
	@Override
	public void run() {
		synchronized(ComputeMain.data) {
			System.out.println("Banked: " + ComputeMain.data.banked);
			ComputeMain.data.banked += ComputeMain.data.rate;
		}
	}
}
