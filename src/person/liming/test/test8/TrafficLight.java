package person.liming.test.test8;

public enum TrafficLight {
	RED("���", 1), YELLOW("�Ƶ�", 2), GREEN("�̵�", 3);
	
	private String name;
	private int index;
	
	private TrafficLight(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public TrafficLight nextLight(){
		//ת����һ����
		switch (this) {
		case RED:
			return YELLOW;
		case YELLOW:
			return GREEN;
		default:
			return RED;
		}
		
	}
}
