package leetcode.editor.cn;

//我们提供了一个类： 
//
// 
//public class Foo {
//  public void first() { print("first"); }
//  public void second() { print("second"); }
//  public void third() { print("third"); }
//} 
//
// 三个不同的线程 A、B、C 将会共用一个 Foo 实例。 
//
// 
// 一个将会调用 first() 方法 
// 一个将会调用 second() 方法 
// 还有一个将会调用 third() 方法 
// 
//
// 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3]
//输出: "firstsecondthird"
//解释: 
//有三个线程会被异步启动。
//输入 [1,2,3] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用 third() 方法。
//正确的输出是 "firstsecondthird"。
// 
//
// 示例 2: 
//
// 
//输入: [1,3,2]
//输出: "firstsecondthird"
//解释: 
//输入 [1,3,2] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 third() 方法，线程 C 将会调用 second() 方法。
//正确的输出是 "firstsecondthird"。 
//
// 
//
// 提示： 
//
// 
// 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。 
// 你看到的输入格式主要是为了确保测试的全面性。 
// 
// 👍 259 👎 0

import java.util.concurrent.Semaphore;

public class PrintInOrder{
    public static void main(String[] args) {
        Solution solution = new PrintInOrder().new Solution();
        solution.run();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Foo {
        public final Semaphore semaphore2 = new Semaphore(0);
        public final Semaphore semaphore3 = new Semaphore(0);

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphore2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphore2.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semaphore3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphore3.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

    public class Solution {
        private Foo foo = new Foo();
        Thread first = new Thread(()->{
            System.out.print("first");
        });
        Thread second = new Thread(()->{
            System.out.print("second");
        });
        Thread third = new Thread(()->{
            System.out.print("third");
        });
        public void run(){
            new Thread(()->{
                try {
                    foo.second(second);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(()->{
                try {
                    foo.first(first);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(()->{
                try {
                    foo.third(third);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}