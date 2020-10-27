import com.javacode.core.EnumerateRanges;
import com.javacode.core.EnumerateRangesImpl;
import com.javacode.util.FileReader;

import java.util.Map;
import java.util.Optional;

/**
 * Below class bootstraps application and provides requires output
 * It can be considered as entry point to application
 */
public class BootStrapApplication {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader();
        Map<Integer,Integer> map = fr.readTextFile(Optional.ofNullable("test.txt"));
        System.out.println(map);
        EnumerateRanges er = new EnumerateRangesImpl();
        System.out.println(er.findMinimumRanges(map));
    }
}
