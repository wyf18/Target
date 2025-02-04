package a.b.c;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class Target {
    public volatile Integer p = 0;
    public int getPassword() {
        return 3444;
    }
    public void mySink(int i) {
        System.out.println("toto: "+ i);
    }

//    class TMirror {
//        protected volatile Integer p = 0;
//        public int getPassword() {
//            return 3444;
//        }
//        public void mySink(int i) {
//            System.out.println("TMirror toto: "+ i);
//        }
//    }

//    public static void main(String[] args) {
//        Class<Target.TMirror> tclass = Target.TMirror.class;
//        Class<Integer> vclass = Integer.class;
//        String fieldName = "field";
//
////        AtomicReferenceFieldUpdater updater =
////                AtomicReferenceFieldUpdater.newUpdater(tclass, vclass,
////                        fieldName);
//
//        Target target = new Target();
//        Object newP = new Integer(42);
//
//        target.p = getPassword();
//
////        updater.set(target, newP);
//
//        mySink(target.p);
//    }
}

