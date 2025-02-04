package a.b.c;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class WMirror {
    protected volatile TMirror tm;
    public WMirror(TMirror tm) {
        this.tm = tm;
    }

    static class Wrapper {
        protected volatile Target t;
        public Wrapper(Target t) { this.t = t;}
    }

    public static void main(String[] args) {
        Target originalTarget = new Target();
        Wrapper w = new Wrapper(originalTarget);

        int password = w.t.getPassword();
//        w.t.mySink(password);
        w.t.mySink(3444);

        AtomicReferenceFieldUpdater updater =
                AtomicReferenceFieldUpdater.newUpdater(Wrapper.class, Target.class, "t");

        WMirror wm = new WMirror(new TMirror());

        System.out.println("wm.tm is " + wm.tm.getClass());

        Target newTarget = new Target();
        updater.set(wm, newTarget);

        System.out.println("wm.tm " + wm.tm.getClass());

        wm.tm.mySink(password);
    }
}
