package person.liming.test.test20;

/**
 * @author liuliming
 *
 */
public enum Week {
	Monday("����һ"), Tuesday("���ڶ�"), Wednesday("������"), Thursday("������"), Friday("������"), Saturday("������"), Sunday("������");

	private final String chinaName;
	
	private Week(String chinaName) {
		this.chinaName = chinaName;
	}
	
	public String getChinaName(){
		return chinaName;
	}
	
}