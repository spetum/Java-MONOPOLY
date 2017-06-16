
class Thread_Ex1 extends Thread {  // 스레드 클래스 선언
    // Thread 클래스의 추상 메소드로 반드시 구현.
	// 스레드 시작할 때 자동 호출
    public void run() {
        try {
            for(int i = 0; i < 20; i++) { // 루프를 돌며 정해진 시간 간격을 두고
                Thread.sleep(500);       // 메시지 출력
                System.out.println(i + "번 : " + i + "*" + i + "=" + (i * i));
            }
        }
        catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}
// 스레드 실행을 위한 클래스
public class ThreadExam1 {

    public static void main(String[] args) {
        Thread_Ex1 thread = new Thread_Ex1(); // 클래스 인스턴스 생성
        //thread.start();                       // 스레드 시작
        thread.run();
        System.out.println("스레드 종료 전에 다음 코드 실행 확인!!");
    }

}