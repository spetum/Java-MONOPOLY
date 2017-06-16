/*
 *  ����:
 *    http://jdm.kr/blog/216 
 */
/*
 * 2017.06.15(Thursday) 18:02
 */
// 1st. Declaration of MyAnnotation interface 

import java.lang.annotation.*;

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME) // ������ ���Ŀ��� JVM�� ���ؼ� ������ �����մϴ�.
//@Retention(RetentionPolicy.CLASS) // �����Ϸ��� Ŭ������ ������ ������ ��ȿ�մϴ�.
//@Retention(RetentionPolicy.SOURCE) // ������̼� ������ ������ ���� �������ϴ�.
@Target({
        ElementType.PACKAGE, // ��Ű�� �����
        ElementType.TYPE, // Ÿ�� �����
        ElementType.CONSTRUCTOR, // ������ �����
        ElementType.FIELD, // ��� ���� �����
        ElementType.METHOD, // �޼ҵ� �����
        ElementType.ANNOTATION_TYPE, // ������̼� Ÿ�� �����
        ElementType.LOCAL_VARIABLE, // ���� ���� �����
        ElementType.PARAMETER, // �Ű� ���� �����
        ElementType.TYPE_PARAMETER, // �Ű� ���� Ÿ�� �����
        ElementType.TYPE_USE // Ÿ�� ����
})
public @interface MyAnnotation {
    /* enum Ÿ���� ������ �� �ֽ��ϴ�. */
    public enum Quality {BAD, GOOD, VERYGOOD}
    /* String�� �⺻ �ڷ����� �ƴ����� ��� �����մϴ�. */
    String value();
    /* �迭 ���·ε� ����� �� �ֽ��ϴ�. */
    int[] values();
    /* enum ���¸� ����ϴ� ����Դϴ�. */
    Quality quality() default Quality.GOOD;
}
