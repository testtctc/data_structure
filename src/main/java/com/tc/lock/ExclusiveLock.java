package com.tc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;

public class ExclusiveLock {

     public static class Async  extends AbstractQueuedSynchronizer{

         // Main exported methods
         /**
          * Attempts to acquire in exclusive mode. This method should query
          * if the state of the object permits it to be acquired in the
          * exclusive mode, and if so to acquire it.
          *
          * <p>This method is always invoked by the thread performing
          * acquire.  If this method reports failure, the acquire method
          * may queue the thread, if it is not already queued, until it is
          * signalled by a release from some other thread. This can be used
          * to implement method {@link Lock#tryLock()}.
          *
          * <p>The default
          * implementation throws {@link UnsupportedOperationException}.
          *
          * @param arg the acquire argument. This value is always the one
          *        passed to an acquire method, or is the value saved on entry
          *        to a condition wait.  The value is otherwise uninterpreted
          *        and can represent anything you like.
          * @return {@code true} if successful. Upon success, this object has
          *         been acquired.
          * @throws IllegalMonitorStateException if acquiring would place this
          *         synchronizer in an illegal state. This exception must be
          *         thrown in a consistent fashion for synchronization to work
          *         correctly.
          * @throws UnsupportedOperationException if exclusive mode is not supported
          */
         @Override
         protected boolean tryAcquire(int arg) {
             //对比值即可
             if(compareAndSetState(0,1)){
                 setExclusiveOwnerThread(Thread.currentThread());
                 return true;

             }
             return false;
         }

         /**
          * Attempts to set the state to reflect a release in exclusive
          * mode.
          *
          * <p>This method is always invoked by the thread performing release.
          *
          * <p>The default implementation throws
          * {@link UnsupportedOperationException}.
          *
          * @param arg the release argument. This value is always the one
          *        passed to a release method, or the current state value upon
          *        entry to a condition wait.  The value is otherwise
          *        uninterpreted and can represent anything you like.
          * @return {@code true} if this object is now in a fully released
          *         state, so that any waiting threads may attempt to acquire;
          *         and {@code false} otherwise.
          * @throws IllegalMonitorStateException if releasing would place this
          *         synchronizer in an illegal state. This exception must be
          *         thrown in a consistent fashion for synchronization to work
          *         correctly.
          * @throws UnsupportedOperationException if exclusive mode is not supported
          */
         @Override
         protected boolean tryRelease(int arg) {
             if (getState()==0){
                 return false;
             }else{
                 setExclusiveOwnerThread(null);
                 setState(0);
                 return true;

             }

         }

         /**
          * Attempts to acquire in shared mode. This method should query if
          * the state of the object permits it to be acquired in the shared
          * mode, and if so to acquire it.
          *
          * <p>This method is always invoked by the thread performing
          * acquire.  If this method reports failure, the acquire method
          * may queue the thread, if it is not already queued, until it is
          * signalled by a release from some other thread.
          *
          * <p>The default implementation throws {@link
          * UnsupportedOperationException}.
          *
          * @param arg the acquire argument. This value is always the one
          *        passed to an acquire method, or is the value saved on entry
          *        to a condition wait.  The value is otherwise uninterpreted
          *        and can represent anything you like.
          * @return a negative value on failure; zero if acquisition in shared
          *         mode succeeded but no subsequent shared-mode acquire can
          *         succeed; and a positive value if acquisition in shared
          *         mode succeeded and subsequent shared-mode acquires might
          *         also succeed, in which case a subsequent waiting thread
          *         must check availability. (Support for three different
          *         return values enables this method to be used in contexts
          *         where acquires only sometimes act exclusively.)  Upon
          *         success, this object has been acquired.
          * @throws IllegalMonitorStateException if acquiring would place this
          *         synchronizer in an illegal state. This exception must be
          *         thrown in a consistent fashion for synchronization to work
          *         correctly.
          * @throws UnsupportedOperationException if shared mode is not supported
          */
         protected int tryAcquireShared(int arg) {
             throw new UnsupportedOperationException();
         }

         /**
          * Attempts to set the state to reflect a release in shared mode.
          *
          * <p>This method is always invoked by the thread performing release.
          *
          * <p>The default implementation throws
          * {@link UnsupportedOperationException}.
          *
          * @param arg the release argument. This value is always the one
          *        passed to a release method, or the current state value upon
          *        entry to a condition wait.  The value is otherwise
          *        uninterpreted and can represent anything you like.
          * @return {@code true} if this release of shared mode may permit a
          *         waiting acquire (shared or exclusive) to succeed; and
          *         {@code false} otherwise
          * @throws IllegalMonitorStateException if releasing would place this
          *         synchronizer in an illegal state. This exception must be
          *         thrown in a consistent fashion for synchronization to work
          *         correctly.
          * @throws UnsupportedOperationException if shared mode is not supported
          */
         @Override
         protected boolean tryReleaseShared(int arg) {
             throw new UnsupportedOperationException();
         }

         /**
          * Returns {@code true} if synchronization is held exclusively with
          * respect to the current (calling) thread.  This method is invoked
          * upon each call to a non-waiting {@link ConditionObject} method.
          * (Waiting methods instead invoke {@link #release}.)
          *
          * <p>The default implementation throws {@link
          * UnsupportedOperationException}. This method is invoked
          * internally only within {@link ConditionObject} methods, so need
          * not be defined if conditions are not used.
          *
          * @return {@code true} if synchronization is held exclusively;
          *         {@code false} otherwise
          * @throws UnsupportedOperationException if conditions are not supported
          */
         @Override
         protected boolean isHeldExclusively() {
             return getState()==1;
         }

     }

    private Async sync = new Async();

    //上锁
    public void lock(){
        sync.acquire(1);
    }

    //释放
    public void unlock(){
        sync.release(1);
    }

    public boolean  trylock(){
        return sync.tryAcquire(1);
    }

    public boolean isHeldExclusively(){
        return sync.isHeldExclusively();
    }

    //在一定时间内尝试获取
    public boolean trylock(Long timeout, TimeUnit unit) throws  InterruptedException{
        return sync.tryAcquireNanos(1,unit.toNanos(timeout));
    }

}
