package LiThuyet.main.session3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class lt_se_demo {

    public static void main(String[] args) {
        // các phương thức với StreamApi
        stream.demoClassicStream();
        stream.demoStreamFilter();
        stream.demoStreamMap();
        stream.demoStreamSorted();
        stream.demoStreamDistinct();
        stream.demoStreamLimit();
        stream.demoStreamReduce();
        stream.demoStreamMatch();
        stream.demoStreamFind();
        stream.demoParallelStream();

        // các phương thức với Optional
        optional.demoCreate();
        optional.demoFilter();
        optional.demoGet();
        optional.demoIfPresent();
        optional.demoIsPresent();
        optional.demoMap();
        optional.demoOrElse();
    }

}