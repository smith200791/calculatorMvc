package implemented;

import java.util.Scanner;

import intf.TimeShift;

public class Timer {

	TimeShift action;

	/**
	 * �������, ������� �������� ����������� ��� ��������� �������.
	 */
	void run() {
		if (isTime()) {
			action.onTime();
			// action.
		}
	}

	/**
	 * ��������� �������, ������� ����� �� ���� ��� ������ �� ��������. ��
	 * ���������� �� ��������� � ������ ���������.
	 * 
	 * @return
	 */
	private boolean isTime() {
		return true;
	}

	public static void main(String[] args) {

		System.out.println("������� ��� ��������:");
		Scanner scanner = new Scanner(System.in);
		String actionType = scanner.nextLine();
		Timer timer = new Timer();

		if (actionType.equalsIgnoreCase("set wake up timer")) {
			timer.action = new WakeUpTimer();
		} else if (actionType.equalsIgnoreCase("set chicken timer")) {
			timer.action = new CarSignalTimer();
		}
		
		

		timer.run();
	}
}
