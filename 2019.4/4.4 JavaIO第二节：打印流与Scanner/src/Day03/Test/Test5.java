package Day03.Test;

import java.io.IOException;
import java.io.OutputStream;

public class Test5 {
    public static void main(String[] args) throws IOException {
        OutputStream out = System.out;
        out.write("hello  ".getBytes());
    }
}
