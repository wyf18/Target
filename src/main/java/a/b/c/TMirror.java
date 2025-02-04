package a.b.c;

public class TMirror {
    public volatile Integer p = 0;

    public int getPassword() {
        return 3444;
    }

    public void mySink(int i) {
        System.out.println("TMirror toto: " + i);
    }
}



