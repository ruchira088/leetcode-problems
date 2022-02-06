package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StudentAttendanceTest {
    private final StudentAttendance studentAttendance = new StudentAttendance();

    @Test
    void testOne() {
//        Assertions.assertEquals(3, studentAttendance.checkRecord(1));
//        Assertions.assertEquals(8, studentAttendance.checkRecord(2));
//        Assertions.assertEquals(19, studentAttendance.checkRecord(3));
//        checkRecord(99999);
        studentAttendance.checkRecord(999999);
//        Assertions.assertEquals(checkRecord(99999), studentAttendance.checkRecord(99999));

    }

    long M = 1000000007;
    public int checkRecord(int n) {
        long a0l0 = 1, a0l1 = 0, a0l2 = 0, a1l0 = 0, a1l1 = 0, a1l2 = 0;
        for (int i = 0; i <= n; i++) {
            long a0l0_ = (a0l0 + a0l1 + a0l2) % M;
            a0l2 = a0l1;
            a0l1 = a0l0;
            a0l0 = a0l0_;
            long a1l0_ = (a0l0 + a1l0 + a1l1 + a1l2) % M;
            a1l2 = a1l1;
            a1l1 = a1l0;
            a1l0 = a1l0_;
        }
        return (int) a1l0;
    }

}