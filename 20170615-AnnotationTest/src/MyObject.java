/**
 *  참조:
 *    http://jdm.kr/blog/216 
 */
/**
 * 2017.06.15(Thursday) 18:02
 */
// 3rd. Definition of MyObject
//어노테이션을 적용할 클래스를 보여준다.

public class MyObject {
	@StringInjector("My name is JDM.")
	private String name;
	
	@StringInjector
	private String defaultValue;
	
	@StringInjector
	private Integer invalidType;
	
	public String getName() {
		return name;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public Integer getInvalidType() {
		return invalidType;
	}
}
