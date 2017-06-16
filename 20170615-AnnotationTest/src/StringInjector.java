/**
 *  ����:
 *    http://jdm.kr/blog/216 
 */
/**
 * 2017.06.15(Thursday) 18:02
 */
// 2nd. Declaration of StringInjector interface
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * String ���ڿ��� �����ϱ� ���� �����ϴ� ������̼��Դϴ�.
 * FIELD���� ���𰡴��ϰ� JVM�� ������̼� ������ �����մϴ�.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface StringInjector {
	String value() default "This is StringInjector.";
}
