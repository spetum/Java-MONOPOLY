/*
 *  참조:
 *    http://jdm.kr/blog/216 
 */
/*
 * 2017.06.15(Thursday) 18:02
 */
// 5th Definition of AnnotationDemo class
// 코드들을 전부 통합해 만든 테스트 프로그램
public class AnnotationDemo {
	public static void main(String[] args) 
			throws IllegalAccessException, InstantiationException {
		// 컨텍스트 컨테이너를 초기화 합니다.
		MyContextContainer demo = new MyContextContainer();
		// MyOjbect 객체를 하나 받아옵니다.
		MyObject obj = demo.get(MyObject.class);
		System.out.println(obj.getName()); // print is "My name is JDM."
		System.out.println(obj.getDefaultValue()); // print is "This is StringInjector."
		System.out.println(obj.getInvalidType()); // print is "null".
	}
}
