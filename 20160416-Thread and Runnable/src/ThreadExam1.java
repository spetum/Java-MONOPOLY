
class Thread_Ex1 extends Thread {  // ������ Ŭ���� ����
    // Thread Ŭ������ �߻� �޼ҵ�� �ݵ�� ����.
	// ������ ������ �� �ڵ� ȣ��
    public void run() {
        try {
            for(int i = 0; i < 20; i++) { // ������ ���� ������ �ð� ������ �ΰ�
                Thread.sleep(500);       // �޽��� ���
                System.out.println(i + "�� : " + i + "*" + i + "=" + (i * i));
            }
        }
        catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}
// ������ ������ ���� Ŭ����
public class ThreadExam1 {

    public static void main(String[] args) {
        Thread_Ex1 thread = new Thread_Ex1(); // Ŭ���� �ν��Ͻ� ����
        //thread.start();                       // ������ ����
        thread.run();
        System.out.println("������ ���� ���� ���� �ڵ� ���� Ȯ��!!");
    }

}