package StudentAttendanceRecordI;

/**
 * 551. Student Attendance Record I
 *
 * You are given a string representing an attendance record for a student.
 * The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 *
 * A student could be rewarded if his attendance record
 * doesn't contain more than one 'A' (absent)
 * or more than two continuous 'L' (late).
 *
 * You need to return whether the student could be rewarded according to his attendance record.
 */
public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        boolean aExist = false;
        int l = 0;
        int lastL = -1;
        int i = 0;

        for (char c : s.toCharArray()) {
            if (c == 'A') {
                if (aExist) {
                    return false;
                }
                else {
                    aExist = true;
                }
            }
            else if (c == 'L') {
                if (lastL != -1 && i == lastL + 1) {
                    if (l == 2) {
                        return false;
                    }
                    else {
                        l++;
                    }
                }
                else {
                    l = 1;
                }
                lastL = i;
            }

            i++;
        }

        return true;
    }
}
